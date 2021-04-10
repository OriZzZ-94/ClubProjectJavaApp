/**
 * The class NightClubMgmtApp allows the user to work with the infrastructure.
 * The purpose of the class is to create a user experience in the infrastructure of abstract class ClubAbstractEntity.
 * @author Nir Sananes & Ori Ashkenazi
 */
	
 	/*Imports*/
	import java.util.*;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.io.*; 
   
	/*NightClubMgmtApp class*/
	public class NightClubMgmtApp 
	{
	//Night-Club Regular Customers Repository
	private ArrayList<ClubAbstractEntity> clubbers;
	private JFrame frame;
	
	/*Default constructor*/
	 /**
	 * NightClubMgmtApp parameterless constructor, initializes a new NightClubMgmtApp.
	 * Creates a user experience in the infrastructure of the abstract class ClubAbstractEntity.
	 * Classes use: {@link java.awt.event.EventListener}, {@link javax.swing.JFrame}, {@link javax.swing.JLabel},
     *{@link javax.swing.JButton}, {@link javax.swing.JPanel}, {@link javax.swing.ImageIcon},{@link javax.swing.Icon},{@link java.util.ArrayList<E>}
     *{@link java.io.showMessageDialog},{@link java.io.showInputDialog},{@link java.awt.event.WindowAdapter}.
	 */
	public NightClubMgmtApp()
	{
	//main JFrame
	frame=new JFrame("Ori & nir application");
	frame.setLayout(new BorderLayout());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setPreferredSize(new Dimension(900, 800));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    //Initializing clubbers
    clubbers=new ArrayList<>();
    //read from file when app begins
	loadClubbersDBFromFile();
    //create JPanels
    JPanel[] Panels = new JPanel[4];
    for(int i=0;i<4;i++)
    {
    	Panels[i]=new JPanel();
    }

    //Picture add to panel
    Icon pic = new ImageIcon(getClass().getResource("picture.jpg"));
    JLabel imgLabel = new JLabel(new ImageIcon("picture.jpg"));
    Panels[0].add(imgLabel);
    
    //Search button
    JButton b1=new JButton("Search");    
    Panels[3].add(b1);
	
	//Create clubber button
	JButton b2=new JButton("Create clubber");    
    Panels[2].add(b2);

	//Welcome label
	JLabel label = new JLabel();		
	label.setText("Welcome to Ori & Nir clubbers application! Enjoy :)");
	Panels[1].add(label);
	
	//Panels colors
	Panels[2].setBackground(Color.BLACK);
	Panels[1].setBackground(Color.CYAN);
    Panels[3].setBackground(Color.WHITE);
    Panels[0].setBackground(Color.DARK_GRAY);
	
	//Panels add and set
	frame.add(Panels[1],BorderLayout.NORTH);
	frame.add(Panels[0],BorderLayout.CENTER);
	frame.add(Panels[3],BorderLayout.EAST);
    frame.add(Panels[2],BorderLayout.WEST);
    
     for(int i=0;i<4;i++)
    {
    	Panels[i].revalidate();
    	Panels[i].validate();
		Panels[i].repaint();
    }
  
	//Search button action listener
		b1.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent e) {
				manipulateDB();					
			}          
	      });
	
	
	//Create button action listener
		b2.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent e) {
				//switch case for the user choose
				String clubber_choose=JOptionPane.showInputDialog(null,"What kind of clubber are you?\nFor Person - type 1\nFor Soldier - type 2\nFor Student - type 3\nBack to main menu - type 0");
				if(clubber_choose != null)
				{
				switch(clubber_choose) {
				case "0":
					break;
				case "1":
					clubbers.add(new Person());
					break;
				case "2":
					clubbers.add(new Soldier());
					break;
				case "3":
					clubbers.add(new Student());
					break;
				default:
					JOptionPane.showMessageDialog(null,"Error, you chose wrong","Error!",JOptionPane.ERROR_MESSAGE);
					break;
				}
					
				}//end of switch case
			}//end of action performed     
	      });//end of action listener
	    
	    
	   
   //Exit the user window
      frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        if (JOptionPane.showConfirmDialog(frame,"Are you sure you want to close this window?", "Close Window?", 
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		writeClubbersDBtoFile();
            System.exit(0);
        }
    }
    });
	}//end of parameterless (default) constructor
	
	
	/*manipulateDB method*/
	 /**
	 * manipulateDB method asks the user for a key and check if the key exists in the club.
	 * Classes use: {@link java.io.showMessageDialog},{@link java.io.showInputDialog}.
	 */
	private void manipulateDB()
	{
	boolean found = false;
	while(true)
	{
	String input=JOptionPane.showInputDialog(null,"Please Enter The Clubber's Key");
	if(input==null)
	{
	 JOptionPane.showMessageDialog(null, "Come Back find your Friend soon :)..\n","Wait!", JOptionPane.INFORMATION_MESSAGE);
	 break;
	}
	for(ClubAbstractEntity clubber : clubbers)
	if(clubber.match(input))
	{
	found = true;
	clubber.setVisible(true); 
	break;
	}
	if(!found)
    JOptionPane.showMessageDialog(null, "Clubber with this key does not exist\n","Wait!", JOptionPane.INFORMATION_MESSAGE);
	else found = !found;
	}
	}//end of method manipulateDB
	
	/*loadClubbersDBFromFile method*/
	/**
	 * loadClubbersDBFromFile method reads from a binary file and fills in the list of existing people in the club.
	 * Classes use: {@link java.io.FileInputStream}, {@link java.io.ObjectInputStream}.
	 * Exception: {@link java.io.EOFException}, {@link java.io.FileNotFoundException}, {@link java.io.ClassNotFoundException}, {@link java.io.IOException}.
	 */
	private void loadClubbersDBFromFile()
	{ 
    try{
     FileInputStream fis = new FileInputStream("BKCustomers.dat");
     ObjectInputStream ois = new ObjectInputStream(fis);
     clubbers = (ArrayList<ClubAbstractEntity>) ois.readObject();
     fis.close();
     ois.close();
    }
    catch(EOFException e)
    {
    	//EOF
    }
    catch(FileNotFoundException e)
    {
    	//Not Exisst
    }
     catch(IOException e)
	{
		e.printStackTrace();
	}
	  catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	}
	
	/*writeClubbersDBtoFile method*/
	/**
	  * writeClubbersDBtoFile method writes to a binary file and fills it from the list of existing people in the club.
	  * Classes use: {@link java.io.ObjectOutputStream}, {@link java.io.FileOutputStream},{@link java.io.showMessageDialog},{@link javax.swing.JOptionPane}.
	  * Exception: {@link java.io.EOFException}, {@link java.io.FileNotFoundException}, {@link java.io.IOException}.
	 */
	private void writeClubbersDBtoFile()
	{
		try
		{
		FileOutputStream fos = new FileOutputStream("BKCustomers.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(clubbers);
		fos.flush();
		oos.close();
        JOptionPane.showMessageDialog(null, "Successfully wrote to the file.\n","Succsess!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(EOFException e)
        {
        	//EOF
        }
        catch(FileNotFoundException e)
        {
        	//file doesnt exist - not happend.
        }
         catch(IOException e)
        {
        	e.printStackTrace();
        }
	}
	
	/*writeClubbersDBtoFile method*/
	/**
	 * Main- call NightClubMgmtApp constructor.
	 */
	public static void main(String[] args)
	{
	NightClubMgmtApp appliction = new NightClubMgmtApp();
	}
	}//end of class NightClubMgmtApp