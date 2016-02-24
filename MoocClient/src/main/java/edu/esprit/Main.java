package edu.esprit;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main implements ActionListener{

    private int clickCount = 0;

    private JLabel label;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Action Listener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton button = new JButton("Click me!");
        frame.add(button);

        JLabel label = new JLabel("You'v0 times.");
        frame.add(label);

        //pass the label into the MyListener constructor
        Main listener = new Main(label);

        //add the listener to the JButton
        //whenever the button is clicked, the JLabel is updated
        button.addActionListener(listener);

        frame.setSize(225, 100);
        frame.setVisible(true);
    }
    
    public Main(JLabel label){
        this.label = label;
    }

    public void actionPerformed(ActionEvent e) {

        clickCount++;

        label.setText("You've clicked " + clickCount + " times.");
    }
}