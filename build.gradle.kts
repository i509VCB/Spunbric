plugins {
    id("java")
    `kotlin-dsl`
    id("fabric-loom") version("0.2.5-SNAPSHOT")
}

logger.lifecycle("""
   Starting Spunbric build. 
""")

//val apiProj = project(":SpongeAPI")
val minecraft_version = "1.14.4"
val loader_version = "0.6.1+build.164"
val yarn_mappings = "1.14.4+build.12"
val fabric_api_version = "0.3.2+build.218-1.14"
val modmenu_version = "1.7.9+build.118"

dependencies {
    val loomVersion = "0.2.5-SNAPSHOT"
    //val mixinVersion

    //implementation("net.fabricmc:fabric-loom:$loomVersion")
    //implementation("net.fabricmc:sponge-mixin:$mixinVersion")

    minecraft("com.mojang:minecraft:$minecraft_version")
    mappings("net.fabricmc:yarn:$yarn_mappings")
    modCompile("net.fabricmc:fabric-loader:$loader_version")
    //compile("org.spongepowered:spongeapi:8.0.0")
    modCompile("net.fabricmc.fabric-api:fabric-api:$fabric_api_version")
    modCompile("io.github.prospector:modmenu:$modmenu_version")
}

group = "org.spongepowered"
version = "SpongeFabric"