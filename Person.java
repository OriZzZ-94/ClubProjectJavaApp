/**
 * Person Class extends the state and behaviour of the abstract Class - ClubAbstractEntity & JFrame
 * @author Nir Sananes & Ori Ashkenazi
 */
 
  	/*Imports*/
 	import java.awt.*;
 	import java.awt.event.*;
 	import javax.swing.*;
 	import java.util.*;
 	import java.io.Serializable;

public class Person extends ClubAbstractEntity implements Serializable
{
	/*Instance Variables*/
	private String Id;
	private String Name;
	private String Surname;
	private String Tel;
    private JTextField[] fields;
    private JLabel[] redot;
    
	/*Default Constructor*/
	 /**
	 * Person parameterless constructor, initializes a new Person.
	* Classes use:{@link javax.swing.JLabel},{@link javax.swing.JFrame}
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel},{@link javax.swing.JTextField}
	 */
	public Person()
	{
		fields=new JTextField[4];
    	redot=new JLabel[4];
    	String[] Labels_names= {"ID","Name","Surname","Tel"};
    	for(int i=0;i<4;i++)//redots and fields loop
    	{
    		JLabel Label=new JLabel(Labels_names[i]);
    		redot[i]=new JLabel("*");
    		redot[i].setForeground(Color.red);
    		redot[i].setVisible(false);
    		Label.setPreferredSize(new Dimension(60, 20));
    		fields[i]=new JTextField(25);
    		super.addToCenter(Label);
    		super.addToCenter(fields[i]);
		    super.addToCenter(redot[i]);
    	}//end of loop
    	setTitle("Person Clubber's Data");
    	setSize(450,220);
    	super.disable_cancel_button();
    	this.Id=new String();
		this.Name=new String();
		this.Surname=new String();
		this.Tel=new String();
	}//end of parameterless (default) constructor
	
	/*Parameters Constructor*/
	/**
	 * Person arguments constructor, initializes a new Person with arguments (Id, Name, Surename, Tel). 
	 * @param Id ID number of the person.
	 * @param Name Name of the person.
	 * @param Surname Surname of the person.
	 * @param Tel Telephone number of the person.
	 * Classes use:{@link javax.swing.JLabel},{@link javax.swing.JFrame}
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel},{@link javax.swing.JTextField}
	 */
    public Person(String Id,String Name,String Surname,String Tel)
    {
    	fields=new JTextField[4];
    	redot=new JLabel[4];
    	String[] Labels_names= {"ID","Name","Surname","Tel"};
    	for(int i=0;i<4;i++)//redots and fields loop
    	{
    		JLabel Label=new JLabel(Labels_names[i]);
    		redot[i]=new JLabel("*");
    		redot[i].setForeground(Color.red);
    		redot[i].setVisible(false);
    		Label.setPreferredSize(new Dimension(60, 20));
    		fields[i]=new JTextField(25);
    		super.addToCenter(Label);
    		super.addToCenter(fields[i]);
		    super.addToCenter(redot[i]);
    	}//end of loop
    	setTitle("Person Clubber's Data");
    	setSize(450,220);
    	this.Id=new String(Id);
    	this.Name=new String(Name);
    	this.Surname=new String(Surname);
    	this.Tel=new String(Tel);
    }//end of parameters constructor
    
	/*Abstract methods*/
	/**
	 * Match abstract method from abstract Class ClubAbstractEntity - search if person exist in the club by key number.
	 * @param key ID number for search.
	 * @return boolean true or false (the match result).
	  * Classes use:{@link javax.swing.JTextField},{@link java.lang.String}.
	 */
	 
	public boolean match(String key)
	{
		return Id.equals(key);
	}//end of match method
	
