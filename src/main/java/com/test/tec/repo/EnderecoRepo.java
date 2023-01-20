package com.test.tec.repo;

import com.test.tec.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EnderecoRepo extends JpaRepository<Endereco, Long> {
    Optional<ArrayList<Endereco>> findByPessoaId(Long pessoaId);
}
