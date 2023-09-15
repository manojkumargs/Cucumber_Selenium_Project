Feature: features to test login and adding product to cart and logging out

  Scenario Outline: checking login procedure
    Given launch the browser
    And Navigate to the URL
    When the user opens account
    And the user enters the "<email>" and "<password>"
    Then the user clicks on login button
    
 	Examples: 
    | email                | password   |
    | abcdef123456@gmail.com | abcdef123456 |

  Scenario: finding domain and adding one product to cart there
    Given click on brands domain
    And click on adidas in brands
    And now click on color change
    When user selects one product
    And selects the product size
    Then adds to cart

  Scenario: View product in cart and logout
    Given view product in cart
    And click on account menu
    Then click on logout there
  