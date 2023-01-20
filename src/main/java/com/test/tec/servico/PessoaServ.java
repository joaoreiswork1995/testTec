package com.test.tec.servico;

import com.test.tec.DTO.CadastroPessoa;
import com.test.tec.DTO.PessoaDTO;
import com.test.tec.excecao.ExcecaoGeral;
import com.test.tec.modelo.Pessoa;

import com.test.tec.repo.PessoaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@AllArgsConstructor
@Transactional
public class PessoaServ {

    private final PessoaRepo pessoaRepo;

    private final EnderecoServ enderecoServ;


    public void cadastroPessoa(CadastroPessoa cadastroPessoa){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(cadastroPessoa.getNome());
        pessoa.setDataNasci(cadastroPessoa.getDataNasci());
        pessoaRepo.save(pessoa);
    }

    public void updatePessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getPessoaId());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNasci(pessoaDTO.getDataNasci());
        pessoaRepo.save(pessoa);
    }

    public ArrayList<PessoaDTO> procurarPessoa(String nome) {
       ArrayList<Pessoa> pessoas = pessoaRepo.findByNome(nome).orElseThrow(() -> new ExcecaoGeral("Nenhuma pessoa cadastrada com esse nome."));
       ArrayList<PessoaDTO> pessoasDTO = new ArrayList<>();
       for(Pessoa pessoa : pessoas){
           PessoaDTO pessoaDTO = new PessoaDTO();
           pessoaDTO.setPessoaId(pessoa.getId());
           pessoaDTO.setNome(pessoa.getNome());
           pessoaDTO.setDataNasci(pessoa.getDataNasci());
           pessoaDTO.setEnderecos(enderecoServ.listarPorPessoa(pessoa));
           pessoasDTO.add(pessoaDTO);
        }
       return pessoasDTO;
    }

    public ArrayList<PessoaDTO> listarTodos(){
        List<Pessoa> pessoas = pessoaRepo.findAll();
        ArrayList<PessoaDTO> pessoasDTO = new ArrayList<>();
        for(Pessoa pessoa : pessoas){
            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setPessoaId(pessoa.getId());
            pessoaDTO.setNome(pessoa.getNome());
            pessoaDTO.setDataNasci(pessoa.getDataNasci());
            pessoaDTO.setEnderecos(enderecoServ.listarPorPessoa(pessoa));
            pessoasDTO.add(pessoaDTO);
        }
        return pessoasDTO;
    }

    public void deletarPessoa(Long pessoaId){
        pessoaRepo.deleteById(pessoaId);
    }

    public Pessoa procurarPorId(Long pessoaId){
        Pessoa pessoa = pessoaRepo.findById(pessoaId).orElseThrow(() -> new ExcecaoGeral("Pessoa não encontrada no banco de dados."));
        return pessoa;
    }

}
