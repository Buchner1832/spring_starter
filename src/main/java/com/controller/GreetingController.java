package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;


@Controller
public class GreetingController {
	/*
	 * Diese Methode wird aufgerufen wenn im Browser URL /greeting aufgerufen wird.
	 * Parameter der Methode sind:
	 * model: Dieses Objekt dient zum "Austausch" von Werten im Controller und der Darstellung 
	 * Der Hintergrund ist das sogenannte Model-View-Controller Muster.
	 */
	@GetMapping("/")
	public String index(Model model, @RequestParam(value="name", defaultValue="Fremder") String name) {
		// Füge dem Modell ein Attribut mit dem Namen name hinzug
		// Der Wert dieses Attributs ist der Wert des Parameters name
		model.addAttribute("name", name);
		model.addAttribute("title", "Spring-Starter Projekt");


		// Rückgabewert ist der Dateiname des Templates.
		// Das Framework Spring "kümmert" sich dann darum, dass das Template / die Vorlage
		// gemäß der Werte im Modell ausgefüllt wird.

		return "greeting.html";
	}
}