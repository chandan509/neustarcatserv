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

# Process Data
http://localhost:8080/neustarcatserv/process
method: POST
Content-Type: application/json
body:[
  {
    "category": "PERSON",
    "subCategory": "Bob Jones"
  },
  {
    "category": "PLACE",
    "subCategory": "Washington"
  },
  {
    "category": "PERSON",
    "subCategory": "Mary"
  },
  {
    "category": "COMPUTER",
    "subCategory": "Mac"
  },
  {
    "category": "PERSON",
    "subCategory": "Bob Jones"
  },
  {
    "category": "OTHER",
    "subCategory": "Tree"
  },
  {
    "category": "ANIMAL",
    "subCategory": "Dog"
  },
  {
    "category": "PLACE",
    "subCategory": "Texas"
  },
  {
    "category": "FOOD",
    "subCategory": "Steak"
  },
  {
    "category": "ANIMAL",
    "subCategory": "Cat"
  }
]
