package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;

	public Persona savePersona(Persona persona) {
		return personaRepository.save(persona);
	}

	public List<Persona> getAllPersonas() {
		return personaRepository.findAll();
	}

	public Persona getPersonaById(Long id) {
		return personaRepository.findById(id).orElse(null);
	}

	public Persona updatePersona(Long id, Persona updatedPersona) {
		if (personaRepository.existsById(id)) {
			updatedPersona.setIdPersona(id);
			return personaRepository.save(updatedPersona);
		}
		return null;
	}

	public void deletePersona(Long id) {
		personaRepository.deleteById(id);
	}
}
