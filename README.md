# microprofile-config-example

This project defines a Web app that uses the Eclipse Microprofile Config API to read its configuration.

It is deployed in WildFly and uses its microprofile-config Susbystem extension.

# Instructions

To run the example, you need:

* Compile and deploy the [microprofile-config-extension](https://github.com/jmesnil/microprofile-config-extension) extension in WildFly
* Package this Web app and deploy it in WildFly:

````
mvn clean package deploy
````

* Go to [http://localhost:8080/microprofile-config-example/config/all](http://localhost:8080/microprofile-config-example/config/all) to see all the properties that are accessed by the Web app.

They include:
 * environment properties
 * System properties
 * Properties from the [src/main/resources/META-INF/microprofile-config.properties](src/main/resources/META-INF/microprofile-config.properties) file


