/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static com.grupo07.proyectoii.so.ProyectoIISO.mainMenuController;
import model.RoundRobinModel;
import view.RoundRobinView;


public class RoundRobinController {
    private RoundRobinView view;
    private RoundRobinModel model;

    public RoundRobinController(RoundRobinView view, RoundRobinModel  model) {
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
