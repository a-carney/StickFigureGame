/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stickfig;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author alex
 */
public class StickFigureGame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    public StickFigureGame() {
        setTitle("Stick Figure Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers frame
        
        StickFigure stickFigure = new StickFigure();
        add(stickFigure);
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        stickFigure.move(0, -10);
                        break;
                    case KeyEvent.VK_DOWN:
                        stickFigure.move(0, 10);
                        break;
                    case KeyEvent.VK_LEFT:
                        stickFigure.move(-10, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        stickFigure.move(10, 0);
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            
    });
        setFocusable(true);
    }

    public static void main(String[] args) {
        StickFigureGame game = new StickFigureGame();
        game.setVisible(true);       
        
    }
}
