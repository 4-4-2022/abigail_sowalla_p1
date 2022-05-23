# abigail_sowalla_p1
## Project Description
"Enlightening Escapades Study Abroad Services" is an API for viewing, booking, and making payments on study abroad trips.

This project is composed of two REST services and one SOAP service called by a public-facing REST client. One REST service handles trip data, another handles booking data, and the SOAP handles payment data.
## Technologies Used
* JAVA
* SQL
* Spring AOP
* Spring Boot
* Spring Data
* SOAP
* REST 
## Features
* GET, PUT, DELETE, and POST requests for trip data
* GET, PUT, DELETE, and POST requests for booking data
* GET requests for payment data
## Getting Started
You will need to download this repository then run the services in Spring Tools Suite or a similar program capable of running REST and SOAP services.
### Downloading the Repository
* On the main page of this repository, click _"Code,"_ the copy the HTTPS address.
* Open Git Bash.
* Navigate to the directory where you intend for the repository to be downloaded.
* Type _git clone_, then paste the repository URL.
* Press _Enter_ on your keyboard. The repository will download.
### Running the Services
* Open Spring Tools Suite or a similar program.
* Open the downloaded repository (_File_ -> _Open Projects from File System_ -> input the directory with the downloaded repository -> _Finish_).
* Run _BookingService_, _PaymentService_, and _TripService_ in any order.
* Run _rest_consumer_ __after__ the other services are running.
## Usage
Once you run the services, you can send requests through clients such as ARC and Postman.
### Commands:
Function  | Request type  |  Request  |  Example Body (JSON)
------------- | ------------- | ------------- | -------------
View all trips  | GET  |  http://localhost:8000/trips/all 
Find a trip by ID  | GET  |  http://localhost:8000/trips?id={id}
Create a new trip  |  POST  |  http://localhost:8000/trips/new  |  {"id": 6, "name": "Italy Adventure", "semester": "Summer", "cost": 6999.99, "description": "Italy Adventure is a great trip for art majors!"}
Remove a trip  |  DELETE  |  http://localhost:8000/trips/delete?id={id}
Update a trip description  |  PUT  |  http://localhost:8000/trips/describe?id={id}  |  "Italy Adventure is a great trip for art majors!"
Update a trip cost  |  PUT  |  http://localhost:8000/trips/newcost?id={id}  |  6999.99
View all bookings  | GET  |  http://localhost:8000/bookings/all
Find a booking by ID  | GET  |  http://localhost:8000/bookings?id={id}
Create a new booking  |  POST  |  http://localhost:8000/bookings/new  |  {"id": 5, "studentName": "Bob Ross", "tripID": 2, "date": 11082022, "dueDate": 12092022}
Remove a booking  |  DELETE  |  http://localhost:8000/bookings/delete?id={id}
Update a booking payment due date  |  PUT  |  http://localhost:8002/bookings/newduedate?id={id}  |  12312022
View all payments  | GET  |  http://localhost:8000/payments/all
