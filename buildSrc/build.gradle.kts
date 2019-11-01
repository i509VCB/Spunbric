plugins {
    `kotlin-dsl`
    `java-library`
    idea
    //id("fabric-loom") version("0.2.5-SNAPSHOT")
}

subprojects {
    dependencies {
        gradleApi()
        gradleKotlinDsl()
    }
    apply(plugin = "org.gradle.kotlin.kotlin-dsl")
    apply(plugin = "org.spongepowered.gradle.sponge.dev")
    apply(plugin = "fabric-loom:0.2.5-SNAPSHOT")
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    jcenter()
    maven(url = "https://files.minecraftforge.net/maven")
    maven("https://repo.spongepowered.org/maven")
    maven(url = "https://maven.fabricmc.net/")

}

dependencies {
    implementation("net.minecrell.licenser:net.minecrell.licenser.gradle.plugin:0.4.1")
    implementation("net.minecraftforge.gradle:ForgeGradle:3.+")
    implementation(group = "org.spongepowered", name = "spongegradle", version = "0.11.0-SNAPSHOT")
}