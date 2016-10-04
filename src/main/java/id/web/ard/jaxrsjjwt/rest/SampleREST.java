/**
 * Ardiansyah | http://ard.web.id
 *
 */

package id.web.ard.jaxrsjjwt.rest;

import id.web.ard.jaxrsjjwt.model.Sample;
import id.web.ard.jaxrsjjwt.service.SampleService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ardiansyah <ard333.ardiansyah@gmail.com>
 */
@Stateless
@Path("/sample")
public class SampleREST {
	
	@EJB
	private SampleService sampleService;

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void create(@Valid Sample entity) {
		sampleService.create(entity);
	}

	@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	public void edit(@PathParam("id") Integer id, @Valid Sample entity) {
		sampleService.edit(entity);
	}

	@DELETE
    @Path("/{id}")
	public void remove(@PathParam("id") Integer id) {
		sampleService.remove(sampleService.find(id));
	}

	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Sample find(@PathParam("id") Integer id) {
		return sampleService.find(id);
	}

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Sample> findAll() {
		return sampleService.findAll();
	}

	@GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
	public String countREST() {
		return String.valueOf(sampleService.count());
	}

}
