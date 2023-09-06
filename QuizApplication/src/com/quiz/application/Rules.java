package com.quiz.application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rules extends JFrame implements ActionListener{
	
	String name;
	
	JButton back,start;
	
    Rules(String name) {
		
		this.name=name;
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null); 
		
		JLabel heading=new JLabel("Welcome to Coding Masti "+name);
		heading.setBounds(50,20,700,50);
		heading.setFont(new Font("Viner Hand ITC",Font.BOLD,36));
		heading.setForeground(new Color(128,0,0));
		add(heading);
		
		//rules content
		JLabel rules=new JLabel();
		rules.setBounds(20,70,700,350);
		rules.setFont(new Font("Times New Roman",Font.PLAIN,14));
		rules.setText(
				"<html>"+ 
		                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
		                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
		                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
		                "4. Crying is allowed but please do so quietly." + "<br><br>" +
		                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
		                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
		                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
		                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
		            "<html>"
				);
		add(rules);
		
		//back button
		back=new JButton("Back");
		back.setBounds(270,400,70,20);;
		back.setBackground(new Color(128,0,0));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		//start button
		start=new JButton("Start");
		start.setBounds(400,400,70,20);;
		start.setBackground(new Color(128,0,0));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);
		
		
		setSize(800,500);
		setLocation(350,100);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args)
	{
		
		new Rules("User");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==back) {
			setVisible(false);
			new Login();
		}
		else{
			setVisible(false);
			new Quiz(name);
		}
		
	}

}
