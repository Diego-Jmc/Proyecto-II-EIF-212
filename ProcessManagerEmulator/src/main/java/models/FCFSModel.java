/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jordan Villalobos
 */
public class FCFSModel extends Observable{
    
    private int contador = 0 ;

    public int getContador() {
        return contador;
    }

    public void incrementarContador() {
        contador++;
    }
    
      @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        refresh();
    }
    
     private void refresh(){
        setChanged();
        notifyObservers();
    }
    
    
}
