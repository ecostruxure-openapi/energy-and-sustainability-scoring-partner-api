# Postman Collection

## About the tool

Postman is an API client that makes it easy for developers and testers to create, share, test and document APIs. With this open-source solution, users can create and save simple and complex HTTP/s requests, as well as read their responses

There are many benefits to using open-source Postman for API testing, including: 
1. Accessibility from the cloud: When you are signed into your account, you are able to access your files. You can execute Postman API tests anytime, anywhere.
2. Collaboration: Postman's import and export capabilities make it easier to share files with other team members, enabling closer collaboration. 
3. Test Creation: You can add test checkpoints such as verifying successful HTTP response statuses to your Postman API calls. This capability can help teams achieve more comprehensive test coverage.  
4. Automated API Testing: With features such as Collection Runner, you can automate Postman API tests, saving time and resources. 
5. Simpler debugging: The Postman console makes it easier to debug API tests by helping teams check the retrieved data. 
6. Collections: Postman's Collections features enables teams to group together multiple related APIs, which helps with organizing test suites.

## Requirements

1. Minimum requirements to use postman tool in windows and MacOS
2. Search this link https://www.postman.com/downloads/ in any browser and download the software

## How to use given Energy and Sustainability Scoring APIs

# How to import postman collection 
1. Select Import in the left navigation menu.
2. Select the file. Postman will automatically recognize Postman data, confirming the name, format.
![Import](/code_samples/Media/Import.PNG)
3. Click on upload files and select the postman collection and environment variable file.
4. Click on import button to complete import.

# Steps to configure the variables in environment

1. Click on Environment quick look button and select the envirnoment file that is import.
2. Configure the envirnoment variables

| VARIABLES  | VALUES  |
|---|---|
| {{api-server-host}}  | Enter the APIGEE endpoint  |
| {{callback-url}}  |Enter the URL that invoked after OAuth authorization for the consumer (The client application callback URL to redirect to after auth. This must be registered with the API provider. If not provided, Postman will use a default empty URL and try to extract the code or access token from it)   |
| {{authorize-url}}  | Enter the AUthorization URL that  the endpoint for the API provider authorization server, to retrieve the auth code  |
|  {{token-url}} | Enter token URL that provider's authentication server, to exchange an authorization code for an access token.  |
| {{clientid}}  |  Enter authorized client Id |
| {{clientsecret}}  | Enter authorized client secret  |
|  {{scope}} | Enter the scope of access you are requesting (refer the swagger), which may include multiple space-separated values   |
| {{state}}  |   Enter an opaque value to prevent cross-site request forgery  |
 


3. After entering all the values in the environment variables save it by clicking on 'Save' button
4. Goto postman collection and select any Api that has to test
5. Generate access token but click on 'Get New Access Token' in authorization tab 
![GenerateAccessToken](/code_samples/Media/GenerateAccessToken.PNG)
6. User will be navigated to CIAM login page as shown below, enter the user name and password and login.
![CIAMLoginPage](/code_samples/Media/CIAMLoginPage.PNG)
7. User will be landing to consent page that consists of terms and conditions and scope that requires authorization to access as shown below
![consentpage](/code_samples/Media/consentpage.PNG)
8. Check the terms and conditions and click on Authorize access button to approve the consent
8. Click on authorization button to get access.
9. Access token will be generated and sent back to postman
10. Use the token to trigger the API
11. Click on send button to trigger API and get response.


## Below we have sample request and response of energy and sustainability scoring apis for the reference 

# REST API

The REST API to the example app is described below.

## Get list of sites

### Request

`GET /sites`
```curl
    curl --location --request GET '--HostName--/ecostruxure/v1/sites' \
--header 'Authorization: Bearer Token'
```
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

### Request

`GET /sites/{site-id}/meters`
``` curl
    curl --location --request GET '{{api-server-host}}//ecostruxure/v1/sites/fc64ac6a-abfd-4f5e-9d38-81101152c0ca/meters' \
--header 'Authorization: Bearer Token' 
```

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

## Create Energy Certification Providers

### Request

`POST /sites/{site-id}/certification-providers`
``` curl
    curl --location --request POST '{{api-server-host}}/ecostruxure/v1/sites/fc64ac6a-abfd-4f5e-9d38-81101152c0ca/certification-providers' \
--header 'Authorization: Bearer Token' \
--data-raw '{
    "leedName": "Mcdonald'\''s Melton South",
    "leedId": 2147483647
    }'
```
### Response

    HTTP Status: 201 Created
    Content-Type: application/json
   
```json
    {
    "leedId": 2147483647,
    "leedName": "Mcdonald's Melton South"
    }
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


## Create Energy Certification Scoring

### Request

`POST /sites/{site-id}/certification-scores`
```curl
    curl --location --request POST '{{api-server-host}}/ecostruxure/v1/sites/fc64ac6a-abfd-4f5e-9d38-81101152c0ca/certification-scores' \
--header 'Authorization: Bearer Token' \
--data-raw '[
    {
        "date": "2022-06-26",
        "score": 87,
        "type": "daily",
        "category": "energy"
    },
    {
        "date": "2022-06-26",
        "score": 90,
        "type": "monthly",
        "category": "energy"
    }
    ]'
```
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
## Limitations

1. User should be existing customer of SE
