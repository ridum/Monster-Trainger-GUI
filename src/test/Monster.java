package test;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Monster {
	
	public final String name;
	public int vitality;
	public int strength;
	public int Toughness;
	public int Acuity;
	public int Resistance;
	public int Agility;
	public int level;
	public HashMap<String, String> Augments;
	
	public Monster(String name,int vitality,int strength,int Toughness,int Acuity,int Resistance,int Agility,int level){
		this.name = name;
		this.vitality = vitality;
		this.strength = strength;
		this.Toughness = Toughness;
		this.Acuity =  Acuity;
		this.Resistance = Resistance;
		this.Agility = Agility;
		this.level = level;
		this.Augments= new HashMap<String, String>(25);
		
	}

	public void ShownOnPanel(JPanel card2,JTabbedPane tabbedPane) {
		JTextField levelField = new JTextField(String.valueOf(this.level), 20);
		JLabel name=new JLabel(this.name);
		TextArea Augments= new TextArea(5, 40);
		
		card2.add(name);
		card2.add(new Label("vitality"));
		card2.add(new JTextField(String.valueOf(this.vitality), 20));
		card2.add(new Label("strength"));
		card2.add(new JTextField(String.valueOf(this.strength), 20));
		card2.add(new Label("Toughness"));
		card2.add(new JTextField(String.valueOf(this.Toughness), 20));
		card2.add(new Label("Acuity"));
		card2.add(new JTextField(String.valueOf(this.Acuity), 20));
		card2.add(new Label("Resistance"));
		card2.add(new JTextField(String.valueOf(this.Resistance), 20));
		card2.add(new Label("Agility"));
		card2.add(new JTextField(String.valueOf(this.Agility), 20));
		card2.add(new Label("level"));
		card2.add(levelField);
		Monster that = this;
		levelField.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	if(that.Augments.containsKey(levelField.getText())){
	        		String current = Augments.getText();
	        		current = current + "," +  that.Augments.get(levelField.getText());
	        		Augments.setText(current);
	        		that.Augments.remove(levelField.getText());
	        	}
	        	 
	         }
	      });
		
		
		card2.add(new Label("Augments"));
		card2.add(Augments);
		
		final Button removeButton = new Button("remove this monster");
		removeButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	 tabbedPane.remove(tabbedPane.getSelectedIndex());
	        	 TabDemo.monsterCounter--;
	         }
	      });
		card2.add(removeButton);
	}
}
