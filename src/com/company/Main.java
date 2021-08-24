package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {

        new Main();
    }

    public Main(){
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyChar()==KeyEvent.VK_ENTER) {
                    Contents.yV = 3;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_BACK_SLASH){
                    Contents.yV = -3;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_A){
                    Contents.bV = 3;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_Q){
                    Contents.bV = -3;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_SPACE){
                    if(Contents.player1scored){
                        Contents.bXv = -3;
                        Contents.bYv = (int)(Math.random() * 7) - 3;
                        Contents.player1scored = false;
                    } else if (Contents.player2scored){
                        Contents.bXv = 3;
                        Contents.bYv = (int)(Math.random() * 7) - 3;
                        Contents.player2scored = false;
                    }
                    event.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {
                if(event.getKeyChar()==KeyEvent.VK_ENTER) {
                    Contents.yV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_BACK_SLASH){
                    Contents.yV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_A){
                    Contents.bV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_Q){
                    Contents.bV = 0;
                    event.consume();
                }

            }

            @Override
            public void keyTyped(KeyEvent event) {
            }

        };
        JFrame frame = new JFrame();
        frame.setTitle("PONG");
        frame.setSize(900, 600);
        frame.setLocation(100, 50);
        frame.addKeyListener(listener);
        frame.add(new Contents());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
