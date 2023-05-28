/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.RoundRobinModel;
import views.RoundRobin;


/**
 *
 * @author Jordan Villalobos
 */
public class RoudRobinController {
    
    
    private RoundRobinModel model;
    private RoundRobin view;
    
     public RoudRobinController(RoundRobin view, RoundRobinModel model){
        
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
