pluginManagement {
    repositories {
        jcenter()
        maven(url = "https://maven.fabricmc.net/")
        maven(url = "https://repo.spongepowered.org/maven")
        gradlePluginPortal()
    }
}

rootProject.name = "Spunbric"
include(":SpongeAPI")