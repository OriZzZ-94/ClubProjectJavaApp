/**
 * This Class extends the state and behaviour of Person & abstract Class ClubAbstractEntity & JFrame
 * @author Nir Sananes & Ori Ashkenazi
 */
 	/*Imports*/
 	import java.awt.*;
 	import java.awt.event.*;
 	import javax.swing.*;
 	import java.util.*;
 	import java.io.Serializable;

public class Soldier extends Person implements Serializable
{
	/*Instance Variables*/
	 private String personalNum;
	 private JTextField field;
	 private JLabel redot1;
	
	 /*Default Constructor*/
	 /**
	 * Soldier constructor, initializes a new Soldier.
	 * Classes use:{@link javax.swing.JLabel},{@link javax.swing.JFrame}
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel},{@link javax.swing.JTextField}
	 */
	public Soldier()
	{
		super();
    	redot1=new JLabel("*");
    	redot1.setForeground(Color.red);
    	redot1.setVisible(false);
    	setTitle("Soldier Clubber's Data");
    	setSize(450,250);
    	JLabel js=new JLabel("Personal No.");
    	this.personalNum=new String();
    	field=new JTextField(25);
    	js.setPreferredSize(new Dimension(80, 20));
    	super.addToCenter(js);
    	//addToCenter method - add soldier centerpanel to the frame
    	super.addToCenter(this.field);
    	super.addToCenter(redot1);
    	super.disable_cancel_button();
	}//end of parameterless (default) constructor
	
	/*Parameters Constructor*/
	/**
	 * Soldier arguments constructor, initializes a new Soldier with arguments (Id, Name, Surename, Tel, new_personalNum). 
	 * @param Id ID number of the soldier.
	 * @param Name Name of the soldier.
	 * @param Surname Surname of the soldier.
	 * @param Tel Telephone number of the soldier.
	 * @param new_personalNum personal number of the soldier.
	 * Classes use:{@link javax.swing.JLabel},{@link javax.swing.JFrame}
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel},{@link javax.swing.JTextField}
	 */
    public Soldier(String Id,String Name,String Surname,String Tel,String new_personalNum)
    {
    	super(Id,Name,Surname,Tel);
    	redot1=new JLabel("*");
    	redot1.setForeground(Color.red);
    	redot1.setVisible(false);
    	setTitle("Soldier Clubber's Data");
    	setSize(450,250);
    	JLabel js=new JLabel("Personal No.");
    	this.personalNum=new String(new_personalNum);
    	field=new JTextField(25);
    	js.setPreferredSize(new Dimension(80, 20));
    	super.addToCenter(js);
    	//addToCenter method - add soldier centerpanel to the frame
    	super.addToCenter(this.field);
    	super.addToCenter(redot1);
	}//end of parameters constructor
	
	/*Methods*/
	/**
	 * Match abstract method from abstract Class ClubAbstractEntity, searches if Soldier exist in the club (by key number).
	 * @param key Id number for search.
	 * @return boolean true or false (by match result).
	 * Classes use:{@link javax.swing.JTextField},{@link java.lang.String}.
	 */
	public boolean match(String key)
	{
		if(super.match(key) == true && personalNum.equals(key))
		return true;
		return false;
	};//end of match()
	
	/**
	 * validateData abstract method from abstract Class ClubAbstractEntity, the function checks whether the soldier's details meet the standards of club registration.
	 * @return boolean true or false.
	 * Classes use:{@link javax.swing.JTextField},{@link javax.swing.JLabel},{@link java.lang.String}.
	 */
	protected boolean validateData()
	{
		boolean valid=true;
		if(field.getText().trim().isEmpty()){redot1.setVisible(true);valid=false;}
		if(!((field.getText()).charAt(0)=='R'||(field.getText()).charAt(0)=='O'||(field.getText()).charAt(0)=='C')){redot1.setVisible(true);valid=false;}
		if(!((field.getText()).charAt(1)=='/')){redot1.setVisible(true);valid=false;}
		if(valid){
		int counter=0;
		for(int i=2; i<(field.getText()).length();i++)
		{
		 if((field.getText()).charAt(i)>='0' && (field.getText()).charAt(i)<='9')counter++;
		}
		if(counter!=7){redot1.setVisible(true);valid=false;}
		}
		if(valid){redot1.setVisible(false);}
		return (super.validateData()&&valid);
	}//end of validateData()
	
	 /**
	 * Commit abstract method from abstract Class ClubAbstractEntity, the function puts the soldier's details in the "belly" from text-fields.
	 * Classes use:{@link javax.swing.JTextField},{@link java.lang.String}.
	 */
	protected void commit()
	{
		super.commit();
		this.personalNum=new String(field.getText());
	};//end of commit()
	
	/**
	 * rollBack abstract method from abstract Class ClubAbstractEntity, the function returns the soldier's details from the "belly" to the text-fields.
	 * Classes use:{@link javax.swing.JTextField}.
	 */
	protected void rollBack()
	{
		super.rollBack();
		field.setText(personalNum);
	};//end of rollBack()
}