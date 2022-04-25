import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;

public class launchPage implements ActionListener{
    Tuple<Integer,Integer,Integer,Integer,Integer> positions = null;
    private JFrame window = new JFrame();
    private JPanel inputs = new JPanel();

    private JTextField boardX = new JTextField();
    private JLabel boardLable = new JLabel();
    private JTextField boardY = new JTextField();

    private JTextField posistionX = new JTextField();
    private JLabel positionLable = new JLabel();
    private JTextField positionY = new JTextField();

    private JLabel delayLable = new JLabel();
    private JTextField delayInput = new JTextField();

    private JButton startButton = new JButton("Start Tour");

    launchPage(){
        startButton.setBounds(750, 400, 150,80);
        startButton.setFocusable(false);
        startButton.setBackground(new Color(96,54,1));
        startButton.addActionListener(this);
        window.add(startButton,BorderLayout.SOUTH);
        window.add(this.inputs,BorderLayout.CENTER);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900,600);
        window.setVisible(true);

        this.boardLable.setText("Board X x Y : ");
        this.boardX.setText("8");
        this.boardY.setText("8");
        this.boardLable.setBounds(250, 250, 125, 25);
        this.boardX.setBounds(375, 250, 60, 25);
        this.boardY.setBounds(435, 250, 60, 25);
        
        this.positionLable.setText("Starting spot (x,y): ");
        this.positionLable.setBounds(250, 275, 125, 25);
        this.posistionX.setText("0");
        this.positionY.setText("0");
        this.posistionX.setBounds(375, 275, 60, 25);
        this.positionY.setBounds(435, 275, 60, 25);

        this.delayLable.setText("delay ms: ");
        this.delayInput.setText("500");
        this.delayLable.setBounds(250,300,125,25);
        this.delayInput.setBounds(405, 300, 60, 25);

        inputs.add(this.boardLable);
        inputs.add(this.positionLable);
        inputs.add(this.boardX);
        inputs.add(this.boardY);
        inputs.add(this.posistionX);
        inputs.add(this.positionY);
        inputs.add(this.delayLable);
        inputs.add(this.delayInput);
        inputs.setBackground(new Color(204,149,68));

    }

    @Override
    public void actionPerformed(ActionEvent action){
        /*
        should create a new window to construct a tour
         */
        if (action.getSource() == startButton){
            positions = new Tuple<Integer,Integer,Integer,Integer,Integer>();
            int getBoardX = Integer.parseInt(this.boardX.getText());
            int getBoardY = Integer.parseInt(this.boardY.getText());
            int getStartX = Integer.parseInt(this.posistionX.getText());
            int getStartY = Integer.parseInt(this.positionY.getText());
            int delay = Integer.parseInt(this.delayInput.getText());

            positions.setFirst(getBoardX);
            positions.setSecond(getBoardY);
            positions.setThird(getStartX);
            positions.setFourth(getStartY);
            positions.setFifth(delay);
        }
    }
    public Tuple<Integer,Integer,Integer,Integer,Integer> returnValues(){
        return this.positions;
    }

}
