import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//Noah Mifsud Lattari
//50076040
//CPS-209-052
//Tim Mclnerney
//April 10th 2017

//Extends the JFrame class to inherit JFrame components for easier GUI building
public class AppointmentFrame extends JFrame {

	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 900;
	//Intiates all the reference variables that need to be updated outside of a method
	private JLabel labelN;
	private SimpleDateFormat sdf;
	private Calendar date = Calendar.getInstance();
	private GregorianCalendar gCal;
	private GregorianCalendar gCal2;
	private Calendar mainDate;
	private ArrayList<Appointment> appointments;
	private JTextArea textTop;
	private JScrollPane scrollPane;
	private JPanel panel;
	private int AREA_ROWS = 16;
	private int AREA_COLUMNS = 39;
	private int hourParsed;
	private int minuteParsed;
	private int currentYear = date.get(Calendar.YEAR);
	private int currentMonth = date.get(Calendar.MONTH);
	private int currentDay = date.get(Calendar.DAY_OF_MONTH);
	private int currentHour = date.get(Calendar.HOUR_OF_DAY);
	private int currentMinute = date.get(Calendar.MINUTE);
	private String descriptionParsed;
	private JTextField descField;
	private JTextField lastnameText = null;
	private JTextField firstnameText = null;
	private JTextField telephoneText = null;
	private JTextField emailText = null;
	private JTextField addressText = null;
	private Person person;
	private Stack<Appointment> appointmentstack = new Stack<Appointment>();
	public AppointmentFrame() {
		//Construct method that builds the top part of the gui, and sets the default date format
		sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
		//Holds date for top left corner
		mainDate = new GregorianCalendar(currentYear, currentMonth, currentDay, currentHour, currentMinute);
		//Places the date in the top

		

		
		//Creates an arraylist to hold each Appointment
		appointments = new ArrayList<Appointment>();
		
		//Area to display appointments
		panel = new JPanel();
		
		
		
		
		
		
		
		
		
		//Calls a method to make the control panel
		createControlPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	

	public void createControlPanel() {
		//Calls the 7 methods to create each control panel part
		JPanel datePanel = createDatePanel();
		JPanel actionPanel = createActionPanel();
		JPanel descPanel = createDescPanel();
		JPanel contactsPanel = createContactPanel();
		JPanel appPanel = createAppPanel();
		JPanel calPanel = createCalPanel();
		JPanel controlPanel = new JPanel();
		//Places each control panel in one grid layout
		controlPanel.setLayout(new GridLayout(3, 2));
		controlPanel.add(appPanel);
		controlPanel.add(calPanel);
		controlPanel.add(datePanel);
		controlPanel.add(contactsPanel);
		controlPanel.add(actionPanel);
		controlPanel.add(descPanel);
		
		add(controlPanel, BorderLayout.SOUTH);
	}
	
	public JPanel createAppPanel() {
		
		JPanel panel = new JPanel();
		
		labelN = new JLabel(sdf.format(mainDate.getTime()));
		panel.add(labelN);
		
		textTop = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		textTop.setEditable(false);
		
		scrollPane = new JScrollPane(textTop);
		panel.add(scrollPane, BorderLayout.SOUTH);

		
		
		
		
		
		return panel;
	}
	
	public JPanel createCalPanel() {
		//Creates the Calendar 
		JPanel panel = new JPanel();
	
		//add label for each day
		JLabel labelM = new JLabel("April:      ");
		panel.add(labelM);		
		
		JPanel dayPanel = new JPanel();
		dayPanel.setLayout(new GridLayout(7, 7));
		
		JLabel sunday = new JLabel("   Sun");
		dayPanel.add(sunday);
		JLabel monday = new JLabel("      Mon");
		dayPanel.add(monday);
		JLabel tuesday = new JLabel("       Tue");
		dayPanel.add(tuesday);
		JLabel wednesday = new JLabel("      Wed");
		dayPanel.add(wednesday);
		JLabel thursday = new JLabel("      Thu");
		dayPanel.add(thursday);
		JLabel friday = new JLabel("      Fri");
		dayPanel.add(friday);
		JLabel saturday = new JLabel("      Sat");
		dayPanel.add(saturday);
		//These are just to make it look neater
		JLabel test1 = new JLabel("");
		dayPanel.add(test1);
		JLabel test2 = new JLabel("");
		dayPanel.add(test2);
		JLabel test3 = new JLabel("");
		dayPanel.add(test3);
		JLabel test4 = new JLabel("");
		dayPanel.add(test4);
		JLabel test5 = new JLabel("");
		dayPanel.add(test5);
		JLabel test6 = new JLabel("");
		dayPanel.add(test6);
		//and yes I manually made 30 buttons..
		JButton button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 1;		
				updateScreen();
			}
		});
		
		dayPanel.add(button1);
		
		JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 2;		
				updateScreen();
			}
		});
		dayPanel.add(button2);
		
		JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 3;		
				updateScreen();
			}
		});
		
		dayPanel.add(button3);
		
		JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 4;		
				updateScreen();
			}
		});
		
		dayPanel.add(button4);
		
		
		JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 5;		
				updateScreen();
			}
		});
		
		dayPanel.add(button5);
		
		JButton button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 6;		
				updateScreen();
			}
		});
		
		dayPanel.add(button6);
		
		JButton button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 7;		
				updateScreen();
			}
		});
		
		dayPanel.add(button7);
		
		JButton button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 8;		
				updateScreen();
			}
		});
		
		dayPanel.add(button8);
		
		JButton button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 9;		
				updateScreen();
			}
		});
		
		dayPanel.add(button9);
		
		JButton button10 = new JButton("10");
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 10;		
				updateScreen();
			}
		});
		
		dayPanel.add(button10);
		
		JButton button11 = new JButton("11");
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 11;		
				updateScreen();
			}
		});
		
		dayPanel.add(button11);
		
		JButton button12 = new JButton("12");
		button12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 12;		
				updateScreen();
			}
		});
		
		dayPanel.add(button12);
		
		JButton button13 = new JButton("13");
		button13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 13;		
				updateScreen();
			}
		});
		
		dayPanel.add(button13);
		
		JButton button14 = new JButton("14");
		button14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 14;		
				updateScreen();
			}
		});
		
		dayPanel.add(button14);
		
		JButton button15 = new JButton("15");
		button15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 15;		
				updateScreen();
			}
		});
		
		dayPanel.add(button15);
		
		JButton button16 = new JButton("16");
		button16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 16;		
				updateScreen();
			}
		});
		
		dayPanel.add(button16);
		
		JButton button17 = new JButton("17");
		button17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 17;		
				updateScreen();
			}
		});
		
		dayPanel.add(button17);
		
		JButton button18 = new JButton("18");
		button18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 18;		
				updateScreen();
			}
		});
		
		dayPanel.add(button18);
		
		JButton button19 = new JButton("19");
		button19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 19;		
				updateScreen();
			}
		});
		
		dayPanel.add(button19);
		
		JButton button20 = new JButton("20");
		button20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 20;		
				updateScreen();
			}
		});
		
		dayPanel.add(button20);
		
		JButton button21 = new JButton("21");
		button21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 21;		
				updateScreen();
			}
		});
		
		dayPanel.add(button21);
		
		JButton button22 = new JButton("22");
		button22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 22;		
				updateScreen();
			}
		});
		
		dayPanel.add(button22);
		
		JButton button23 = new JButton("23");
		button23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 23;		
				updateScreen();
			}
		});
		
		dayPanel.add(button23);
		
		JButton button24 = new JButton("24");
		button24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 24;		
				updateScreen();
			}
		});		
		
		dayPanel.add(button24);
		
		JButton button25 = new JButton("25");
		button25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 25;		
				updateScreen();
			}
		});
		
		dayPanel.add(button25);
		
		JButton button26 = new JButton("26");
		button26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 26;		
				updateScreen();
			}
		});
		
		dayPanel.add(button26);
		
		JButton button27 = new JButton("27");
		button27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 27;		
				updateScreen();
			}
		});
		
		dayPanel.add(button27);
		
		JButton button28 = new JButton("28");
		button28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 28;		
				updateScreen();
			}
		});
		
		dayPanel.add(button28);
		
		JButton button29 = new JButton("29");
		button29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 29;		
				updateScreen();
			}
		});
		
		dayPanel.add(button29);
		
		JButton button30 = new JButton("30");
		button30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = 30;	
				updateScreen();
			}
		});
		
		dayPanel.add(button30);
		
		//add to main panel
		panel.add(dayPanel);
		return panel;
	}

	
	public JPanel createContactPanel(){
		//Creates the contact info box
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Contact"));
		
		//Makes a grid layout within the contact box
		//Add labels
		JPanel lastFirstLabel = new JPanel();
		lastFirstLabel.setLayout(new GridLayout(1, 2));
		
		JLabel lastnameLabel = new JLabel("Last Name");
		lastFirstLabel.add(lastnameLabel);
		
		JLabel firstnameLabel = new JLabel("First Name");
		lastFirstLabel.add(firstnameLabel);
		
		//adds a jpanel within the panel
		JPanel lastFirstText = new JPanel();
		lastFirstText.setLayout(new GridLayout(1, 2));
		
		lastnameText = new JTextField();
		lastFirstText.add(lastnameText);
		
		firstnameText = new JTextField();
		lastFirstText.add(firstnameText);
		
		
		
		//another jpanel because I found it easier to make a big panel and multiple
		//sub panels
		JPanel teleEmailLabel = new JPanel();
		teleEmailLabel.setLayout(new GridLayout(1, 2));
		JPanel teleEmailText = new JPanel();
		teleEmailText.setLayout(new GridLayout(1, 2));
		
		
		JLabel telephoneLabel = new JLabel("Telephone");
		teleEmailLabel.add(telephoneLabel);
		
		
		telephoneText = new JTextField();
		telephoneText.setPreferredSize(new Dimension(50, 25));
		teleEmailText.add(telephoneText);
		
		
		JLabel emailLabel = new JLabel("Email");
		teleEmailLabel.add(emailLabel);
		
		
		emailText = new JTextField();
		emailText.setPreferredSize(new Dimension(50, 25));
		teleEmailText.add(emailText);
		
		JLabel addressLabel = new JLabel("Address");
		addressText = new JTextField();;
		
		JPanel buttonPanel = new JPanel();
		JButton find = new JButton("Find");
		
		Contacts contact = new Contacts();
		//Check if file is in the right area or it exists
		try {
			contact.readContactsFile();
		} catch (Exception e) {
			descField.setText("Error: Unable to read contacts file.");
		}
		
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//button to find a contact
				
				for(int i = 0;i < contact.persons.size();i++) {
					//if the email entered matches a contact email
					if(emailText.getText().compareTo(contact.persons.get(i).getemail()) == 0) {
						addressText.setText(contact.persons.get(i).getaddress());
						lastnameText.setText(contact.persons.get(i).getlastName());
						firstnameText.setText(contact.persons.get(i).getfirstName());
						telephoneText.setText(contact.persons.get(i).gettelephone());
					} //else if the telephone text entered matches a contact's telephone
					else if(telephoneText.getText().compareTo(contact.persons.get(i).gettelephone()) == 0) {
						addressText.setText(contact.persons.get(i).getaddress());
						lastnameText.setText(contact.persons.get(i).getlastName());
						firstnameText.setText(contact.persons.get(i).getfirstName());
						emailText.setText(contact.persons.get(i).getemail());
					}//if the last name entered and first name entered display the contact with that name 
					else if(lastnameText.getText().compareTo(contact.persons.get(i).getlastName()) == 0 && firstnameText.getText().compareTo(contact.persons.get(i).getfirstName()) == 0) {
						addressText.setText(contact.persons.get(i).getaddress());
						telephoneText.setText(contact.persons.get(i).gettelephone());
						emailText.setText(contact.persons.get(i).getemail());
					}
				}
				

			}
		});
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			//just clears the text fields 
			public void actionPerformed(ActionEvent e) {
				lastnameText.setText("");
				firstnameText.setText("");
				telephoneText.setText("");
				emailText.setText("");
				addressText.setText("");		
				updateScreen();
			}
		});
		
		
		buttonPanel.add(find);
		buttonPanel.add(clear);
		
		panel.setLayout(new GridLayout(7, 1));
		panel.add(lastFirstLabel);
		panel.add(lastFirstText);
		panel.add(teleEmailLabel);
		panel.add(teleEmailText);
		panel.add(addressLabel);
		panel.add(addressText);
		panel.add(buttonPanel);
		
		return panel;
	}
	
	
	
	
	
	
	public JPanel createDatePanel() {
		//Method for creating the date panel
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Date"));

		
		JPanel prevNextPanel = new JPanel();
		prevNextPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 2, 0, 2);
		
		//prevNextPanel.setMaximumSize(new Dimension(50, 50));
		//prevNextPanel.setPreferredSize(new Dimension(50, 50));
		//Creates button for going to the previous day
		JButton prevDay = new JButton("<");
		prevDay.setPreferredSize(new Dimension(550, 50));
		prevNextPanel.add(prevDay, constraints);
	
		prevDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Makes current day yesterday's date
				currentDay = currentDay-1;
				//This method updates the appointments on screen
				updateScreen();
			}
		});
		//Creates the button to go to the next day
		JButton nextDay = new JButton(">");
		nextDay.setPreferredSize(new Dimension(550, 50));
		constraints.gridx = 1;
		
		prevNextPanel.add(nextDay, constraints);
		nextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDay = currentDay+1;
				updateScreen();
			}
		});

		//Creates 3 sub panels to put in the grid layout for day month and year
		JPanel DMYPanel = new JPanel();
		//Creates the day label
		JLabel dayLabel = new JLabel("Day");
		JTextField day = new JTextField();
		day.setPreferredSize(new Dimension(25, 20));

		JLabel monthLabel = new JLabel("Month");
		JTextField month = new JTextField();
		month.setPreferredSize(new Dimension(25, 20));

		JLabel yearLabel = new JLabel("Year");
		JTextField year = new JTextField();
		year.setPreferredSize(new Dimension(50, 20));
		//add each component to the JFrame
		DMYPanel.add(dayLabel);
		DMYPanel.add(day);
		DMYPanel.add(monthLabel);
		DMYPanel.add(month);
		DMYPanel.add(yearLabel);
		DMYPanel.add(year);

		// Show Panel to show the desired appointments for entered date
		JPanel showPanel = new JPanel();
		JButton show = new JButton("Show");
		showPanel.add(show);
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//When button is clicked, it will parse the information entered and store in variables.
				
				
				
				if(day.getText().length() != 0) {
					
					if(month.getText().length() != 0) {
						
						int monthInt = Integer.parseInt(month.getText());
						
						if(monthInt > 0 && monthInt < 13) {
							if(monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 || monthInt == 8 || monthInt == 10 || monthInt == 12) {
								if(Integer.parseInt(day.getText()) > 0 && Integer.parseInt(day.getText()) < 32) {
									currentDay = Integer.parseInt(day.getText());
					
								} else {
									descField.setText("Please input a valid value for day.");
								}
							} else if(monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11){
								if(Integer.parseInt(day.getText()) > 0 && Integer.parseInt(day.getText()) < 31) {
									currentDay = Integer.parseInt(day.getText());

								} else {
									descField.setText("Please input a valid value for day.");
								}
							} else {
								if(year.getText().length() != 0) {
									if(Integer.parseInt(year.getText()) % 4 == 0) {
										if(Integer.parseInt(day.getText()) > 0 && Integer.parseInt(day.getText()) < 30) {
											currentDay = Integer.parseInt(day.getText());
										} else {
											descField.setText("Please input a valid value for day.");
										}
									} else {
										if(Integer.parseInt(day.getText()) > 0 && Integer.parseInt(day.getText()) < 29) {
											currentDay = Integer.parseInt(day.getText());;
										}
									}
								} else {
									descField.setText("Please input a valid value for year.");
								}
							}
						} else {
							descField.setText("Please input a valid value for month.");
						}
					} else {
						descField.setText("Please input a valid value for month.");
					}
				} else {
					descField.setText("Please input a valid value for day.");
				}
				
				if(month.getText().length() != 0) {
					if(Integer.parseInt(month.getText()) > 0 && Integer.parseInt(month.getText()) < 13) {
						currentMonth = Integer.parseInt(month.getText())-1;
					}
				} else {
					descField.setText("Please input a valid value for month.");
				}
				
				if(year.getText().length() != 0) {
					if(Integer.parseInt(year.getText()) > 1900) {
						currentYear = Integer.parseInt(year.getText());
					} else {
						descField.setText("You probably didn't have any appointments this early!");
					}
				} else {
					descField.setText("Please input a valid value for year.");
				}
				
				
				
				
				
				
				updateScreen();
			}
		});
		//add to the frame
		panel.add(prevNextPanel);
		panel.add(DMYPanel);
		panel.add(showPanel);
		panel.setLayout(new GridLayout(3, 1));

		return panel;
	}
	
	public JPanel createActionPanel() {
		//Creates the "action" panel
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Appointment"));
		//Creates 3 sub panels
		JPanel hourMinPanel = new JPanel();
		JLabel hourLabel = new JLabel("Hour");
		//text field for hours
		JTextField hours = new JTextField();
		hours.setPreferredSize(new Dimension(50, 20));
		
		JLabel minLabel = new JLabel("Minute");
		//create the text field for minutes
		JTextField minutes = new JTextField();
		minutes.setPreferredSize(new Dimension(50, 20));
		//add to frame
		hourMinPanel.add(hourLabel);
		hourMinPanel.add(hours);
		hourMinPanel.add(minLabel);
		hourMinPanel.add(minutes);

		JPanel createCancelPanel = new JPanel();
		//create the cancel button
		JButton create = new JButton("CREATE");
		JButton cancel = new JButton("CANCEL");
		JButton recall = new JButton("RECALL");

		createCancelPanel.add(create);
		createCancelPanel.add(cancel);
		createCancelPanel.add(recall);

		
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//What happens when create is clicked
				//Store entered descrtipion in variable
				descriptionParsed = descField.getText();
				//If the minutes field is empty, assume 0, otherwise parses whatever is entered
				if(minutes.getText().isEmpty() == true) {
					minuteParsed = 00;
				} else {
					
					if(Integer.parseInt(minutes.getText()) > 0 && Integer.parseInt(minutes.getText()) < 60) {
						minuteParsed = Integer.parseInt(minutes.getText());
					} else {
						descField.setText("Please enter in a valid value for minutes.");
					}
				}
				
				if(hours.getText().isEmpty() == true) {
					descField.setText("Please enter in a valid value for hours.");
				} else {
					
					if(Integer.parseInt(hours.getText()) > 0 && Integer.parseInt(hours.getText()) < 25) {
						hourParsed = Integer.parseInt(hours.getText());
					} else {
						descField.setText("Please enter in a valid value for hours.");
					}
				}
			
				
				Contacts contact = new Contacts();
				try {
					contact.readContactsFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 0;i < contact.persons.size();i++) {
					if(emailText.getText().equals(contact.persons.get(i).getemail()) || telephoneText.getText().equals(contact.persons.get(i).gettelephone())) {
						person = contact.persons.get(i);
						break;
					} else {
						person = new Person("", "", "", "", "");
					}
				}
				
				
			
				
				//Creates a new Appointment object with the current information entered
				Appointment Today = new Appointment(currentYear, currentMonth, currentDay, hourParsed, minuteParsed, descriptionParsed, person);
		
				//Copy of current appointment without description
				gCal = new GregorianCalendar(currentYear, currentMonth, currentDay, hourParsed, minuteParsed);
				//check if exists
				boolean exists = false;
				//if size is 0, add the appointment to the appointments list, then update the screen
				if (appointments.size() == 0) {
				appointments.add(Today);
				appointmentstack.push(Today);
					updateScreen();
				} else {
					for (int i = 0; i < appointments.size(); i++) {
						//Makes a second calender that gets the info from whatever place in the array it's at
						gCal2 = new GregorianCalendar(appointments.get(i).getDate().get(Calendar.YEAR),
								appointments.get(i).getDate().get(Calendar.MONTH),
								appointments.get(i).getDate().get(Calendar.DAY_OF_MONTH),
								appointments.get(i).getDate().get(Calendar.HOUR_OF_DAY),
								appointments.get(i).getDate().get(Calendar.MINUTE));
						//if the current appointment's date is the same as another, send a conflict message in the desc box
						if (gCal.equals(gCal2)) {
							descField.setText("CONFLICT!!");
							//change to now exists
							exists = true;
						}
					}
					//if it doesn't exist already, then add the appointment normally, sort the array, and update the screen again
					if (exists == false) {
						appointments.add(Today);
						appointmentstack.push(Today);
						Collections.sort(appointments);
						updateScreen();
					}
					
				}

			}
		});
		
		cancel.addActionListener(new ActionListener() {
			//When cancel button is clicked;
			public void actionPerformed(ActionEvent e) {
				//
				if(minutes.getText().isEmpty() == true) {
					minuteParsed = 00;
				} else {
					minuteParsed = Integer.parseInt(minutes.getText());
				}
				hourParsed = Integer.parseInt(hours.getText());
				//gets current date info
				gCal = new GregorianCalendar(currentYear, currentMonth, currentDay, hourParsed, minuteParsed);
				
				for (int i = 0; i < appointments.size(); i++) {
					//gets date from appointment
					gCal2 = new GregorianCalendar(appointments.get(i).getDate().get(Calendar.YEAR),
							appointments.get(i).getDate().get(Calendar.MONTH),
							appointments.get(i).getDate().get(Calendar.DAY_OF_MONTH),
							appointments.get(i).getDate().get(Calendar.HOUR_OF_DAY),
							appointments.get(i).getDate().get(Calendar.MINUTE));
					//If it exists, removes it (opposite of create method)
					if (gCal.equals(gCal2)) {
						appointments.remove(i);
						appointmentstack.pop();
						updateScreen();
					}
				}
			}
		});
		
		recall.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	
   
                currentDay = appointmentstack.peek().getDate().get(Calendar.DATE);
                currentMonth = appointmentstack.peek().getDate().get(Calendar.MONTH);
                currentYear = appointmentstack.peek().getDate().get(Calendar.YEAR);
                currentHour = appointmentstack.peek().getDate().get(Calendar.HOUR);
                currentMinute = appointmentstack.peek().getDate().get(Calendar.MINUTE);
                
                hours.setText(Integer.toString(appointmentstack.peek().getDate().get(Calendar.HOUR)));
                minutes.setText(Integer.toString(appointmentstack.peek().getDate().get(Calendar.MINUTE)));
                updateScreen();

            }
        });
		
		//add to frame
		panel.add(hourMinPanel);
		panel.add(createCancelPanel);
		panel.setLayout(new GridLayout(2, 1));
		return panel;
	}
	//Creates the panel for the description
	public JPanel createDescPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Description"));
		//create area to write description
		descField = new JTextField();
		descField.setPreferredSize(new Dimension(300, 100));
		//add to frame
		panel.add(descField);
		return panel;
	}
	//Method for updating the screen, it's called whenever the appointments on screen are changed, or the day changes
	public void updateScreen() {
		textTop.setText("");
		//sort appointments
		Collections.sort(appointments);
		//cycle through all appointments, check if the appointment's date is the same as the date you're currently on, if so screen is updated
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getDate().get(Calendar.YEAR) == currentYear
					&& appointments.get(i).getDate().get(Calendar.MONTH) == currentMonth
					&& appointments.get(i).getDate().get(Calendar.DAY_OF_MONTH) == currentDay) {
				
				textTop.setText(textTop.getText() + "\n" + appointments.get(i).stringTime());
				
			}
		}
		mainDate = new GregorianCalendar(currentYear, currentMonth, currentDay, currentHour, currentMinute);
		labelN.setText(sdf.format(mainDate.getTime()));
		

	}

}