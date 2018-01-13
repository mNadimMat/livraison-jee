package ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import client.CurrentUser;
import client.CurrentUserLocal;
import exceptions.AuthenticationException;
import persistence.Client;
import persistence.Facteur;
import services.ClientServiceRemote;

@Path("/client")
@RequestScoped

public class ClientRessources {
	@EJB
	ClientServiceRemote cs;
	
	@Inject
	CurrentUserLocal cu;
	
	@Inject
	CurrentUser current;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@HeaderParam("mail") String email, @HeaderParam("password") String password) {

		
		try {
			current.current = cs.login(email, password);
			return Response.ok().entity(current.current).build();
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}

	}

	@PUT
	@Path("/client")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signUp(Client c) {
		try {
			cs.signUp(c);
			return Response.ok().build();
		} catch (AuthenticationException e) {

			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}

	}

	@PUT
	@Path("/facteur")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signUpF(Facteur c) {
		try {
			cs.signUp(c);
			return Response.ok().build();
		} catch (AuthenticationException e) {

			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}

	}

}
