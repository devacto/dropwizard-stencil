## Dropwizard Stencil

Dropwizard is a microservice framework. This stencil shows various configurations and libraries we added to Dropwizard.

### Features

* Code coverage
* Health check page
* Info page
* Docker
* MySQL database connector (optional)
* MongoDB database connector (optional)
* Groovy console
* Precommit

### Libraries

* Dropwizard
* Gradle
* Groovy
* Codenarc
* Checkstyle
* Jacoco
* Retrofit
* RxJava
* Google Guice
* Shadow
* Mockito
* Hamcrest
* PactJvm
* Hystrix

### To do

* Something

### How to use

##### To build the code

`gradle build --refresh-dependencies`

##### To run the web service

`gradle run`

#### To get persons

After the above `gradle run`, open up your browser and type `http://localhost:8080/people`

### License

MIT