import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal")) {
          maven {
              name = "LocalFileSystem"
              url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("ImageKit API")
        description.set("Checkout [API overview](/docs/api-overview) to learn about ImageKit's APIs,\nauthentication, rate limits, and error codes etc.")
        url.set("https://imagekit.io/docs/api-reference")

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
            connection.set("scm:git:git://github.com/imagekit-developer/imagekit-java.git")
            developerConnection.set("scm:git:git://github.com/imagekit-developer/imagekit-java.git")
            url.set("https://github.com/imagekit-developer/imagekit-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
