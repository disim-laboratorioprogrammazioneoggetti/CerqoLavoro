package it.univaq.disim.oop.cerqolavoro.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import it.univaq.disim.oop.cerqolavoro.domain.Employer;

public class Employer extends User {
	
	  private String name;
	  private String surname;
	  private Integer phone;
	  private String companyName;
	  private Integer companyPhone;
	  private Integer IVA;
	  private String companyEmail;
	  private String companyBio;
	  private Set<Offer> myOffer = new HashSet<>();
	  private Set<Message> sentMessages = new HashSet<>();
	  private ArrayList<Candidacy> candidates = new ArrayList<>();

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
    
      public Integer getPhone() {
	    return phone;
	  }

	  public void setPhone(Integer phone) {
	    this.phone = phone;
	  }
	  
	  public String getCompanyName() {
		    return companyName;
		  }

      public void setCompanyName(String companyName) {
		    this.companyName = companyName;
		  }
 
	  public String getCompanyEmail() {
		    return companyEmail;
		  }

      public void setCompanyEmail(String companyEmail) {
		    this.companyEmail = companyEmail;
		  }

	  public Integer getCompanyPhone() {
	    return companyPhone;
	  }

	  public void setCompanyPhone(Integer companyPhone) {
	    this.companyPhone = companyPhone;
	  }
	  
	  public Integer getIVA() {
	    return IVA;
	  }

	  public void setIVA(Integer IVA) {
	    this.IVA = IVA;
	  }
	  
	  public String getCompanyBio() {
		    return companyBio;
		  }

      public void setCompanyBio(String companyBio) {
		    this.companyBio = companyBio;
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

