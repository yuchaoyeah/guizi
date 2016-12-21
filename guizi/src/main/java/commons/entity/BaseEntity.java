package commons.entity;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Id;

public class BaseEntity implements Serializable{
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
