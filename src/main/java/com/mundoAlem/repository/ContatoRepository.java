package com.mundoAlem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mundoAlem.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
