### **Seera Automation API Test**

#### Getting Started
    
Setup your machine:

* Install JDK 1.8

* Install IntelliJ (Community edition is fine)

* Install Cucumber Plugin To IntelliJ

#### Running tests:
* Right Click On The Feature You Want To Run And Select Run Feature
* To run BookApartment.feature run this command 
`mvn test -Dcucumber.options="--tags @book_apartment"`
* To run GetHotelsAndLocations.feature run this command 
`mvn test -Dcucumber.options="--tags @get_hotels_and_locations"`
* To run both scnarios run this command 
`mvn test -Dcucumber.options="--tags '@get_hotels_and_locations and @book_apartment'"`

### Reports

* Open courgette-report folder after running framework from target directory.
* Open `index.html` using any web browser
* Report will generate for each TestFlow.
