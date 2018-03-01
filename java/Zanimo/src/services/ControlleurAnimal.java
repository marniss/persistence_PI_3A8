/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Animal;
import java.util.ArrayList;

/**
 *
 * @author makni
 */
public class ControlleurAnimal {

    public ArrayList afficherAnimal() {
        Animal fds = new Animal();
        System.out.println("animal controller");
        return fds.selectAll();
    }

}
