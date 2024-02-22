/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.Exclusion;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.DependencyRequest;
import org.eclipse.aether.resolution.DependencyResolutionException;
import org.eclipse.aether.supplier.RepositorySystemSupplier;

public class MavenArtifactResolver {
    public static MavenArtifactResolver createDefault() {
        var repositorySystem = new RepositorySystemSupplier().get();
        var session = MavenRepositorySystemUtils.newSession();
        session.setSystemProperties(System.getProperties());
        var mavenLocal = new LocalRepository(new File(System.getProperty("user.home") + "/.m2/repository"));
        session.setLocalRepositoryManager(repositorySystem.newLocalRepositoryManager(session, mavenLocal));

        var mavenCentral = new RemoteRepository.Builder("central", "default", "https://repo.maven.apache.org/maven2/").build();
        return new MavenArtifactResolver(repositorySystem, session, List.of(mavenCentral));
    }

    private final static Collection<Exclusion> EXCLUDE_ALL_TRANSITIVES = Collections.singleton(new Exclusion("*", "*", "*", "*"));

    private final RepositorySystem repositorySystem;
    private final RepositorySystemSession session;
    private final List<RemoteRepository> repositories;

    public MavenArtifactResolver(RepositorySystem repositorySystem, RepositorySystemSession session, List<RemoteRepository> repositories) {
        this.repositorySystem = Objects.requireNonNull(repositorySystem);
        this.session = Objects.requireNonNull(session);
        this.repositories = Objects.requireNonNull(repositories);
    }

    public Set<File> resolve(boolean withTransitives, Collection<String> mavenCoordinates) {
        var dependencies = mavenCoordinates.stream()
            .map(coord -> new Dependency(new DefaultArtifact(coord), null, null, withTransitives ? null : EXCLUDE_ALL_TRANSITIVES))
            .toList();

        var request = new DependencyRequest(new CollectRequest(dependencies, null, repositories), null);

        try {
            return repositorySystem.resolveDependencies(session, request)
                .getArtifactResults()
                .stream()
                .map(r -> r.getArtifact().getFile())
                .collect(Collectors.toSet());
        } catch (DependencyResolutionException ex) {
            throw new RuntimeException("Failed to resolve dependencies", ex);
        }
    }
}
