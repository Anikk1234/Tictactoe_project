
package com.mycompany.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Mygame extends JFrame implements ActionListener{
    JLabel up,down;
    Font font = new Font("",Font.BOLD,20);
    JPanel mainPanel;
    JButton []butt = new JButton[9];
    int chance[] = {2,2,2,2,2,2,2,2,2};
    int active = 0;
    
    int winningPos[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int win=2;
    boolean gOver = false;
Mygame(){
    System.out.println("1st page");
    setTitle("TicTacToe");
    setSize(500,500);
    //ImageIcon icon= new ImageIcon("src/img/tictak.png");
    //setIconImage(icon.getImage());
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Mygame();
    setVisible(true);
}
private void Mygame(){
    this.getContentPane().setBackground(Color.red);
this.setLayout(new BorderLayout());
up = new JLabel("TIC TAC TOE");
up.setFont(font);
up.setHorizontalAlignment(SwingConstants.CENTER);
up.setForeground(Color.white);

this.add(up,BorderLayout.NORTH);

down = new JLabel("CLOCK");
down.setFont(font);
down.setHorizontalAlignment(SwingConstants.CENTER);
down.setForeground(Color.white);

this.add(down,BorderLayout.SOUTH);

Thread t = new Thread(){
public void run(){
try{
while(true){
    String datetime = new Date().toLocaleString();
    down.setText(datetime);
Thread.sleep(1000);
}
}
catch(Exception e){
    e.printStackTrace();
}}
};
t.start();

mainPanel = new JPanel();
mainPanel.setLayout(new GridLayout(3,3));
for(int i=1;i<=9;i++){
JButton btn = new JButton();
//btn.setIcon(new ImageIcon("src/img/zero.png"));
mainPanel.add(btn);
butt[i-1]=btn;
btn.addActionListener(this);
btn.setName(String.valueOf(i-1));
}
this.add(mainPanel,BorderLayout.CENTER);
}

    @Override
    public void actionPerformed(ActionEvent e) {
JButton curButton = (JButton)e.getSource();
String nameStr = curButton.getName();
        System.out.println(nameStr);
        int name = Integer.parseInt(nameStr.trim());
        if(gOver==true){
        JOptionPane.showMessageDialog(this, "Mygame Already Over......");
        return;
        }
        
        
        
        if(chance[name]==2){
        if(active == 1){
        curButton.setText("1");
        curButton.setBackground(Color.blue);
        curButton.setFont(new Font("",Font.BOLD,150));
        chance[name] = active;
        active = 0;
        }
        else {
              curButton.setText("0");
        curButton.setBackground(Color.yellow);
        curButton.setFont(new Font("",Font.BOLD,150));
                chance[name] = active;

        active = 1;
        }
        
        for(int []tempor:winningPos){
            if((chance[tempor[0]]==chance[tempor[1]]) && (chance[tempor[1]]==chance[tempor[2]])&&(chance[tempor[2]]!=2 )){
              win=chance[tempor[0]];
              gOver=true;
              JOptionPane.showMessageDialog(null, "Player "+win+" has won the game...");
              int i = JOptionPane.showConfirmDialog(this, "Do you want to play more??");
              if(i==0){
              this.setVisible(false);
              new Mygame();
              }
              else if(i==1){
              System.exit(101);
              }
              else {
              
              }
              break;
            }
        }
        
        
        int c=0;
        for(int x:chance){
        if(x==2){
        c++;
        break;
        }
        }
        if(c==0 && gOver==false){
        JOptionPane.showMessageDialog(null, "Its draw.....");
        int i= JOptionPane.showConfirmDialog(this, "Play More");
        if(i==0){
        this.setVisible(false);
        new Mygame();
        }
        else if(i==1){
        System.exit(102);
        
        }
        else{
        
        }
        gOver=true;
        }
        
    }
        else {
            JOptionPane.showMessageDialog(this, "Position Already Occupied");
        }}
}
