# api-testing

Project containing test cases for the Schiphol API (https://api.schiphol.nl) written in Kotlin.

## Steps to run
Requirements: 
- Java 11 SDK (https://openjdk.java.net/install/)
- gradle (https://gradle.org/install/)

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
