### Why
**As a client who needs to calculate tax **
**I want to** send a request to a calculation service
**So that** I can receive tax determined by my zip code

### Acceptance Criteria

```gherkin
Scenario: I send a request with price, quantity, and zipCode to the calculation service for Atlanta tax (6% sales tax)
Given the zipCode in the request is "30339"
When the calculation service responds
Then the response should contain the taxAmount for my item in addition to my original request 
```

```gherkin
Scenario: I send a request with price, quantity, and zipCode to the calculation service for Rome tax (7% sales tax)
Given the zipCode in the request is "30149"
When the calculation service responds
Then the response should contain the taxAmount for my item in addition to my original request 
```

```gherkin
Scenario: I send a request with price, quantity, and zipCode to the calculation service for Hephzibah tax (8% sales tax)
Given the zipCode in the request is "30815"
When the calculation service responds
Then the response should contain the taxAmount for my item in addition to my original request 
```

**Notes:**
If none of the above zip codes are provided in a request the default tax rate should be 4%
**Example Request**:
```
{
  "invoice": {
    "price": 100,
    "quantity": 1,
    "zipCode": "30339"
  }
}
```

**Reponse**:
```
{
  "invoice": {
    "price": 100,
    "quantity": 1,
    "zipCode": "30339",
    "taxAmount": 6
  }
}
```