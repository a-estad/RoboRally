
@tag
Feature: Player

  @tag1
  Scenario: Draw hand
    Given a player
    When the player draws a hand of cards
    Then he has 9 random cards
  
  
