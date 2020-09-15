package it.univaq.disim.oop.cerqolavoro.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import it.univaq.disim.oop.cerqolavoro.domain.Employer;

public class Employer extends User {
	
	  private String name;
	  private String surname;
	  private Long phone;
	  private String companyName;
	  private Long companyPhone;
	  private Long IVA;
	  private String companyEmail;
	  private String companyBio;
	  private ArrayList<Offer> myOffers = new ArrayList<>();
	  private Set<Message> sentMessages = new HashSet<>();

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
    
      public Long getPhone() {
	    return phone;
	  }

	  public void setPhone(Long phone) {
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

	  public Long getCompanyPhone() {
	    return companyPhone;
	  }

	  public void setCompanyPhone(Long companyPhone) {
	    this.companyPhone = companyPhone;
	  }
	  
	  public Long getIVA() {
	    return IVA;
	  }

	  public void setIVA(Long IVA) {
	    this.IVA = IVA;
	  }
	  
	  public String getCompanyBio() {
		    return companyBio;
		  }

      public void setCompanyBio(String companyBio) {
		    this.companyBio = companyBio;
		  }
      
		public ArrayList<Offer> getOffer() {
			return myOffers;
		}

		public void setOffer(ArrayList<Offer> myOffers) {
			this.myOffers = myOffers;
		}
		
		public Set<Message> getMessages() {
			return sentMessages;
		}

		public void setMessages(Set<Message> sentMessages) {
			this.sentMessages = sentMessages;
		}
	  
}

