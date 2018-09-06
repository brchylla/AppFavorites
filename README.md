# AppFavorites
Hi, my name is Benjamin Chylla. I have developed this web application in order to apply for the Developer/Software Engineer position at the Great Lakes Bioenergy Research Center. Instructions and requirements for deploying the program are provided below:

# Server Requirements
The server running the web application must have Java (version 1.7 or above) and Apache Maven installed. 

# Running the App
Once you have installed the above requirements, run the following command in the AppFavorites directory using a command line application: 
```mvn spring-boot:run```
The program might take approximately one minute to run the first time, due to the building of dependencies via Maven, including an embedded data source: a server with MongoDB. Once the app starts running, you may access it in a browser by entering the following URL:
```localhost:8080```

NOTE: At the current time, the embedded server is unable to store data between sessions. Otherwise, the only requirement missing from this application is drag-and-drop functionality for the application links. This feature could not be completed in time, due in part to difficulties deploying NPM to my OS X machine.

# The Interface
Once you open the application, it opens a default user interface which displays a table of application links, but does not allow the user to add or remove applications. Although there is an "Add New App" modal in the top-left corner, none of the apps inside can be added to the application link table. A "Login" button is provided in the top-right corner, where you can login to the desired user account. After you are logged in, each application link in the table will display "Remove" link, allowing you to remove the link. Furthermore, each application link in the "Add New App" modal (top-left corner of the screen) can be added to the table by clicking on the "Add" link.