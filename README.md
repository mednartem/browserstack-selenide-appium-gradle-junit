Mobile tests with use browserstack

### Dependencies:

* Java 8
* Selenide 5.15.1
* JUnit 5.6.2
* Aspectj 1.9.5
* Rest Assured 4.1.2
* Appium 7.3.0
* Owner 1.0.12
* Allure-selenide 2.13.6
* Allure plugin 2.8.1

For run tests need to pass credentials with System.properties or update file remote.properties
> browserstack.username=
> 
> browserstack.password=

Then run tests with use terminal

Android:
> gradle android

 Ios:
> gradle ios

