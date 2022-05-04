package com.EEStudyAbroad.entities;

import java.util.Objects;

public class SpringTrip {
	
	private long id;
	private String name;
	private String country;
	
	@Override
	public String toString() {
		return "SpringTrip [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpringTrip other = (SpringTrip) obj;
		return Objects.equals(country, other.country) && id == other.id && Objects.equals(name, other.name);
	}

	public SpringTrip() {
		super();
	}

	public SpringTrip(long id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
