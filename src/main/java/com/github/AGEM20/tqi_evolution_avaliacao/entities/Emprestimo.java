package com.github.AGEM20.tqi_evolution_avaliacao.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="emprestimo")
public class Emprestimo {


  private int codigo;
  private String email;
  private float valorEmprestimo;
  private Date dataInicio;
  private byte  parcelas;
  private Cadastro cadastro;

  public Emprestimo() {}

  public Emprestimo(int codigo, String email, float valorEmprestimo, Date dataInicio, byte parcelas) {
    this.codigo = codigo;
    this.email = email;
    this.valorEmprestimo = valorEmprestimo;
    this.dataInicio = dataInicio;
    this.parcelas = parcelas;
  }

  @Id
  public int getCodigo() {return codigo;}
  public void setCodigo(int codigo) {this.codigo = codigo;}

  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}

  @Column(name = "valorEmprestimo", nullable = false)
  public float getValorEmprestimo() {return valorEmprestimo;}
  public void setValorEmprestimo(float valorEmprestimo) {this.valorEmprestimo = valorEmprestimo;}

  @Column(name = "dataInicio", nullable = false)
  public Date getDataInicio() {return dataInicio;}
  public void setDataInicio(Date dataInicio) {this.dataInicio = dataInicio;}

  @Column(name = "parcelas", nullable = false)
  public byte getParcelas() {return parcelas;}
  public void setParcelas(byte parcelas) {this.parcelas = parcelas;}

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emailEmprestimo", nullable = false)
  public Cadastro getCadastro() {
    return cadastro;
  }

  public void setCadastro(Cadastro cadastro){
    this.cadastro = cadastro;
  }


  @Override
  public String toString() {
    return "Emprestimo [email = " + email + ", Valor Emprestimo = " + valorEmprestimo
      + ", Data Inicio = " + dataInicio + ", Pqrcelas =" + parcelas + "]";
  }
}
