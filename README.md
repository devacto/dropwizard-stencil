## Dropwizard Stencil

Dropwizard is a microservice framework. This stencil shows various configurations and libraries we added to Dropwizard.

### Principle

This stencil should be really small because it is a microservice.

### Features

* Source code and tests are written in Groovy.
* Gradle is used as a build tool.
* Code quality checks using Checkstyle and CodeNarc.
* Runs unit tests.
* Code coverage are being measured, and we know how it changes (up or down).
* Has precommit which checks code quality, runs tests and produces code coverage reports.
* Has a banner.
* Has health check page (/health).
* Has info page that shows version, etc. (/info).
* Has Groovy console to aid development.
* Has centralised logging using Log4J or SLF4J
* Has Mockito and Hamcrest to assist testing.
* Google Guice for dependency injection.
* Package into RPM.
* RPM then will be put into Docker image.

### Later

Other functionalities such as PactJVM, Retrofit, RxJava, Hibernate, Flyway, MongoDB connections will be added later.

### How to use

##### To run the webservice

`./gradlew installApp`
`./build/install/dropwizard-stencil/bin/dropwizard-stencil server conf/stencil-service.yml`

### License

MIT