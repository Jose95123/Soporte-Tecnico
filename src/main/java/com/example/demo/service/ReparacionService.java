package com.example.demo.service;

import com.example.demo.model.Reparacion;
import com.example.demo.repository.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparacionService {
	@Autowired
	private ReparacionRepository reparacionRepository;

	public ReparacionService(ReparacionRepository reparacionRepository) {
		this.reparacionRepository = reparacionRepository;
	}

	public Reparacion saveReparacion(Reparacion reparacion) {
		return reparacionRepository.save(reparacion);
	}

	public List<Reparacion> getAllReparaciones() {
		return reparacionRepository.findAll();
	}

	public Reparacion getReparacionById(Long id) {
		return reparacionRepository.findById(id).orElse(null);
	}

	public Reparacion updateReparacion(Long id, Reparacion updatedReparacion) {
		if (reparacionRepository.existsById(id)) {
			updatedReparacion.setIdReparacion(id);
			return reparacionRepository.save(updatedReparacion);
		}
		return null;
	}

	public void deleteReparacion(Long id) {
		reparacionRepository.deleteById(id);
	}
}
