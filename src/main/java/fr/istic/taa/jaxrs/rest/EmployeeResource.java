package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.EmployeeDAO;
import fr.istic.taa.jaxrs.domain.Employee;
import fr.istic.taa.jaxrs.domain.Pet;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/employee")
@Produces({ "application/json", "application/xml" })
public class EmployeeResource {
	EmployeeDAO dao;
	
	public EmployeeResource() {
		this.dao = new EmployeeDAO();
		this.dao.setClazz(Employee.class);
	}

	@GET
	@Path("/{employeeId}")
	public Employee getEmployeeById(@PathParam("employeeId") int employeeId) {
		return dao.findOne(employeeId);
	}
	
	@GET
	public List<Employee> getAllEmployees(){
		return dao.findAll();
	}
	

	@POST
	@Consumes("application/json")
	public Response addEmployee(
			@Parameter(description = "employee object that needs to be added to the db", required = true) Employee employee) {
		this.dao = new EmployeeDAO();
		dao.save(employee);
		return Response.ok().entity("SUCCESS").build();
	}
}