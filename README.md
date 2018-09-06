# AppFavorites
Hi, my name is Benjamin Chylla. I have developed this web application in order to apply for the Developer/Software Engineer position at the Great Lakes Bioenergy Research Center. Instructions and requirements for deploying and using the program are provided below:

#Server Requirements
The server running the web application must have Java (version 1.7 or above) and Apache Maven installed. 

#Running the App
Once you have installed the above requirements, run the following command in the AppFavorites directory using a command line application: 
```mvn spring-boot:run```
The program might take approximately one minute to run the first time, due to the building of dependencies via Maven, including an embedded data source: a server with MongoDB. 

NOTE: At the current time, the embedded server is unable to store data between sessions. Otherwise, the only requirement missing from this application is drag-and-drop functionality for the application links. This feature could not be completed in time, due in part to difficulties deploying NPM to my OS X machine.