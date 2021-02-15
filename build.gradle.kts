import org.gradle.api.JavaVersion.VERSION_15

plugins {
	id("org.springframework.boot") version "2.4.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	java
}

group = "com.priyakdey"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = VERSION_15

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

val graphqlJavaVersion = "11.0.0"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.graphql-java-kickstart:graphql-java-tools:")
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:${graphqlJavaVersion}")
	implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:${graphqlJavaVersion}")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
