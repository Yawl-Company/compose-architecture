plugins {
    kotlin("jvm")
}

group = "com.convention.android.build-logic"

dependencies {
    compileOnly(gradleApi())
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}
