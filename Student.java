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

public class Student extends Person implements Serializable
{
	/*Instance Variables*/
	private String Studentid;
    private JTextField field;
    private JLabel redot2;
	
	/*Default Constructor*/
	/**
	 * Student parameterless (default) constructor, initializes a new Student.
	 * Classes use:{@link javax.swing.JLabel},{@link javax.swing.JFrame}
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel},{@link javax.swing.JTextField}
	 */
	public Student()
	{
		super();
		redot2=new JLabel("*");
		redot2.setForeground(Color.red);
		redot2.setVisible(false);
    	setTitle("Student Clubber's Data");
    	setSize(450,250);
    	JLabel js=new JLabel("Student ID");
    	this.Studentid=new String();
    	field=new JTextField(25);
    	js.setPreferredSize(new Dimension(60, 20));
    	super.addToCenter(js);
    	//addToCenter method - add student centerpanel to the frame
        super.addToCenter(this.field);
        super.addToCenter(redot2);
        super.disable_cancel_button();
	}//end of paramterless (default) constructor
	
	/*Parameters Constructor*/
	/**
	 * Student argument constructor, initializes a new Student with arguments (Id, Name, Surename, Tel, new_Studentid). 
	 * @param Id ID number of the student.
	 * @param Name Name of the student.
	 * @param Surname Surname of the student.
	 * @param Tel Telephone number of the student.
	 * @param new_Studentid StudentID number.
	 * Classes use:{@link javax.swing.JLabel},{@link javax.swing.JFrame}
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel},{@link javax.swing.JTextField}
	 */
   public Student(String Id,String Name,String Surname,String Tel,String new_Studentid)
    {
    	super(Id,Name,Surname,Tel);
		redot2=new JLabel("*");
		redot2.setForeground(Color.red);
		redot2.setVisible(false);
    	setTitle("Student Clubber's Data");
    	setSize(450,250);
    	JLabel js=new JLabel("Student ID");
    	this.Studentid=new String(new_Studentid);
    	field=new JTextField(25);
    	js.setPreferredSize(new Dimension(60, 20));
    	super.addToCenter(js);
    	//addToCenter method - add student centerpanel to the frame
        super.addToCenter(this.field);
        super.addToCenter(redot2);
    }//end of paramters constructor
    
	/*Methods*/
	/**
	 * Match abstract method from abstract Class ClubAbstractEntity, searches if Student exist in the club (by key numer).
	 * @param key Id number for search.
	 * @return boolean true or false.
	  * Classes use:{@link javax.swing.JTextField},{@link java.lang.String}.
	 */
	public boolean match(String key)
	{
		boolean flag=true;
		int counter3=0;
		int j=0;
		for(int i=3;i<Studentid.length();)
		{
			if(Studentid.charAt(i)==key.charAt(j))counter3++;
			i++;j++;
		}
		if(counter3!=5)flag=false;
		if(super.match(key)||flag)return true;
		return flag;
	};//end of match()
	
	/**
	 * validateData abstract method from abstract Class ClubAbstractEntity, the function checks whether the student's details meet the standards of club registration.
	 * @return boolean true or false.
	 * Classes use:{@link javax.swing.JTextField},{@link javax.swing.JLabel},{@link java.lang.String}.
	 */
	protected boolean validateData()
	{
		boolean valid=true;
		if(field.getText().trim().isEmpty()){redot2.setVisible(true);valid=false;}
		int a=field.getText().length();
		if(a!=8){redot2.setVisible(true);valid=false;}
		if(valid){
		int counter1=0;
		int counter2=0;
		char check=0;
		for(int i=0; i<3;i++)
		{
			check=(field.getText()).charAt(i);
			if(check>='A'&&check<='Z')counter1++;
		}
		if(counter1!=3){redot2.setVisible(true);valid=false;}
		if((field.getText()).charAt(3)=='0'){redot2.setVisible(true);valid=false;}
		for(int i=4; i<8;i++)
		{
			check=(field.getText()).charAt(i);
			if(check>='0'&&check<='9')counter2++;
		}
		if(counter2!=4){redot2.setVisible(true);valid=false;}
		}
		if(valid){redot2.setVisible(false);}
		return (super.validateData()&&valid);
	}//end of validateData()
	
     /**
	 * commit abstract method from abstract Class ClubAbstractEntity ,A function that puts the student's details in the "belly" from text-fields.
	 * Classes use:{@link javax.swing.JTextField},{@link java.lang.String}.
	 */
	protected void commit()
	{
		super.commit();
		this.Studentid=new String(field.getText());
	};//end of commit()
	
	/**
	 * rollBack abstract method from abstract Class ClubAbstractEntity ,A function that returns the student's details from the "belly" to the text-fields.
	 * Classes use:{@link javax.swing.JTextField}.
	 */
	protected void rollBack()
	{
		super.rollBack();
		field.setText(Studentid);
	};//end of rollBack()
}//end of Student class