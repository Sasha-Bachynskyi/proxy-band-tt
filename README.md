## Spring Boot API with MongoDB
***
# Functional:
- Table ```users``` with fields ```name``` and ```email```
- Create new users
- Delete users
- Update users
- Show all users
#Steps to run
1. Download, install and run MongoDB by path ```MongoDB\Server\5.0\bin\mongod.exe```
2. Clone repository and run ```TestTaskApplication``` class
3. Download, install and run Postman
4. To add new users use ```POST``` method and ```localhost:8080/users``` path, in body you should fill in ```name``` and ```email``` in JSON format
5. To show all users use ```GET``` method and ```localhost:8080/users``` path
6. To update user use ```PUT``` method and ```localhost:8080/users/(id)``` path, in body you should fill in ```name``` and ```email``` in JSON format
7. To delete user user ```DELETE``` method and ```localhost:8080/users/(id)``` path
