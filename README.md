# api-testing

Project containing test cases for the Schiphol API (https://api.schiphol.nl) written in Kotlin.

## Description
### Configuration
Configuration files are stored in [`src/main/resources`](src/main/resources) and the [`ConfigurationSpecification`](src/main/kotlin/org/apitest/helper/ConfigurationSpecification.kt) class is used to read from them.

For Schiphol API properties, the [`SchipholAPIProperties`](src/main/kotlin/org/apitest/property/SchipholAPIProperties.kt) data class is populated with the above approach.

### Data Modelling 

Kotlin data classes for modelling API reponses are found in [`src/main/kotlin/org/apitest/model`](src/main/kotlin/org/apitest/model)

The `Gson` library is used to map response body JSON to these data classes as follows:

```kotlin
val destinations = gson.fromJson(body, Destinations::class.java).destinations
```
### Test Cases
Test cases are executed with JUnit and can be found in the [`SchipholAPITest`](src/test/kotlin/org/apitest/tests/SchipholAPITest.kt) class.

## Steps to run
Requirements: 
- Java 11 SDK (https://openjdk.java.net/install/)
- gradle (https://gradle.org/install/) - v7.2 used for development

Clone repository:
```
git clone https://github.com/ancodia/api-testing.git
cd api-testing
```
Generate Gradle wrapper:
```
gradle wrapper
```
Run tests:

*nix:
```
./gradlew :schiphol
```
Windows (untested):
```
gradlew.bat :schiphol
```

Note: https://github.com/dilshan5/sample_kotlin was used as a starting point
