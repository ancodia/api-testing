import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    id("com.adarshr.test-logger") version "2.1.1"
}

group = "org.apitest"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.0")
    implementation("io.rest-assured:kotlin-extensions:4.4.0")
    implementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.junit.platform:junit-platform-launcher:1.8.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.12.5")
    implementation("com.google.code.gson:gson:2.8.8")
}

tasks.withType<Test> {
    useJUnitPlatform()
    //testLogging.showStandardStreams = true

}

//Defines and configure a new task
tasks.register<Test>("schiphol") {
    useJUnitPlatform() {
        includeTags("schiphol")
    }
}

//Compiles Kotlin source files.
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}