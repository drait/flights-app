1 - To run the server app (Spring Boot + MongoDB): 
	a - naviagte to assignment/server/fligt-app
	b - run this command : mvn spring-boot:run
	c - open a borwser and navigate to : http://localhost:8080
	d - to make sure the back-end api is working fine, just naviagte to : http://localhost:8080/api/flights (will return all the flights in the mongoDB database)

	
2 - To run the client app (Angular 2+):
	a - nvaigate to assignment/client/flight-app
	b - run : npm install (install all the required dependecies for the project)
	c - ng serve, it will start a local server and watches changes
	d - open a browser and navigate to : http://localhost:4200

	


N.B : 
* I used a hosted maongodb database (https://mlab.com/)
* due to time resttriction, i did not implemented many nice to have features :
	1 - unit tests for both apps (client/server)
	2 - code comments for both client/server apps
	3 - enhance the algorithm for searching a flight
	4 - add more vlaidation for user inputs and back-end validation


Please, watch my github (https://github.com/drait/flights-app)
for coming changes

