package com.example.demo.service;

import com.example.demo.model.Equipo;
import com.example.demo.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
	@Autowired
	private EquipoRepository equipoRepository;

	public Equipo saveEquipo(Equipo equipo) {
		return equipoRepository.save(equipo);
	}

	public List<Equipo> getAllEquipos() {
		return equipoRepository.findAll();
	}

	public Equipo getEquipoById(Long id) {
		return equipoRepository.findById(id).orElse(null);
	}

	public Equipo updateEquipo(Long id, Equipo updatedEquipo) {
		if (equipoRepository.existsById(id)) {
			updatedEquipo.setIdEquipo(id);
			return equipoRepository.save(updatedEquipo);
		}
		return null;
	}

	public void deleteEquipo(Long id) {
		equipoRepository.deleteById(id);
	}
}
