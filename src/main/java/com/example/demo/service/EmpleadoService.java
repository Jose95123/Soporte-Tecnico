package com.example.demo.service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public Empleado saveEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}

	public Empleado getEmpleadoById(Long id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	public Empleado updateEmpleado(Long id, Empleado updatedEmpleado) {
		if (empleadoRepository.existsById(id)) {
			updatedEmpleado.setIdEmpleado(id);
			return empleadoRepository.save(updatedEmpleado);
		}
		return null;
	}

	public void deleteEmpleado(Long id) {
		empleadoRepository.deleteById(id);
	}
}
