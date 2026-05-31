plugins {
    id("com.android.application")
    // This plugin is included via includeBuild in settings.gradle.kts
    id("com.lb.navplugin.NavProguardPlugin")
}

/**
 * How to use this plugin in your own project via Jitpack:
 *
 * 1. Add the Jitpack repository to your root `settings.gradle.kts` or `build.gradle.kts`
 *    (in the `pluginManagement` block or `buildscript` block):
 *
 *    pluginManagement {
 *        repositories {
 *            google()
 *            mavenCentral()
 *            gradlePluginPortal()
 *            maven { url = uri("https://jitpack.io") }
 *        }
 *    }
 *
 * 2. Add the plugin as a dependency in your root `build.gradle.kts`:
 *
 *    buildscript {
 *        repositories {
 *            google()
 *            mavenCentral()
 *            maven { url = uri("https://jitpack.io") }
 *        }
 *        dependencies {
 *            // Replace 'USERNAME' with your GitHub username and 'TAG' with the version/tag.
 *            // Note: Jitpack coordinates are usually com.github.User:Repo:Tag
 *            classpath("com.github.username:NavProguardPlugin:1.0.0")
 *        }
 *    }
 *
 * 3. Apply the plugin in your app's `build.gradle.kts`:
 *
 *    plugins {
 *        id("com.lb.navplugin.NavProguardPlugin")
 *    }
 *
 *    OR using the legacy way:
 *
 *    apply(plugin = "com.lb.navplugin.NavProguardPlugin")
 */
android {
    namespace = "com.lb.myapplication"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.lb.myapplication"
        minSdk = 23
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.18.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("com.google.android.material:material:1.14.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.9.8")
    implementation("androidx.navigation:navigation-ui-ktx:2.9.8")
}
