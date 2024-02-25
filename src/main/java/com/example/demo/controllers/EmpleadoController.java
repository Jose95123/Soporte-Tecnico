package com.example.demo.controllers;

import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	public ResponseEntity<List<Empleado>> getAllEmpleados() {
		List<Empleado> empleados = empleadoService.getAllEmpleados();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
		Empleado empleado = empleadoService.getEmpleadoById(id);
		if (empleado != null) {
			return new ResponseEntity<>(empleado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
		Empleado savedEmpleado = empleadoService.saveEmpleado(empleado);
		return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado updatedEmpleado) {
		Empleado empleado = empleadoService.updateEmpleado(id, updatedEmpleado);
		if (empleado != null) {
			return new ResponseEntity<>(empleado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
		empleadoService.deleteEmpleado(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
