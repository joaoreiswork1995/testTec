package com.test.tec.repo;

import com.test.tec.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PessoaRepo extends JpaRepository<Pessoa, Long> {
    Optional<ArrayList<Pessoa>> findByNome(String nome);
}
