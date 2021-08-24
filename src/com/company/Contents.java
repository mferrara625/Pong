package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends JPanel implements ActionListener {

    public static int b = 200, y = 200, bX = 440, bY = 300;
    static int score1 = 0;
    static int score2 = 0;
    public static boolean player1scored = false, player2scored = false;



    private Timer t;

    public Contents(){
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(800, y, 25, 100);
        g2d.fillRect(50, b, 25, 100);

        g2d.fillOval( bX, bY, 15, 15);



        g2d.drawString("Player 1 Score: " + score1, 10, 50);
        g2d.drawString( "Q = \uD83E\uDC15   A = \uD83E\uDC17 ", 10, 25);
        g2d.drawString("Player 2 Score: " + score2, 700, 50);
        g2d.drawString( "Backslash = \uD83E\uDC15   Enter = \uD83E\uDC17 ", 700, 25);
        if(player1scored || player2scored){
            g2d.drawString("Press SPACE to continue", 450, 350);
        }


    }


    public static int yV = 2;
    public static int bV = 2;
    public static int bXv = 4;
    public static int bYv = 4;




    public void move(){
        b = b + bV;
        y = y + yV;

        bX = bX + bXv;
        bY = bY + bYv;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();


        if(b <= 0){
            bV = 3;
        } else if (b >= 450){
            bV = -3;
        }


        if(y <= 0){
            yV = 3;
        } else if (y >= 450){
            yV = -3;
        }

        if(bX <= 0){
            player2scored = true;
            score2++;
            bX = 440;
            bY = 300;
            bXv = 0;
            bYv = 0;
        } else if (bX >= 870){
            player1scored = true;
            score1++;
            bX = 440;
            bY = 300;
            bXv = 0;
            bYv = 0;
        }

        if(bY <= 0){
            bYv = 3;
        } else if (bY >= 550){
            bYv = -3;
        }

        if(bX <= 75 && bX >= 25 && bY > b && bY <= b + 100){
            bXv = 4;
            bYv = (int)(Math.random() * 7) - 3;
        }

        if(bX >= 775 && bX <= 800 && bY > y && bY <= y + 100){
            bXv = -4;
            bYv = (int)(Math.random() * 7) - 3;
        }

        repaint();
    }
}