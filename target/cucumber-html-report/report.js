$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/GetHotelsAndLocations.feature");
formatter.feature({
  "name": "Verify Get Hotels and Location API.",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@get_hotels_and_locations"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verify Get Hotels And Locations API Response Code.",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "From Hotels API, Set \u003cquery_value\u003e For Query.",
  "keyword": "Given "
});
formatter.step({
  "name": "From Hotels API, Call Get Hotels API.",
  "keyword": "When "
});
formatter.step({
  "name": "Verify API 200 Status Code.",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "query_value"
      ]
    },
    {
      "cells": [
        "Paris"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify Get Hotels And Locations API Response Code.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@get_hotels_and_locations"
    }
  ]
});
formatter.step({
  "name": "From Hotels API, Set Paris For Query.",
  "keyword": "Given "
});
formatter.match({
  "location": "GetHotelsAndLocationsStepDef.setQueryValue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "From Hotels API, Call Get Hotels API.",
  "keyword": "When "
});
formatter.match({
  "location": "GetHotelsAndLocationsStepDef.callGetHotelsAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify API 200 Status Code.",
  "keyword": "Then "
});
formatter.match({
  "location": "BookApartmentStepDef.verifyStatusCode(String)"
});
formatter.result({
  "status": "passed"
});
});