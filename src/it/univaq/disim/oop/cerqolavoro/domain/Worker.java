package it.univaq.disim.oop.cerqolavoro.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Worker extends User {
	
	private String name;
	private String surname;
	private String sector;
	private Integer phone;
	private String region;
	private String province;
	private String city;
	private Integer cap;
	private String address;
	private LocalDate birthdate;
	private String education;
	private String experience;
	private String bio;
	private Set<Message> messagesList = new HashSet<>();
    private ArrayList<Candidacy> candidatesList = new ArrayList<>();
	
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

public void setSector(String sector) {
this.sector = sector;
}

public Integer getPhone() {
	return phone;
}

public void setPhone(Integer phone) {
this.phone = phone;
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

public Integer getCap() {
    return cap;
}

public void setCap(Integer cap) {
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

public LocalDate getBirthdate() {
    return birthdate;
}

public void setBirthdate(LocalDate birthdate) {
this.birthdate = birthdate;
}

public String getExperience() {
    return experience;
}

public void setExperience(String experience) {
this.experience = experience;
}

public String getBio() {
	return bio;
}

public void setBio(String bio) {
this.bio = bio;
}

public ArrayList<Candidacy> getCandidates() {
	return candidatesList;
}

public void setCandidacy(ArrayList<Candidacy> candidatesList) {
	this.candidatesList = candidatesList;
}

public Set<Message> getMessages() {
	return messagesList;
}

public void setMessages(Set<Message> messagesList) {
	this.messagesList = messagesList;
}

}


