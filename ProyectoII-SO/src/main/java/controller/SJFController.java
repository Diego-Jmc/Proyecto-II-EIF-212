/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static com.grupo07.proyectoii.so.ProyectoIISO.mainMenuController;
import model.SJFModel;
import view.SJFEManager;




public class SJFController {
     private SJFEManager view;
     private SJFModel model;

    public SJFController(SJFEManager view, SJFModel  model) {
        this.view = view;
        this.model = model;
        view.setModel(model);
        view.setController(this);
    }
    
       public void returnToMainMenu(){
        hide();
        mainMenuController.mostrar();
    }
    
      public void mostrar(){
        
        view.setVisible(true);
    }
    
    public void hide(){
        
        view.setVisible(false);
    }
}
