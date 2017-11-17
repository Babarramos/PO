package mmt.core;

import mmt.core.categorias.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Passenger {

  private String _nome;
  private Categoria _cat;
  private int _nite;
  private int _id;

  public Passenger(String n, int id) {

      _nome = n;
      _id = id;
      _cat = new Normal();
  }

  public String getName(){

    return _nome;
  }

  public void setName(String x){

    _nome = x;
  }

  public int getNumeroViagens() {

    return _nite;
  }

  public void updateCategory(Categoria c){

    _cat= c;
  }

  public Categoria getCategory(){

    return _cat;
  }

  public String toText() {

    return Integer.toString(_id) + " | " + _nome + " | " + _cat.getAsText();
  }

}
