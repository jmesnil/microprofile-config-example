# microprofile-config-example

This project defines a Web app that uses the Eclipse Microprofile Config API to read its configuration.

It is deployed in WildFly and uses its microprofile-config Susbystem extension.

# Instructions

To run the example, you need:

1. Compile and deploy the [microprofile-config](https://github.com/jmesnil/microprofile-config-extension) extension in WildFly
2. Add the extension and subsystem to WildFly:

````
/extension=net.jmesnil.microprofile-config-extension:add()
/subsystem=microprofile-config:add()
````

3. Package this Web app and deploy it in WildFly:

````
mvn clean package deploy
````

4. Go to http://localhost:8080/microprofile-config-example/config/all to see all the properties that are accessed by the Web app.

They include:
 * environment properties
 * System properties
 * Properties from the src/main/resources/META-INF/microprofile-config.properties file


