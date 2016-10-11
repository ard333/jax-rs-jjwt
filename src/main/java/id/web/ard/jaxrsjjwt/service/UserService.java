/**
 * Ardiansyah | http://ard.web.id
 *
 */

package id.web.ard.jaxrsjjwt.service;

import id.web.ard.jaxrsjjwt.model.Role;
import id.web.ard.jaxrsjjwt.model.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ardiansyah <ard333.ardiansyah@gmail.com>
 */
@Stateless
public class UserService extends AbstractService<User> {

	public UserService() {
		super(User.class);
	}
	
	public String login(String username, String password) {
		TypedQuery<String> loginQuery = super.getEntityManager().createNamedQuery("User.login", String.class);
		loginQuery.setParameter("username", username);
		loginQuery.setParameter("password", hashPassword(password.toCharArray()));
		
		try {
			String role = loginQuery.getSingleResult();
			return role;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String hashPassword(final char[] password) {
		try {
			byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
											.generateSecret(new PBEKeySpec(password, "SaltPasswordHere".getBytes(), 33/*iteration*/, 256/*key length*/))
											.getEncoded();
			return Base64.getEncoder().encodeToString(result);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			throw new RuntimeException(ex);
		}
	}
}
