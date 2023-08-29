# Energy Sustainability Scoring API
### Documentation
EcoStruxure Openness makes developer experience easier to use our products. EcoStruxure Openness provide code sample Software Development Kits (SDKs) that will prevent developers to write their code from scratch.

SDK is a set of tools for third-party developers to use in producing applications using a particular framework or platform.

SDKs provide the necessary development plugins to import into the developer's code so that reduces the development efforts drastically and enables the
user to integrate faster.

### Versions
Latest Version - 1.0.0 
- Whats new in 1.0.0, API's that are supported
   - Get Sites
   - Get Performance Scores
   - Create Scoring Requests
   - Get Scoring Requests
### Supported Java Versions

This library supports the following Java implementations:

* OpenJDK 8+
* OracleJDK 8+
 
### Pre-Requisites

To build and run these SDK, you'll need:
- Apache Maven (>3.0)
- JAVA 8+
- Shell support(to execute run.sh)

### Dependency
Add the following dependency in your project to grab via Maven:

```xml
    <dependency>
        <groupId>se.ecostruxure.sdk</groupId>
        <artifactId>energy-sustainabilty-scoring-api</artifactId>
        <version>1.0.0</version>
        <scope>compile</scope>
    </dependency>
```
### Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import se.ecostruxure.sdk.client.invoker.*;
import se.ecostruxure.sdk.client.invoker.auth.*;
import se.ecostruxure.sdk.client.model.*;
import se.ecostruxure.sdk.client.PerformanceScoreApi;

public class PerformanceScoreApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("https://api.exchange.se.com/ecostruxure");
        
        // Configure OAuth2 access token for authorization: OAuth2AuthCode
        OAuth OAuth2AuthCode = (OAuth) defaultClient.getAuthentication("OAuth2AuthCode");
        OAuth2AuthCode.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: PersonalAccessToken
        HttpBearerAuth PersonalAccessToken = (HttpBearerAuth) defaultClient.getAuthentication("PersonalAccessToken");
        PersonalAccessToken.setBearerToken("TOKEN");

        PerformanceScoreApi apiInstance = new PerformanceScoreApi(defaultClient);
        String siteId = "a483d4-e5be-4521-9f92-5400f5"; // String | 
        try {
            ScoringRequest result = apiInstance.createScoringRequest(siteId);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Exception when calling PerformanceScoreApi#createScoringRequest");      
            e.printStackTrace();
        }
    }
}

```
### Compile it yourself, here's how:
 build your own .jar, execute the following from within the cloned directory:

    $ git clone https://github.com/ecostruxure-openapi/energy-and-sustainability-scoring.git
    $ cd energy-and-sustainability-scoring/code-samples/java
    $ mvn clean install       # Requires maven and run the below command    
 
## Run SDK Examples
### GetSites
Fetch all sites belonging to which the connected user has access, along site metadata like address, geolocation, gross area, building occupants, operating hours, etc
 ## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 > **Syntax**
 ```bash
 ./run.sh -c $className -t $token -b $baseUrl
 ```
 > **Example**
 ```bash
 ./run.sh -c GetSites -t gfghfxgh -b https://api.exchange.se.com/ecostruxure
 ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value(Note: without Bearer)
 > **Syntax**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl" -Dexec.cleanupDaemonThreads=false
 ```
 > **Example**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetSites" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure" -Dexec.cleanupDaemonThreads=false
 ```    
