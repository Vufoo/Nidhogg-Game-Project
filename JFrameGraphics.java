package com.company;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class JFrameGraphics extends JPanel{
    public void paint(Graphics g){
        g.drawString("3, 2, 1, GO!", 10, 10);
    }

    public static void main(String[] args){
        JFrame frame= new JFrame("JavaTutorial.net");
        frame.getContentPane().add(new JFrameGraphics());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
