package br.com.rotacostcontrol.services.json;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntryJSONResult extends JSONResult implements Serializable{

	private static final long serialVersionUID = -3681537384679919092L;

	private EntryJSON entry;
	
	private List<EntryJSON> entries;

	public EntryJSON getEntry() {
		return entry;
	}

	public void setEntry(EntryJSON entry) {
		this.entry = entry;
	}

	public List<EntryJSON> getEntries() {
		return entries;
	}

	public void setEntries(List<EntryJSON> entries) {
		this.entries = entries;
	}
}
