plugins {
    id("org.springframework.boot") version "3.5.3" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    kotlin("jvm") version "2.2.0" apply false
    kotlin("plugin.spring") version "2.2.0" apply false
}

allprojects {
    group = "com.spa"
    version = "0.1.0"

    repositories {
        mavenCentral()
    }
}

subprojects {
    plugins.apply("org.jetbrains.kotlin.jvm")

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper> {
        extensions.configure<JavaPluginExtension>("java") {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(21))
            }
        }
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        dependencies {
            "implementation"("org.jetbrains.kotlin:kotlin-reflect")
        }
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            compilerOptions {
                freeCompilerArgs.add("-Xjsr305=strict")
            }
        }
    }
}
