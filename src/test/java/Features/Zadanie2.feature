Feature: New order

  Scenario Outline: Adding new order
    Given user opens https://prod-kurs.coderslab.pl/ page
    And user clicks on SingIn button
    And user enters email <email> and password <password> and click Signin button
    When user finds Hummingbird Printed Sweater
    And user choose size, quantity, add product to the basket and goes to checkout
    And user confirms address
    And user choose delivery method Pick up in store, choose pay by Check and confirms order
    Then user sees order confirmation
    And screenshot is taken
    And browser is closed
    Examples:
      | email                        | firstname | lastname | password | alias  | address       | code   | city   | country        | phone    |
      | yxzvdnetsdhrjohqpq@mrvpm.net | Joanna    | Doe      | Qwe!23   | domowy | Przykładowa 2 | 02-022 | London | United Kingdom | 77733000 |