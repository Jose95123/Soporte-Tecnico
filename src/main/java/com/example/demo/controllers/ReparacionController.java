package com.example.demo.controllers;

import com.example.demo.model.Reparacion;
import com.example.demo.service.ReparacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparaciones")
public class ReparacionController {

	@Autowired
	private ReparacionService reparacionService;

	@GetMapping
	public ResponseEntity<List<Reparacion>> getAllReparaciones() {
		List<Reparacion> reparaciones = reparacionService.getAllReparaciones();
		return new ResponseEntity<>(reparaciones, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reparacion> getReparacionById(@PathVariable Long id) {
		Reparacion reparacion = reparacionService.getReparacionById(id);
		if (reparacion != null) {
			return new ResponseEntity<>(reparacion, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Reparacion> createReparacion(@RequestBody Reparacion reparacion) {
		Reparacion savedReparacion = reparacionService.saveReparacion(reparacion);
		return new ResponseEntity<>(savedReparacion, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reparacion> updateReparacion(@PathVariable Long id,
			@RequestBody Reparacion updatedReparacion) {
		Reparacion reparacion = reparacionService.updateReparacion(id, updatedReparacion);
		if (reparacion != null) {
			return new ResponseEntity<>(reparacion, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReparacion(@PathVariable Long id) {
		reparacionService.deleteReparacion(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
