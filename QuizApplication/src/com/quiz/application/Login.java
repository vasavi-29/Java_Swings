package com.quiz.application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	JButton rules,back;
	JTextField tf;
	Login(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		//inserting an image
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(0,0,500,450);//left,right,length,width
		add(image);
		
		//heading
		JLabel heading=new JLabel("Coding Masti");
		heading.setBounds(650,50,300,70);
		heading.setFont(new Font("Viner Hand ITC",Font.BOLD,36));
		heading.setForeground(new Color(128, 0, 0));//rgb values
		add(heading);
		
		//Enter your name label
		
	    JLabel name=new JLabel("Enter your name");
	    name.setBounds(650,155,300,50);
	    name.setFont(new Font("Mongolian Baiti",Font.BOLD,24));
	    name.setForeground(new Color(128, 0, 0));
	    add(name);
	    
	    
	    //textbox
	    tf=new JTextField();
	    tf.setBounds(600,220,300,30);
	    tf.setFont(new Font("Times New Roman",Font.PLAIN,14));
	    add(tf);
	     
	    //rules button
	   rules=new JButton("Rules");
	    rules.setBounds(650,290,70,22);
	    rules.setBackground(new Color(128, 0, 0));
	    rules.setForeground(Color.white);
	    rules.addActionListener(this);
	    add(rules);
	    
	  //back button
	    back=new JButton("Back");
	    back.setBounds(770,290,70,22);
	    back.setBackground(new Color(128, 0, 0));
	    back.setForeground(Color.white);
	    rules.addActionListener(this);
	    add(back);
	     
		setVisible(true);//to get frame visible
		setSize(1000,500);//width,height
		setLocation(200,100);//left,top
		
		
			
		
	}
	
	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==rules) {
			String name=tf.getText();
			setVisible(false);
			new Rules(name);
			
			
		}
		else if(e.getSource()==back) {
			setVisible(false);
		}
	}
}
