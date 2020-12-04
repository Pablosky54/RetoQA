#Author: cefit.pablo@gmail.com

Feature: Chose a most sheap trip
  She want chose a different option in web page

  
  Scenario: Carolina chose a most cheap option a trip
    Given "Carolina" open page
    When she chose options destination, Las Vegas and init "12/12/2021" until "12/20/2021"    
    Then she verify the total price is 720 

  