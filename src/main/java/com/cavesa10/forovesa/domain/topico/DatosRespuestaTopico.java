package com.cavesa10.forovesa.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   Estatus estatus,
                                   LocalDateTime fecha) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getEstatus(), topico.getFecha());
    }
}
