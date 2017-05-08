## Project Structure
For this project I toke the following steps:
- The programming language is JAVA;
- Create a Maven project to build the program;
- Add all dependences in pom.xml regarding some frameworks that I used such as Cucumber, JUnit and Selenium;
- Add all drivers that will be used when launched the browsers, so I considered the following browsers (Chrome, Firefox and IE);
- Create all packages/files to store all page objects, feature file and steps definition

## Page Objects
There are 2 pages for automation which are "Login Page" and "Secure Area Page":
- Each page becomes a class and each element becomes a variable in this class;
- Write all required methods to manage the page as per the requirements;
- Create a abstract class to manage the webdriver in order to use it only once and it is passed through the constructor when a new object is created;
- In abstract class was created common methods that will be invoked for all pages/classes (reusability);

## BDD (Feature file / Step definition)
BDD requires a feature file to invoke the step definitions:
- Create the scenarios in feature file as per the requirements, so each step in feature file has to match a step definition in class file;
- Following the BDD practices for coding;
- Using the special annotation like "@Before" which is the first method to run for each scenario. Moreover, this is the right place to set up the browser by setting the right driver for different browser;
- Using the special annotation like "@After" which is the last method to run when the scenarios has ended;
- The webdriver is declared and initialized in this phase and it is passed during order processing to each page;
- Implement the assert statements in the steps to ensure the processing is as per business rules;

## Testing procedures
- Read the requirements to know what the system really does;
- Perform manual tests so as to understand the behaviour of the system;
- Automate the test cases using BDD practices;
- The requirement rules asked to pass the parameters "USERNAME" and "PASSWORD" by command line instead of leaving hardcode;

## How to run it
- First, it is necessary to declare which parameters should be passed by command line or VM arguments in Java. Follow the below image to illustrate it. So, in this project is necessary to pass 3 parameters in run execution such as USERNAME, PASSWORD and BROWSER.

![config file](https://cloud.githubusercontent.com/assets/25671064/25788799/2c745bf6-3382-11e7-8761-0ba7bddbc88a.jpg)

- Observation: It is possible to run it through prompt command by invoking the java file and passing these 3 parameter values too;

- It is possible to run it in two different ways such as:
- 1 - By feature file directly;
- 2 - By a runner using Cucumber;

