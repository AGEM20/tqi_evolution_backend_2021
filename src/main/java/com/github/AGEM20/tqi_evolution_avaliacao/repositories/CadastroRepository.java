package com.github.AGEM20.tqi_evolution_avaliacao.repositories;


import com.github.AGEM20.tqi_evolution_avaliacao.entities.Cadastro;
import com.github.AGEM20.tqi_evolution_avaliacao.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, String> {
  Optional<Emprestimo> findByEmail(String email);
}
