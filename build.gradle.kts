plugins {
    kotlin("jvm") version "1.9.25"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3"
    id("xyz.jpenilla.run-paper") version "2.2.0"
}

group = "io.github.seggan"
version = "UNOFFICIAL"

repositories {
    mavenCentral()
    maven("https://jitpack.io/")
    maven("https://drakescraft-labs.github.io/maven-repo/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    library(kotlin("stdlib"))

    compileOnly("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")
    compileOnly("com.github.drakescraft_labs:slimefun-core:11.0-Drake-1.21.11-SNAPSHOT")

    api("com.github.Seggan:metis:c0bde92f08")


    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

bukkit {
    name = "Automation"
    main = "io.github.seggan.automation.Automation"
    version = project.version.toString()
    author = "Seggan"
    apiVersion = "1.21"
    depend = listOf("Slimefun")
    commands {
        register("automation") {
            description = "Automation plugin command"
            aliases = listOf("auto")
        }
    }
}

tasks.shadowJar {
    dependsOn(tasks.test)
    relocate("io.github.seggan.metis", "io.github.seggan.automation.metis") {
        exclude("META-INF/**")
    }
        exclude("META-INF/**")
    }
}
