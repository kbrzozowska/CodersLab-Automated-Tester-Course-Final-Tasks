#Feature: New Address
#
#  Scenario Outline: Adding new address
#    Given user opens https://prod-kurs.coderslab.pl/ page
#    And user clicks on SingIn button
#    And user enters email <email> and password <password> and click Signin button
#    When user clicks "add first address" button
#    And user add new alias <alias>, firstname <firstname>, surname <lastname>, address <address>, zip code <code>, city <city>, country <country> and phone <phone>
#    Then user sees confirmation message
#    And browser is closed
#    Examples:
#      | email                        | firstname | lastname | password | alias  | address       | code   | city   | country        | phone    |
#      | yxzvdnetsdhrjohqpq@mrvpm.net | Joanna    | Doe      | Qwe!23   | domowy | Przykładowa 2 | 02-022 | London | United Kingdom | 77733000 |
#
