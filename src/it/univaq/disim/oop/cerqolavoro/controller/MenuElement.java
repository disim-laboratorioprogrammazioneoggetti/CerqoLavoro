package it.univaq.disim.oop.cerqolavoro.controller;

public class MenuElement {

	private String name;
	private String vista;

	public MenuElement(String name, String vista) {
		super();
		this.name = name;
		this.vista = vista;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

}
