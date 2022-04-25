import java.util.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class AutoTour implements ActionListener{
    //private ArrayList<Node> allButtons = new ArrayList<Node>();
    private int x;
    private int y;
    private int totalButtons = this.x * this.y;
    private JButton[] allButtons; 
    private JFrame window = new JFrame();
    private JPanel gameBoard = new JPanel();
    
    AutoTour(int x,int y){
        this.x = x;
        this.y = y;
        this.totalButtons = (this.x * this.y) + 1;
        this.allButtons = new JButton[totalButtons];
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 600);
        window.getContentPane().setBackground(new Color(50,50,50));
        window.setLayout(new BorderLayout());

        gameBoard.setLayout(new GridLayout(x,y));
        gameBoard.setBackground(new Color(204,149,68));
        String mode = "even";
        for (int index = 1; index != this.totalButtons; ++index){
            int spot = index - 1;
            allButtons[spot] = new JButton();
            allButtons[spot].setBackground(new Color(204,149,68));
            if (mode == "even"){
                if (index % 2 == 0){
                    allButtons[spot].setBackground(new Color(96,54,1));
                }
            } else {
                if (index % 2 != 0){
                    allButtons[spot].setBackground(new Color(96,54,1));
                }
            }
            if (index % x == 0){
                if (mode == "even"){
                    mode = "odd";
                } else {
                    mode = "even";
                }
            }
            gameBoard.add(allButtons[spot]);
            allButtons[spot].setFocusable(false);
            allButtons[spot].addActionListener(this);
        }
        window.add(gameBoard);
        window.setVisible(true);
    }
    public void sleep(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public void deleteWindow(){
        this.window.dispose();
    }
    public void reconstruct(){
        for (int x = 0; x < this.totalButtons; ++x){
            this.allButtons[x].repaint();
        }
        this.gameBoard.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent action){
        for (int x = 0; x < this.totalButtons; ++x){
            if (action.getSource() == allButtons[x]){
                allButtons[x].setBackground(Color.BLACK);
                allButtons[x].repaint();
                gameBoard.validate();
            }
        }
    }
    public void clickButton(int index,int delay){
        this.sleep(delay);
        allButtons[index].doClick(1);
    }

}