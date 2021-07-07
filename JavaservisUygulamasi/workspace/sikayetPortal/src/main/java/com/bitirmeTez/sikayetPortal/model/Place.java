package com.bitirmeTez.sikayetPortal.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(	name = "PLACE", catalog="sikayet_portali", schema="dbo")
public class Place implements  Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name="seq_post", sequenceName="place_seq",allocationSize = 1)
	@Column(name = "id",updatable = false, nullable = false)
	private int id;

	@Column(name = "name")
    private String name;
	
	@Column(name = "adress")
    private String adress;
	
	@Column(name = "latitude")
    private String latitude;
		
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "city")
	private String city;
			
	@Column(name = "district")
	private String district;
		
	@OneToMany(fetch = FetchType.LAZY,mappedBy="place",cascade = CascadeType.ALL)
	private List<Complaint> complaintList = new ArrayList<>();
	
	public Place() {		
	}

	public Place(int id, String name, String adress, String latitude, String longitude, String city, String district) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.district = district;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

	
	
	
	
	

}
