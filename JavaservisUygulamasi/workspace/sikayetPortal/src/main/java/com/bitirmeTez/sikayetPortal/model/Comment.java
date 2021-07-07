package com.bitirmeTez.sikayetPortal.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(	name = "COMMENT", catalog="sikayet_portali", schema="dbo")
public class Comment implements  Serializable{

	private static final long serialVersionUID = 2L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name="seq_post", sequenceName="comment_seq",allocationSize = 1)
	@Column(name = "id",updatable = false, nullable = false)
	private int id;

	@Column(name = "context")
    private String context;
	
	@Column(name = "create_date")
    private Date create_date;
	
	@Column(name = "update_date")
    private Date update_date;
		
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="complaint_id")
    private Complaint complaint;
	
	public Comment() {
		
	}

	public Comment(int id, String context, Date create_date, Date update_date) {
		super();
		this.id = id;
		this.context = context;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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
	
	
	
	
}
