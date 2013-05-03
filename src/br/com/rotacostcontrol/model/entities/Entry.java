package br.com.rotacostcontrol.model.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rotacostcontrol.model.enums.EntryType;

@NamedQueries({@NamedQuery(name="Entry.listEntriesByEmailUser", 
						   query="SELECT e FROM Entry e WHERE e.date >= :initDate AND e.date < :endDate AND e.category.user.email = :email ORDER BY e.date"),
			   @NamedQuery(name="Entry.listEntriesByIdCategoryAndEmailUser",
			               query="SELECT e FROM Entry e WHERE e.date >= :initDate AND e.date < :endDate AND e.category.id = :id AND e.category.user.email = :email ORDER BY e.date"),
			   @NamedQuery(name="Entry.deleteEntryByIdAndEmailUser",
					   	   query="DELETE FROM Entry e WHERE e.id = :id"),
			   @NamedQuery(name="Entry.findEntryByIdAndEmailUser",
					   	   query="SELECT e FROM Entry e WHERE e.id = :id AND e.category.user.email = :email")

})

/**
 * Classe reponsável por representar os lançamentos 
 * @author bruno
 *
 */
@Entity
@Table(name="entry")
public class Entry implements Serializable{

	private static final long serialVersionUID = 399822523671449727L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Double cost;
	
	@Temporal(TemporalType.DATE)
	private Calendar date;

	@Enumerated(EnumType.STRING)
	private EntryType type;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="category_id")
	private Category category;
	
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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public EntryType getType() {
		return type;
	}

	public void setType(EntryType type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
