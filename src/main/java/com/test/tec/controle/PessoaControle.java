package com.test.tec.controle;

import com.test.tec.DTO.CadastroPessoa;
import com.test.tec.DTO.PessoaDTO;
import com.test.tec.servico.EnderecoServ;
import com.test.tec.servico.PessoaServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaControle {

    private final PessoaServ pessoaServ;

    private final EnderecoServ enderecoServ;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastroPessoa(@RequestBody CadastroPessoa cadastroPessoa){
        pessoaServ.cadastroPessoa(cadastroPessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> updatePessoa(@RequestBody PessoaDTO pessoaDTO){
        pessoaServ.updatePessoa(pessoaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/procurar/{nome}")
    public ResponseEntity<ArrayList<PessoaDTO>> procurarPessoa(@PathVariable String nome){
        ArrayList<PessoaDTO> pessoaPorNome = pessoaServ.procurarPessoa(nome);
        return new ResponseEntity<>(pessoaPorNome, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{pessoaId}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Long pessoaId){
        enderecoServ.deletarTodosOsEnderecos(pessoaServ.procurarPorId(pessoaId));
        pessoaServ.deletarPessoa(pessoaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<ArrayList<PessoaDTO>> listarTodos(){
        ArrayList<PessoaDTO> pessoas = pessoaServ.listarTodos();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }
}
