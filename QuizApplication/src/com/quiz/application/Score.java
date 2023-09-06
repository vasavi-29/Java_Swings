package com.quiz.application;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
	
	String name;
	Score(String name,int score){
		this.name=name;
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//image setting
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/score.png"));
		Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(50,200,300,250);
		add(image);
		
		//heading
		JLabel heading=new JLabel("Thank you "+name+" for playing Coding Masti");
		heading.setBounds(150,70,800,80);
		heading.setFont(new Font("Viner Hand ITC",Font.BOLD,36));
		heading.setForeground(new Color(0,191,221));
		add(heading);
		
		//displaying score
		JLabel finalscore=new JLabel("Your Score is: "+score);
		finalscore.setBounds(550,300,800,50);
		finalscore.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(finalscore);
		
		//play again button
		JButton submit=new JButton("Play Again");
		submit.setBounds(550,370,150,30);
		submit.setBackground(new Color(0,136,221));
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Tahoma",Font.PLAIN,18));
		submit.addActionListener(this);
		add(submit);
		
		
		setSize(1000,900);
		setLocation(150,50);
		setVisible(true);
		
	}
	public static void main(String args[]) {
		new Score("User",0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();
		
		
	}

}
