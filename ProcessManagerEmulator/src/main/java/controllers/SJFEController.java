/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.SJFEModel;
import views.SJFEView;

/**
 *
 * @author Jordan Villalobos
 */
public class SJFEController {
    
    private SJFEModel model;
    private SJFEView view;
    
     public SJFEController(SJFEView view, SJFEModel model){
        
        this.view = view;
        this.model = model;
        view.setModel(model);
        view.setController(this);
    }
     
     
       public void mostrar(){
        
        view.setVisible(true);
    }
    
    public void hide(){
        
        view.setVisible(false);
    }
    
}
