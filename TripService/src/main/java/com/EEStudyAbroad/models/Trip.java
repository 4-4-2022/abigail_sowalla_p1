package com.EEStudyAbroad.models;

import java.util.Objects;

public class Trip {
	
	private long id;
	private String name;
	private String description;
	
	//constructor using fields
	public Trip(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Trip() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
