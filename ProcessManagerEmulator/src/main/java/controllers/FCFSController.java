/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.FCFSModel;
import views.FCFS;

/**
 *
 * @author Jordan Villalobos
 */
public class FCFSController {
    
    //juntando los tres procesos principales
    private FCFS view;
    private FCFSModel model;
    
    public FCFSController(FCFS view, FCFSModel model){
        
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
