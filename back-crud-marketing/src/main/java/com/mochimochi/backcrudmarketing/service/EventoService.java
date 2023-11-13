package com.mochimochi.backcrudmarketing.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.mochimochi.backcrudmarketing.dto.EventoDTO;
import com.mochimochi.backcrudmarketing.dto.mapper.EventoMapper;
import com.mochimochi.backcrudmarketing.exception.RecordNotFoundException;
import com.mochimochi.backcrudmarketing.model.Evento;
import com.mochimochi.backcrudmarketing.repository.EventoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EventoService {
    
    private final EventoRepository eventoRepository;
    private final EventoMapper eventoMapper;

    public EventoService(EventoRepository eventoRepository, EventoMapper eventoMapper) {
        this.eventoRepository = eventoRepository;
        this.eventoMapper = eventoMapper;
    }

    public List<EventoDTO> list(){
        return eventoRepository.findAll()
                .stream()
                .map(eventoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EventoDTO findById(@NotNull @Positive Long id){
        return eventoRepository.findById(id).map(eventoMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
                 
    }

    public EventoDTO create( @Valid @NotNull EventoDTO evento){
        return eventoMapper.toDTO(eventoRepository.save(eventoMapper.toEntity(evento)));
        
    }

    public EventoDTO update( @NotNull @Positive Long id, @Valid @NotNull EventoDTO evento){
        return eventoRepository.findById(id)
                .map(recordFound ->{
                    recordFound.setNome(evento.nome());
                    recordFound.setDescricao(evento.descricao());
                    recordFound.setImg(evento.img());
                    recordFound.setUrlEvento(evento.urlEvento());
                    //recordFound.setLike(evento.like());
                    return eventoMapper.toDTO(eventoRepository.save(recordFound));
                } ).orElseThrow(() -> new RecordNotFoundException(id));
                
    }

    public void delete(@NotNull @Positive Long id){
        eventoRepository.delete(eventoRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
    }

    //public Evento toggleLike(Long id) {
        //Evento evento = eventoRepository.findById(id)
        //.orElseThrow(null);
        //if (evento != null) {
            //evento.setLike(!evento.getLike());
            //eventoRepository.save(evento);
        //}
        //return evento;
    }

