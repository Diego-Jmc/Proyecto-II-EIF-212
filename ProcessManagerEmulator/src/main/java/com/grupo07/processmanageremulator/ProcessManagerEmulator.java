
package com.grupo07.processmanageremulator;

import controllers.MainMenuController;
import models.MainMenuModel;
import views.MainMenuView;


public class ProcessManagerEmulator {

    public static void main(String[] args) {
       MainMenuView mainView = new MainMenuView();
       MainMenuModel mainMenuModel = new MainMenuModel();
       MainMenuController mainMenuController = new MainMenuController(mainView,mainMenuModel);
       mainView.setVisible(true);
    }
    
   
}
