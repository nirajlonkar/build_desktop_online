package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "builds")
public class Builds {

	private String name;
	private Integer id;
	private float price;
	private Users user;
	private int cpu_id,mb_id,ram_id,gpu_id,smps_id,case_id,cooler_id,ssd_id,hdd_id,wificard_id;
	private Date date_creted;
	public Builds() {
		
	}
	
	
	public Builds(String name, Integer id, float price, int cpu_id, int mb_id, int ram_id, int gpu_id, int smps_id,
			int case_id, int cooler_id, int ssd_id, int hdd_id, int wificard_id, Date date_creted) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.cpu_id = cpu_id;
		this.mb_id = mb_id;
		this.ram_id = ram_id;
		this.gpu_id = gpu_id;
		this.smps_id = smps_id;
		this.case_id = case_id;
		this.cooler_id = cooler_id;
		this.ssd_id = ssd_id;
		this.hdd_id = hdd_id;
		this.wificard_id = wificard_id;
		this.date_creted = date_creted;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "build_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "build_price")
	public float getPrice() {
		return price;
	}
	public void setPrice(float ptice) {
		this.price = ptice;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Column(length = 50, name = "buildName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getCpu_id() {
		return cpu_id;
	}


	public void setCpu_id(int cpu_id) {
		this.cpu_id = cpu_id;
	}


	public int getMb_id() {
		return mb_id;
	}


	public void setMb_id(int mb_id) {
		this.mb_id = mb_id;
	}


	public int getRam_id() {
		return ram_id;
	}


	public void setRam_id(int ram_id) {
		this.ram_id = ram_id;
	}


	public int getGpu_id() {
		return gpu_id;
	}


	public void setGpu_id(int gpu_id) {
		this.gpu_id = gpu_id;
	}


	public int getSmps_id() {
		return smps_id;
	}


	public void setSmps_id(int smps_id) {
		this.smps_id = smps_id;
	}


	public int getCase_id() {
		return case_id;
	}


	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}


	public int getCooler_id() {
		return cooler_id;
	}


	public void setCooler_id(int cooler_id) {
		this.cooler_id = cooler_id;
	}


	public int getSsd_id() {
		return ssd_id;
	}


	public void setSsd_id(int ssd_id) {
		this.ssd_id = ssd_id;
	}


	public int getHdd_id() {
		return hdd_id;
	}


	public void setHdd_id(int hdd_id) {
		this.hdd_id = hdd_id;
	}


	public int getWificard_id() {
		return wificard_id;
	}


	public void setWificard_id(int wificard_id) {
		this.wificard_id = wificard_id;
	}


	public Date getDate_creted() {
		return date_creted;
	}


	public void setDate_creted(Date date_creted) {
		this.date_creted = date_creted;
	}


	@Override
	public String toString() {
		return "Builds [name=" + name + ", id=" + id + ", price=" + price + ", cpu_id=" + cpu_id + ", mb_id=" + mb_id
				+ ", ram_id=" + ram_id + ", gpu_id=" + gpu_id + ", smps_id=" + smps_id + ", case_id=" + case_id
				+ ", cooler_id=" + cooler_id + ", ssd_id=" + ssd_id + ", hdd_id=" + hdd_id + ", wificard_id="
				+ wificard_id + ", date_creted=" + date_creted + "]";
	}
	
	
	
}
