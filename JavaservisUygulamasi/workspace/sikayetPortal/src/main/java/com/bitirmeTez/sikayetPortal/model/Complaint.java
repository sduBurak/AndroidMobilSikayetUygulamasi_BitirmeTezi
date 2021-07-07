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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(	name = "COMPLAINT", catalog="sikayet_portali", schema="dbo")
public class Complaint implements  Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name="seq_post", sequenceName="complaint_seq",allocationSize = 1)
	@Column(name = "id",updatable = false, nullable = false)
	private int id;

	@Column(name = "title")
    private String title;
	
	@Column(name = "context")
    private String context;
	
	@Column(name = "create_date")
    private Date create_date;
	
	@Column(name = "update_date")
    private Date update_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Users user;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="place_id")
    private Place place;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="complaint",cascade = CascadeType.ALL)
	private List<Attachment> attachmentList = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="complaint",cascade = CascadeType.ALL)
	private List<Comment> commentList = new ArrayList<>();
	
	
	public Complaint() {
		
	}

	public Complaint(int id, String title, String context, Date create_date, Date update_date) {
		super();
		this.id = id;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	

}
