package com.github.AGEM20.tqi_evolution_avaliacao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="cadastro")
public class Cadastro implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private String email;
  private String nome;
  private String cpf;
  private String rg;
  private String endereco;
  private String complemento;
  private String cep;
  private String bairro;
  private String cidade;
  private String uf;
  private float  renda;
  private String senha;
  private List<Emprestimo> emprestimo;


  public Cadastro() {	}

  public Cadastro(String email, String nome, String cpf, String rg, String endereco,
                  String complemento, String cep, String cidade, String uf, float renda, String senha){
    this.email = email;
    this.nome = nome;
    this.cpf = cpf;
    this.rg = rg;
    this.endereco = endereco;
    this.complemento = complemento;
    this.cep = cep;
    this.cidade = cidade;
    this.uf = uf;
    this.renda = renda;
    this.senha = senha;
  }

  @Id
  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}

  @Column(name = "nome", nullable = false)
  public String getNome() {return nome;}
  public void setNome(String nome) {this.nome = nome;}

  @Column(name = "cpf", nullable = false)
  public String getCpf() {return cpf;}
  public void setCpf(String cpf) {this.cpf = cpf;}

  @Column(name = "rg", nullable = false)
  public String getRg() {return rg;}
  public void setRg(String rg) {this.rg = rg;}

  @Column(name = "endereco", nullable = false)
  public String getEndereco() {return endereco;}
  public void setEndereco(String endereco) {this.endereco = endereco;}

  @Column(name = "complemento", nullable = false)
  public String getComplemento() {return complemento;}
  public void setComplemento(String complemento) {this.complemento = complemento;	}

  @Column(name = "cep", nullable = false)
  public String getCep() {return cep;}
  public void setCep(String cep) {this.cep = cep;}

  @Column(name = "bairro", nullable = false)
  public String getBairro() {return bairro;}
  public void setBairro(String bairro) {this.bairro = bairro;}

  @Column(name = "cidade", nullable = false)
  public String getCidade() {return cidade;}
  public void setCidade(String cidade) {this.cidade = cidade;}

  @Column(name = "uf", nullable = false)
  public String getUf() {return uf;}
  public void setUf(String uf) {this.uf = uf;}

  @Column(name = "renda", nullable = false)
  public float getRenda() {return renda;}
  public void setRenda(float renda) {this.renda = renda;}

  @Column(name = "senha", nullable = false)
  public String getSenha() {return senha;}
  public void setSenha(String senha) {this.senha = senha;}

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "email", targetEntity = Emprestimo.class)
  public List<Emprestimo> getEmprestimo() {return emprestimo;}
  public void setEmprestimo(List<Emprestimo> emprestimo) {this.emprestimo = emprestimo;}
}
