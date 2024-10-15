plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.convention.android.build-logic"

dependencies {
    implementation(projects.kotlin)
    implementation(projects.gradleExtension)
    implementation(libs.android.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("android-lib") {
            id = "convention.kotlin-android-library"
            implementationClass = "com.convention.AndroidLibraryConventionPlugin"
        }

        create("android-app") {
            id = "convention.kotlin-android-app"
            implementationClass = "com.convention.AndroidApplicationConventionPlugin"
        }

        create("android-compose") {
            id = "convention.android-compose"
            implementationClass = "com.convention.AndroidComposeConventionPlugin"
        }
    }
}
