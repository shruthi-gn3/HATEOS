/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateosappeals;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Calendar;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author shruthign3
 */



public class AppealsClient {
     static String path = "http://localhost:8080/HateosAppeals/webresources";
     
     private static void hangAround(long backOffTimeInMillis) {
        try {
            Thread.sleep(backOffTimeInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

     public static void HappyState(Client client){
           int id =1;
               System.out.println("*****Happy Case*****");
               System.out.println("Step 1");
               System.out.println("Creating an Appeal by making POST request to URI "+ path+ "/appeal");
               
                 AppealRepresentation rep1 = new AppealRepresentation(id,1,"Assignment1",80,"review item1",null,null);
                WebResource webResource1 = client
                    .resource(path + "/appeal");
              ClientResponse response1 = webResource1.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .post(ClientResponse.class, rep1);
               String output1 = response1.getEntity(String.class);
               
                System.out.println("\n");
               System.out.println("Appeal Created");
               System.out.println("Appeal Object = " + output1);
               System.out.println("Appeal Status is Created");
               System.out.println("Updating the Appeal to reword and tone down the language");
               System.out.println("Sending the appeal to be updated to URI" + path + "/appeal/" + id + " by making a PUT request");
               System.out.println("\n");
              
               AppealRepresentation rep3 = new AppealRepresentation(id,1,"Assignment1",80,"Please review item1",null,null);
                WebResource webResource3 = client
                    .resource(path + "/appeal/"+ id);
               ClientResponse response3 = webResource3.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .put(ClientResponse.class, rep3);
               String output3 = response3.getEntity(String.class);
               
               System.out.println("Step 2");
               System.out.println("Appeal Updated");
               System.out.println("Appeal Object = " + output3);
               System.out.println("Appeal Status is Created");
               System.out.println("Sending the appeal to be processed to URI" + path + "/feedback/" + id + " by making a PUT request");
               System.out.println("\n");
              
           AppealRepresentation rep2 = new AppealRepresentation(id,1,"Assignment1",100,"Please review item1","Appeal Accepted","Processed");
                WebResource webResource2 = client
                    .resource(path + "/feedback/"+ id);
               ClientResponse response2 = webResource2.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .put(ClientResponse.class, rep2);
               String output2 = response2.getEntity(String.class);
               
               System.out.println("Step 3");
               System.out.println("Appeal has been reviewed and processed");
               System.out.println("Appeal Object = " + output2);
               System.out.println("Appeal Status is Processed");
               System.out.println("Student can view the appeal result using URI " + path + "/appeal/" + id + " by making a GET request"); 
               System.out.println("\n");

      }
  
     
     public static void Abandonedstate(Client client){
         int id =2;
         System.out.println("*****Abandoned Case*****");
         System.out.println("Step 1");
         System.out.println("Creating an Appeal by making POST request to URI "+ path+ "/appeal");

                 AppealRepresentation rep1 = new AppealRepresentation(id,1,"Assignment2",80,"please review item1",null,null);
                WebResource webResource1 = client
                    .resource(path + "/appeal");
              ClientResponse response1 = webResource1.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .post(ClientResponse.class, rep1);
               String output1 = response1.getEntity(String.class);
               
               System.out.println("\n");
               System.out.println("Appeal Created");
               System.out.println("Appeal Object = " + output1);
               System.out.println("Appeal Status is Created");
               System.out.println("Deleting the Appeal as we feel the professor will not consider it");
               System.out.println("Sending the appeal to be deleted to URI" + path + "/appeal/" + id + " by making a DELETE request");
               System.out.println("\n");
               
                WebResource webResource2 = client
                    .resource(path + "/appeal/"+ id);
               ClientResponse response2 = webResource2.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .delete(ClientResponse.class);
               String output2 = response2.getEntity(String.class);
               System.out.println("Step 2");
               System.out.println("Appeal Deleted");
               System.out.println(output2);
              System.out.println("\n");

     }
     
     
     
      public static void ForgottenCase(Client client){
      int id =3;
      System.out.println("*****Forgotten Case*****");
         System.out.println("Step 1");
         System.out.println("Creating an Appeal by making POST request to URI "+ path+ "/appeal");
         System.out.println("\n");

                 AppealRepresentation rep1 = new AppealRepresentation(id,1,"Assignment1",80,"please review item1",null,null);
                WebResource webResource1 = client
                    .resource(path + "/appeal");
              ClientResponse response1 = webResource1.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .post(ClientResponse.class, rep1);
               String output1 = response1.getEntity(String.class);
               
               System.out.println("Appeal Created");
               System.out.println("Appeal Object = " + output1);
               System.out.println("Appeal Status is Created");
               System.out.println("Sending the appeal to be processed to URI" + path + "/feedback/" + id + " by making a PUT request");
               System.out.println(String.format("Appeal has been sent at time %d ", System.currentTimeMillis()));
               System.out.println("\n");
               
               hangAround(2000);
               
               System.out.println("Step 2");
               System.out.println("Checking the Status of the appeal after sometime by making a GET request to the URI " + path + "/appeal/" + id ); 
                WebResource webResource3 = client
                    .resource(path + "/appeal/"+ id);
               ClientResponse response3 = webResource3.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .get(ClientResponse.class);
               String output3 = response3.getEntity(String.class);
               System.out.println("Appeal Object = " + output3);
               System.out.println(String.format("Checking the Appeal status at time [%d] ", System.currentTimeMillis()));
               System.out.println("Appeal Status is still Created");
               System.out.println("As we have not heard from the professor for sometime following up on the appeal");
               System.out.println("Resending the appeal to be processed to URI" + path + "/feedback/" + id + " by making a PUT request");
               System.out.println("\n");
              
           AppealRepresentation rep2 = new AppealRepresentation(id,1,"Assignment1",100,"Please review item1","Appeal Accepted","Processed");
                WebResource webResource2 = client
                    .resource(path + "/feedback/"+ id);
               ClientResponse response2 = webResource2.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .put(ClientResponse.class, rep2);
               String output2 = response2.getEntity(String.class);
               
               System.out.println("Step 3");
               System.out.println("Appeal has been reviewed and processed");
               System.out.println("Appeal Object = " + output2);
               System.out.println("Appeal Status is Processed");
               System.out.println("Student can view the appeal result using URI " + path + "/appeal/" + id + " by making a GET request"); 
              System.out.println("\n");

               
      }
     
      public static void BadStart(Client client){
      int id =4;
               System.out.println("*****BadStart Case*****");
               System.out.println("Step 1");
               System.out.println("Creating the appeal via POST at URI " + path + "/appeal" + "/badUri");
               System.out.println("\n");
      
                 AppealRepresentation rep1 = new AppealRepresentation(id,1,"Assignment1",80,"review item1",null,null);
                WebResource webResource1 = client
                    .resource(path + "/appeal" + "/badUri");
              ClientResponse response1 = webResource1.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .post(ClientResponse.class, rep1);
               System.out.println("The response returned from the client is: " + response1);
               System.out.println("Hence a bad start");
                System.out.println("\n");
      }
      
       public static void BadId(Client client){
          int id = 5;
               System.out.println("****Bad Id Case****");
               System.out.println("Step 1");
               System.out.println("Creating an appeal via POST to URI " + path + "/appeal");

                 AppealRepresentation rep1 = new AppealRepresentation(id,1,"Assignment1",80,"review item1",null,null);
                WebResource webResource1 = client
                    .resource(path + "/appeal");
              ClientResponse response1 = webResource1.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .post(ClientResponse.class, rep1);
               String output1 = response1.getEntity(String.class);
               System.out.println("Appeal Created");
               System.out.println("Appeal Object = " + output1);
               System.out.println("Appeal Status is Created");
               System.out.println("\n");
               System.out.println("Sending the appeal to be processed to URI" + path + "/feedback/" + id + " by making a PUT request");
               System.out.println(String.format("Appeal has been sent at time %d ", System.currentTimeMillis()));
               System.out.println("\n");
               
               hangAround(2000);
               
               System.out.println("Step 2");
               System.out.println("Checking the Status of the appeal after sometime by making a GET request to the URI " + path + "/appeal/" + id ); 
                WebResource webResource3 = client
                    .resource(path + "/appeal/"+ id);
               ClientResponse response3 = webResource3.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .get(ClientResponse.class);
               String output3 = response3.getEntity(String.class);
               System.out.println("Appeal Object = " + output3);
               System.out.println(String.format("Checking the Appeal status at time [%d] ", System.currentTimeMillis()));
               System.out.println("Appeal Status is still Created");
               System.out.println("As we have not heard from the professor for sometime following up on the appeal");
               System.out.println("Resending the appeal to be processed to URI" + path + "/feedback/xyz" + " by making a PUT request");
               System.out.println("\n");
               System.out.println("\n");
              
           AppealRepresentation rep2 = new AppealRepresentation(id,1,"Assignment1",100,"Please review item1","Appeal Accepted","Processed");
                WebResource webResource2 = client
                    .resource(path + "/feedback/xyz");
               ClientResponse response2 = webResource2.accept("application/vnd-cse564-appeals+xml").type("application/vnd-cse564-appeals+xml")
                    .put(ClientResponse.class, rep2);
               String output2 = response2.getEntity(String.class);
               
               
               System.out.println("Step 3");
               System.out.println("The appeal object was not found and the server returned a response:  " + response2);
               System.out.println("The user seems to have forgotten the appeal id and is trying to process an invalid id");
               

               
       }
      
public static void main(String[] args){
    Client client = Client.create();
     HappyState(client);
     Abandonedstate(client);
     ForgottenCase(client);
     BadStart(client);
     BadId(client);
}
}
