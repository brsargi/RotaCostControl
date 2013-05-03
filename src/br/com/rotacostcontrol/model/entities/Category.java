package br.com.rotacostcontrol.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({@NamedQuery(name="Category.listCategoryByEmailUser",
query="SELECT c FROM Category c WHERE c.user.email = :email"),
			  @NamedQuery(name="Category.findCategoryByNameAndEmailUser",
query="SELECT c FROM Category c WHERE c.name = :name AND c.user.email = :email")
})


/**
 * Classe responsável por manter valores das categorias
 * @author bruno
 *
 */
@Entity
@Table(name="category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6297587101313265795L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	private String description;

	@OneToMany(mappedBy="category")
	private List<Entry> entries;
		
	@ManyToOne
	private User user;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
