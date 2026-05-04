plugins {
    id("java-library")
    id("maven-publish")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "de.jalorenz"
            artifactId = "lib-b"

            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/jalorenz/gradle-modules-semantic-versioning")
            credentials {
                username = System.getenv("GPR_USERNAME")
                password = System.getenv("GPR_TOKEN")
            }
        }
    }
}