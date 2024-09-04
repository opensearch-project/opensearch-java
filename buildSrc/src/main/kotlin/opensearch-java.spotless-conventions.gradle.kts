plugins {
    id("com.diffplug.spotless")
}

spotless {
    java {
        target("**/*.java")

        licenseHeaderFile(rootProject.file("LICENSE_HEADER.txt"))
            .named("PrimaryLicenseHeader")
            .onlyIfContentMatches("^((?!Licensed to Elasticsearch)[\\s\\S])*$")
            .delimiter("(package |//-----)")

        licenseHeaderFile(rootProject.file("LICENSE_HEADER_FORKED.txt"))
            .named("ForkedLicenseHeader")
            .onlyIfContentMatches("Licensed to Elasticsearch")
            .delimiter("(package |//-----)")

        // Use the default importOrder configuration
        importOrder()
        removeUnusedImports()

        eclipse().configFile(rootProject.file("buildSrc/formatterConfig.xml"))

        trimTrailingWhitespace()
        endWithNewline()

        val wildcardImportRegex = Regex("""^import\s+(?:static\s+)?[^*\s]+\.\*;$""", RegexOption.MULTILINE)
        custom("Refuse wildcard imports") { contents ->
            // Wildcard imports can't be resolved by spotless itself.
            // This will require the developer themselves to adhere to best practices.
            val wildcardImports = wildcardImportRegex.findAll(contents)
            if (wildcardImports.any()) {
                throw AssertionError(
                    """
                    Please replace the following wildcard imports with explicit imports ('spotlessApply' cannot resolve this issue):

                    ${wildcardImports.joinToString("\n") { "\t- ${it.value}" }}

                    """.trimIndent()
                )
            }
            contents
        }
    }
}