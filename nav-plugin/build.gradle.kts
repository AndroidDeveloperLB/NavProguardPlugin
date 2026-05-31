plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

// Group and version are usually provided by Jitpack as properties
group = project.findProperty("group")?.toString()?.takeIf { it.isNotEmpty() } ?: "com.github.AndroidDeveloperLB"
version = project.findProperty("version")?.toString()?.takeIf { it.isNotEmpty() && it != "unspecified" } ?: "1.0.0"

gradlePlugin {
    plugins {
        create("navProguardPlugin") {
            id = "com.lb.navplugin.NavProguardPlugin"
            implementationClass = "com.lb.navplugin.NavProguardPlugin"
        }
    }
}

// Ensure sources and javadoc are published for Jitpack
java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "nav-plugin"
            groupId = group.toString()
            version = version.toString()
        }
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:9.3.0-alpha09")
}
