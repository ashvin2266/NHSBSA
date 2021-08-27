@nhs
Feature: As a person from Wales
         I need to know what help I can get with my NHS costs
         So that I can get the treatment I need
  Background:
    Given I am on the help paying nhs costs page
    And I am a person from "Wales"
  @under19
  Scenario:001- Verify the user benefits if they are under 19 years and full time education.
    Given I am 18 years old and I enter the Day as "01" and Month as "01" and Year as "2003"
    And I am in full time education
    When click on next button
    Then I can see the nhs cost help result page title contains "Because you're under 19 and in full time education you get help paying NHS costs"
    And I verify message as "You get help with NHS costs" with full time education
    And I can see following help get free
      | NHS prescriptions|
      |NHS dental check-ups and treatment|
      |sight tests|
      |NHS wigs and fabric supports|
      |£4.25 each week of your pregnancy from the 10th week  |
      |£8.50 each week for children from birth to 1 year old |
      |£4.25 each week for children between 1 and 4 years old |
      |travel for NHS treatment|
  @under19
  Scenario:002- Verify the user benefits if they are under 19 years and not in full time education.
    Given I am 18 years old and I enter the Day as "01" and Month as "01" and Year as "2003"
    And I am not in full time education
    And I dont live with partner
    And I dont claim benefits
    And I am not pregnant
    And I dont have injury serving armed forces
    And I dont have diabetes and glucoma
    And I dont live in care home
    And I have no savings
    When click on next button
    Then I can see the nhs cost help result page title contains "You get help with health costs"


  @age19-24
  Scenario:003- Verify the user benefits if they are from 19 to 24 years.
    Given I am 22 years old and I enter the Day as "01" and Month as "01" and Year as "1999"
    And I dont live with partner
    And I dont claim benefits
    And I am not pregnant
    And I dont have injury serving armed forces
    And I dont have diabetes and glucoma
    And I dont live in care home
    And I have no savings
    When  click on next button
    Then I can see the nhs cost help result page title contains "You get help with health costs"

  @age19-24
  Scenario:004- Verify the user benefits if they are from 19 to 24 years and live with partner.
    Given I am 22 years old and I enter the Day as "01" and Month as "01" and Year as "1999"
    And I do live with partner
    And I dont claim benefits
    And I am not pregnant
    And I do have injury serving armed forces
    And I do have diabetes and glucoma
    And I dont live in care home
    And I have no savings
    When  click on next button
    Then I can see the nhs cost help result page title contains "You get help with health costs"

#  @age25-60
  Scenario:005- Verify the user benefits if they are 25 to 60 years.
    Given I am 35 years old and I enter the Day as "01" and Month as "01" and Year as "1986"
    And I do live with partner
    And I dont claim benefits
    And I am not pregnant
    And I dont have injury serving armed forces
    And I do have diabetes and glucoma
    And I dont live in care home
    And I have no savings
    When click on next button
    Then I can see the nhs cost help result page title contains "You get help with health costs"

  @age25-60
  Scenario:008- Verify the user benefits if they are 25 to 60 years and claim benefit or tax credit
    Given I am 41 years old and I enter the Day as "01" and Month as "01" and Year as "1980"
    And I do live with partner
    And I claim benefits or tax credit
    And we received universal credit payment
    And we have responsibility with child
    And we have a combined take home pay in last credit period
    When click on next button
    Then I can see the nhs cost help result page title contains "Because you or your partner get qualifying universal credit"
    And I can see following help get free
      | NHS prescriptions|
      |NHS dental check-ups and treatment|
      |sight tests|
      |NHS wigs and fabric supports|
    And I can see following help I get Money off
      |new glasses or contact lenses  |
      |repairing or replacing your glasses or contact lenses|
      |travel for NHS treatment |

  @over60
  Scenario:006- Verify the user benefits if they are over 60 years with council help.
    Given I am 62 years old and I enter the Day as "01" and Month as "01" and Year as "1959"
    And I do live with partner
    And I dont claim benefits
    And I dont have injury serving armed forces
    And I do live in care home
    And I do get help from council
    When  click on next button
    Then I can see the nhs cost help result page title contains "Because you get help from your local council to pay for your care home"
#    Then I can see the nhs cost help result page for council help
   @over60
  Scenario:007- Verify the user benefits if they are over 60 years without council help.
    Given I am 62 years old and I enter the Day as "01" and Month as "01" and Year as "1959"
    And I do live with partner
    And I dont claim benefits
    And I dont have injury serving armed forces
    And I do live in care home
    And I do not get help from council
    And I do have savings of £24000
    When click on next button
    Then I can see the nhs cost help result page title contains "You get help with health costs"
