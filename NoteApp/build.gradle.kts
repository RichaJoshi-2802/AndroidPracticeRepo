import kotlin.script.experimental.jvm.util.classpathFromClass

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}
buildscript {
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        mavenCentral()
        mavenCentral() // Warning: this repository is going to shut down soon
        gradlePluginPortal()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}
