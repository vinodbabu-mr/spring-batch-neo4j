# spring-batch-neo4j
Reads a csv file and writes the contents into neo4j database

# Setup Steps
- Install Neo4j database in your desktop
- Leave DB with its default credentials neo4j/neo4j
- Run the Project as Java Application
- Hit the Rest URIs to validate the functionality

# REST Endpoints
# ``localhost:8081/rest/trigger``
- Inserts 5000 records from sales.csv into "Sales" Node in Neo4j DB
- Returns "COMPLETED" if Successful
- Returns "FAILURE" otherwise
	
# ``localhost:8081/rest/sales``
- Returns First 10 records from "Sales" Node
- Returns data in JSON response
- Returns 404 if records aren't available
