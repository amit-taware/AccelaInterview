Feature: Accela Interview : Automation Challenge

  buyagift.co.uk is a UK website offering users to purchase vouchers which they can redeem for
  various experiences, from dinner at a restaurant to hotels and short stays, to parachute jumping. As
  part of their production monitoring, they want to run a test to ensure that users can add a product to
  cart and proceed to checkout. This test is to be automated and executed in Jenkins on an hourly
  basis. Of course, as this test is running on production, the script will enter an invalid credit card
  number. The test will be considered successful only if:
  1. A user can open the homepage
  2. A user can find (either by search or by menu) the product of interest
  3. The correct price is displayed on the product page
  4. The user can add the product to their basket
  5. The user can add a personalized message to the product in their basket
  6. The user can select E-Voucher delivery method
  7. No additional delivery charge is added when E-Voucher is selected
  8. The correct product price is displayed in the users basket
  9. The user does not need to create an account to checkout, but can continue the purchase as a
  guest
  10. The user can add their Title, Email, First Name, Last Name, Telephone Number etc to the
  order
  11. User can find their billing address using a post code search
  12. When user enters a fake credit card number an error message is displayed


  Background: Go to app URL

    When I got to APP URL

  @UI
  Scenario: Buy a product

    Then I verify home page is opened
    Then I hover on menu 'Adventure'
    And I click on link 'Adventure For Two'
    When I select my product
    Then I verify that correct price is displayed on the page
    When I click on 'Buy Now' button
    Then I verify that product is being added into basket
    Then I add personalised message
    And I select 'E-Voucher' delivery method
    Then I verify that No additional delivery charge is added when E-Voucher is selected
    And I verify that correct product price is displayed in the users basket
    When I click on 'Pay Securely Now' button
    Then I verify that checkout page is opened
    Then I enter email
    And I click on 'Continue as a Guest' Button
    Then I  add  Title, First Name, Last Name, Telephone Number
    Then I add my billing address
    When I enters a fake credit card number and proceeds
    Then An error message is displayed




