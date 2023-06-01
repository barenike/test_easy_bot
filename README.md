# test_easy_bot

Stack: Java 17, Spring 3.0, Maven, H2 and Basic JUnit tests

Current data storage approach is to store all data in a single table. I didn't want to overengineer since each product type has only one optional property. However, this approach is not viable for a bigger application.

To address this limitation, a more suitable approach would be to use a JSON-based NoSQL database like MongoDB. With MongoDB, we can conveniently store products with multiple optional properties as JSON documents.

However, since the technical task specifies the use of an in-memory database like H2, using MongoDB is not an option. We also can use an alternative approach that can be easily implemented with H2. This approach involves creating a second table, named products_properties, where we can store all the optional properties that are not shared between all products. This table would have columns such as id, productId, propertyName, and propertyValue, with productId serving as a foreign key referencing the main products table. By adopting this approach, we can establish a One-To-Many relationship between a product and its corresponding optional properties (if there are more than one optional property per product).

Swagger: http://localhost:8080/swagger-ui/index.html#/

Install:
1. docker pull barenike/test_easy_bot:0.0.1-SNAPSHOT
2. docker run --rm -p 8080:8080 barenike/test_easy_bot:0.0.1-SNAPSHOT
