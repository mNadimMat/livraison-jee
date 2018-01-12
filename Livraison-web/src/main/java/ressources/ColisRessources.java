package ressources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import services.ColisServiceRemote;

@Path("/colis")
public class ColisRessources {
	
	@EJB
	ColisServiceRemote cs;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		return Response.ok().entity(cs.getAll()).build();
	}

}
