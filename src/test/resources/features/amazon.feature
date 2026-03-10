Feature: Amazon Product Name and Price Validation

  Scenario: 1. Navigate to Categories and extract Name and Price using Excel Data
    Given User launches browser and navigates to Amazon
    When User reads category data from Excel
    And User navigates to categories and subcategories

  Scenario: 2. Perform Category Search and capture Product Name and Price
    Given User launches browser and navigates to Amazon
    When User searches for category "Smart Watch" and captures details
    Then Validate and capture Product Name and Price

  Scenario: 3. Apply Filters on Categories and validate filtered products
    Given User launches browser and navigates to Amazon
    When User searches for category "Camera Lenses" and captures details
    And User applies filter "Canon" on results
    Then Validate filtered Product Name and Price