### GetPerformanceScores
The objective is to return the scores (average, daily, monthly, yearly) and based on category(energy) upon siteId.
 ## Run using bash terminal with arguments that has to be passed
 - -c to pass className
 - -t to pass token (Note: without bearer)
 - -b to pass baseUrl
 - -s to pass siteId
 - -y to pass category.
 - -p to pass type
 > **Syntax**
 ```
 ./run.sh -c $className -t $token -b $baseUrl -s $siteId -p $type -y $category
 ```
 > **Example**
 ```
 ./run.sh -c "GetPerformanceScores" -t "cX5BTXzjPPimyMy121pdKDgGWKWlS" -b "https://api.exchange.se.com/ecostruxure" -s "e80101c0dd-9103-44d7-af93-2d06946c8cdf" -p "daily" -y "energy"
 ```
 > **Note**
 you can pass multiple type and category
 
  > **Example**
  ```
   ./run.sh -c "GetPerformanceScores" -t "cX5BTXzjPPimyMy121pdKDgGWKWlS" -b "https://api.exchange.se.com/ecostruxure" -s "e80101c0dd-9103-44d7-af93-2d06946c8cdf" -p "daily" -y "energy" -p "monthly" -y "consumption"
  ```
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value (Note: without Bearer)
 - $siteId to pass siteId 
 - $type to pass type 
 - $category to pass category
 > **Syntax**
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId type=$type category=$category" -Dexec.cleanupDaemonThreads=false
 ```
 > **Example**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetPerformanceScores" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=eb7a2757-d4d8-44e7-8d  type=monthly category=energy" -Dexec.cleanupDaemonThreads=false
 ```
 > **Note**
 You can also pass multiple type and category
 - Example
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetPerformanceScores" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure  siteId=eb7a2757-d4d8-44e7-8d type=daily category=energy  type=monthly category=consumption" -Dexec.cleanupDaemonThreads=false
 ```
### CreateScoringRequests
Allows end user to request a site to be configured for generating LEED certificate.
 ## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 - -s to pass siteId
 > **Syntax**
 ```
 ./run.sh -c $className -t $token -b $baseUrl -s $siteId
 ```
 > **Example**
 ```
 ./run.sh -c "CreateScoringRequests" -t "gfghfxgh" -b "https://api.exchange.se.com/ecostruxure" -s "eb7a2757-d4d8-44e7-8d65"
 ```
    
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value (Note: without Bearer)
 - $siteId to pass siteId 
 > **Syntax**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId" -Dexec.cleanupDaemonThreads=false
 ```
 > **Example**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.CreateScoringRequests" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=eb7a2757-d4d8-44e7-8d" -Dexec.cleanupDaemonThreads=false
 ```
### GetScoringRequests
Allows end user to check the status of the site configuration.
 ## Run using bash terminal with arguments that has to be passed
 - -b to pass baseUrl
 - -c to pass className 
 - -t to pass token (Note: without Bearer)
 - -s to pass siteid
 - -i to pass id (Optional)
 > **Syntax(without id)**
 ```
 ./run.sh -c $className -t $token -b $baseUrl -s $siteId
  ```
  > **Or(with id)**
  ```
  ./run.sh -c $className -t $token -b $baseUrl -s $siteId -i $id
  ```
 > **Example(without id)**
 ```
 ./run.sh -c "GetScoringRequests" -t "gfghfxgh" -b "https://api.exchange.se.com/ecostruxure" -s "eb7a2757-d4d8-44e7-8d65"
 ```
 
  > **Or(with id)**
  ```
  ./run.sh -c "GetScoringRequests" -t "gfghfxgh" -b "https://api.exchange.se.com/ecostruxure" -s "eb7a2757-d4d8-44e7-8d65" -i "9b6e4438-d4e6-482c"
  ```
    
 ## Run as maven command with arguments that has to be passed
 - $baseUrl to pass baseUrl value
 - $className to pass className
 - $token to pass token value (Note: without Bearer)
 - $siteId to pass siteId 
 - $id to pass id (Optional)
 > **Syntax(without id)**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId" -Dexec.cleanupDaemonThreads=false
 ```
  > **Or(with id)**
  ```
  mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.$className" -Dexec.args="token=$token baseUrl=$baseUrl siteId=$siteId id=$id" -Dexec.cleanupDaemonThreads=false
  ```
 > **Example(without id)**
 ```
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetScoringRequests" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=eb7a2757-d4d8-44e7-8d" -Dexec.cleanupDaemonThreads=false
 ```
 > **Or(with id)**
  ```
  mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetScoringRequests" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=eb7a2757-d4d8-44e7-8d id=9b6e4438-d4e6" -Dexec.cleanupDaemonThreads=false
  ```
