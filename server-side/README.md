# Magnificent Game

## Database Setup 
Currently the application runs locally only. Therefore the database has to be initialised locally.

### Prerequisites
- Have a version of MySQL > 8.0 (If you are downloading it, download it directly and not through a package manager like Homebrew)
- Have the MySQL Server running on your pc

### Steps
In the command line, run:
- Login to mysql with an admin user, i.e. ```$ mysql -u root -p``` and enter the password
- Execute ```mysql> CREATE USER 'magnificent'@'%' IDENTIFIED BY 'password';```
- Execute ```mysql> CREATE SCHEMA `magnificent` CHARACTER SET utf8 COLLATE utf8_general_ci;```
- Execute ```mysql> GRANT ALL ON `magnificent`.* TO 'magnificent'@'%';```
- Exit mysql and log back in as the magnificent user: ```$ mysql -u magnificent -p```

## Running the application
In the command line. Run:

```mvn clean install```

to create the jar file (in the target folder). Then to start the BE application (it is configured to use localhost:8080):

```java -jar target/magnificent-0.0.1.jar --DB_USERNAME=magnificent --DB_PASSWORD=password --DB_HOSTNAME=localhost```

Now start the client-side to get the whole application running locally.

## API information
Visit http://localhost:8080/swagger-ui.html to see Swagger generated documentation on the application.
