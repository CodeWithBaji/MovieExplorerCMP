import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import java.util.Properties

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { localProperties.load(it) }
}
val tmdbToken = localProperties.getProperty("TMDB_API_TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxY2I4ZjQ5NTc2ZWJiZmExMTkyOGVmZjhjODBhMzZiZCIsIm5iZiI6MTc4ODE2OTM1MS4xMjk5OTk5LCJzdWIiOiI2YTk1NGM4N2ExYjVjMThiNGVkZDFmOWIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.n93zEXA-dVpIhe8KuHBc1TPqEjElXaCUzGl-syx0Mek")

val tmdbGenDir = layout.buildDirectory.dir("generated/tmdb/commonMain/kotlin")

// Config-cache-safe task: no closures capturing the script object,
// only serializable Property/DirectoryProperty inputs.
abstract class GenerateTmdbConfigTask : DefaultTask() {

    @get:Input
    abstract val apiToken: Property<String>

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @TaskAction
    fun generate() {
        val pkgDir = outputDir.get().asFile
            .resolve("com/moviewexplorer/app/config")
        pkgDir.mkdirs()
        pkgDir.resolve("TmdbConfig.kt").writeText(
            """
            package com.moviewexplorer.app.config

            object TmdbConfig {
                const val API_TOKEN = "${apiToken.get()}"
            }
            """.trimIndent()
        )
    }
}

val generateTmdbConfig by tasks.registering(GenerateTmdbConfigTask::class) {
    apiToken.set(tmdbToken)
    outputDir.set(tmdbGenDir)
}

// Eager write at configuration time too, so IDE sync/indexing
// sees the file immediately without running the task.
run {
    val pkgDir = tmdbGenDir.get().asFile
        .resolve("com/moviewexplorer/app/config")
    pkgDir.mkdirs()
    pkgDir.resolve("TmdbConfig.kt").writeText(
        """
        package com.moviewexplorer.app.config

        object TmdbConfig {
            const val API_TOKEN = "$tmdbToken"
        }
        """.trimIndent()
    )
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompileCommon>().configureEach {
    dependsOn(generateTmdbConfig)
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    dependsOn(generateTmdbConfig)
}
tasks.matching { it.name == "prepareKotlinIdeaImport" }.configureEach {
    dependsOn(generateTmdbConfig)
}

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    jvmToolchain(17)

    androidTarget()

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    
    sourceSets {



        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
        }
        val commonMain by getting {
            kotlin.srcDir(
                layout.buildDirectory.dir(
                    "generated/tmdb/commonMain/kotlin"
                )
            )
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                //implementation(compose.preview)
                implementation(libs.androidx.lifecycle.viewmodelCompose)
                implementation(libs.androidx.lifecycle.runtimeCompose)
                implementation(libs.kotlinx.serialization.json)
                implementation(compose.materialIconsExtended)
                implementation(libs.androidx.navigation.compose)

                implementation(libs.kotlinx.coroutines.core)

                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.ktor.client.logging)

                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.serialization.kotlinx.json)

                implementation(libs.coil.compose)
                implementation(libs.coil.network.ktor3)

                implementation(libs.kotlinx.datetime)

            }
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }


        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
            implementation(libs.ktor.client.cio)
        }



        val wasmJsMain by getting {
            dependencies {
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(libs.ktor.client.js)
            }
        }

        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies{
                implementation(libs.ktor.client.darwin)

            }
        }
    }
}



android {
    namespace = "com.moviewexplorer.app.shared"

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

compose {
    resources {
        publicResClass = true
    }
}


dependencies {
    //androidRuntimeClasspath(compose.uiTooling)
}

