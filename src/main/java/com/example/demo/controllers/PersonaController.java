package com.example.demo.controllers;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping
	public ResponseEntity<List<Persona>> getAllPersonas() {
		List<Persona> personas = personaService.getAllPersonas();
		return new ResponseEntity<>(personas, HttpStatus.OK); // cambias esto para usar en las vistas
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
		Persona persona = personaService.getPersonaById(id);
		if (persona != null) {
			return new ResponseEntity<>(persona, HttpStatus.OK); // cambias esto para usar en las vistas
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // cambias esto para usar en las vistas
		}
	}

	@PostMapping
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
		Persona savedPersona = personaService.savePersona(persona);
		return new ResponseEntity<>(savedPersona, HttpStatus.CREATED); // cambias esto para usar en las vistas
	}

	@PutMapping("/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona updatedPersona) {
		Persona persona = personaService.updatePersona(id, updatedPersona);
		if (persona != null) {
			return new ResponseEntity<>(persona, HttpStatus.OK); // cambias esto para usar en las vistas
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // cambias esto para usar en las vistas
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
		personaService.deletePersona(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // cambias esto para usar en las vistas
	}
}
