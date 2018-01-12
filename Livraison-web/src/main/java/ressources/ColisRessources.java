package ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import client.CurrentUserRemote;
import persistence.Colis;
import services.ColisServiceRemote;

@Path("/colis")
@RequestScoped
public class ColisRessources {

	@EJB
	ColisServiceRemote cs;

	@EJB
	CurrentUserRemote cu;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok().entity(cs.getAll()).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Colis c) {

		if (cu.get() == null)
			return Response.status(Status.UNAUTHORIZED).build();
		else {
			
			//c.setClient(cu.get());
			cs.add(c);
			return Response.ok().build();
		}
	}

}
