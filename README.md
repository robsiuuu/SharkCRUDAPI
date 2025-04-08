# How to shark api
*run in postman (not sure if needed but i recommend it) <br />
*have ammps running (i don't know if it's needed but better safe than sorry) <br />

1. run the "SharkApiApplication.java"

2. use these local host url: <br />
http://localhost:8080/sharks for all sharks <br />
http://localhost:8080/sharks/{id} for a certain shark through id <br />
http://localhost:8080/sharks/search/{name} for a certain shark through name <br />
http://localhost:8080/sharks/species/{species} for a certain shark through species <br />
in post mode: http://localhost:8080/sharks/new to add more sharks <br />
in put mode: http://localhost:8080/sharks/{id} to update a specific shark <br />
in delete mode: http://localhost:8080/shark/{id} to delete a specific shark <br />

3. formats for adding/updating is:<br />
{ <br />
"name": "{name}", <br />
"description": "{desc}", <br />
"species": "{species}" <br />
}
