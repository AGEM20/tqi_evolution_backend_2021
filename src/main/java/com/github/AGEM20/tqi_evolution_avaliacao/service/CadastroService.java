package com.github.AGEM20.tqi_evolution_avaliacao.service;

import com.github.AGEM20.tqi_evolution_avaliacao.entities.Cadastro;
import com.github.AGEM20.tqi_evolution_avaliacao.entities.Login;
import com.github.AGEM20.tqi_evolution_avaliacao.repositories.CadastroRepository;
import com.github.AGEM20.tqi_evolution_avaliacao.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

@Service
public class CadastroService {

  @Autowired
  private CadastroRepository cadastroRepository;
  private LoginRepository loginRepository;

  public Cadastro findById(String email) {
    Optional<Cadastro> obj = this.cadastroRepository.findById(email);
    return obj.orElse(null);
  }

  public Login create(@RequestBody Login login){
    return loginRepository.save(login);
  }

}
