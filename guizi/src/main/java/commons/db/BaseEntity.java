package commons.db;

import org.mongodb.morphia.annotations.Id;

public class BaseEntity {
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
