package com.bitirmeTez.sikayetPortal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(	name = "CATEGORY", catalog="sikayet_portali", schema="dbo")
public class Category implements  Serializable{

	private static final long serialVersionUID = 2L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name="seq_post", sequenceName="category_seq",allocationSize = 1)
	@Column(name = "id",updatable = false, nullable = false)
	private int id;

	@Column(name = "name")
    private String name;
	
	@Column(name = "create_date")
    private Date create_date;
	
	@Column(name = "update_date")
    private Date update_date;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="category",cascade = CascadeType.ALL)
	private List<Complaint> complaintList = new ArrayList<>();
	
	public Category() {
		
	}

	public Category(int id, String name, Date create_date, Date update_date) {
		super();
		this.id = id;
		this.name = name;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	public int getId() {
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

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}
	
	
	
		
	
}
