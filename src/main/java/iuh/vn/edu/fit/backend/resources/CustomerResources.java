package iuh.vn.edu.fit.backend.resources;

import iuh.vn.edu.fit.backend.models.Customer;
import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.services.CustomerServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/customer")
public class CustomerResources {

    @Inject
    private CustomerServices service;


    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response add(Customer customer){
        service.add(customer);
        return Response.ok(customer).build();
    }
    @GET
    @Produces({"application/json"})
    @Path("/{id}")
    public Response getProductById(@PathParam("id") long id){
        Optional<Customer> t = service.getCustomerById(id);
        if(t.isPresent()){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Produces({"application/json"})
    public Response getAll(){
        List<Customer> customerList = service.getAll();
        return Response.ok(customerList).build();
    }


}
