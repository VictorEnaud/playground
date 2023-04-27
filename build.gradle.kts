import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.benmanes.gradle.versions.reporter.HtmlReporter
import com.github.benmanes.gradle.versions.reporter.PlainTextReporter
import com.github.benmanes.gradle.versions.reporter.result.Result
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import java.io.FileOutputStream
import java.io.PrintStream

plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.github.ben-manes.versions") version "0.46.0"
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
}

group = "me.victorenaud"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility >= JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.jar {
    enabled = false
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputDir = "build/reports"
    reportfileName = "dependency-updates-report"
    gradleReleaseChannel = "current"
    outputFormatter = closureOf<Result> {
        if (!this.outdated.dependencies.isEmpty()) {
            mkdir(outputDir)
            val outputFile = File(outputDir, "$reportfileName.html")
            val outputFileOutputStream = FileOutputStream(outputFile)
            val htmlReporter = HtmlReporter(project, revision, gradleReleaseChannel)

            outputFileOutputStream.use { out: FileOutputStream ->  htmlReporter.write(PrintStream(out), this) }

            val consoleReporter = PlainTextReporter(project, revision, gradleReleaseChannel)
            consoleReporter.write(System.out, this)

            throw GradleException("Abort, there are dependencies to update.")
        }
    }
}
