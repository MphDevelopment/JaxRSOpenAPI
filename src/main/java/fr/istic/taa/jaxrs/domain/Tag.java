package fr.istic.taa.jaxrs.domain;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="tag")
public class Tag implements Serializable{
	
	private String name;
	
	public Tag(String name) {
		this.name = name;
	}
	
	public Tag() {
		
	}

	@Id
	@XmlElement(name="name-id")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
