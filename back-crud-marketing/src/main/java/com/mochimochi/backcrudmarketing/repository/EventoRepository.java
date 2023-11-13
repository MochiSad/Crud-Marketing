package com.mochimochi.backcrudmarketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mochimochi.backcrudmarketing.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

    
}