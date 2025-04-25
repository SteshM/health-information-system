### HEALTH INFORMATION SYSTEM
##Sample Request http://localhost:8080/v1/program/create
```
{
   "name":"HIV Prevention awareness",
    "description":"Empowering communities with knowledge and tools to prevent HIV and promote healthy, stigma-free lives.",
    "startDate": "2024-01-01",
   "endDate": "2024-12-31"
}
```
##Sample Response
```
{
"statusCode": "0000",
    "statusMessage": "successfully created a health program",
    "data": [],
    "errors": []
}
```
##Sample Request http://localhost:8080/v1/client/create
```
{
    "firstName":"Stella",
    "lastName":"Mbithe",
    "email":"mbithestella0@gmail.com",
    "dateOfBirth":"2000-05-15",
    "gender":"female",
    "phoneNumber":"0712345789",
    "password":"pass1234",
    "metaData":{
      "idNumber":"39876543"

    }
}
```
##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "Successfully created a client",
    "data": [],
    "errors": []
}
```
##Sample Request http://localhost:8080/v1/enrollment/enrol
```
 {
  "clientId": 1,
  "healthProgramIds": [1,2],
  "enrollmentDate": "2025-04-25"
}
```

##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "Enrolled client to a program successfully",
    "data": [],
    "errors": []
}
```

##Sample Request http://localhost:8080/v1/client/view/1
```
```

##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "Successfully fetched a client",
    "data": [
        {
            "clientId": 1,
            "firstName": "Stella",
            "lastName": "Mbithe",
            "email": "mbithestella0@gmail.com",
            "dateOfBirth": "2000-05-15",
            "gender": "female",
            "phoneNumber": "0712345789",
            "metaData": {
                "idNumber": "39876543"
            }
        }
    ],
    "errors": []
}
```
##Sample Request http://localhost:8080/v1/client/1/profile
```
```

##Sample Response
```
{

    "statusCode": "0000",
    "statusMessage": "Successfully fetched client profile",
    "data": [
        {
            "clientId": 1,
            "firstName": "Stella",
            "lastName": "Mbithe",
            "phoneNumber": "0712345789",
            "email": "mbithestella0@gmail.com",
            "dateOfBirth": "2000-05-15",
            "gender": "female",
            "metaData": {
                "idNumber": "39876543"
            },
            "enrolledPrograms": [
                 
                {
                    "healthProgramId": 1,
                    "name": "Malaria Prevention awareness",
                    "description": "Providing mosquito nets and awareness for rural communities.",
                    "startDate": "2024-01-01",
                    "endDate": "2024-12-31",
                    "active": true
                },
                {
                    "healthProgramId": 2,
                    "name": "HIV Prevention awareness",
                    "description": "Empowering communities with knowledge and tools to prevent HIV and promote healthy, stigma-free lives.",
                    "startDate": "2024-01-01",
                    "endDate": "2024-12-31",
                    "active": true
                }
            ]
        }
    ],
    "errors": []
}
```
##Sample Request http://localhost:8080/v1/client/search
```
```
##Sample Response
```
{
    "content": [
        {
            "clientId": 1,
            "firstName": "Stella",
            "lastName": "Mbithe",
            "email": "mbithestella0@gmail.com",
            "dateOfBirth": "2000-05-15",
            "gender": "female",
            "phoneNumber": "0712345789",
            "metaData": {
                "idNumber": "39876543"
            }
        },
        {
            "clientId": 2,
            "firstName": "Bahati",
            "lastName": "Maneno",
            "email": "bahatimaneno0@gmail.com",
            "dateOfBirth": "2000-02-15",
            "gender": "male",
            "phoneNumber": "0716345769",
            "metaData": {
                "idNumber": "39876526"
            }
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
}
```
##Sample Request http://localhost:8080/v1/client/1
```
{
    "firstName":"Stella",
    "lastName":"Mbithe",
    "email":"mbithestella0@gmail.com",
    "dateOfBirth":"2000-05-15",
    "gender":"female",
    "phoneNumber":"0712345789",
    "password":"pass1234",
    "metaData":{
      "idNumber":"39876543"

    }
}
```

##Sample Response 
```
{
    "statusCode": "0000",
    "statusMessage": "Updated a client's details successfully",
    "data": [
        {
            "clientId": 1,
            "firstName": "Stella",
            "lastName": "Mbithe",
            "email": "mbithestella0@gmail.com",
            "dateOfBirth": "2000-05-15",
            "gender": "female",
            "phoneNumber": "0712345789",
            "metaData": {
                "idNumber": "39876543"
            }
        }
    ],
    "errors": []
}
```
##Sample Request http://localhost:8080/v1/client/2
```
```

##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "client  deleted successfully",
    "data": [],
    "errors": []
}
```

##Sample Request http://localhost:8080/v1/program/search
```
```

##Sample Response
```
{
    "content": [
        {
            "healthProgramId": 1,
            "name": "Malaria Prevention awareness",
            "description": "Providing mosquito nets and awareness for rural communities.",
            "startDate": "2024-01-01",
            "endDate": "2024-12-31",
            "active": true
        },
        {
            "healthProgramId": 2,
            "name": "HIV Prevention awareness",
            "description": "Empowering communities with knowledge and tools to prevent HIV and promote healthy, stigma-free lives.",
            "startDate": "2024-01-01",
            "endDate": "2024-12-31",
            "active": true
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 2,
    "totalPages": 1,
    "first": true,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 2,
    "empty": false
}
```
##Sample Request http://localhost:8080/v1/program/3
```
{
    "name":"TB",
    "description":"Empowering communities with knowledge and tools to prevent TB and promote healthy, stigma-free lives.",
    "startDate": "2024-01-01",
     "endDate": "2024-12-31"
}
```

##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "Updated a health program successfully",
    "data": [
        {
            "healthProgramId": 3,
            "name": "TB",
            "description": "Empowering communities with knowledge and tools to prevent HIV and promote healthy, stigma-free lives.",
            "startDate": "2024-01-01",
            "endDate": "2024-12-31",
            "active": true
        }
    ],
    "errors": []
}
```

##Sample Request http://localhost:8080/v1/program/view/1
```
```

##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "Successfully fetched a health program",
    "data": [
        {
            "healthProgramId": 1,
            "name": "Malaria Prevention awareness",
            "description": "Providing mosquito nets and awareness for rural communities.",
            "startDate": "2024-01-01",
            "endDate": "2024-12-31",
            "active": true
        }
    ],
    "errors": []
}
```
##Sample Request http://localhost:8080/v1/program/3
```
```

##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "health program deleted successfully",
    "data": [],
    "errors": []
}
```

##Sample Request http://localhost:8080/v1/enrollment/program/2/clients
```
```
##Sample Response
```
{
    "statusCode": "0000",
    "statusMessage": "Successfully fetched clients enrolled in program",
    "data": [
        {
            "clientId": 1,
            "firstName": "Stella",
            "lastName": "Mbithe",
            "email": "mbithestella0@gmail.com",
            "dateOfBirth": "2000-05-15",
            "gender": "female",
            "phoneNumber": "0712345789",
            "metaData": {
                "idNumber": "39876543"
            }
        },
        {
            "clientId": 1,
            "firstName": "Stella",
            "lastName": "Mbithe",
            "email": "mbithestella0@gmail.com",
            "dateOfBirth": "2000-05-15",
            "gender": "female",
            "phoneNumber": "0712345789",
            "metaData": {
                "idNumber": "39876543"
            }
        }
    ],
    "errors": []
}
```




















