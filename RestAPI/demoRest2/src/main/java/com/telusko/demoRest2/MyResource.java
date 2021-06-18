
package com.telusko.demoRest2;

/*
 V14- 18
 Here we are adding Database instead of using the fake db. We will use jdbc. You also need to add dependency for MySql 
 connector.
 
 Just like GET request has @Produces annotation, Similarly for POST request we can use @Consumes annotation. 
 With Consumes we can specify what are the allowed type of data you want to accept. Again you can use array to specify multiple
 types of data.
 
 2 request of different types can have same @Path
 
 Now we use PUT to update and add update method in the repo. 
 To check if the entry for an update exist or not, you can check the entries it has made change to.
 
 Similarly we have DELETE to delete entries, for same we have added delete method in repo.
 
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
