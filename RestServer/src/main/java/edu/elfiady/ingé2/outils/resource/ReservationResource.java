package edu.elfiady.ingé2.outils.resource;



import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * @author elfiady
 *
 */
@Path("/reservation")
@Singleton
public class ReservationResource {
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/authenticate/{Id}")
	public Response authenticate(@PathParam("Id")final long id) {
		final Long idClient=new Long(id);
		return Response.ok(idClient.toString()).build();
	}

}
