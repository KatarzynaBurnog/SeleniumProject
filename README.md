# SeleniumProject
Selenium Projects

Description of the implementation

The following technologies are used in order to implement the test cases:
-	Selenium WebDriver
-	Testng

Test cases are respecting the Page Object Pattern. There are 2 main packages in the project:
-	selenium.pages - where are implemented the necessary page classes. Each page class represents a page from the application. If something is changed in the UI, there should be done a change in the corresponding page class
-	selenium.tests - containing all the test scenario. A test scenario is build of page instances.

Configuration of test cases
The configuration of test cases is done in the testng.xml file:

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="JobSearchTestSuite" verbose="1" parallel="tests" thread-count="1">

    <listeners>
        <listener class-name="utils.LoggerListener"/>
    </listeners>

    <parameter name="url"  value="http://akamaijobs.referrals.selectminds.com"/>
    <parameter name="timeToWait"  value="10"/>

    <test name="FirefoxTest">
        <parameter name="browser"  value="firefox"/>
        <parameter name="geckodriverPath" value="D:\\geckodriver-v0.11.1-win64\\geckodriver.exe"/>
        <parameter name="pathToDriver"  value=""/>
        <classes>
            <class name="selenium.tests.SearchJobTest"/>
        </classes>
    </test>

</suite>

Technologies

- Java
- Maven

Dependencies

- Selenium 3.0.1
- Testng 6.9.9

Executing the test cases

Test cases can be run directly from the IDE, by executing the testng.xml file.

Before you run tests you must define path to geckodriver.exe inside the file testng.xml:

parameter name="geckodriverPath" value="D:\\geckodriver-v0.11.1-win64\\geckodriver.exe"


