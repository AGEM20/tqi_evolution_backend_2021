package com.github.AGEM20.tqi_evolution_avaliacao.repositories;

import com.github.AGEM20.tqi_evolution_avaliacao.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
