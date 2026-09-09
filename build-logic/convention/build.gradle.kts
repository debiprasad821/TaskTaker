plugins {
    `kotlin-dsl`
}

group = "com.poc.buildlogic"

repositories {
    google()
    mavenCentral()
}


gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "tasktaker.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}