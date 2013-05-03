package br.com.rotacostcontrol.model.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe responsável por representar uma role
 * @author bruno
 *
 */
@Entity
@Table(name="role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6288304274715223477L;

	@Id
	private Integer id;
	
	private String name;
	
	@ManyToMany(mappedBy="roles", fetch = FetchType.EAGER)
	private List<User> users;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
