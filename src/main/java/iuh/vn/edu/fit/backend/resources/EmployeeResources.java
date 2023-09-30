package iuh.vn.edu.fit.backend.resources;

import iuh.vn.edu.fit.backend.models.Employee;
import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.services.EmployeeServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/employee")
public class EmployeeResources {
    @Inject
    private EmployeeServices services;

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response add(Employee employee){
        services.add(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if(services.remove(id)){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") long id){
        Optional<Employee> t = services.getEmployeeById(id);
        if(t.isPresent()){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Produces({"application/json"})
    public Response getAll(){
        List<Employee> employeeList = services.getAll();
        return Response.ok(employeeList).build();
    }
}
