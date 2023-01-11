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

       <!-- The Apache Commons IO library contains utility classes, stream implementations, file filters, file comparators, 
endian transformation classes, and much more-->  
       <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.11.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.nimbusds/oauth2-oidc-sdk -->
        <!-- OpenID Connection extensions for developing client and server applications. -->
        <dependency>
            <groupId>com.nimbusds</groupId>
            <artifactId>oauth2-oidc-sdk</artifactId>
            <version>9.35</version>
            <scope>runtime</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
        <!-- HTTPClient provides an efficient, up-to-date, and feature-rich package implementing the client 
side of the most recent HTTP standards and recommendations. -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.13</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore -->
        <!-- Apache HttpCore. Apache HttpComponents Core (blocking I/O). License, Apache Categories,
 HTTP Clients. Tags, networkapacheclienthttp. -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpcore</artifactId>
            <version>4.4.15</version>
        </dependency>

       <!-- General data-binding functionality for Jackson: works on core streaming API. 
License, Apache 2.0. Categories, JSON Libraries. Tags, formatbindingjsonjackson.-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.3</version>
        </dependency>
```

### Compile it yourself, here's how:
 build your own .jar, execute the following from within the cloned directory:

    $ git clone https://github.schneider-electric.com/open-esx/energy-sustainibilty-scoring-api.git
    $ cd energy-and-sustainability-scoring/code_samples/java
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
 ./run.sh -c "GetPerformanceScores" -t "cX5BTXzjPPimyMy121pdKDgGWKWlS" -b "https://se-exchange-uat-uat.apigee.net/ecostruxure" -s "e80101c0dd-9103-44d7-af93-2d06946c8cdf" -p "daily" -y "energy"
 ```
 > **Note**
 you can pass multiple type and category
 
  > **Example**
  ```
   ./run.sh -c "GetPerformanceScores" -t "cX5BTXzjPPimyMy121pdKDgGWKWlS" -b "https://se-exchange-uat-uat.apigee.net/ecostruxure" -s "e80101c0dd-9103-44d7-af93-2d06946c8cdf" -p "daily" -y "energy" -p "monthly" -y "consumption"
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
 mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetPerformanceScores" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure siteId=eb7a2757-d4d8-44e7-8d  type="monthly" category=energy" -Dexec.cleanupDaemonThreads=false
 ```
 > **Note**
 You can also pass multiple type and category
 - Example
 ```
mvn exec:java -Dexec.mainClass="se.ecostruxure.sdk.example.GetPerformanceScores" -Dexec.args="token=nFxghx baseUrl=https://api.exchange.se.com/ecostruxure  siteId=eb7a2757-d4d8-44e7-8d type="daily" category=energy"  type="monthly" category=consumption" -Dexec.cleanupDaemonThreads=false
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
