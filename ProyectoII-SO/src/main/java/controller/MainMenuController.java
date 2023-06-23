/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.FCFSModel;
import model.MainMenuModel;
import model.RoundRobinModel;
import model.SFJNEModel;
import model.SJFModel;
import view.FCFSView;
import view.FifoRoundRobinManager;
import view.MainMenu;
import view.RoundRobinView;
import view.SJFEManager;
import view.SJFNEXView;

/**
 *
 * @author diego
 */
public class MainMenuController {
    private MainMenu view;
    private MainMenuModel model;

       //MVC ROUND ROBIN FIFO REVISAR
       FifoRoundRobinManager rRFifoView = new FifoRoundRobinManager();
       RoundRobinModel rRFifoModel = new  RoundRobinModel();
       RoundRobinFifoController rRFifo = new  RoundRobinFifoController(rRFifoView,rRFifoModel);
 
       
      // MVC FCFS BIEN
        FCFSView fcfsView = new FCFSView();
        FCFSModel fcfsModel = new FCFSModel();
        FCFSController fcfsController = new FCFSController(fcfsView,fcfsModel);
 
            
       // MVC ROUND ROBIN REVISAR
       RoundRobinView rr= new RoundRobinView();
       RoundRobinModel rrModel = new  RoundRobinModel();
       RoundRobinController rrController = new  RoundRobinController(rr,rrModel);
   
      
       //MVC SJF (EXPULSIVO) BIEN
       SJFEManager sjfView = new SJFEManager();
       SJFModel sjfModel = new SJFModel();
       SJFController sjfController = new SJFController(sjfView, sjfModel);
   
      
        // MVC SJF (NO EXPULSIVO) BIEN
       SJFNEXView sfjneView = new SJFNEXView();
       SFJNEModel sfjneModel = new SFJNEModel();
       SJFNEController sjfneController = new SJFNEController(sfjneView,sfjneModel);


    public MainMenuController(MainMenu view, MainMenuModel model) {
        this.view = view;
        this.model = model;
        view.setModel(model);
        view.setController(this);
    }
    
    
    public void mostrarRoundRobinFifoView(){
       hide();
       rRFifo.mostrar();
    }
    
    
    public void mostrarRoundRobinView(){
        hide();
        rrController.mostrar();
    }
    
    public void mostrarSJFExpulsivoView(){
        hide();
        sjfController.mostrar();
    }
    
    public void mostrarSJFNoExpulsivoView(){
        hide();
        sjfneController.mostrar();
    }
    
    public void mostrarFCFSView(){
        hide();
        fcfsController.mostrar();
    }
    
    public void mostrar(){        
        view.setVisible(true);
    }
    
    public void hide(){
        
        view.setVisible(false);
    }
}
