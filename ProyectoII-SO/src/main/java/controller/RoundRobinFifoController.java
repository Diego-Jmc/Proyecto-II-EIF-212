
package controller;

import static com.grupo07.proyectoii.so.ProyectoIISO.mainMenuController;
import model.RoundRobinModel;
import view.FifoRoundRobinManager;


public class RoundRobinFifoController {
    private FifoRoundRobinManager view;
    private RoundRobinModel model;

    public RoundRobinFifoController(FifoRoundRobinManager view, RoundRobinModel  model) {
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
