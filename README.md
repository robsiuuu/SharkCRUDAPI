# How to shark api
*run in postman (not sure if needed but i recommend it)__
*have ammps running (i don't know if it's needed but better safe than sorry)__

1. run the "SharkApiApplication.java"

2. use these local host url:
http://localhost:8080/sharks for all sharks__
http://localhost:8080/sharks/{id} for a certain shark through id__
http://localhost:8080/sharks/search/{name} for a certain shark through name__
http://localhost:8080/sharks/species/{species} for a certain shark through species__
in post mode: http://localhost:8080/sharks/new to add more sharks__
in put mode: http://localhost:8080/sharks/{id} to update a specific shark__
in delete mode: http://localhost:8080/shark/{id} to delete a specific shark__

3. formats for adding/updating is:
{
"name": "{name}",
"description": "{desc}",
"species": "{species}"
}