	/**
	 * validateData abstract method from abstract Class ClubAbstractEntity, this function checks whether the person's details meet the standards of club registration.
	 * @return boolean true or false.
	 * Classes use:{@link javax.swing.JTextField},{@link javax.swing.JLabel},{@link java.lang.String}.
	 */
	protected boolean validateData()
	{
		//validateData pre-settings
		boolean flag=true;
		boolean check_1=true;
		boolean check_2=true;
		int a=0;
		int counter1=0;
		int counter2=0;
		int cap_let=0;
		int characters=0;
		int first_nums=0;
		int sec_nums=0;
		int third_nums=0;
		char check=0;
			
				
		//ID field RE
		if(fields[0].getText().trim().isEmpty()){redot[0].setVisible(true);flag=false;}
		else{
		for(int i=2; i<(fields[0].getText()).length()-2;i++)
		{
			if((fields[0].getText()).charAt(i)>='0'&&(fields[0].getText()).charAt(i)<='9')counter1++;
		}
		if(!(((fields[0].getText()).charAt(0)>='0'&& (fields[0].getText()).charAt(0)<='9')&&((fields[0].getText()).charAt(1)=='-')&&((fields[0].getText()).charAt(9)=='|')&&((fields[0].getText()).charAt(10)>='1')&&((fields[0].getText()).charAt(10)<='9')&&(counter1==7)))
			{redot[0].setVisible(true);flag=false;}
		else {redot[0].setVisible(false);}
		}//end of ID check
		
		//Name field RE
		if(fields[1].getText().trim().isEmpty()){redot[1].setVisible(true);flag=false;}
		else{
		for(int i=1; i<(fields[1].getText()).length();i++)
		{
			if((fields[1].getText()).charAt(i)>='a'&&(fields[1].getText()).charAt(i)<='z')counter2++;
		}
		if(!(((fields[1].getText()).charAt(0)>='A'&&(fields[1].getText()).charAt(0)<='Z')&&(counter2!=0)))
			{redot[1].setVisible(true);flag=false;}
		else {redot[1].setVisible(false);}
		}//end of Name check
		
	//Surname field RE
		if(fields[2].getText().trim().isEmpty()){redot[2].setVisible(true);flag=false;check_1=false;}//if jtextfield empty
		else{check=(fields[2].getText()).charAt(0);a=(fields[2].getText()).length();}
		if(a==1){redot[2].setVisible(true);flag=false;check_1=false;}//if jtextfield contain 1 letter/character
		else if(!(check>='A'&&check<='Z')){redot[2].setVisible(true);flag=false;check_1=false;}//if first letter not capital
		if(check_1==true){
		for(int i=0; i<(fields[2].getText()).length();i++)
		{
			check=(fields[2].getText()).charAt(i);
			if(!((check>='A'&&check<='Z')||check==(char)39||check=='-'||(check>='a'&&check<='z')))check_2=false;
			if(check==(char)39||check=='-')characters++;
		}//check if all the letters or characters are as needed and counting capital letters+characters
		if(check_2==false){redot[2].setVisible(true);flag=false;}
		else if(characters>2){redot[2].setVisible(true);flag=false;}
		else {redot[2].setVisible(false);}
		}//end of Surename check*/
		
		//Tel field RE
		if(fields[3].getText().trim().isEmpty()){redot[3].setVisible(true);flag=false;}
		else{
		int i=0;
		int j=0;
		for(; (fields[3].getText()).charAt(i)!=')';i++)
		{
			if((fields[3].getText()).charAt(i)>='0'&&(fields[3].getText()).charAt(i)<='9')first_nums++;
		}
		
		for(i=first_nums+3; (fields[3].getText()).charAt(i)!='-';i++)
		{
			if((fields[3].getText()).charAt(i)>='0'&&(fields[3].getText()).charAt(i)<='9')sec_nums++;
		}
		
		for(j=i+1; j<(fields[3].getText()).length();j++)
		{
			if((fields[3].getText()).charAt(j)>='0'&&(fields[3].getText()).charAt(j)<='9')third_nums++;
		}
		if(!((fields[3].getText()).charAt(0)=='+')&&((fields[3].getText()).charAt(1)=='(')&&((fields[3].getText()).charAt(2)!='0')&&((fields[3].getText()).charAt(first_nums+2)==')')&&((fields[3].getText()).charAt(first_nums+3)>='1'&&(fields[3].getText()).charAt(first_nums+3)<='9')&&(first_nums<=3)&&(sec_nums<=3)&&((fields[3].getText()).charAt(i+1)!='0')&&(third_nums==7))
		{redot[3].setVisible(true);flag=false;}
		else {redot[3].setVisible(false);}
		}//end of Tel check
		
		return flag;//return flag!
		
	}//end of validateData method
	
	/**
	 * commit abstract method from abstract Class ClubAbstractEntity ,A function that puts the person's details in the "belly" from text-fields.
	 * Classes use:{@link javax.swing.JTextField},{@link java.lang.String}.
	 */
	protected void commit()
	{
		Id=new String(fields[0].getText());
		Name=new String(fields[1].getText());
		Surname=new String(fields[2].getText());
		Tel=new String(fields[3].getText());
	};//end of commit()
	
	/**
	 * rollBack abstract method from abstract Class ClubAbstractEntity ,A function that returns the person's details from the "belly" to the text-fields.
	 * Classes use:{@link javax.swing.JTextField}.
	 */
	protected void rollBack()
	{
		fields[0].setText(Id);
		fields[1].setText(Name); 
		fields[2].setText(Surname); 
		fields[3].setText(Tel); 
	}//end of rollBack()
}//end of Person class