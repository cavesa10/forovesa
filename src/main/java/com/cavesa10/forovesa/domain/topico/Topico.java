package com.cavesa10.forovesa.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    private LocalDateTime fecha;
    private Boolean activo;

    public Topico(DatosRegistroTopico datosRegistroMedico) {
        this.titulo = datosRegistroMedico.titulo();
        this.mensaje = datosRegistroMedico.mensaje();
        this.estatus = Estatus.ABIERTO;
        this.fecha = LocalDateTime.now();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje()!= null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.estatus()!= null) {
            this.estatus = datosActualizarTopico.estatus();
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}
