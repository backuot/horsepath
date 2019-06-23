   # Chess Knight's Minimum Moves REST API
   For chessboard of M x N size, given the position of knight and position of target. Need to find, 
   out minimum steps a Knight, will take to reach the target position. 
   
   This problem can be seen as shortest path in unweighted graph. For solution this problem uses 
   Breadth-first search (BFS) algorithm. We try all 8 possible positions of a Knight, and 
   if reachable position is not already visited and is inside the board, we push this position 
   into queue with distance 1 more than its parent position. We are implements BFS for searching 
   through nodes, where each node contains its coordinate and distance from starting node. 
   In worst case, algorithm visits all nodes of board, making worst-case time complexity as O(N^2).

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