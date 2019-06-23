   # Chess Knight's Minimum Moves REST API
   Description...
   
   ## Dependencies
   * Oracle JDK 1.8
   * Maven 3.6.1
   * Spring Boot 2.1.6
   * JAX-RS 2.1
   * Tomcat 9.0.21
   * JUnit 4.12
      
   ## Installation
   ```
   $ git clone https://github.com/backuot/knightmoves.git
   $ cd /knightmoves
   $ mvn install
   ```
   
   ## Run
   For run server:
   ```
   $ mvn spring-boot:run
   ```
   For run tests:
   ```
   $ mvn test
   ```
   
   ## Usage
   JAX-RS endpoint:
   ```
   $ curl -i "http://localhost:8080/knight/servlet/count?width=8&height=8&start=A1&end=E8"
   ```
   Spring Boot endpoint:
   ```
   $ curl -i "http://localhost:8080/knight/rest/count?width=8&height=8&start=A1&end=E8"
   ```
   
   ## Versions
   * 0.0.1
   
  ## Authors
  * **Dmitry Nazarov**
  
  ## License
  This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.