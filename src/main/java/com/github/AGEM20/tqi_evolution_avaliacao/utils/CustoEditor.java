package com.github.AGEM20.tqi_evolution_avaliacao.utils;

import java.beans.PropertyEditorSupport;

public class CustoEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text){
    text = text.replaceAll("[\\D]+", "");
    if(!text.isEmpty()){
      Integer c = Integer.parseInt(text);
      this.setValue(c);
    }
  }

}
