# pecodeTask
Pecode login test task
Jdk11, Spring Boot, Cucumber, TestNG, Maven

### Run tests
```
./mvnw clean test
```
Tests will run with default configuration:
```
...
<properties>
  <thread.count>2</thread.count>
</properties>

...

<systemPropertyVariables>
  <pecode.browser>chrome</pecode.browser>
  <pecode.username>Username</pecode.username>
  <pecode.password>Password</pecode.password>
</systemPropertyVariables>
...
```

You can twick some of the configurations by passing arguments to the test phase:
```
./mvnw clean test -Dthread.count=3 \
                  -Dpecode.browser=safari \
                  -Dpecode.username=NewUsername \
                  -Dpecode.password=NewPassword
```
### Run test locally
You can also edit test configuration from `application.properties` file
```
pecode.browser=safari
pecode.username=Username
pecode.password=Password
```
And run individual tests from Intellij Run
### Reporting
Test reporting is available under `target/cucumber-report-html` path.
Screenshots of falied tests: `target/cucumber-report-html/cucumber-html-reports/embeddings`.
