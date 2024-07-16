package com.cavesa10.forovesa.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        Estatus estatus,
        LocalDateTime fecha
) {


    public DatosListadoTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getEstatus(), topico.getFecha());
    }
}
