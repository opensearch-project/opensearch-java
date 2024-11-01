/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.ZonedDateTime;
import java.util.Date;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class SelfSignedCertificateAuthority {
    private static final Provider BC_PROVIDER = new BouncyCastleProvider();
    private static final String KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256with" + KEY_ALGORITHM;

    private final PublicKey publicKey;
    private final ContentSigner signer;
    private final JcaX509CertificateConverter converter;
    private final JcaX509ExtensionUtils extUtils;
    private final X500Name issuingSubject;
    private final AuthorityKeyIdentifier authorityKeyIdentifier;
    private final X509Certificate certificate;

    public SelfSignedCertificateAuthority() throws NoSuchAlgorithmException, OperatorCreationException, CertIOException,
        CertificateException {
        KeyPair keyPair = generateKeyPair();
        publicKey = keyPair.getPublic();
        signer = new JcaContentSignerBuilder(SIGNATURE_ALGORITHM).build(keyPair.getPrivate());
        converter = new JcaX509CertificateConverter().setProvider(BC_PROVIDER);
        extUtils = new JcaX509ExtensionUtils();
        issuingSubject = new X500Name("DC=localhost, O=localhost, OU=localhost Root CA, CN=localhost Root CA");

        X509CertificateHolder certificate = newCertificate(issuingSubject, publicKey).addExtension(
            Extension.authorityKeyIdentifier,
            false,
            extUtils.createAuthorityKeyIdentifier(publicKey)
        )
            .addExtension(Extension.subjectKeyIdentifier, false, extUtils.createSubjectKeyIdentifier(publicKey))
            .addExtension(Extension.basicConstraints, true, new BasicConstraints(true))
            .addExtension(Extension.keyUsage, true, new KeyUsage(KeyUsage.digitalSignature | KeyUsage.keyCertSign | KeyUsage.cRLSign))
            .build(signer);
        authorityKeyIdentifier = extUtils.createAuthorityKeyIdentifier(certificate);
        this.certificate = converter.getCertificate(certificate);
    }

    public X509Certificate getCertificate() {
        return certificate;
    }

    public GeneratedCertificate generateCertificate(X500Name subject, GeneralName[] subjectAlternateNames) throws NoSuchAlgorithmException,
        CertIOException, CertificateException {
        KeyPair keyPair = generateKeyPair();
        X509CertificateHolder certificate = newCertificate(subject, keyPair.getPublic()).addExtension(
            Extension.authorityKeyIdentifier,
            false,
            authorityKeyIdentifier
        )
            .addExtension(Extension.subjectKeyIdentifier, false, extUtils.createSubjectKeyIdentifier(publicKey))
            .addExtension(Extension.basicConstraints, true, new BasicConstraints(false))
            .addExtension(
                Extension.keyUsage,
                true,
                new KeyUsage(KeyUsage.digitalSignature | KeyUsage.nonRepudiation | KeyUsage.keyEncipherment)
            )
            .addExtension(
                Extension.extendedKeyUsage,
                true,
                new ExtendedKeyUsage(new KeyPurposeId[] { KeyPurposeId.id_kp_serverAuth, KeyPurposeId.id_kp_clientAuth })
            )
            .addExtension(Extension.subjectAlternativeName, false, new GeneralNames(subjectAlternateNames))
            .build(signer);
        return new GeneratedCertificate(this, keyPair.getPrivate(), converter.getCertificate(certificate));
    }

    private X509v3CertificateBuilder newCertificate(X500Name subject, PublicKey publicKey) {
        ZonedDateTime start = ZonedDateTime.now().minusDays(1);

        return new JcaX509v3CertificateBuilder(
            issuingSubject,
            new BigInteger(Long.SIZE, CryptoServicesRegistrar.getSecureRandom()),
            Date.from(start.toInstant()),
            Date.from(start.plusDays(7).toInstant()),
            subject,
            publicKey
        );
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(KEY_ALGORITHM, BC_PROVIDER);
        keyGen.initialize(2048, CryptoServicesRegistrar.getSecureRandom());
        return keyGen.generateKeyPair();
    }

    public static class GeneratedCertificate {
        private final SelfSignedCertificateAuthority ca;
        private final PrivateKey privateKey;
        private final X509Certificate certificate;

        private GeneratedCertificate(SelfSignedCertificateAuthority ca, PrivateKey privateKey, X509Certificate certificate) {
            this.ca = ca;
            this.privateKey = privateKey;
            this.certificate = certificate;
        }

        public PrivateKey getPrivateKey() {
            return privateKey;
        }

        public X509Certificate getCertificate() {
            return certificate;
        }

        public X509Certificate[] getCertificateChain() {
            return new X509Certificate[] { certificate, ca.getCertificate() };
        }
    }
}
