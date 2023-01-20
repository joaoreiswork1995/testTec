package com.test.tec.servico;

import com.test.tec.DTO.CadastroEndereco;
import com.test.tec.DTO.EnderecoDTO;
import com.test.tec.DTO.UpdateEndereco;
import com.test.tec.excecao.ExcecaoGeral;
import com.test.tec.modelo.Endereco;
import com.test.tec.modelo.Pessoa;
import com.test.tec.repo.EnderecoRepo;
import com.test.tec.repo.PessoaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class EnderecoServ {

    private final EnderecoRepo enderecoRepo;

    private final PessoaRepo pessoaRepo;

    public void cadastroEndereco(CadastroEndereco cadastroEndereco){
        Endereco endereco = new Endereco();
        endereco.setPrincipal(cadastroEndereco.isPrincipal());
        endereco.setCep(cadastroEndereco.getCep());
        endereco.setLogradouro(cadastroEndereco.getLogradouro());
        endereco.setNumero(cadastroEndereco.getNumero());
        endereco.setCidade(cadastroEndereco.getCidade());
        endereco.setPessoa(pessoaRepo.findById(cadastroEndereco.getPessoaId()).orElseThrow(() -> new ExcecaoGeral("Pessoa não encontrada no banco de dados.")));
        enderecoRepo.save(endereco);
    }

    public void updateEndereco(UpdateEndereco updateEndereco){
        Endereco endereco = new Endereco();
        endereco.setId(updateEndereco.getEnderecoId());
        endereco.setLogradouro(updateEndereco.getLogradouro());
        endereco.setNumero(updateEndereco.getNumero());
        endereco.setCidade(updateEndereco.getCidade());
        endereco.setPrincipal(updateEndereco.isPrincipal());
        endereco.setCep(updateEndereco.getCep());
        endereco.setPessoa(pessoaRepo.findById(updateEndereco.getPessoaId()).orElseThrow(() -> new ExcecaoGeral("Pessoa não encontrada no banco de dados.")));
        enderecoRepo.save(endereco);
    }

    public ArrayList<EnderecoDTO> listarPorPessoa(Pessoa pessoa){
        ArrayList<Endereco> enderecos = enderecoRepo.findByPessoaId(pessoa.getId()).orElseThrow(() -> new ExcecaoGeral("Pessoa não encontrada no banco de dados."));
        ArrayList<EnderecoDTO> enderecosDTO = new ArrayList<>();
        for(Endereco endereco : enderecos){
            EnderecoDTO enderecoDTO = new EnderecoDTO();
            enderecoDTO.setEnderecoId(endereco.getId());
            enderecoDTO.setLogradouro(endereco.getLogradouro());
            enderecoDTO.setCep(endereco.getCep());
            enderecoDTO.setCidade(endereco.getCidade());
            enderecoDTO.setNumero(endereco.getNumero());
            enderecoDTO.setPrincipal(endereco.isPrincipal());
            enderecosDTO.add(enderecoDTO);
        }
        return enderecosDTO;
    }

    public void deletarEndereco(Long enderecoId){
        enderecoRepo.deleteById(enderecoId);
    }

    // Não é uma boa solução, mas ainda não sou familiar com a implementação do cascade no Spring Boot, então foi mais seguro fazer assim
    public void deletarTodosOsEnderecos(Pessoa pessoa){
        ArrayList<Endereco> enderecos = enderecoRepo.findByPessoaId(pessoa.getId()).orElseThrow(() -> new ExcecaoGeral("Pessoa não encontrada no banco de dados"));
        for(Endereco endereco : enderecos){
            deletarEndereco(endereco.getId());
        }
    }
}
