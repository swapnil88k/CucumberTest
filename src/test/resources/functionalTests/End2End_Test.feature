Feature:  Automate E2E Tests

Scenario: Customer place an order by purchasing an item from search

Given user is on Home Page
When he search for "dress" 
And choose to buy the first item
And moves to checkout from mini cart
And enter personal details on checkout page
And place the order