package control;

import view.GUI;

public class Listener implements ActionListener {

    private GUI theGui;
    private JK8055 jk8055;
    public static int DEVICE = 0;

    public Listener(GUI myGui) {
	this.theGui = myGui;
	this.jk8055 = jk8055.getInstance();
    }

    public void actionPerformed(ActionEvent e) 
    { 
	if(e.getSource() == theGui.getMenuItemConnexion())
	    { 
		JTextArea jta = theGui.getJtaScenario();
		try
		    { jk8055.OpenDevice( DEVICE ); }
		catch(Exception exOpen){} 
		jta.setText(jta.getText() +"\n Connecte");

	    }

	else if (e.getSource() == theGui.getMenuItemDeconnexion())
	    { 
		JTextArea jta = theGui.getJtaScenario();
		try{ jk8055.CloseDevice(); }
		catch(Exception exClose){} 
		jta.setText(jta.getText() +"\n Deconnecte"); 
	    }

	else if (e.getSource() == theGui.getBtSetDig())
	    { 
		JTextArea jta = theGui.getJtaScenario();
		jta.setText(jta.getText() +"\n SetDigital Effectue");
	    }

	else if (e.getSource() == theGui.getBtClearDig())
	    { 
		JTextArea jta = theGui.getJtaScenario();
		jta.setText(jta.getText() +"\n ClearDigital Effectue"); 
	    }

	else if (e.getSource() == theGui.getBtSetAn())
	    { 
		JTextArea jta = theGui.getJtaScenario();
		jta.setText(jta.getText() +"\n SetAllAnalogique Effectue"); 
	    }

	else if (e.getSource() == theGui.getBtClearAn())
	    { 
		JTextArea jta = theGui.getJtaScenario();
		jta.setText(jta.getText() +"\n ClearAnalogiqueEffectue"); 
	    } 
    }
    

}