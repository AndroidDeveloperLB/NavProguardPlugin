A tiny Android project plugin to prevent the need to manually exclude obfuscation of classes in "argument" from navigation xml files, as written here: 

https://developer.android.com/guide/navigation/use-graph/pass-data#proguard_considerations

To use:

In dependencies, add according to the Jitpack page:

https://jitpack.io/#AndroidDeveloperLB/NavProguardPlugin

Meaning:

    implementation("com.github.AndroidDeveloperLB:NavProguardPlugin:")

In "plugins" section of the project, add:

    id("com.lb.navplugin.NavProguardPlugin") apply false

In "plugins" section of the app's module, add:

    id("com.lb.navplugin.NavProguardPlugin")

In "pluginManagement" section, add:

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.lb.navplugin.NavProguardPlugin") {
                // Correct coordinate for JitPack multi-module:
                useModule("com.github.AndroidDeveloperLB.CommonUtils:nav-plugin:a2b8ae7754")
            }
        }
    }

    
