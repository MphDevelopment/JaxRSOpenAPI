package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="task")
public class Task implements Serializable{

	private Project project;
	private int id;
	private String name;
	private Date limitDate;
	private Employee employee;
	private int estimatedDuration;
	private List<Tag> tags;
	private String location;
	private String url;
	private String description;
	private String category; //todo, doing, done

	public Task(Project project, String name, String description, Date limitDate, Employee employee,
			int estimatedDuration, String location, String url, String category) {
		this.project = project;
		this.name = name;
		this.description = description;
		this.limitDate = limitDate;
		this.employee = employee;
		this.estimatedDuration = estimatedDuration;
		this.location = location;
		this.url = url;
		this.category = category;
	}
	
	public Task() {
		
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
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@XmlElement(name="project")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@XmlElement(name="limit-date")
	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	@ManyToOne(cascade=CascadeType.REMOVE)
	@XmlElement(name="employee")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@XmlElement(name="duration")
	public int getEstimatedDuration() {
		return estimatedDuration;
	}

	public void setEstimatedDuration(int estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}

	@ManyToMany(cascade=CascadeType.REMOVE)
	@XmlElementWrapper(name="tags")
	@XmlElement(name="tag")
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@XmlElement(name="location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@XmlElement(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
