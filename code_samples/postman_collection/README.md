# Postman Collection

## About the tool

Postman is an API client that makes it easy for developers and testers to create, share, test and document APIs. With this open-source solution, users can create and save simple and complex HTTP/s requests, as well as read their responses


## Prerequisites

1. User should be existing customer for Schneider Electric
2. User should be subscribed to Energy and sustainability apis and should have their client-id and client-secret
3. Open this link [postman tool](https://www.postman.com/downloads/) in any browser and download the software

 
[How to import postman collection](#How-to-import-postman-collection)

## How to use given Energy and Sustainability Scoring APIs

# How to import postman collection 
1. Select Import in the left navigation menu.

![image](https://user-images.githubusercontent.com/117276316/200790237-5d54aa4c-637f-4bf1-a362-638039e78ab5.png)

2. click on Upload files option and select the postman collection and environment variable file. Postman will automatically recognize Postman data, confirming the name, format.

![image](https://user-images.githubusercontent.com/117276316/200791281-ce9a3ccd-39f6-4352-b4cf-3653b9b6aa1c.png)

3. Click on import button to complete import.


# Steps to configure the variables in environment

1. Click on Environment quick look button and select the EnergyandSustainabilityScoring.postman_environment that is import.
![image](https://user-images.githubusercontent.com/117276316/200793725-fe1de64d-b092-4ae5-ab7c-6b1eea7d6521.png)

3. Configure the variables given below in environment section

| NUM | VARIABLES  | VALUES  |
|---|---|---|
| 1 | {{api-server-host}}  | Enter the apiserver endpoint that is mentioned in the api specification file  |
| 2 | {{callback-url}}  |Enter the URL that invoked after OAuth authorization for the consumer (The client application callback URL to redirect to after auth.  If not provided, Postman will use a default empty URL and try to extract the code or access token from it)   |
| 3 | {{authorize-url}}  | Enter the Authorization URL that  the endpoint for the API provider authorization server, to retrieve the auth code (mentioned in the api specification file) |
| 4 |  {{token-url}} | Enter token URL that provider's authentication server, to exchange an authorization code for an access token (mentioned in the api specification file) |
| 5 | {{client-id}}  |  Enter consumer key obtain when they subscribe to the product |
| 6 | {{client-secret}}  | Enter consumer key obtained when they subscribe to the product  |
| 7 |  {{scope}} | Enter the scope of access you are requesting (mentioned in the api specification file), which may include multiple space-separated values   |
| 8 | {{state}}  |   Enter an opaque value to prevent cross-site request forgery  |
 
![apiSpecUrl](/code_samples/Media/apiSpecUrl.png)

4. After entering all the values in the environment variables, save it by clicking on 'Save' button


##  Steps to use the postman collection

1. Goto postman collection and select GetSite request that is used to retrieve all sites belonging to which the connected user has access, along site metadata needed for certification scores calculation.
2. Generate access token but click on 'Get New Access Token' in authorization tab 
![GenerateAccessToken](/code_samples/Media/GenerateAccessToken.PNG)
3. User will be navigated to CIAM login page as shown below, enter the user name and password and login.
![LoginPage](/code_samples/Media/LoginPage.PNG)
4. User will be landing to consent page that consists of terms and conditions and scope that requires authorization to access as shown below
![consentpage](/code_samples/Media/consentpage.PNG)
5. Check the terms and conditions and click on Authorize access button to approve the consent
6. Click on authorization button to get access.
7. Access token will be generated and sent back to postman
8. Use the token to trigger GetSite API
9. Click on send button to trigger API and get response.
![Getsite](/code_samples/Media/Getsite.PNG)

10. similarly user can retrive meters details by sending Getmeters request to retrieve all meters installed at a given site, including the list of measurements and units they support.

### Sample responses for Getsites and GetMeters

## Get list of sites

### Response

    HTTP Status: 200 OK
    Content-Type: application/json
```json   
    [
    {
        "id": "c207fb75-a207-4014-b85d-0e3b7c01ad14",
        "name": "Mcdonald's Milton",
        "type": "retail",
        "metadata": {
            "grossArea": 425,
            "buildingOccupants": 49,
            "daysPerWeekWithVisitors": 7,
            "numberOfVisitorsPerDay": 548,
            "visitDuration": 0.020833333,
            "weeklyOperatingHours": 168
        },
        "postalAddress": {
            "address": "cnr Milton Rd &",
            "city": "Milton",
            "countryIsoCode": "AU",
            "stateProvince": "New South Wales"
        }
    },
    {
        "id": "33f1096f-5293-49c0-8370-1844ecb511ee",
        "name": "McDonald's Padstow",
        "type": "retail",
        "metadata": {
            "grossArea": 425,
            "buildingOccupants": 49,
            "daysPerWeekWithVisitors": 7,
            "numberOfVisitorsPerDay": 548,
            "visitDuration": 0.020833333,
            "weeklyOperatingHours": 168
        },
        "postalAddress": {
            "address": "27 Arab Road",
            "city": "Padstow",
            "countryIsoCode": "AU",
            "zipCode": "2211",
            "stateProvince": "New South Wales"
        }
    }
]
```


## Get list of meters

### Response

    HTTP Status: 200 OK
    Content-Type: application/json
   ``` json
    [
    {
        "id": "8bebc978-750d-4b55-bc31-f014bf1fff8c",
        "name": "main_meter",
        "gatewayId": "751",
        "commodity": "Electricity",
        "usage": "MainMeter",
        "measurements": [
            {
                "id": "61773",
                "name": "IA",
                "timeseries": {
                    "key": "43b68619-7681-4458-bbd6-c4e38a0b202a"
                }
            }
        ]
    }
]

```

## Steps to create registration and certification scoring for sites

There is a Create Energy Certification Providers Api that allows the Certification Provider, to register a site by providing the Certification metadata details and thus starting automatically a data pipeline to collect all timeseries related information. 

1. Select Create Energy Certification Providers request in the collection, generate access token using similar steps used in GetSites 
2. Enter the input values in the request body as shown below and **send** the request  

![createEnergyProvider](createEnergyProvider.png)

3. New record should be created with providing the Certification metadata details and same should be obtained in the response body.

### sample Response

    HTTP Status: 201 Created
    Content-Type: application/json
   
```json
    {
    "leedId": 2147483647,
    "leedName": "Mcdonald's Melton South"
    }
```

similarly there is create Energy certification scoring api to provide Certification Scores for a given site and read current and historical scores.

 4. Select Create Energy Certification Providers request in the collection, generate access token using similar steps used in GetSites 
 5. Enter the input values with required type and category in the request and **send** the request

![createEnergyScoring](createEnergyScoring.png)

6. New record should be created with provide certification scores for a given site and read current and historical scores and same should be obtained in the response body.

### Response

    HTTP Status: 201 Created
    Content-Type: application/json
   ```json
   [
    {
        "date": "2022-06-26",
        "score": 87,
        "type": "daily",
        "category": "energy",
        "updatedAt": "2022-09-29T06:28:09.38430211Z"
    },
    {
        "date": "2022-06-26",
        "score": 90,
        "type": "monthly",
        "category": "energy",
        "updatedAt": "2022-09-29T06:28:09.385182117Z"
    }
    ]
```



## Get list of Timeseries

This api is to retrieve all timeseries for any given site and for an arbitrary time period.

1. 


### Response

    HTTP Status: 200 OK
    Content-Type: application/json
   ```json
   [
    {
        "key": "43b68619-7681-4458-bbd6-c4e38a0b202a",
        "values": [
            {
                "date": "2022-01-02T00:00:00Z",
                "updatedAt": "2022-02-01T14:49:46Z",
                "value": 567
            }
        ]
    }
]
```




## Get list of Timeseries

### Request

`GET /sites/{site-id}/timeseries`
``` curl
    curl --location --request GET '{{api-server-host}}//ecostruxure/v1/sites/fc64ac6a-abfd-4f5e-9d38-81101152c0ca/timeseries?updatedAt[gte]=2022-01-01T12:08:56.235-07:00&updatedAt%5Blt%5D=2022-06-06T12:08:56.235-07:00' \
--header 'Authorization: Bearer Token'
```
### Response

    HTTP Status: 200 OK
    Content-Type: application/json
   ```json
   [
    {
        "key": "43b68619-7681-4458-bbd6-c4e38a0b202a",
        "values": [
            {
                "date": "2022-01-02T00:00:00Z",
                "updatedAt": "2022-02-01T14:49:46Z",
                "value": 567
            }
        ]
    }
    ]
```



## Limitations

1. User should be existing customer of SE
