/**
 * This is abstract class ClubAbstractEntity extends from JFrame
 * Builds the frame and the center panel (with buttons and labels) that will be ready for construction by each of the users: Person, Soldier, Student.
 * @author Nir Sananes & Ori Ashkenazi
 */
 	/*Imports*/
 	import java.awt.*;
 	import java.awt.event.*;
 	import javax.swing.*;
 	import java.io.Serializable;

public  abstract class ClubAbstractEntity extends JFrame
{
	/*Instance Variables*/
	private JPanel centerPanel;
	private JButton okButton; 
	private JButton cancelButton;
	private ButtonHandler handler;
	
	/*Parameterless Constructor*/
	
	 /**
	 * ClubAbstractEntity parameterless constructor, initializes a new JFrame , JButton , JPanel , ButtonHandler.  
	 * Classes use:{@link javax.swing.JLabel},{@link javax.swing.JFrame}
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel},{@link javax.swing.JTextField}
	 */
	public ClubAbstractEntity()
	{
		//Create main JFrame
		super("Welcome to the club");
		
		//Main JFrame settings
		BorderLayout layout1=new BorderLayout();
        setLayout(layout1);
		getContentPane().setBackground(Color.gray);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(0);
		setVisible(true);
		
		//Create panels, labels, buttons and handlers
		centerPanel= new JPanel();
		JPanel[] WindowPanels= new JPanel[2];
		for(int i=0;i<2;i++)
		WindowPanels[i]=new JPanel();
		okButton=new JButton("ok");
		cancelButton=new JButton("cancel");
		handler=new ButtonHandler();
		
		//Gui settings
		FlowLayout layout2=new FlowLayout(FlowLayout.RIGHT,5,10);
		centerPanel.setLayout(layout2);
		WindowPanels[0].setPreferredSize(new Dimension(40, 40));
		WindowPanels[1].setPreferredSize(new Dimension(50, 50));
		
        //Buttons ActionListeners
        okButton.addActionListener(handler);
        cancelButton.addActionListener(handler);

        //Gui adding
        WindowPanels[0].add(okButton);
     	WindowPanels[0].add(cancelButton);
     	add(WindowPanels[0], BorderLayout.SOUTH);
     	add(centerPanel, BorderLayout.CENTER);
     	add(WindowPanels[1], BorderLayout.WEST);
                
	}//end of ClubAbAstractEntity parameterless (default) constructor
	
	/*Methods*/
	/**
	 * addToCenter method adds GUI Components to the centerPanel.
	 * @param guiComponent Id number of person.
	 */
	protected void addToCenter(Component guiComponent)
	{
		centerPanel.add(guiComponent);
	}//end of addToCenter
	
	/**
	 * disable_cancel_button method disables the ability and fuctional of the cancelButton click.
	 */
	protected void disable_cancel_button()
	{
		cancelButton.setEnabled(false);
	}//end of disable_cancel_button

	/*Abstract methods*/
		/**
	 * disable_cancel_button method disables the ability and fuctional of the cancelButton click.
	 * Match abstract method - search if person exist in the club by key number.
	 * @param key ID number for search.
	 * @return boolean true or false (the match result).
	 */
	public abstract boolean match(String key);
	/**
	 * validateData abstract method , this function checks whether details meet the standards of club registration.
	 * @return boolean true or false.
	 * Classes use:{@link javax.swing.JTextField},{@link javax.swing.JLabel},{@link java.lang.String}.
	 */
	protected abstract boolean validateData();
	/**
	 * commit abstract method ,A function that puts details in the "belly" from text-fields.
	 * Classes use:{@link javax.swing.JTextField},{@link java.lang.String}.
	 */
	protected abstract void commit();
	/**
	 * rollBack abstract method ,A function that returns details from the "belly" to the text-fields.
	 * Classes use:{@link javax.swing.JTextField}.
	 */
	protected abstract void rollBack();
	
	/*Inner Class*/
	 /**
	 * ButtonHandler Private inner class for event handling-implements from ActionListener - Activates the functionality of the Buttons.
	 * Classes use: {@link java.awt.event.EventListener}, {@link javax.swing.JButton}.
	 */
	private class ButtonHandler implements ActionListener,Serializable
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if(event.getActionCommand()=="ok")
			{
				if(validateData()==true){commit();cancelButton.setEnabled(true);}
			}
			
			else if(event.getActionCommand()=="cancel")rollBack();
		}
	}//end of ButtonHandler inner class
	
}//end of ClubAbstractEntity class