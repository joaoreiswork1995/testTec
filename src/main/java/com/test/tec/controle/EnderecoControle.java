package com.test.tec.controle;

import com.test.tec.DTO.CadastroEndereco;
import com.test.tec.DTO.UpdateEndereco;
import com.test.tec.servico.EnderecoServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
@AllArgsConstructor
public class EnderecoControle {

    private final EnderecoServ enderecoServ;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody CadastroEndereco cadastroEndereco){
        enderecoServ.cadastroEndereco(cadastroEndereco);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> updateEndereco(@RequestBody UpdateEndereco updateEndereco){
        enderecoServ.updateEndereco(updateEndereco);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{enderecoId}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long enderecoId){
        enderecoServ.deletarEndereco(enderecoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
