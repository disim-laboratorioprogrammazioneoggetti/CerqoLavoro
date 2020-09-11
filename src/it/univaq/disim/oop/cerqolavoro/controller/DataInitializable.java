package it.univaq.disim.oop.cerqolavoro.controller;

import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;

public interface DataInitializable<T> {

	/*
	 * Implementato come metodo di default in modo tale che i controllori che
	 * implementano tale interfaccia non sono costretti ad implementare il metodo
	 * qualora non sia necessario
	 */
	
	default void initializeData(T t) {

	}

}
