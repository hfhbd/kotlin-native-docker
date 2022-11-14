import org.jetbrains.kotlin.gradle.plugin.mpp.*

plugins {
    kotlin("multiplatform") version "1.7.21"
}

repositories {
    mavenCentral()
}

kotlin {
    fun KotlinNativeTarget.config(custom: Executable.() -> Unit = {}) {
        binaries {
            executable {
                entryPoint = "main"
                custom()
            }
        }
    }
    macosArm64 {
        config()
    }
    macosX64 {
        config()
    }

    linuxX64 {
        config()
    }
    linuxArm64 {
        config()
    }

    val staticAlpine: Executable.() -> Unit = {
        linkerOpts("--as-needed", "--defsym=isnan=isnan")
        freeCompilerArgs =
            freeCompilerArgs + "-Xoverride-konan-properties=linkerGccFlags=-lgcc -lgcc_eh -lc"
    }

    linuxX64("docker-amd64") {
        config(staticAlpine)
    }
    linuxArm64("docker-arm64") {
        config(staticAlpine)
    }
}
