package com.github.AGEM20.tqi_evolution_avaliacao.controller;

import com.github.AGEM20.tqi_evolution_avaliacao.entities.Cadastro;
import com.github.AGEM20.tqi_evolution_avaliacao.repositories.CadastroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

  private CadastroRepository cadastroRepository;
  @PostMapping(path = "/pesquisa/{login}")
  public ResponseEntity<Cadastro> verificaLogin(@RequestBody Cadastro login){
    //String email = login.getEmail();
    //String senha = login.getSenha();
    String email = "teste@123.456";
    String senha = "123456";

    cadastroRepository.findById(email)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());

    // return para montar metodo
    return null;
  }

  public ResponseEntity<Cadastro> lista(@PathVariable String email){
    return cadastroRepository.findById(email)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }



}
