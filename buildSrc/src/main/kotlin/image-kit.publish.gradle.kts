plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("ImageKit API")
                description.set("Checkout [API overview](/docs/api-overview) to learn about ImageKit's APIs,\nauthentication, rate limits, and error codes etc.")
                url.set("https://imagekit.io")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Image Kit")
                        email.set("developer@imagekit.io")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/stainless-sdks/imagekit-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/imagekit-java.git")
                    url.set("https://github.com/stainless-sdks/imagekit-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
