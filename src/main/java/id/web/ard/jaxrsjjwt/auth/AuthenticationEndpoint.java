/**
 * Ardiansyah | http://ard.web.id
 *
 */

package id.web.ard.jaxrsjjwt.auth;

import id.web.ard.jaxrsjjwt.service.UserService;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ardiansyah <ard333.ardiansyah@gmail.com>
 */
@Path("/auth")
public class AuthenticationEndpoint {
	
	@EJB
	private UserService userService;
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {
		String role = userService.login(username, password);
		
		if (role!=null) {
			return Response.ok(
				Json.createObjectBuilder().add("token", createToken(username, role)).build(),
				MediaType.APPLICATION_JSON
			).build();
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	
	private String createToken(String username, String role) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 3);
		return TokenServices.createToken(username, role, cal.getTimeInMillis());
	}
	
}