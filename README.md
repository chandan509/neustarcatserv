# neustarcatserv
Nuestar Company Task

# Get Categories
http://localhost:8080/neustarcatserv/categories
method: GET
Content-Type: application/json

# Create Categories
http://localhost:8080/neustarcatserv/categories
method: POST
Content-Type: application/json
body:{
    "name": "PERSON"
}

# Remove Category
http://localhost:8080/neustarcatserv/categories
method: DELETE
Content-Type: application/json
body:{
    "name": "PERSON"
}
