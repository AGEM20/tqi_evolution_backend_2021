package com.github.AGEM20.tqi_evolution_avaliacao.controller;

import com.github.AGEM20.tqi_evolution_avaliacao.entities.Emprestimo;
import com.github.AGEM20.tqi_evolution_avaliacao.repositories.EmprestimoRepository;
import com.github.AGEM20.tqi_evolution_avaliacao.service.EmprestimoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

  @Autowired
  private EmprestimoRepository emprestimoRepository;
  @Autowired
  private EmprestimoService emprestimoService;

  @GetMapping(path = "/detalhado/{email}")
  public Optional<Emprestimo> buscaEmprestimos(@PathVariable String email){
    System.out.println("email buscaEmprestimos detalhado - " + email);
    Optional<Emprestimo> lista = emprestimoRepository.findById(email);
    System.out.println("lista -> " + lista);

    return lista;
  }

  @GetMapping(path = "/simples/{email}")
  public ResponseEntity<Emprestimo> listaCadastro(@PathVariable String email){
    System.out.println("email buscaEmprestimos simples - " + email);
    return emprestimoRepository.findByEmail(email)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }


  @PostMapping
  public Emprestimo create(@RequestBody Emprestimo emprestimo){
    System.out.println("grava emprestimo ->"+ emprestimo);
    byte parcelas = emprestimo.getParcelas();

    // cálculo dos dias
    Calendar data = Calendar.getInstance();
    Date hoje = data.getTime();

    Calendar dataFutura = Calendar.getInstance();
    dataFutura.setTime(dataFutura.getTime());
    dataFutura.add(Calendar.MONTH, 2);
    Date amanha = dataFutura.getTime();

    long diferenca = emprestimoService.diferencaData(hoje, amanha);

    if (parcelas > 60) {
      System.out.println("Quantidade de parcelas não pode ser maior que 60.");
      return null;
    }
    if(diferenca > 60){
      System.out.println("Não é possível data superior a 60 dias");
      return null;
    }

    return emprestimoRepository.save(emprestimo);
  }


}
