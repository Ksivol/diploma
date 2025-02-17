plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.kspPlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    // dagger2
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    testImplementation(libs.junit.jupiter)
    testImplementation(libs.mockito.core)
}
