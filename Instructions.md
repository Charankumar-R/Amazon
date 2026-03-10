# Amazon BDD Automation Framework

## Architecture & Tech Stack
- **Language:** Java 11+
- **Build Tool:** Maven
- **Test Framework:** TestNG
- **BDD Framework:** Cucumber
- **UI Automation:** Selenium WebDriver 4.18.1
- **Design Pattern:** Page Object Model with PageFactory

## Project Structure
```text
amazon-bdd-framework/
 ├── pom.xml
 ├── src/test/java/
 │   ├── util/
 │   │   └── Base.java (WebDriver initialization, waits, teardown)
 │   ├── pages/
 │   │   ├── HomePage.java
 │   │   ├── CategoryPage.java
 │   │   ├── SubCategoryPage.java
 │   │   └── ProductPage.java
 │   ├── stepdefinitions/
 │   │   ├── Hooks.java (Browser Setup/Teardown)
 │   │   └── AmazonSteps.java (Cucumber step defs)
 │   └── runner/
 │       └── TestRunner.java (TestNG execution layer)
 └── src/test/resources/
     └── features/
         └── amazon.feature
```

## Execution Instructions
Navigate to the root directory `e:/hcl_sample/AmazonBDDFramework` and execute the following Maven command:

```bash
mvn clean test
```
Alternatively, you can run `TestRunner.java` directly from your IDE (IntelliJ / Eclipse) using the TestNG plugin. Reports will be generated in `/target/cucumber-reports/`.
