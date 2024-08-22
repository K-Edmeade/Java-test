Java-test

This Java app can be used to process a csv file into a database and to get data from said database using a customer reference. This is all done through the console.

Prerequisites

Java 17: Ensure you have Java 17 installed. This tool requires Java 17 for proper execution.
PostgreSQL: You need PostgreSQL for the database. Make sure you have it installed and running.
Installation

1. Clone the Repository
Start by cloning the repository to your local machine:

bash
Copy code
git clone (https://github.com/K-Edmeade/Java-test.git)
cd java-test
2. Set Up PostgreSQL
Install PostgreSQL: If PostgreSQL is not installed, download and install it from the official PostgreSQL website.
Create a Database:
Open the PostgreSQL command-line interface or use a graphical tool like pgAdmin, and execute the following commands:

sql
Copy code
CREATE DATABASE mydatabase;
Create a Database User (if not using the default postgres user):
Create a new user with appropriate privileges:

sql
Copy code
CREATE USER postgres WITH PASSWORD 'mysecretpassword';
GRANT ALL PRIVILEGES ON DATABASE mydatabase TO postgres;
If you are using the default postgres user, you can skip this step.
3. Configure the Application
Database Connection:
Update the database connection settings in src/main/resources/application.properties with the following:

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=postgres
spring.datasource.password=mysecretpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build the Project:
Build the project using Maven or Gradle, depending on your setup:

For Maven:

bash
Copy code
./mvnw clean install
For Gradle:

bash
Copy code
./gradlew build
4. Run the Application
To run the application, use the following command:

bash
Copy code
./mvnw spring-boot:run
or

bash
Copy code
./gradlew bootRun
5. Access the Tool
Once the application is running, you can access it at http://localhost:8080.

6. Troubleshooting
Java Version Issues: Ensure you are using Java 17. Verify by running java -version.
Database Connection Issues: Ensure PostgreSQL is running and accessible. Verify that the application.properties file has the correct database credentials and that the mydatabase database is available.
Contributing

Contributions are welcome! Please follow the contributing guidelines for more information.

License

This project is licensed under the MIT License.
