package com.EEStudyAbroad.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trip {

	private long id;
	private String name;
	private String semester;
	private double cost;
	private String description;
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
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Trip(long id, String name, String semester, double cost, String description) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.cost = cost;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Trip [id=" + id + ", name=" + name + ", semester=" + semester + ", cost=" + cost + ", description="
				+ description + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cost, description, id, name, semester);
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
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(semester, other.semester);
	}
	
	
}
