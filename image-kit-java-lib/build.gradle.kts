plugins {
    id("image-kit.kotlin")
}

dependencies {
    api(project(":image-kit-java-core"))

    testImplementation(kotlin("test"))
    testImplementation(project(":image-kit-java-client-okhttp"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
}
