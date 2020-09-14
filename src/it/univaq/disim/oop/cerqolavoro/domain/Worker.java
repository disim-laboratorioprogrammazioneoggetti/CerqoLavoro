package it.univaq.disim.oop.cerqolavoro.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

public class Worker extends User {
	
	private String name;
	private String surname;
	private String sector;
	private String region;
	private String province;
	private String city;
	private String cap;
	private String address;
	private Date birthdate;
	private String education;
	private String experience;
	private Set<Message> receivedMessages = new HashSet<>();
	private Set<Skills> mySkills;
    private ArrayList<Candidacy> myCandidates = new ArrayList<>();
	
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
	
public String getSector() {
    return sector;
}

public void setSe(String sector) {
this.sector = sector;
}

public String getRegion() {
    return region;
}

public void setRegion(String region) {
this.region = region;
}

public String getProvince() {
    return province;
}

public void setProvince(String province) {
this.province = province;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
this.city = city;
}

public String getCap() {
    return cap;
}

public void setCap(String cap) {
this.cap = cap;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getEducation() {
    return education;
}

public void setEducation(String education) {
this.education = education;
}

public Date getBirthdate() {
    return birthdate;
}

public void setBirthdate(Date birthdate) {
this.birthdate = birthdate;
}

public String getExperience() {
    return experience;
}

public void setExperience(String experience) {
this.experience = experience;
}

public ArrayList<Candidacy> getCandidates() {
	return myCandidates;
}

public void setCandidacy(ArrayList<Candidacy> myCandidates) {
	this.myCandidates = myCandidates;
}

public Set<Skills> getSkills() {
	return mySkills;
}

public void setSkills(Set<Skills> mySkills) {
	this.mySkills = mySkills;
}

public Set<Message> getMessages() {
	return receivedMessages;
}

public void setMessages(Set<Message> receivedMessages) {
	this.receivedMessages = receivedMessages;
}

}


