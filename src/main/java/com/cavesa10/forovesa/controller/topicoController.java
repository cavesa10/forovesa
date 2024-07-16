package com.cavesa10.forovesa.controller;

import com.cavesa10.forovesa.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class topicoController {

    @Autowired
    private TopicoRespository topicoRespository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroMedico) {
        topicoRespository.save(new Topico(datosRegistroMedico));
    }
    @GetMapping
    public List<DatosListadoTopicos> obtenerTopicos() {
        List <Topico> topicos = topicoRespository.findByActivoTrue();
        return topicos.stream()
                .map(DatosListadoTopicos::new)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public DatosRespuestaTopico obtenerTopico(@PathVariable Long id){
         Topico topico = topicoRespository.getReferenceById(id);
         var datosTopicos = new DatosRespuestaTopico(
                 topico.getId(),
                 topico.getTitulo(),
                 topico.getMensaje(),
                 topico.getEstatus(),
                 topico.getFecha());
         return datosTopicos;
    }

    @PutMapping("/{id}")
    @Transactional
    public void actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRespository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
    }
//Delete lógico
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRespository.getReferenceById(id);
        topico.desactivarTopico();

    }

}
