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
- Perform manual tests so as to understand the behaviour of the system;
- Automate the test cases using BDD practices;
- The requirements requested that was passed the parameters USERNAME and PASSWORD by command line instead of leaving hardcode;



