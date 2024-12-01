@SearchTest
Feature: MarsAir: Search Validation

  @ValidSearch
  Scenario Outline: Valid Search for <scenarioName>
    Given I go to "MarsAir" homepage
    When I select dropdown "departure" with value "<departureDate>"
    And I select dropdown "return" with value "<returnDate>"
    And I click on Search
    Then I see "seat availability"

    Examples:
      | scenarioName                    | departureDate        | returnDate                    |
      | July-JulyNextYear               | July                 | July (next year)              |
      | July-DecemberNextYear           | July                 | December (next year)          |
      | July-July2Years                 | July                 | July (two years from now)     |
      | December-DecemberNextYear       | December             | December (next year)          |
      | December-July2Years             | December             | July (two years from now)     |
      | December-December2Years         | December             | December (two years from now) |
      | JulyNextYear-July2Years         | July (next year)     | July (two years from now)     |
      | JulyNextYear-December2Years     | July (next year)     | December (two years from now) |
      | DecemberNextYear-December2Years | December (next year) | December (two years from now) |

  @InvalidSearch @LessThanOneYear
  Scenario Outline: Invalid Search for <scenarioName>
    Given I go to "MarsAir" homepage
    When I select dropdown "departure" with value "<departureDate>"
    And I select dropdown "return" with value "<returnDate>"
    And I click on Search
    Then I see "schedule not possible"

    Examples:
      | scenarioName                      | departureDate                 | returnDate                    |
      | July-July                         | July                          | July                          |
      | July-December                     | July                          | December                      |
      | December-December                 | December                      | December                      |
      | December-JulyNextYear             | December                      | July (next year)              |
      | JulyNextYear-JulyNextYear         | July (next year)              | July (next year)              |
      | JulyNextYear-DecemberNextYear     | July (next year)              | December (next year)          |
      | DecemberNextYear-DecemberNextYear | December (next year)          | December (next year)          |
      | DecemberNextYear-July2Years       | December (next year)          | July (two years from now)     |
      | July2Years-July2Years             | July (two years from now)     | July (two years from now)     |
      | July2Years-December2Years         | July (two years from now)     | December (two years from now) |
      | December2Years-December2Years     | December (two years from now) | December (two years from now) |

  @InvalidSearch @FutureDeparture
  Scenario Outline: Invalid Search for <scenarioName>
    Given I go to "MarsAir" homepage
    When I select dropdown "departure" with value "<departureDate>"
    And I select dropdown "return" with value "<returnDate>"
    And I click on Search
    Then I see "schedule not possible"

    Examples:
      | scenarioName    | departureDate | returnDate |
      | FutureDeparture | December      | July       |

  @InvalidSearch @WithOutDepartureReturn
  Scenario Outline: Invalid Search for <scenarioName>
    Given I go to "MarsAir" homepage
    And I click on Search
    Then I see "schedule not possible"

    Examples:
      | scenarioName           |
      | WithOutDepartureReturn |