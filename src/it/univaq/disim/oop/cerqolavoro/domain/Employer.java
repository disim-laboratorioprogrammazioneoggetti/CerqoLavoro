package it.univaq.disim.oop.cerqolavoro.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import it.univaq.disim.oop.cerqolavoro.domain.Employer;

public class Employer extends User {
	
	  private String name;
	  private String surname;
	  private Integer phone;
	  private String companyname;
	  private Integer companyphone;
	  private Integer IVA;
	  
	  private Set<Offer> myOffer = new HashSet<>();
	  private Set<Message> sentMessages = new HashSet<>();
	  private ArrayList<Candidacy> candidates = new ArrayList<>();

	  public String getName() {
		    return name;
		  }

    public void setName(String name) {
		    this.name = name;
		  }
    
    public String getSurame() {
		    return surname;
		  }

    public void setSurame(String surname) {
		    this.surname = surname;
		  }
    
    public Integer getPhone() {
	    return phone;
	  }

	  public void setPhone(Integer phone) {
	    this.phone = phone;
	  }
	  
	  public String getCompanyname() {
		    return companyname;
		  }

    public void setCompanyname(String companyname) {
		    this.companyname = companyname;
		  }
 
	  public Integer getCompanyphone() {
	    return companyphone;
	  }

	  public void setCompanyphone(Integer companyphone) {
	    this.companyphone = companyphone;
	  }
	  
	  public Integer getIVA() {
	    return IVA;
	  }

	  public void setIVA(Integer IVA) {
	    this.IVA = IVA;
	  }
	  
		public Set<Offer> getOffer() {
			return myOffer;
		}

		public void setOffer(Set<Offer> myOffer) {
			this.myOffer = myOffer;
		}
		
		public ArrayList<Candidacy> getCandidates() {
			return candidates;
		}

		public void setCandidacy(ArrayList<Candidacy> candidates) {
			this.candidates = candidates;
		}
		
		public Set<Message> getMessages() {
			return sentMessages;
		}

		public void setMessages(Set<Message> sentMessages) {
			this.sentMessages = sentMessages;
		}
	  
}

