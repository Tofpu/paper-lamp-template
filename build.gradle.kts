plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("xyz.jpenilla.run-paper") version "2.0.1"
}

group = "io.github.tofpu"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")

    compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")
    testImplementation("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")

    implementation("com.github.Revxrsal.Lamp:common:3.1.7")
    implementation("com.github.Revxrsal.Lamp:bukkit:3.1.7")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
    }

    runServer {
        minecraftVersion("1.19.4")
        // provides a copy of files on `/libs` to the `run/plugins` directory
        project.file("libs").listFiles()?.forEach { project.file(it) }
    }

    test {
        useJUnitPlatform()
    }
}