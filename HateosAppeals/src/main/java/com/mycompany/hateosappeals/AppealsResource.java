/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateosappeals;

import java.net.URI;
import java.util.HashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author shruthign3
 */
@Path("webresources")
public class AppealsResource {
    public HashMap<Integer, AppealRepresentation> appeals = AppealsRepository.getAppeals();
       private @Context UriInfo uriInfo;
@GET
@Produces(MediaType.TEXT_PLAIN)
public String test(){
    
return "test";
}
    
@POST
@Path("appeal")
@Produces("application/vnd-cse564-appeals+xml")
@Consumes("application/vnd-cse564-appeals+xml")
public AppealRepresentation CreateAppeal(AppealRepresentation appeal){
        int id = appeal.getAppealId();
        appeal.setStatus("Created");
        String url = getUri( "appeal", id);//path(AppealsResource.class).path(Integer.toString(id)).toString();
        String sendUrl = getUri("feedback",id);
        appeal.setLinks(new Link("update" , url , "application/vnd-cse564-appeals+xml"));
        appeal.setLinks(new Link("delete" , url , "application/vnd-cse564-appeals+xml"));
        appeal.setLinks(new Link("Send" , sendUrl , "application/vnd-cse564-appeals+xml"));
   
         AppealsRepository.setAppeals(id, appeal);
       
    return appeal;
}


@GET
@Path("appeal/{AppealId}")
@Produces("application/vnd-cse564-appeals+xml")
public AppealRepresentation GetAppeal(@PathParam("AppealId") int AppealId){
    AppealRepresentation rep = null;
    try{
     rep = appeals.get(AppealId);
    }
    catch (NoSuchAppealException na){
    System.out.println("No such appeal");
    }
    catch (Exception e){
     System.out.println("Exception is :" + e);
    }
     return rep;
}

@PUT
@Path("appeal/{AppealId}")
@Produces("application/vnd-cse564-appeals+xml")
@Consumes("application/vnd-cse564-appeals+xml")
public AppealRepresentation PutAppeal(AppealRepresentation appeal){
          int id = appeal.getAppealId();
          String url = getUri("appeal",id);
        String sendUrl = getUri("feedback",id);
        appeal.setLinks(new Link("update" , url , "application/vnd-cse564-appeals+xml"));
        appeal.setLinks(new Link("delete" , url , "application/vnd-cse564-appeals+xml"));
        appeal.setLinks(new Link("Send" , sendUrl , "application/vnd-cse564-appeals+xml"));
   
         AppealsRepository.setAppeals(id, appeal);
     return appeal;      
} 

@DELETE
@Path("appeal/{AppealId}")
@Produces("application/vnd-cse564-appeals+xml")
public String DeleteAppeal(@PathParam("AppealId") int AppealId){
    try{
       AppealsRepository.getAppeals().remove(AppealId);
    }
    catch (DeleteException d){
    System.out.println("Delete Exception");
    }
    return "Appeal Object no longer exists";
}

@PUT
@Path("/feedback/{AppealId}")
@Produces("application/vnd-cse564-appeals+xml")
@Consumes("application/vnd-cse564-appeals+xml")
public AppealRepresentation PutFeedback(@PathParam("AppealId") int AppealId, AppealRepresentation appeal){
         int id = appeal.getAppealId();
         appeal.setStatus("Processed");
          String url = getUri("appeal",id);
         appeal.setLinks(new Link("view" , url , "application/vnd-cse564-appeals+xml"));

          AppealsRepository.setAppeals(id, appeal);
          return appeals.get(id);
 
}


private String getUri(String path, int id){
   
    String url = uriInfo.getBaseUriBuilder().toString()+ "webresources" + "/" + path + "/" + Integer.toString(id);

        
        return url;
}
}
