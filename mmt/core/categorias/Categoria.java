package mmt.core.categorias;

public abstract class Categoria {

  private String _text;
  private double _discount;

  public String getAsText(){

    return _text;
  }

  public double applyDiscount(){

    return 1 - _discount;
  }

  public void setDiscount(double d){

    _discount = d ;
  }

  public void setAsText(String m){

      _text=m;
  }
}
