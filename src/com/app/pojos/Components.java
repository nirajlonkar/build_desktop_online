package com.app.pojos;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class Components {

	private Integer id;
	private String manufacturer, name, model_no;
	private float price;
	private ComponentType type;
	private byte[] description;
	private byte[] image;
	
	public Components() {
		// TODO Auto-generated constructor stub
	}

	public Components(String manufacturer, String name, String model_no, float price, ComponentType type,
			byte[] description) {
		this.manufacturer = manufacturer;
		this.name = name;
		this.model_no = model_no;
		this.price = price;
		this.type = type;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 60)
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Column(length = 60)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 60)
	public String getModel_no() {
		return model_no;
	}

	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30, name = "component_category")
	public ComponentType getType() {
		return type;
	}

	public void setType(ComponentType type) {
		this.type = type;
	}
	@Lob
	public byte[] getDescription() {
		return description;
	}

	public void setDescription(byte[] description) {
		this.description = description;
	}
	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Components [id=" + id + ", manufacturer=" + manufacturer + ", name=" + name + ", model_no=" + model_no
				+ ", price=" + price + ", type=" + type + ", description=" + Arrays.toString(description) + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	
}
