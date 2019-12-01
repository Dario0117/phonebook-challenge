
### The Phonebook code challenge ###
### Quick summary ###

The Phonebook code challenge is a non-finished JAVA project that its name explains it. Fork it and show us what you're capable of. Actually, here's the list of requirements that we expect you to accomplish:

1. Enable the 'Add contact' functionality
2. Enable the 'Search contact' functionality. Search must be enabled to be performed by any available criteria.
3. List the existent contacts. 
4. Create a DB (do whatever to persist data, not in memory of course -_-)

### How to run it ###

This project was built with:
- Java: 1.8.0_202
- Gradle: 5.3.1
- NodeJs: v12.13.1
- Npm: 6.12.1
- MySQL: 5.7.27

1. Install dependencies in both projects, in `phoneboko-challenge-ui` with npm and `phonebook-challenge` with gradle
2. Set the environment variables:
  - `MYSQL_HOST`
  - `MYSQL_USER`
  - `MYSQL_PW`
  
  **Note:** in the `application.property` file the MySQL port is `3307` (MySQL default port is `3306`).
  
3. In your MySQL database you need to create a schema called `phonebook`, customizable in the `application.property`
4. Start the backend with `gradle bootRun`, it start on port 8080
5. Check if the HOST is correctly configured in `App.js` on the front end directory
6. Run `npm start` on the front end project or build the project and run it