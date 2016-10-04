/**
 * Ardiansyah | http://ard.web.id
 *
 */

package id.web.ard.jaxrsjjwt.service;

import id.web.ard.jaxrsjjwt.model.Sample;
import javax.ejb.Stateless;

/**
 *
 * @author Ardiansyah <ard333.ardiansyah@gmail.com>
 */
@Stateless
public class SampleService extends AbstractService<Sample> {

	public SampleService() {
		super(Sample.class);
	}

}
