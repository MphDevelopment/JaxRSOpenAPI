package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;

@XmlRootElement(name="employee")
@Entity
public class Employee implements Serializable{

	private int id;
	private String firstName;
	private String lastName;
	private List<Project> projects;
	private List<Task> tasks;
	
	
	public Employee(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.projects = new ArrayList<Project>();
	}
	
	public Employee(String firstName, String lastName, List<Project> projects, List<Task> tasks)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.projects = projects;
		this.tasks=tasks;
	}
	
	public Employee() {
		
	}
	
	@Id
	@GeneratedValue
	@XmlElement(name="id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="firstname")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement(name="lastname")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ManyToMany(cascade=CascadeType.REMOVE)
	@XmlElementWrapper(name = "projects")
	@XmlElement(name = "project")
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	@OneToMany(cascade=CascadeType.REMOVE)
	@XmlElementWrapper(name = "tasks")
	@XmlElement(name = "task")
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public String toString()
	{
		return String.format("Employee[id=%d, name=%s %s]", this.id, firstName, (String)lastName.toUpperCase());
	}
	
	
}
