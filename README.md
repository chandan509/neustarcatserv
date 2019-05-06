# neustarcatserv
Nuestar Company Task

# Deployed to PCF
* We can use https://nuestar-task.cfapps.io in plcase of localhost:8080 to directly access service over internet.

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

OUTPUT:
{
    "productList": [
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
            "category": "ANIMAL",
            "subCategory": "Cat"
        }
    ],
    "catGroup": {
        "PERSON": 2,
        "PLACE": 2,
        "COMPUTER": 1,
        "OTHER": 1,
        "ANIMAL": 2
    }
}

# Additional Details
* Currently only one instance is running in PCF
* We can scale the service by increasing the no of instances
* We have to create and bind rediscloud service and have common cache if we want to scale the service
* We can check load of each instance and health in PCF.
