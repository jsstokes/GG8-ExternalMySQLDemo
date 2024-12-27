# External Storage with MYSQL Demo (GridGain v8)

## Prerequisites
* Install MySQL and create a database
  - I used STOKES as the database name
  - MySQL 9.0.1 was used
  - If you use another you will have to adjust the src/main/resources/mysql-pojo-config.xml file appropriately
* Install the MySQL JDBC Driver from https://dev.mysql.com/downloads/connector/j/
  * Make sure to copy the jar file into the /libs folder of your GridGain install
* Install GridGain and configure properly with a license key
  - This was tested with GridGain Enterprise 8.9.15
* Access to Control Center
  - I used a local control center but Nebula should work as well

## Notes
* I followed the directions from https://ignite.apache.org/docs/latest/persistence/external-storage 
* It is important to change the fully qualified names to match the Person class you create
* Also, add the @QuerySqlField to each of the attributes or you will not be able to see anything created
with a cache.put statement

##  Issues
1. Data inserted using Cache.put do not show up until the GG instance is restarted and the cache
is loaded from the data store

## Running the demo
1. Insert a few records into the person table in MySQL
> insert into person (id, name) values (1,'First Name')  
> insert into person (id, name) values (1,'First Name')
> etc ...
2. Start your gridgain instance:
> from the $GRIDGAIN_HOME/bin directory
> 
> ignite.sh <i>path_to_the_config)file
3. Add the cluster to control center <br>
4. Goto Caches  
  Select the 3 elipses (...) and then "Load from cache store"  
   <br/>
5. Goto Queries and run
  > SELECT ID, NAME FROM PERSON;

6. Execute the code: ConfigFromJava class<br>


7. Play with queries to select the data
* There should be 2 new records
  - One of them may be hidden - run a scan query to see it
  - If you kill, restart, and load from cache store again, the record should show in the SQL Query results


