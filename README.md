#  Traini8 MVP - Government-Funded Training Centers Registry
##  Overview
Traini8 MVP is a **Spring Boot-based REST API** that allows the creation and retrieval of **government-funded training centers**.  
This project supports:
- ✅ **Adding new training centers with validation**
- ✅ **Fetching a list of all stored training centers**
- ✅ **Using an in-memory H2 database for quick persistence**
- ✅ **Exception handling for validation errors**
- ✅ **Performance-optimized API design**

---

##  **Tech Stack**
- **Backend**: Spring Boot, Java 17
- **Database**: H2 (In-memory Database)
- **ORM**: Spring Data JPA (Hibernate)
- **Validation**: Jakarta Validation (JSR-380)
- **Build Tool**: Maven
- **Testing**: JUnit, Mockito

---

##  **API Endpoints**

### 1️⃣ **Create Training Center (POST)**
**URL:**  

POST /api/training-centers

**Request Body (JSON)**:
```json
{
  "centerName": "ABC Training Center",
  "centerCode": "ABC123XYZ789",
  "address": {
    "detailedAddress": "123, MG Road",
    "city": "Bengaluru",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Python", "Spring Boot"],
  "contactEmail": "contact@abc.com",
  "contactPhone": "9876543210"
}

**Validations:**

centerName → Required, max 40 characters.
centerCode → Required, exactly 12 alphanumeric characters.
address → Required (object).
contactPhone → Required, valid 10-digit phone number.
contactEmail → Optional, but must be valid if provided.
createdOn → Auto-generated by the system (epoch time).

Response (201 - Created):

{
  "id": 1,
  "centerName": "ABC Training Center",
  "centerCode": "ABC123XYZ789",
  "address": {
    "detailedAddress": "123, MG Road",
    "city": "Bengaluru",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Python", "Spring Boot"],
  "createdOn": 1700000000,
  "contactEmail": "contact@abc.com",
  "contactPhone": "9876543210"
}
************************Get All Training Centers (GET)****************************

URL:
GET /api/training-centers

Response (200 - OK)
[
  {
    "id": 1,
    "centerName": "ABC Training Center",
    "centerCode": "ABC123XYZ789",
    "address": {
      "detailedAddress": "123, MG Road",
      "city": "Bengaluru",
      "state": "Karnataka",
      "pincode": "560001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Python", "Spring Boot"],
    "createdOn": 1700000000,
    "contactEmail": "contact@abc.com",
    "contactPhone": "9876543210"
  }
]

**If no data is found:**
[]

**********************************Project Structure**************************************
traini8/
├── src/
│   ├── main/java/com/example/traini8/
│   │   ├── controller/TrainingCenterController.java
│   │   ├── exception/GlobalExceptionHandler.java
│   │   ├── model/TrainingCenter.java
│   │   ├── model/Address.java
│   │   ├── repository/TrainingCenterRepository.java
│   │   ├── service/TrainingCenterService.java
│   │   ├── Traini8Application.java
│   ├── resources/
│   │   ├── application.properties
│   ├── test/java/com/example/traini8/
│   │   ├── TrainingCenterControllerTest.java
│   │   ├── TrainingCenterServiceTest.java
├── pom.xml
└── README.md


------------------------------------How to Run the Project---------------------------------------------

1.Clone the Repository

git clone https://github.com/your-username/traini8-mvp.git
cd traini8-mvp

2.Build the Project

mvn clean install

3.Run the Application

mvn spring-boot:run

4.Test APIs using Postman or Curl

curl -X POST http://localhost:8080/api/training-centers \
     -H "Content-Type: application/json" \
     -d @training-center.json


********************************** Validations Implemented**********************************

Field                                               Validation   
	                                           
centerName	                                  Required, max 40 chars
centerCode	                                Required, exactly 12 alphanumeric chars
address	                                Required (object)
studentCapacity	                                Optional (integer)
coursesOffered	                                Optional (list of text)
createdOn	                                Auto-generated by system
contactEmail	                                Optional, valid email
contactPhone	                                Required, valid phone

************************************Error Handling********************************************

🔹 400 Bad Request → Missing required fields, invalid email, phone number, or center code.
🔹 409 Conflict → Duplicate centerCode detected.

***************************************Testing****************************************************
Use Postman or cURL to test the APIs.
Ensure that the validation rules work correctly.
Verify database persistence using H2 Console (http://localhost:8080/h2-console).
