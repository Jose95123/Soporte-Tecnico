package com.example.demo.repository;

import com.example.demo.model.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReparacionRepository extends JpaRepository<Reparacion, Long> {
}