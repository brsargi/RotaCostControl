package br.com.rotacostcontrol.services.json;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoryJSONResult extends JSONResult implements Serializable{

	private static final long serialVersionUID = 5132852685341728494L;

	private CategoryJSON category;
	
	private List<CategoryJSON> categories;

	public CategoryJSON getCategory() {
		return category;
	}

	public void setCategory(CategoryJSON category) {
		this.category = category;
	}

	public List<CategoryJSON> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryJSON> categories) {
		this.categories = categories;
	}
}
