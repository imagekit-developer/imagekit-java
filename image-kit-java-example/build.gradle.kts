plugins {
    id("image-kit.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":image-kit-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :image-kit-java-example:run` to run `Main`
    // Use `./gradlew :image-kit-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "io.imagekit.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
