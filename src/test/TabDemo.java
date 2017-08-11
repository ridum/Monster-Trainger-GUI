
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
package test;
 
/*
 * TabDemo.java
 */
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class TabDemo {
    final static String BUTTONPANEL = "Humans";
    final static int extraWindowWidth = 100;
    private JTextField pointsCount = new JTextField("12",20);
    private JTextField body = new JTextField("0",20);
    private JTextField intellect= new JTextField("0",20);
    private JTextField creativity= new JTextField("0",20);
    private JTextField presence= new JTextField("0",20);
    private Button AddBody;    // Declare a Button component
    private Button Addintellect;    // Declare a Button component
    private Button Addcreativity;    // Declare a Button component
    private Button Addpresence;    // Declare a Button component
    static int monsterCounter = 0;
    private int maxMonsterCounter = 0;
    Object[] monsters = {"John", "Ridum", "Monster"};

    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
 
        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                size.height += 300;
                return size;
            }
        };
        card1.setLayout(new BorderLayout(3, 10));
        
        JPanel totalPoint = new JPanel();
//		card1.add(new Label());
		pointsCount.setEditable(false);
		totalPoint.add(new Label("total points"));
		totalPoint.add(pointsCount);
		card1.add(totalPoint,BorderLayout.NORTH);
		
		JPanel seperation= new JPanel();
		seperation.setLayout(new GridLayout(4, 1, 3, 3));
		
		JPanel bodyPanel= new JPanel();
		bodyPanel.add(new Label("body"));
		bodyPanel.add(body);
		AddBody = new Button("Add");
		AddBody.addActionListener(new BtnCountListener());
		bodyPanel.add(AddBody);    		
		seperation.add(bodyPanel);
		
		JPanel IntPanel= new JPanel();
		IntPanel.add(new Label("intellect"));
		IntPanel.add(intellect);
		Addintellect = new Button("Add");
		Addintellect.addActionListener(new BtnCountListener());
		IntPanel.add(Addintellect); 
		seperation.add(IntPanel);
		
		JPanel CreatPanel= new JPanel();
		CreatPanel.add(new Label("creativity"));
		CreatPanel.add(creativity);
		Addcreativity = new Button("Add");
		Addcreativity.addActionListener(new BtnCountListener());
		CreatPanel.add(Addcreativity);
		seperation.add(CreatPanel);
		
		JPanel PrePanel= new JPanel();
		PrePanel.add(new Label("presence"));
		PrePanel.add(presence);
		Addpresence = new Button("Add");
		Addpresence.addActionListener(new BtnCountListener());
		PrePanel.add(Addpresence);  
		seperation.add(PrePanel);
		
		card1.add(seperation,BorderLayout.CENTER);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3, 3, 3));
		
		final Button resetButton = new Button("reset");
		resetButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	 body.setText("0");
	        	 intellect.setText("0");
	        	 creativity.setText("0");
	        	 presence.setText("0");
	        	 pointsCount.setText("12");
	        	 maxMonsterCounter = 0;
	        	 monsterCounter = 0;
	        	 int count= tabbedPane.getTabCount();
	        	 for(int i=1;i<count;i++){
	        		 tabbedPane.remove(1);
	        	 }
	         }
	      });
		buttonsPanel.add(resetButton);
		
		final Button AddMonsterButton = new Button("Add Monster");
		AddMonsterButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	             //add a monster
	        	 //TODO warning messsage
	        	 if(monsterCounter>= maxMonsterCounter) return;

	             String s = (String)JOptionPane.showInputDialog(
	                     card1,
	                     "choose a monster:\n",
	                     "Add Monster",
	                     JOptionPane.PLAIN_MESSAGE,
	                     null,
	                     monsters,
	                     "John");
	             Monster m;
	             switch (s) {
	             	case "John":  m =  new John();
	                      break;
	             	case "Ridum":  m =  new Ridum();
	             		  break;
	             	case "Monster":  m =  new Monster("hi",1,2,3,4,5,6,7);
           		  		 break;
	                default: return;
	             }

	             JPanel card2 = new JPanel(){};
	             card2.setLayout(new BoxLayout(card2, BoxLayout.PAGE_AXIS));	            	             	            
	             m.ShownOnPanel(card2,tabbedPane);
	             tabbedPane.addTab(m.name, card2); 	
	             monsterCounter++;
	         }
	      });
		
		buttonsPanel.add(AddMonsterButton);
		
		card1.add(buttonsPanel,BorderLayout.SOUTH);
		

 
        tabbedPane.addTab(BUTTONPANEL, card1);
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
 

    private class BtnCountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	int points = Integer.parseInt(pointsCount.getText());
        	if(points==0) return;
        	
        	int bodycount = Integer.parseInt(body.getText());
        	int intellectcount = Integer.parseInt(intellect.getText());
        	int creativitycount = Integer.parseInt(creativity.getText());
        	int presencecount = Integer.parseInt(presence.getText());
        	if(evt.getSource().equals(AddBody)){
        		bodycount++;
        		body.setText(bodycount + "");
        	}else if(evt.getSource().equals(Addintellect)){	
        		intellectcount++;
        		intellect.setText(intellectcount + "");
        	}else if(evt.getSource().equals(Addcreativity)){
        		creativitycount++;
        		creativity.setText(creativitycount + "");
        	}else if(evt.getSource().equals(Addpresence)){
        		presencecount++;
        		presence.setText(presencecount + "");
        	}
        	maxMonsterCounter = Math.max(Math.max(Math.max(bodycount,intellectcount),creativitycount),presencecount);
        	points--;
        	pointsCount.setText(points + "");
        }

     }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TabDemo demo = new TabDemo();
        demo.addComponentToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
//        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
