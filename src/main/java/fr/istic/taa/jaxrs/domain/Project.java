package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="project")
public class Project implements Serializable{
	
	private int id;
	private String name;
	private String description;
	private List<Employee> employees;
	private List<Task> tasks;

	@Id
	@GeneratedValue
	@XmlElement(name="id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(cascade=CascadeType.REMOVE)
	@XmlElementWrapper(name="employees")
	@XmlElement(name="employee")
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	@XmlElementWrapper(name="tasks")
	@XmlElement(name="task")
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public String toString()
	{
		return String.format("Project[id=%d, name=%s]", this.id, this.name);
	}
}
