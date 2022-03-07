plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

apply(plugin = "kover")

kover {
    isDisabled = false
    coverageEngine.set(kotlinx.kover.api.CoverageEngine.INTELLIJ)
    intellijEngineVersion.set("1.0.656")
    jacocoEngineVersion.set("0.8.7")
    generateReportOnCheck = true
    disabledProjects = setOf()
    instrumentAndroidPackage = false
    runAllTestsForProjectTask = false
}

tasks.test {
    useJUnitPlatform()
    extensions.configure(kotlinx.kover.api.KoverTaskExtension::class) {
        isDisabled = false
        binaryReportFile.set(file("$buildDir/custom/result.bin"))
        includes = listOf("org.*")
        excludes = listOf()
    }
}

tasks.koverMergedHtmlReport {
    isEnabled = true
    htmlReportDir.set(layout.buildDirectory.dir("reports/kover/html"))
    includes = listOf("org.*")
    excludes = listOf()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}