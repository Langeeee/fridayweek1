package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;
import facades.BankFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("bankcustomer")
public class BankCustomerResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final BankFacade FACADE =  BankFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
  
    
   @Path ("{id}")
   @GET
   @Produces({MediaType.APPLICATION_JSON})
   public String getCustomerById(@PathParam("id") long id) {
       return GSON.toJson(FACADE.getCustomerById(id));
   }
   
   @Path("all")
   @GET
   @Produces({MediaType.APPLICATION_JSON})
   public String getAllCustomers(){
       return GSON.toJson(FACADE.getAllBankCustomers());
   }
}
