
package controller;

import static com.grupo07.proyectoii.so.ProyectoIISO.mainMenuController;
import model.SFJNEModel;
import view.SJFNEXView;


public class SJFNEController {
     private SJFNEXView view;
     private SFJNEModel model;

    public SJFNEController(SJFNEXView view, SFJNEModel  model) {
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
