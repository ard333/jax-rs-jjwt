/**
 * Ardiansyah | http://ard.web.id
 *
 */

package id.web.ard.jaxrsjjwt.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ardiansyah <ard333.ardiansyah@gmail.com>
 */
@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.login", query = "SELECT u.role FROM User u WHERE u.username = :username AND u.password = :password")
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 16)
	@Column(name = "username")
	private String username;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 44)
	@Column(name = "password")
	private String password;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String username, String password, Role role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "id.web.ard.jaxrsjjwt.model.User[ id=" + id + " ]";
	}

}
