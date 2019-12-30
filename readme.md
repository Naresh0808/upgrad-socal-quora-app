# Quora Application Projection

 CheckList - Running the Application 
-    Postgres is running.
-    Database "quora" is created in database.
-    Check the version of java is 1.8 by java -version
-    Maven is installed and available to run commands.
        . check mvn is recognized.
-    Now configure the required files like local.properties and application.yaml
     * for port
     * username 
     * password
-    First commands are mvn clean install -Psetup (setup the db )
-    Later you can run mvn clean install
-    Please check the Generated Models in quora-api -> target -> generated-sources