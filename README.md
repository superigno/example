# example
Spring boot with REST example

1. Clone repo
- git clone https://github.com/superigno/example.git

2. Go to folder
- cd example

3. Install
- mvn clean install

4. Go to target folder
- cd target

5. Run
- java -jar example-0.0.1-SNAPSHOT.jar

6. Open another terminal

- Task 1  
curl http://localhost:8080/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d '{"searchText":["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}' -H "Content-Type: application/json" -X POST
- Task 2  
curl http://localhost:8080/counter-api/top/20 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
