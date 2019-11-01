pluginManagement {
    repositories {
        jcenter()
        maven(url = "https://maven.fabricmc.net/")
        gradlePluginPortal()
    }
}
rootProject.name = "Spunbric"
//include("buildSrc")
include(":SpongeAPI")
