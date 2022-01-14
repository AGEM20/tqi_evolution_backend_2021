package com.github.AGEM20.tqi_evolution_avaliacao.entities;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {

  private String email;
  private String senha;

  public Login() {};

  public Login(String email, String senha) {
    this.email = email;
    this.senha = senha;
  }

  @Id
  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}

  @Column(name = "senha", nullable = false)
  public String getSenha() {return senha;}
  public void setSenha(String senha) {this.senha = senha;}

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "Cadastro_email")
  private Cadastro cadastro;
}
