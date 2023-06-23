
package controller;

import com.grupo07.proyectoii.so.ProyectoIISO;
import static com.grupo07.proyectoii.so.ProyectoIISO.mainMenuController;
import model.FCFSModel;
import model.MainMenuModel;
import view.FCFSView;
import view.MainMenu;


public class FCFSController {
    private FCFSView view;
    private FCFSModel model;

    public FCFSController(FCFSView view, FCFSModel model) {
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
