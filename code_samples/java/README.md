# energy-sustanibility-score SDK for GetSites Java
## Prerequisites
------------------
To build and run GetSites, you'll need:
- Apache Maven (>3.0)
- JAVA 11
- Git Bash

## Download Artefacts

https://github.com/ecostruxure-openapi/Energy-and-Sustainability-Scoring/releases/tag/v1.0.0

## Building the GetSites
------------------
The code sample are divided into directories by api service (GetSites, GetMeters, and so on). Within each, you'll find a pom.xml file used for building the GetSites with Maven
- First pull the project go inside the api service you need to run
To build, open a command-line (terminal) window and change to the directory containing the GetSites you want to build/run. Then in cli type: 
- mvn clean install
## Once you've build succsesfully, you can execute run.sh as shown:
- run the below command in git bash inside the Gitesites Folder where you can see run.sh file
### sh run.sh $className $token $baseUrl
Ex: sh run.sh GetSites m2n09rSoCuRXYDNYc9Au14LbkAzC https:{{base-URL}}/ecostruxure
- args 1 -> GetSites explains we need to run Getsites api
- args 2 -> token has to be passed
- args 3 -> baseurl has to be passed

This will run the GetSites api (assuming that you've built the GetSites first!).

