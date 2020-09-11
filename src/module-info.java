module CerqoLavoro {
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.swt;
	requires javafx.web;
	requires org.controlsfx.controls;
	exports it.univaq.disim.oop.cerqolavoro;
	opens it.univaq.disim.oop.cerqolavoro;
	exports it.univaq.disim.oop.cerqolavoro.controller;
	opens it.univaq.disim.oop.cerqolavoro.controller;
	exports it.univaq.disim.oop.cerqolavoro.domain;
	opens it.univaq.disim.oop.cerqolavoro.domain;
	exports it.univaq.disim.oop.cerqolavoro.view;
	opens it.univaq.disim.oop.cerqolavoro.view;
	
}