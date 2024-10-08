package com.boot.music.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Document implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Date_Start")
	private Date dateStart;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Date_End")
	private Date dateEnd;

	public int userId;
	@Column(name = "statusid")
	private int statusID;
	@OneToMany(mappedBy = "document"
			, cascade = CascadeType.ALL)
	private List<Version> versionList;
	private String sumary;
	public Document(String title,String sumary, Date dateStart, Date dateEnd, int userId) {
		super();
		this.title = title;
		this.sumary=sumary;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.userId = userId;
		this.statusID=1;
		versionList= new ArrayList<Version>();
	}
	public String getSumary() {
		return sumary;
	}
	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	public Document() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public int getUser() {
		return userId;
	}
	public void setUser(int userId) {
		this.userId = userId;
	}
	public int getStatus() {
		return statusID;
	}
	public void setStatus(int status_ID) {
		this.statusID = status_ID;
	}
	public List<Version> getVersionList() {
		return versionList;
	}
	public void setVersionList(List<Version> versionList) {
		this.versionList = versionList;
	}
	public Long getId() {
		return id;
	}

}