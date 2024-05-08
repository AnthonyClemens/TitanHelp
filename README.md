TitanHelp is a program that was commissioned by Saint Petersburg College, as a test of multiple student's ability to utilize different frameworks. 
Steps to run:
1.	With Maven installed, open the command prompt, and go to the TitanHelp directory.
2.	Type in “mvn clean package”
3.	Make sure you have MySQL8 server installed and running, with the root password set to “password”
4.	Once it compiles correctly, type in the command “./mvnw org.springframework.boot:spring-boot-maven-plugin:run”
5.	If no errors appear in the console, you can connect to the website by opening a browser and going to: “127.0.0.1:8080/ticket/form”
6.	Once a ticket is submitted, you can open up your MySQL8 command line and “select * from ticketdb.tickets” as Hibernate will automatically create this database and table if it is not already present.
7.	There you go! Tickets from Springboot, through Java, and then from Hibernate to SQL, all with frameworks.
