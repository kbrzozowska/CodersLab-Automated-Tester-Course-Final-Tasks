Feature: New order

  Scenario Outline: Adding new order
    Given user opens https://mystore-testlab.coderslab.pl/ page
    And user clicks on SingIn button
    And user enters email <email> and password <password> and click Signin button
    When user finds Hummingbird Printed Sweater
    And user choose size, quantity, add product to the basket and goes to checkout
    And user confirms address alias <alias>
    And user choose delivery method Pick up in store, choose pay by Check and confirms order
    Then user sees order confirmation
    And screenshot is taken
    And browser is closed
    Examples:
      | email                        | firstname | lastname | password | alias  |
      | yxzvdnetsdhrjohqpq@mrvpm.net | Joanna    | Doe      | Qwe!23   | domowy |