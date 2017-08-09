package test;

import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
	public ArrayList<String> Augments;
	
	public Monster(String name,int vitality,int strength,int Toughness,int Acuity,int Resistance,int Agility,int level){
		this.name = name;
		this.vitality = vitality;
		this.strength = strength;
		this.Toughness = Toughness;
		this.Acuity =  Acuity;
		this.Resistance = Resistance;
		this.Agility = Agility;
		this.level = level;
	}

	public void ShownOnPanel(JPanel card2) {
		
		card2.add(new JLabel(this.name));
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
		card2.add(new JTextField(String.valueOf(this.level), 20));
		
		
	
	}
}
