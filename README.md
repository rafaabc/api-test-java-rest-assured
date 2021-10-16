# Framework of automated API's tests with JUnit5, Java, RestAssured and Gradle

Framework to test in the integration layer.

# Pre-conditions

Tools:
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
- [Java SE Development Kit 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)

Libraries:
- [JUnit5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.8.0-M1) to support the test creation
- [REST Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured) library to test REST APIs
- [JSON Schema Validator](https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator) to test the response body against swagger
- [Owner](https://mvnrepository.com/artifact/org.aeonbits.owner/owner) to manage the property files

# Project Structure

```

```

# CLI
Run all test classes through command line:

Linux/Mac

    ./gradlew clean test  

Windows

    gradle clean test

# Report
As soon as tests are executed, an html file report is displayed:

`build -> reports -> tests -> test -> index.html`
