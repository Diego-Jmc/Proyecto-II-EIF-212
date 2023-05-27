
package controllers;

import models.MainMenuModel;
import views.MainMenuView;


public class MainMenuController {
    private MainMenuView view;
    private MainMenuModel model;

    public MainMenuController(MainMenuView view, MainMenuModel model) {
        this.view = view;
        this.model = model;
        view.setModel(model);
        view.setController(this);
    }
    
    
    
}
