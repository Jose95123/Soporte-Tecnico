package com.example.demo.controllers;

import com.example.demo.model.Equipo;
import com.example.demo.service.EquipoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

	@Autowired
	private EquipoService equipoService;

	@GetMapping
	public ResponseEntity<List<Equipo>> getAllEquipos() {
		List<Equipo> equipos = equipoService.getAllEquipos();
		return new ResponseEntity<>(equipos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Equipo> getEquipoById(@PathVariable Long id) {
		Equipo equipo = equipoService.getEquipoById(id);
		if (equipo != null) {
			return new ResponseEntity<>(equipo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
		Equipo savedEquipo = equipoService.saveEquipo(equipo);
		return new ResponseEntity<>(savedEquipo, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo updatedEquipo) {
		Equipo equipo = equipoService.updateEquipo(id, updatedEquipo);
		if (equipo != null) {
			return new ResponseEntity<>(equipo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
		equipoService.deleteEquipo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
