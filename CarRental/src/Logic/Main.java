/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import GUI.Search_GUI;
import java.awt.Dimension;
import java.awt.GridLayout;
import static javax.swing.JFrame.EXIT_ON_CLOSE;



/**
 *
 * @author aldo
 */
public class Main {
    public static void main(String[] args){
        Search_GUI frame=new Search_GUI();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(250, 250);
        frame.setSize(700,500);
        frame.setMaximumSize(new Dimension(800, 400));
        frame.setVisible(true);
    }
}
