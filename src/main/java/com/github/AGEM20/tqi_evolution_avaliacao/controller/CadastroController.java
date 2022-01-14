package com.github.AGEM20.tqi_evolution_avaliacao.controller;

import com.github.AGEM20.tqi_evolution_avaliacao.entities.Cadastro;
import com.github.AGEM20.tqi_evolution_avaliacao.repositories.CadastroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/cadastro")
public class CadastroController {

  @Autowired
  private CadastroRepository cadastroRepository;


  @GetMapping(path = {"/pesquisa/{email}"})
  public Object listaCadastro(@PathVariable String email) {
    System.out.println("Pesquisa cadastro ->" + email);
    return cadastroRepository.findByEmail(email);
    //   .map(record -> ResponseEntity.ok().body(record))
    //   .orElse(ResponseEntity.notFound().build());
  }


  @PostMapping
  public Cadastro create(@RequestBody Cadastro cadastro) {
    System.out.println("grava ->" + cadastro);
    return cadastroRepository.save(cadastro);

  }

  @PutMapping(value = "/atualizar/{email}")
  public ResponseEntity<Cadastro> update(@PathVariable("email") String email,
                                         @RequestBody Cadastro cadastro) {
    System.out.println("put ->" + email + "  " + cadastro);
    return cadastroRepository.findById(email)
      .map(record -> {
        record.setNome(cadastro.getNome());
        record.setCpf(cadastro.getCpf());
        record.setRg(cadastro.getRg());
        record.setEndereco(cadastro.getEndereco());
        record.setComplemento(cadastro.getComplemento());
        record.setCep(cadastro.getCep());
        record.setBairro(cadastro.getBairro());
        record.setCidade(cadastro.getCidade());
        record.setUf(cadastro.getUf());
        record.setRenda(cadastro.getRenda());
        record.setSenha(cadastro.getSenha());
        Cadastro updated = cadastroRepository.save(record);
        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = {"/apaga/{email}"})
  public ResponseEntity<?> delete(@PathVariable String email) {
    System.out.println("delete ->" + email);
    return cadastroRepository.findById(email)
      .map(record -> {
        cadastroRepository.deleteById(email);
        return ResponseEntity.ok().build();
      }).orElse(ResponseEntity.notFound().build());
  }
}
