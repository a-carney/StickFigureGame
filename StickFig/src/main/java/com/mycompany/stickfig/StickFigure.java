/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stickfig;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author alex
 */
public class StickFigure extends JPanel {
    private int x;
    private int y;
    private static final int WALL_THICKNESS = 20;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;
    
    

    public StickFigure() {
        x = 100; // starting position
        y = 100; 
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return  
     * if collision : TOP_COLLISION, BOTTOM_COLLISION, LEFT_COLLISION, RIGHT_COLLISION
     * <P>         
     * else: NO_COLLISION
     */
    public CollisionState isCollision(int x, int y) {
        boolean xLeftCollision = (x < WALL_THICKNESS);
        boolean xRightCollision = (x + 20 > GAME_WIDTH - WALL_THICKNESS);
        boolean yTopCollision = (y < WALL_THICKNESS);
        boolean yBottomCollision = (y + 40 > GAME_HEIGHT - WALL_THICKNESS);
        
        if (yTopCollision) {
            return CollisionState.TOP_COLLISION;
        } else if (yBottomCollision) {
            return CollisionState.BOTTOM_COLLISION;
        } else if (xLeftCollision) {
            return CollisionState.LEFT_COLLISION;
        } else if (xRightCollision) {
            return CollisionState.RIGHT_COLLISION;
        } else {
            return CollisionState.NO_COLLISION;
        } 
    }
    
    public void move(int dx, int dy) {
        int x_next = x + dx;
        int y_next = y + dy;
        
        // Check for coliisions with walls
        CollisionState collisionState = isCollision(x_next, y_next);
        // Collision Limiter
        limiterHorizontal(collisionState, dy);
        
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK); // Draw black background
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        
        g.setColor(Color.WHITE); // Draw white walls
        g.fillRect(0, 0, GAME_WIDTH, WALL_THICKNESS); // Top Wall
        g.fillRect(0, 0, WALL_THICKNESS, GAME_HEIGHT); // Left Wall
        g.fillRect(0, GAME_HEIGHT - WALL_THICKNESS, GAME_WIDTH, WALL_THICKNESS); // Bottom Wall
        g.fillRect(GAME_WIDTH - WALL_THICKNESS, 0, WALL_THICKNESS, GAME_HEIGHT); // Right WAll
        
        
        // Draw the stick figure at the current position
        g.fillOval(x, y, 20, 20); // Head
        g.drawLine(x + 10, y + 20, x + 10, y + 40); // Body
        g.drawLine(x, y + 30, x + 10, y + 20); // Left Arm
        g.drawLine(x + 20, y + 30, x + 10, y + 20); // Right Arm
        g.drawLine(x + 10, y + 40, x, y + 60); // Left Leg
        g.drawLine(x + 10, y + 40, x + 20, y + 60); // Right Leg
    } 

    private int[][] limiterHorizontal(CollisionState collisionState, int dy) {
        switch (collisionState) {
            case BOTTOM_COLLISION:
                if (dy > 0) {
                    
                }
                
        }
        return null;
    }

}
