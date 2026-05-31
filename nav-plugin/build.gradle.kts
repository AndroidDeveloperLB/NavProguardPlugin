plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.github.username"
version = "1.0.0"

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
            groupId = group.toString()
            artifactId = "nav-plugin"
            version = version.toString()
        }
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:9.3.0-alpha09")
}
