package com.mochimochi.backcrudmarketing.dto.mapper;

import org.springframework.stereotype.Component;

import com.mochimochi.backcrudmarketing.dto.EventoDTO;
import com.mochimochi.backcrudmarketing.model.Evento;

@Component
public class EventoMapper {
    
    public EventoDTO toDTO(Evento evento) {
        if (evento == null) {
            return null;
        }
        return new EventoDTO(evento.getId(), evento.getNome(), evento.getDescricao(), evento.getImg(), evento.getUrlEvento()); //evento.getLike());
    }

    public Evento toEntity(EventoDTO eventoDTO){

        if (eventoDTO == null){
            return null;
        }

        Evento evento = new Evento();
        if (eventoDTO != null ) {
            evento.setId(eventoDTO.id());
        }
        
        evento.setNome(eventoDTO.nome());
        evento.setDescricao(eventoDTO.descricao());
        evento.setImg(eventoDTO.img());
        evento.setUrlEvento(eventoDTO.urlEvento());
        //evento.setLike(eventoDTO.like());

        return evento;
    }
}
