package com.example.demo.dto;

import java.util.List;

public class CompleteAddress {
	private int id;
	private String name;
	private boolean permanent;
	private EmpAddress address;
	private List<Integer> phoneNumbers;
	private String role;
	private List<String> cities;
	private AddressProp properties;

	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public EmpAddress getAddress() {
		return address;
	}
	public void setAddress(EmpAddress address) {
		this.address = address;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
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
	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public AddressProp getProperties() {
		return properties;
	}
	public void setProperties(AddressProp properties) {
		this.properties = properties;
	}
}

class EmpAddress{
	private String street;
	private String city;
	private int zipcode;

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}

class AddressProp{
	private String age;
	private String salary;

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
}