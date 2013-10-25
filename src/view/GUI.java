package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import java.awt.event.*;

import net.sf.libk8055.jk8055.*;





//Control
import control.Listener;

public class GUI extends JFrame {


    /*---------------------------------------------------------- */
    /*------------------------ATTRIBUT ------------------------- */
    /*---------------------------------------------------------- */

    private JMenuBar menuBar;
    private JMenu menuFichier;
    private JMenu menuAide;
    private JMenuItem menuItemAide;
    private JMenuItem menuItemAPropos;
    private JPanel mainPanel;
    private JMenuItem menuItemConnexion;
    private JMenuItem menuItemDeconnexion;
    private JTextArea jtaScenario;
    private JPanel panelBot;
    private JPanel panelInOut;
    private JPanel panelBtn;
    private JPanel panelScroll;
    private JPanel panelIn;
    private JPanel panelOut;
    private JCheckBox cBox1;
    private JCheckBox cBox3;
    private JCheckBox cBox4;
    private JCheckBox cBox2;
    private JCheckBox cBox5;
    private JCheckBox cBox6;
    private JCheckBox cBox7;
    private JCheckBox cBox8;
    private JCheckBox cBox9;
    private JCheckBox cBox11;
    private JCheckBox cBox12;
    private JCheckBox cBox10;
    private JCheckBox cBox13;
    private JButton btSetDig;
    private JButton btClearDig;
    private JButton btSetAn;
    private JButton btClearAn;
    private JPanel panelDA1;
    private JPanel panelDA2;
    private JPanel panelAD1;
    private JPanel panelAD2;
    private JSlider sliderDA1;
    private JSlider sliderDA2;
    private JSlider sliderAD1;
    private JSlider sliderAD2;

    Thread1 th1;
    Thread2 th2;



