package com.quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Quiz extends JFrame implements ActionListener{
	
	String questions[][]=new String[10][5];
	String answers[][]=new String[10][2];
	String useranswers[][]=new String[10][1];
	
	JLabel qno,question;
	JRadioButton opt1,opt2,opt3,opt4;
	ButtonGroup grpoptions;
	JButton next,lifeline,submit;
	
	public static int timer=10;
	public static int ans_given=0;//to check whether user has clicks the answer or not
	public static int count=0;
	public static int score=0;
	
	String name;
	Quiz(String name)
	{
		this.name=name;
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//image setting
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/quiz2.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(0,0,1000,300);
		add(image);
		
		//adding questions
		qno=new JLabel();
		qno.setBounds(100,350,50,30);
		add(qno);
		
		question=new JLabel();
		question.setBounds(120,350,900,30);
		add(question);
		
		//questions for the quiz
		questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        //answers for the questions
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
		
		opt1=new JRadioButton();
		opt1.setBounds(140,390,300,30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Mongolian Baiti",Font.PLAIN,16));
		add(opt1);
		
		opt2=new JRadioButton();
		opt2.setBounds(140,425,300,30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Mongolian Baiti",Font.PLAIN,16));
		add(opt2);
		
		opt3=new JRadioButton();
		opt3.setBounds(140,460,300,30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Mongolian Baiti",Font.PLAIN,16));
		add(opt3);
		
		opt4=new JRadioButton();
		opt4.setBounds(140,495,300,30);
		opt4.setBackground(Color.WHITE);
		opt4.setFont(new Font("Mongolian Baiti",Font.PLAIN,16));
		add(opt4);
		
		//grouping radio buttons
		grpoptions=new ButtonGroup();
		grpoptions.add(opt1);
		grpoptions.add(opt2);
		grpoptions.add(opt3);
		grpoptions.add(opt4);
		
		//next button
		next=new JButton("Next");
		next.setBounds(700,400,150,25);
		next.setBackground(new Color(0,136,221));
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
		next.addActionListener(this);
		add(next);
		
		//50-50 lifeline
		lifeline=new JButton("50-50 Lifeline");
		lifeline.setBounds(700,450,150,25);
		lifeline.setBackground(new Color(0,136,221));
		lifeline.setForeground(Color.WHITE);
		lifeline.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
		lifeline.addActionListener(this);
		add(lifeline);
		
		//Submit
		submit=new JButton("Submit");
		submit.setBounds(700,500,150,25);
		submit.setBackground(new Color(0,136,221));
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
		submit.setEnabled(false);
		submit.addActionListener(this);
		add(submit);
		
		start(count);
		
		setSize(1000,900);
		setLocation(150,50);
		setVisible(true);
		
		
	}
	
	//setting timer and decreasing timer automatically
	public void paint(Graphics g) {
		super.paint(g);
		
		String time="Time Left : "+timer+" seconds";//Time Left:10 seconds
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma",Font.BOLD,18));
		
		if(timer>0){
			g.drawString(time, 700, 390);
		}
		else {
			g.drawString("Times up!!",700,390);
		}
		
		timer--;//9 seconds
		
		try {
			Thread.sleep(1000);//1 sec=1000ms
			repaint();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(ans_given==1) {
			ans_given=0;
			timer=10;
		}
		else if(timer<0) {
			timer=10;
			
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			if(count==9) {//submit button
				if(grpoptions.getSelection()==null) {//to check whether anyone of the radio button is selected or not
					useranswers[count][0]="";
				}
				else {
					useranswers[count][0]=grpoptions.getSelection().getActionCommand();
				}
				for(int i=0;i<useranswers.length;i++) {
					if(useranswers[i][0].equals(answers[i][1])) {
						score+=10;
					}
					else {
						score+=0;
					}
				}
				setVisible(false);
				//score
				new Score(name,score);
			}
			else {//next button
				if(grpoptions.getSelection()==null) {//to check whether anyone of the radio button is selected or not
					useranswers[count][0]="";
				}
				else {
					useranswers[count][0]=grpoptions.getSelection().getActionCommand();
				}
				count++;
				start(count);
			}
		}
		
	}
	
	public void start(int count) {
		qno.setText(""+(count+1)+".");
		
		question.setText(questions[count][0]);
		
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);
		
		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);
		
		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);
		
		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);
		
		grpoptions.clearSelection();
		
	}
	
	public static void main(String[] args)
	{
		new Quiz("User");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==next) {
			repaint();
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			
			ans_given=1;
			
			if(grpoptions.getSelection()==null) {//to check whether anyone of the radio button is selected or not
				useranswers[count][0]="";
			}
			else {
				useranswers[count][0]=grpoptions.getSelection().getActionCommand();
			}
			
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			
			count++;
			start(count);
			
		}else if(e.getSource()==lifeline) {
			
			 if(count==2 || count==4 || count==6 || count==8 || count==9) {
				 opt2.setEnabled(false);
				 opt3.setEnabled(false);
				 
			 }else {
				 opt1.setEnabled(false);
				 opt4.setEnabled(false);
			 }
			 lifeline.setEnabled(false);
		}
		else if(e.getSource()==submit) {
			ans_given=1;
			
			if(grpoptions.getSelection()==null) {//to check whether anyone of the radio button is selected or not
				useranswers[count][0]="";
			}
			else {
				useranswers[count][0]=grpoptions.getSelection().getActionCommand();
			}
			
			for(int i=0;i<useranswers.length;i++) {
				if(useranswers[i][0].equals(answers[i][1])) {
					score+=10;
				}
				else {
					score+=0;
				}
			}
			setVisible(false);
			//score
			new Score(name,score);
			
		}
			
		
		
		
	}

}
