## Technology Stack
- Java 8
- Junit
- Maven

## Run Instructions 
  - checkout the project
  - just run mvn command: 
   ``mvn clean install``
  - the jar file should appear under the `target` folder
  - run jar command:
    ``java -jar target/DateCalculator-1.0.jar``

## Input
On Run you will be prompted to enter two dates.
 Valid Date Format: ``dd/MM/YYYY``
 
 Example: ```01/01/2018```
 
 Which will return the number of days difference 
 
### Example:
 ``` 
 java -jar target/DateCalculator-1.0.jar
    Enter First Date: (example: 01/01/2012)
    03/01/1989
    Enter Second Date:
    03/08/1983
    Result : 1979 days
 ```
  