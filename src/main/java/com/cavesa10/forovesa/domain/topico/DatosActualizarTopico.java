package com.cavesa10.forovesa.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        Estatus estatus
) {
}
