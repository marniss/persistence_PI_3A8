/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.zanimo;

import com.codename1.components.ImageViewer;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.gui.users.AjouterFs;

/**
 *
 * @author makni
 */
public class Bar {

    protected Form hi;
    protected Resources theme;

    public Bar() {

        theme = UIManager.initFirstTheme("/theme");
        hi = new Form("Best Pets");
        Toolbar tb = hi.getToolbar();
        ImageViewer img = new ImageViewer(theme.getImage("1.jpg"));
        // hi.add(img);
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AjouterFs aj = new AjouterFs();
                aj.getHi().show();
            }
        });
        tb.addMaterialCommandToSideMenu("Proffessionel", FontImage.MATERIAL_MONEY_OFF, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hi.show();
            }
        });
        tb.addMaterialCommandToSideMenu("Produits", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hi.show();
            }
        });
        tb.addMaterialCommandToSideMenu("Annonce", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hi.show();
            }
        });
        tb.addMaterialCommandToSideMenu("Concours", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hi.show();
            }
        });
    }

    public Form getHi() {
        return hi;
    }

}