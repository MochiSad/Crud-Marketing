package com.mochimochi.backcrudmarketing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mochimochi.backcrudmarketing.dto.EventoDTO;
import com.mochimochi.backcrudmarketing.model.Evento;
import com.mochimochi.backcrudmarketing.service.EventoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }
    
    //@PatchMapping("/{id}/like")
    //public Evento toggleLike(@PathVariable Long id) {
        //return eventoService.toggleLike(id);
    //}
    
    //@RequestMapping(method = RequestMethod.GET) 
    @GetMapping
    public List<EventoDTO> list(){
        return eventoService.list();
    }

    @GetMapping("/{id}")
    public EventoDTO findById(@PathVariable @NotNull @Positive Long id){
        return eventoService.findById(id); 
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EventoDTO create(@RequestBody @Valid @NotNull EventoDTO evento){
        return eventoService.create(evento);
        //return ResponseEntity.status(HttpStatus.CREATED)
            //.body(eventoRepository.save(evento));
    }

    @PutMapping("/{id}")
    public EventoDTO update(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @Valid @NotNull EventoDTO evento){
        return eventoService.update(id, evento); 
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        eventoService.delete(id);
                    
    }
}
