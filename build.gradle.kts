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

    val static: String? by project
    val custom: Executable.() -> Unit = if (static == "true") {
        {
            linkerOpts("--as-needed", "--defsym=isnan=isnan")
            freeCompilerArgs =
                freeCompilerArgs + "-Xoverride-konan-properties=linkerGccFlags=-lgcc -lgcc_eh -lc"
        }
    } else {
        {}
    }
    linuxX64 {
        config(custom)
    }
    linuxArm64 {
        config(custom)
    }
}
