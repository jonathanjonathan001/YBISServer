
<h1>YBIF SHOP SERVER</h1>
Run.. <br>
docker network create my-network<br><br>
docker run --network my-network --name=mysql-ybis-network -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=ybis -e MYSQL_USER=dev -e MYSQL_PASSWORD=password  mysql:latest<br><br>
mvn clean package -Dmaven.test.skip<br><br>
docker build -t com.jonfen/ybis .<br><br>
docker run -d --name=ybis-server --network my-network -p 8080:8080 com.jonfen/ybis<br><br>
____________<br><br>
You can connect to the database using for instance DataGrip
on localhost:3306/ybis with username dev and password password
and create two products:<br>
INSERT INTO product (id, name, description, price, image_url, stock)<br>
VALUES (1, 'T-shirt', 'A beautiful t-shirt', 100, 'Images/t-shirt-1', 100);
<br><br>
INSERT INTO product (id, name, description, price, image_url, stock)<br>
VALUES (2, 'Vinyl', 'I Completely disagree on Vinyl', 150, 'Images/vinyl-1', 100);
<br><br>
GET request http://localhost:8080/products should give you the products
