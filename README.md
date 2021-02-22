# Mobiquity code test

#Description
 Implemented rest service for https://www.ing.nl/api/locator/atms/ 
 Added services to fetch card data along with address.
 

#Technologies Used
Spring boot , spring 

# Instalation and Usage
Step 1:import project into any ide tool
Step 2:run gradle build to get dependencies into project
Step 3:open AtmsApplication java file and run with ide or deploy any server
step 4:hit below urls from curl or postman or browser
curl http://localhost:8080/api/atmslist 
this uri will get all the records.

curl http://localhost:8080/api/atmslist?city=Den%20Haag
this uri will give only specific city records


