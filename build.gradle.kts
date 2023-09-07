plugins {
    id("java")
    id("com.modrinth.minotaur") version "2.8.2"
}

group = "xyz.galaxyy.tdeathmessages"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("io.github.miniplaceholders:miniplaceholders-api:2.2.1")
}

modrinth {
    token.set(System.getenv("MODRINTH_TOKEN")) // Remember to have the MODRINTH_TOKEN environment variable set or else this will fail - just make sure it stays private!
    projectId.set("tdeathmessages") // This can be the project ID or the slug. Either will work!
    versionNumber.set(version.toString()) // You don't need to set this manually. Will fail if Modrinth has this version already
    versionType.set("beta") // This is the default -- can also be `beta` or `alpha`
    uploadFile.set(tasks.jar)
    gameVersions.addAll("1.20.1")
    loaders.addAll("paper", "purpur")
    dependencies {
        optional.project("miniplaceholders")
    }
}

tasks.test {
    useJUnitPlatform()
}