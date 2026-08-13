pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

// Se quito el plugin foojay-resolver: solo servia para que Gradle se descargase un JDK por su
// cuenta cuando el toolchain pedido no estaba. Aqui compilamos con el Java 21 del sistema, que es
// el mismo que corre el servidor, asi que sobra -- y ademas fallaba al resolverse.

rootProject.name = "Automation"
