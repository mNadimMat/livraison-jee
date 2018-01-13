package ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import client.CurrentUser;
import client.CurrentUserLocal;
import client.CurrentUserRemote;
import persistence.Colis;
import services.ColisServiceRemote;

@Path("/colis")
@RequestScoped
public class ColisRessources {

	@EJB
	ColisServiceRemote cs;

	
	
	@Inject
	CurrentUser current;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
	
		return Response.ok().entity(cs.getAll()).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Colis c) {
System.out.println("ColisRessources.add() "+current.current);
		
		if (current.current == null)
			return Response.status(Status.UNAUTHORIZED).build();
		else {
			
			c.setClient(current.current);
			cs.add(c);
			return Response.ok().build();
		}
	}

}
