Feature: Amazon Product Name and Price Validation

  Scenario Outline: 1. Navigate to Categories and extract Name and Price
    Given User launches browser and navigates to Amazon
    When User navigates to category "<Category>" and subcategory "<SubCategory>"
    Then Extract Name and Price for products in subcategory "<SubCategory>"

    Examples:
      | Category               | SubCategory             |
      | Camera                 | Lenses                  |
      | Camera                 | Flashes                 |
      | Mobiles, Computers     | Smart Watch             |
      | Mobiles, Computers     | Mobile Broadband Device |

  Scenario: 2. Perform Category Search and capture Product Name and Price
    Given User launches browser and navigates to Amazon
    When User searches for category "Smart Watch" and captures details
    Then Validate and capture Product Name and Price

  Scenario: 3. Apply Filters on Categories and validate filtered products
    Given User launches browser and navigates to Amazon
    When User searches for category "Camera Lenses" and captures details
    And User applies filter "Canon" on results
    Then Validate filtered Product Name and Price
