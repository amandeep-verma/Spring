
package com.telusko.demoRest1;
/*
 V1-13
 The program starts with making a jersey project in maven.
 You might have to make changes in pom.xml file to get rid of error.
 
 Now the program has webapp->WEB-INF->index.jsp which is the page loads in your browser when you start the program.
 We start with making Alien class and Alien Resource. We give a @Path annotation to the AlienResource. Again for the method
 inside we specify @GET to say it is called for get request and @Produces(MediaType.APPLICATION_XML) to mention that the
 output is of type XML. 
 Now to the alien class we specify the annotation @XmlRootElement which states when you return object of this class it returns
 XML object of its properties with Root element of XML file specified as object of the class.
 
 Now we make another class AliensResource which on the call returns List<Alien>
 
 
 Now we make AlienRepository class which acts like pesudo database. Proceeding from here.
 AlienRepository class have method getalien(int id) which matches if the repository contains an alien with that id and returns 
 it. Now in AliensResource we are getting data from repository.
 
 HTTP Methods for RESTful Services
 @GET is for fetching the data
 @POST is for sending the data
 @PUT is for updating the resource
 @DELETE is for delete the resource
 
 We create another method createAlien() in AlienResource which takes data from user and adds it to the database. We will have
 to use POST. Along with that we are using @Path again with this method to it so it is linked to /aliens/alien. 
 Now from here we can accept a Alien object from user but question arises how will user send it to us. Here we aren't creating
 a website or application, so we will use a plugin called PostMan to test our application. Sending Post req using the Postman
 we can see the object being entered into the repo.
 
 Now we create another method called getSpecificAlien() to get alien from the repo. User enters the alien id and backend returns
 it after the matching. Look we have used path @Path("alien/{id}") {id} means id is placeholder.
 it will be called using -> aliens/alien/101 
 
 
 Now the question arises how would you send the JSON data. You have to modify the @Produces annotation. Here we have another
 method show casing that. We have to add dependency to achieve so but in our case it was already present in the project.
 
 @Produces can have array defining types of data user can have. 
 ie - @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
 This is called content negotiation.
 
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
}
