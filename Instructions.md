# Amazon BDD Automation Framework

## Architecture & Tech Stack
- **Language:** Java 11+
- **Build Tool:** Maven
- **Test Framework:** TestNG
- **BDD Framework:** Cucumber
- **UI Automation:** Selenium WebDriver 4.18.1
- **Design Pattern:** Page Object Model with PageFactory
- **Data Driven Testing:** Apache POI for Excel interactions

## Project Structure
```text
amazon-bdd-framework/
 ├── pom.xml
 ├── src/test/java/
 │   ├── util/
 │   │   ├── Base.java (WebDriver initialization, waits, teardown)
 │   │   └── ExcelReader.java (Apache POI Excel logic)
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
     ├── features/
     │   └── amazon.feature
     └── testdata/
         └── AmazonData.xlsx
```

## Sample Excel Structure (AmazonData.xlsx)
Create an Excel file at `src/test/resources/testdata/AmazonData.xlsx` with the following structure:

**Sheet Name: `Categories`**

| Category | SubCategory |
|----------|-------------|
| Camera | Lenses |
| Camera | Flashes |
| Mobile and Accessories | Smart Watch |
| Mobile and Accessories | Mobile Broadband Device |

*(Ensure "Categories" is accurately named as it is used in `AmazonSteps.java` to fetch the sheet.)*

## Execution Instructions
Navigate to the root directory `e:/hcl_sample/AmazonBDDFramework` and execute the following Maven command:

```bash
mvn clean test
```
Alternatively, you can run `TestRunner.java` directly from your IDE (IntelliJ / Eclipse) using the TestNG plugin. Reports will be generated in `/target/cucumber-reports/`.
