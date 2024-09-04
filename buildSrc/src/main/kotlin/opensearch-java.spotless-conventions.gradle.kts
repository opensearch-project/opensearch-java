plugins {
    id("com.diffplug.spotless")
}

interface SpotlessConventionsPluginExtension {
    val eclipseFormatterConfigFile: RegularFileProperty
}

val extension = project.extensions.create<SpotlessConventionsPluginExtension>("spotlessConventions")

extension.eclipseFormatterConfigFile.convention(rootProject.layout.projectDirectory.file("buildSrc/formatterConfig.xml"))

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

        eclipse().configFile(extension.eclipseFormatterConfigFile)

        trimTrailingWhitespace()
        endWithNewline()

        // NOTE: Any time a custom step below is modified, bump this number.
        // Allows up-to-date checks to work correctly with custom steps.
        bumpThisNumberIfACustomStepChanges(1)

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