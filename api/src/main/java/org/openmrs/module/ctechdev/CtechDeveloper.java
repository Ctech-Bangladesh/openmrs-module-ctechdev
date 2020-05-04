package org.openmrs.module.ctechdev;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ctechdev.CtechDeveloper")
@Table(name = "ctech_devs")
public class CtechDeveloper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ctech_dev_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Basic
	@Column(name = "job_id")
	private String jobid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "designation")
	private String designation;
	
	public CtechDeveloper() {
	}
	
	public CtechDeveloper(Integer id, String jobid, String name, String gender, String designation) {
		this.id = id;
		this.jobid = jobid;
		this.name = name;
		this.gender = gender;
		this.designation = designation;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getJobid() {
		return jobid;
	}
	
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "CtechDeveloper{" + "id=" + id + ", jobid='" + jobid + '\'' + ", name='" + name + '\'' + ", gender='"
		        + gender + '\'' + ", designation='" + designation + '\'' + '}';
	}
}
