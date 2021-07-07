package com.bitirmeTez.sikayetPortal.model;

import java.io.Serializable;
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
@Table(	name = "ATTACHMENT", catalog="sikayet_portali", schema="dbo")
public class Attachment implements  Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name="seq_post", sequenceName="attachment_seq",allocationSize = 1)
	@Column(name = "id",updatable = false, nullable = false)
	private int id;

	@Column(name = "type")
    private String type;
	
	@Column(name = "path")
    private String path;
		
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="complaint_id")
    private Complaint complaint;
	
	public Attachment() {
		
	}

	public Attachment(int id, String type, String path) {
		super();
		this.id = id;
		this.type = type;
		this.path = path;
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	


}
