/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.grupo07.proyectoii.so;


import controller.MainMenuController;
import model.MainMenuModel;
import view.MainMenu;

public class ProyectoIISO {

    
    
       static MainMenu mainView = new MainMenu();
       static MainMenuModel mainMenuModel = new MainMenuModel();
       public static MainMenuController mainMenuController = new MainMenuController(mainView,mainMenuModel);
   
       
    public static void main(String[] args) {

       mainMenuController.mostrar();
       
       
     
    }
}
