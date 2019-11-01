plugins {
    id("java")
    id("fabric-loom") version("0.2.5-SNAPSHOT")
    id("org.spongepowered.gradle.sponge.common")
}

logger.lifecycle("""
   Starting Spunbric build. 
""")

//val apiProj = project(":SpongeAPI")
val mcVersion = "1.14.4"
val loaderVersion = "0.6.1+build.164"
val yarnMappings = "1.14.4+build.12"
val apiVersion = "0.3.2+build.218-1.14"
val modmenuVersion = "1.7.9+build.118"

dependencies {
    minecraft("com.mojang:minecraft:$mcVersion")
    mappings("net.fabricmc:yarn:$yarnMappings")
    modCompile("net.fabricmc:fabric-loader:$loaderVersion")
    modCompile("net.fabricmc.fabric-api:fabric-api:$apiVersion")
    modCompile("io.github.prospector:modmenu:$modmenuVersion")
}

group = "org.spongepowered"
version = "Spunbric"
