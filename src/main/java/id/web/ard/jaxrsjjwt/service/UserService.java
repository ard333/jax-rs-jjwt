/**
 * Ardiansyah | http://ard.web.id
 *
 */

package id.web.ard.jaxrsjjwt.service;

import id.web.ard.jaxrsjjwt.model.User;
import javax.ejb.Stateless;

/**
 *
 * @author Ardiansyah <ard333.ardiansyah@gmail.com>
 */
@Stateless
public class UserService extends AbstractService<User> {

	public UserService() {
		super(User.class);
	}

}
