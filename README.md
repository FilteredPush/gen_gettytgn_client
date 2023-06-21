# gen_gettytgn_client
Artifacts to generate java client code for Getty's TGN SOAP service. 

## Generate sources

Uses the WSDL file at http://vocabsservices.getty.edu/TGNService.asmx?WSDL and the jaxws-maven-plugin

    mvn clean jaxws:wsimport

The pom is configured to generate these sources into src/main/java

After generation, run 

    mvn test 

for a minimal test of the generated client code against the TGNservice.

See ... for the source code of this test and 
an example of invocation of the ... service call.

### To see the com.sun.xml.ws jaxws-maven-plugin documentation for other configuration options: 

   mvn jaxws:help

   mvn jaxws:help -Ddetail=true -Dgoal=wsimport