    /*-------------------------------------------------------------- */
    /*------------------------CONSTRUCTEUR ------------------------- */
    /*-------------------------------------------------------------- */
    /** Constructeur de la classe Ihm */
    public GUI(){
	this.createInterface(); //Init the interface
	this.linkReactions(); //Bound the reactions
	
	this.setSize(900,1000); // Taille de la fenetre
	this.setVisible(true); // Rend la fenetre visible
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    /*---------------------------------------------------------- */
    /*------------------------ METHODS ------------------------ */
    /*---------------------------------------------------------- */
    /** Methode qui cree l'interface graphique de l'application */
    private void createInterface(){
	
    	/* ############# LA FENETRE COURANTE ############# */
	this.setLayout(new BorderLayout(20, 20));
		
	GridBagConstraints c = new GridBagConstraints();
		
	mainPanel = new JPanel(new GridBagLayout());
		
	/* ############# MENU ############# */
	menuBar = new JMenuBar();
	menuBar.setBorderPainted(false);
	menuFichier = new JMenu("Fichier");
	menuAide = new JMenu("Aide");
		
	menuItemConnexion = new JMenuItem("Connexion");
	menuItemDeconnexion = new JMenuItem("Deconnexion");
	menuItemAide = new JMenuItem("?");
	menuItemAPropos = new JMenuItem("A Propos");
		
		
	/* ############# PanelInOut ############# */
	panelInOut = new JPanel(new GridLayout(2,1));
	panelInOut.setPreferredSize(new Dimension(250,150));
		
	panelIn = new JPanel();
	TitledBorder titleIn = BorderFactory.createTitledBorder("Entrees");
	panelIn.setBorder(titleIn);
		
	panelOut = new JPanel();
		
	TitledBorder titleOut = BorderFactory.createTitledBorder("Sorties");
	panelOut.setBorder(titleOut);
		
	cBox1 = new JCheckBox();
	cBox2 = new JCheckBox();
	cBox3 = new JCheckBox();
	cBox4 = new JCheckBox();
	cBox5 = new JCheckBox();
	cBox6 = new JCheckBox();
	cBox7 = new JCheckBox();
	cBox8 = new JCheckBox();
	cBox9 = new JCheckBox();
	cBox10 = new JCheckBox();
	cBox11 = new JCheckBox();
	cBox12 = new JCheckBox();
	cBox13 = new JCheckBox();


		
	/* ############# PANELBTN ############# */
	panelBtn = new JPanel(new GridLayout(4,1,5,5));
	panelBtn.setPreferredSize(new Dimension(250,80));
		
	btSetDig = new JButton("SetAll Digital");
	btSetDig.setPreferredSize(new Dimension(100,50));
	btClearDig = new JButton("ClearAll Digital");
	btClearDig.setPreferredSize(new Dimension(100,50));
	btSetAn = new JButton("SetAll Analogique");
	btSetAn.setPreferredSize(new Dimension(100,50));
	btClearAn = new JButton("ClearAll Analogique");
	btClearAn.setPreferredSize(new Dimension(100,50));
		
		
	/* ############# PANELSCROLL ############# */
	panelScroll= new JPanel(new GridLayout(1,4));
		
	panelDA1 = new JPanel();
	//panelDA1.setPreferredSize(new Dimension(300,900));
	TitledBorder titleda1 = BorderFactory.createTitledBorder("DA1");
	panelDA1.setBorder(titleda1);
	sliderDA1 = new JSlider(JSlider.VERTICAL,0,1,0);
		
	panelDA2 = new JPanel();
	TitledBorder titleda2 = BorderFactory.createTitledBorder("DA2");
	panelDA2.setBorder(titleda2);
	sliderDA2 = new JSlider(JSlider.VERTICAL,0,1,0);
		
	panelAD1 = new JPanel();
	TitledBorder titlead1 = BorderFactory.createTitledBorder("AD1");
	panelAD1.setBorder(titlead1);
	sliderAD1 = new JSlider(JSlider.VERTICAL,0,1,0);
		
	panelAD2 = new JPanel();
	TitledBorder titlead2 = BorderFactory.createTitledBorder("AD2");
	panelAD2.setBorder(titlead2);
	sliderAD2 = new JSlider(JSlider.VERTICAL,0,1,0);
		
		
	/* ############# PANELBOT ############# */
	panelBot = new JPanel(new GridLayout(1,1));
	TitledBorder titleSc = BorderFactory.createTitledBorder("Scenario");
	panelBot.setBorder(titleSc);
		
		
	jtaScenario = new JTextArea();
	jtaScenario.setPreferredSize(new Dimension(240,280));
	jtaScenario.setEditable(false);
	jtaScenario.setBackground(Color.BLACK);
	jtaScenario.setForeground(Color.GREEN);

		
		
		
	/* ############# ADD ############# */
	this.setJMenuBar(menuBar);
	this.add(mainPanel);
		
	//Menu
	menuBar.add(menuFichier);
	menuBar.add(menuAide);
	menuFichier.add(menuItemConnexion);
	menuFichier.add(menuItemDeconnexion);
	menuAide.add(menuItemAide);
	menuAide.add(menuItemAPropos);
		
	//mainpanel
	c.gridx = 0; 
	c.gridy = 0;
	c.weightx = 0.5;
	c.fill = GridBagConstraints.HORIZONTAL;
	c.anchor = GridBagConstraints.FIRST_LINE_START;
	mainPanel.add(panelInOut,c);
	c.gridx = 0; 
	c.gridy = 1;
	c.weightx = 1.5;
	c.weighty = 2;
	c.insets = new Insets(0,0,0,0);
	mainPanel.add(panelBtn, c);
	c.gridx = 1; 
	c.gridy = 0;
	c.weightx = 2;
	c.weighty = 2;
	c.gridheight = 2;
	c.gridwidth = 1;
	mainPanel.add(panelScroll,c);
	c.gridx = 0; 
	c.gridy = 2;
	c.weightx = 3;
	c.weighty = 3;
	c.gridwidth = 2;
	mainPanel.add(panelBot, c);
		
		
	//PanelInOut
	panelInOut.add(panelIn);
	panelInOut.add(panelOut);
		
	//panelIn
	panelIn.add(cBox1);
	panelIn.add(cBox2);
	panelIn.add(cBox3);
	panelIn.add(cBox4);
	panelIn.add(cBox5);
		
	//panelOut
	panelOut.add(cBox6);
	panelOut.add(cBox7);
	panelOut.add(cBox8);
	panelOut.add(cBox9);
	panelOut.add(cBox10);
	panelOut.add(cBox11);
	panelOut.add(cBox12);
	panelOut.add(cBox13);
		
	//panelBtn
	panelBtn.add(btSetDig);
	panelBtn.add(btClearDig);
	panelBtn.add(btSetAn);
	panelBtn.add(btClearAn);
		
	//panelScroll
	panelScroll.add(panelAD1);
	panelScroll.add(panelAD2);
	panelScroll.add(panelDA1);
	panelScroll.add(panelDA2);
		
	panelAD1.add(sliderAD1);
	panelAD2.add(sliderAD2);
	panelDA1.add(sliderDA1);
	panelDA2.add(sliderDA2);
		
	//panelbot
	panelBot.add(jtaScenario);


	th1.start();
	th2.start();
    
	
    }

    
    /** Methode qui gere les reactions de l'application */
    private void linkReactions(){    	
	//Concerne le log de connexion ainsi que les "gros" bouttons
    	btSetAn.addActionListener(new Listener(this));
    	btClearAn.addActionListener(new Listener(this));
    	btSetDig.addActionListener(new Listener(this));
    	btClearDig.addActionListener(new Listener(this));

	//Concerne les bouttons connexion/deconnexion
	menuItemConnexion.addActionListener(new Listener(this));
	menuItemDeconnexion.addActionListener(new Listener(this));


	//Concerne les CheckBox d'entree
	cBox1.addActionListener(new Listener(this));
	cBox2.addActionListener(new Listener(this));
	cBox3.addActionListener(new Listener(this));
	cBox4.addActionListener(new Listener(this));
	cBox5.addActionListener(new Listener(this));
	cBox6.addActionListener(new Listener(this));
	cBox7.addActionListener(new Listener(this));
	cBox8.addActionListener(new Listener(this));
	cBox9.addActionListener(new Listener(this));
	cBox10.addActionListener(new Listener(this));
	cBox11.addActionListener(new Listener(this));
	cBox12.addActionListener(new Listener(this));
	cBox13.addActionListener(new Listener(this));

    }
    
    /*------------------------------------------------------------ */
    /*------------------------ ACCESSEUR ------------------------- */
    /*------------------------------------------------------------ */
 	
    
    public JTextArea getJtaScenario() {
	return jtaScenario;
    }
    
    public void setJtaScenario(JTextArea jtaScenario) {
	this.jtaScenario = jtaScenario;
    }

    class Thread1 implements Runnable{
	public void run(){
	    while(true)
		{ 
		    try
			{ 
			    while(jk8055.ReadAllDigital() == 0)
				{
				
				    if(jk8055.ReadAllDigital() == 1)
					setcBox1();
				    if(jk8055.ReadAllDigital() == 2)
					setcBox2(); 
				    if(jk8055.ReadAllDigital() == 4)
					setcBox3(); 
				    if(jk8055.ReadAllDigital() == 8)
					setcBox4(); 
				    if(jk8055.ReadAllDigital() == 16)
					setcBox5(); 
				
				    Thread.sleep(1); 
				} 
			} catch(Exception e){} 
		} 
	}
    } 



    class Thread2 implements Runnable{
    
	public void run(){
	
	    while(true)
		{ 
		    try
			{ 
			    sliderDA1.setValue(jk8055.ReadAnalogChannel(1));
			    sliderDA2.setValue(jk8055.ReadAnalogChannel(2));
			    Thread.sleep(1);
			}
		    catch(Exception e){} 
		}
	}
    }



    public static void main(String[] args) {
	GUI i = new GUI();
    }


}
