package com.github.AGEM20.tqi_evolution_avaliacao.service;

import org.springframework.stereotype.Service;
import java.util.Date;

@Service

public class EmprestimoService {


  public long diferencaData(Date hoje, Date dataFutura) {
    System.out.println("hoje ->"+ hoje);
    System.out.println("amanha ->"+ dataFutura);
    long diferenca;
    long date1 = hoje.getTime();
    long date2 = dataFutura.getTime();

    long differenceMilliSeconds = date2 - date1;
    diferenca = (differenceMilliSeconds/1000/60/60/24);
    System.out.println("diferenca ->"+ diferenca);
    return diferenca ++;

  }
}
