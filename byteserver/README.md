# Micronaut HTTP Server Example

## API Spec
**Base url** (for local testing): ``http://localhost:8080``

``GET /``
- Returns the text "api is operational"

``GET /get/``
- Query parameters are ``name``, ``cohort``, and ``team``. All of these are optional. If one or more are not provided, the value is considered an empty string.
- Echos team information in a json list
- Example request: ``http://localhost:8080/get?name=linux+gods&cohort=two&team=4``
- Response: ``["linux gods", "two", "4"]``

## How to run the server
1. Install GraalVM: ``sdk install java 17.0.12-graal`` You need ``sdk`` installed to use to run the above command. See https://sdkman.io/install/ 
2. Switch to using GraalVM as the Java Runtime: ``sdk use java 17.0.12-graal``
3. Build the server: ``./mvnw package -Dpackaging=native-image`` This may take a while.
4. Run the executable. From the main project directory (linux-gods), run ``byteserver/target/byteserver``

Now use curl or a browser to access the two endpoints.

For more info, see the offical micronaut getting started guide: https://guides.micronaut.io/latest/creating-your-first-micronaut-app-maven-java.html


## Micronaut 4.6.3 Documentation

- [User Guide](https://docs.micronaut.io/4.6.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.6.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.6.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Maven Plugin documentation](https://micronaut-projects.github.io/micronaut-maven-plugin/latest/)
## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#nettyHttpClient)


## Feature maven-enforcer-plugin documentation

- [https://maven.apache.org/enforcer/maven-enforcer-plugin/](https://maven.apache.org/enforcer/maven-enforcer-plugin/)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


