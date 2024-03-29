package iuh.vn.edu.fit.backend.resources;

import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.services.ProductServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/product")
public class ProductResource {
   @Inject
   private ProductServices service;

    @GET
    @Path("/heart-beat")
    @Produces("application/json")
    public Response heartbeat(){
        return Response.ok("live").build();
    }


    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response addProduct(Product product){
        service.addProduct(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") long id){
        if(service.deleteProduct(id)){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Produces({"application/json"})
    @Path("/{id}")
    public Response getProductById(@PathParam("id") long id){
        Optional<Product> t = service.getProductById(id);
        if(t.isPresent()){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Produces({"application/json"})
    public Response getAll(){
        List<Product> productList = service.getAll();
        return Response.ok(productList).build();
    }
}
