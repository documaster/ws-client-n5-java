Documaster Noark 5 web services client
---------------------------------------

## Introduction

This repository contains the code for the [Documaster Noark 5 web services](https://github.com/documaster/noark5-web-services/) client. To use the client, add the latest version of the following Maven artifact as a dependency to your project:

```
<dependency>
  <groupId>com.documaster.rms</groupId>
  <artifactId>documaster-ws-client-n5</artifactId>
  <version>VERSION</version>
</dependency>
```

## Prerequisites

**Required**
* JDK 8

**Optional (only required to build the code)**
* Maven
* Internet connection (unless dependencies are already available in the local Maven repository)

## Build

```
mvn clean package
```

## Samples

Code samples demonstrating the usage of the client are available [here](https://github.com/documaster/ws-client-n5-java-samples).

## Choosing the right client version

We aim to maintain backwards compatibility with each update to the web services. Backwards-incompatible updates are extremely rare and always introduced as a new **major version** of the services.

When developing an integration with Documaster, you should always use the most recent version of the client because it contains the latest bug fixes and improvements. Note that using the latest version of the client may cause issues if you develop an integration against the latest Documaster version and then deploy the code in production with older Documaster versions (due to functionality available in the client but not in Documaster). To avoid this, you should always have your Documaster instances upgraded prior to deploying the integration in production. Note that simply upgrading the version of the client in a production integration should not have any negative effect on the integration.

## License

This project is licensed under the Apache License, Version 2.0 - see the [LICENSE.txt](LICENSE.txt) file for details.
