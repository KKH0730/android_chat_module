buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.ANDROID_GRADLE_PLUGIN)
        classpath(Plugins.KOTLIN)
        classpath(Plugins.HILT_AGP)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}