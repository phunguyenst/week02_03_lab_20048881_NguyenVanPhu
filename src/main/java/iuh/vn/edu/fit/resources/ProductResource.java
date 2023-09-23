package iuh.vn.edu.fit.resources;

import iuh.vn.edu.fit.models.Product;
import iuh.vn.edu.fit.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/product")
public class ProductResource {
    @Inject
    private ProductService service;
//    @Inject
//    public ProductResource(){
//        service = new ProductService();
//    }
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
