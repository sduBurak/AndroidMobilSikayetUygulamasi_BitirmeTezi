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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "USERS", catalog="sikayet_portali", schema="dbo")
public class Users implements  Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name="seq_post", sequenceName="user_seq",allocationSize = 1)
	@Column(name = "id",updatable = false, nullable = false)
	private int id;

	@Column(name = "name")
    private String name;
	
	@Column(name = "surname")
    private String surname;
	
	@Column(name = "phone")
    private String phone;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "username")
	private String username;

	@NotBlank
	@Size(max = 120)
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name = "email")
	private String email;
	
	@Column(name = "create_date")
    private Date create_date;
	
	@Column(name = "update_date")
    private Date update_date;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="user",cascade = CascadeType.ALL)
	private List<Complaint> complaintList = new ArrayList<>();
	
	public Users() {
		
	}

	public Users(int id, String name, String surname, String phone, @NotBlank @Size(max = 20) String username,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 50) @Email String email, Date create_date,
			Date update_date) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.email = email;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
