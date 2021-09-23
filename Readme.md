# PicRecon
An Image repository application that enables users to upload, view, categorize, and delete images. 

This is the web application flavour of the project. Keep a lookout for this application being available in all the major platforms including windows, MacOs, iOS, and android. 

### Inspiration
The inital inspiration behind starting the project was that it has become very common to have access to massive storage devices, the only drawback being that you cannot carry your storage everywhere. Moreover, a majority of people have access to desktop computers that are just sitting with your media but you cannot access them remotely. The most convinient solution in this case is to use cloud storage which might not be suitable for everyone. And that still doesn't exploit the resources you yourself own. Therefore, I wanted to build an application that gives you access to your media remotely from anywhere. Altough the current version of the application is no way near accomplishing that, it's a genuine first step.

### Technology Stack:
- The frontend of the web application is developed using Angular framework
- The backend is developed using java sprign boot framework
- The user and image metadata is hosted on MongoDB Atlas

## Running Instructions:
### Backend
Prerequisites: Make sure that you have Java version 15 or higher installed on your machine.

For now open the project in IntelliJ and click on the run button. 

### Frontend
Prerequisites: Make sure that you have Node.Js, npm package manager, and Angular cli installed

Navigate to the main directory of the project using terminal and execute the following commands
```
cd Frontend/picrecon
ng server
```

## Version Info
The user has the option to upload, view, and delete images. Moreover, there can be a single user only. Working on adding functionality for multiple users and searching images based on items in them.


## Built With:
Java, Spring boot, MongoDB, TypeScript, Angular, Html, CSS, Postman