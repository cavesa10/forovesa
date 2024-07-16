package com.cavesa10.forovesa.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRespository extends JpaRepository<Topico, Long> {
    List<Topico> findByActivoTrue();
}
