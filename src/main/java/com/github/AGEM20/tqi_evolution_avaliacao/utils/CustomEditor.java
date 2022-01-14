package com.github.AGEM20.tqi_evolution_avaliacao.utils;


import java.beans.PropertyEditorSupport;

public class CustomEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text){
    text = text.replaceAll("[^\\d,]+", "");
    text = text.replaceAll("[,]+", ".");
    if(!text.isEmpty()){
      Float c = Float.parseFloat(text);
      this.setValue(c);
    }

  }

}
