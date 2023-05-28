/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.SJFNEModel;
import views.SJFNEVIEW;

/**
 *
 * @author Jordan Villalobos
 */
public class SJFNEController {
    
    
    private SJFNEVIEW view;
    private SJFNEModel model;
    
    public SJFNEController(SJFNEVIEW view, SJFNEModel model){
        
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
