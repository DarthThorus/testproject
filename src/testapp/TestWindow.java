/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author foltynp
 */
public class TestWindow extends JFrame implements ActionListener{
	//mf - medical facility
	private JLabel lMfName, lMfMail, lMfAdres, lMfPost, lMfCiti;
	private JTextField txtMfName, txtMfMail, txtMfAdres, txtMfPost, txtMfCiti;
	private JButton saveData, loadData, closeWindow;
	private UserInfo userInfo;
	public TestWindow(){
		setSize(500,800);
		setTitle("Ekran podawania danych");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		lMfName = new JLabel("Nazwa placówki: ",JLabel.RIGHT);
			lMfName.setBounds(5, 5, 200, 20);
			add(lMfName);
		txtMfName = new JTextField();
			txtMfName.setBounds(210, 5, 100,20);
			txtMfName.addActionListener(this);
			txtMfName.setToolTipText("W tym polu należy wpisać nazwę placówki");
			add(txtMfName);
			
		lMfMail = new JLabel("Mail kontaktowy: ",JLabel.RIGHT);
			lMfMail.setBounds(5, 30, 200, 20);
			add(lMfMail);
		txtMfMail = new JTextField();
			txtMfMail.setBounds(210, 30, 100,20);
			txtMfMail.addActionListener(this);
			txtMfMail.setToolTipText("W tym polu należy wpisać mailowy adres kontaktowy");
			add(txtMfMail);
			
		lMfAdres = new JLabel("Adres placówki(Ulica): ",JLabel.RIGHT);
			lMfAdres.setBounds(5, 55, 200, 20);
			add(lMfAdres);
		txtMfAdres = new JTextField();
			txtMfAdres.setBounds(210, 55, 100,20);
			txtMfAdres.addActionListener(this);
			txtMfAdres.setToolTipText("W tym polu należy wpisać ulicę i numer Placówki");
			add(txtMfAdres);
			
		lMfPost = new JLabel("Adres placówki(Kod pocztowy): ",JLabel.RIGHT);
			lMfPost.setBounds(5, 80, 200, 20);
			add(lMfPost);
		txtMfPost = new JTextField();
			txtMfPost.setBounds(210, 80, 100,20);
			txtMfPost.addActionListener(this);
			txtMfPost.setToolTipText("W tym polu należy wpisać kod pocztowy");
			add(txtMfPost);
			
			
		lMfCiti = new JLabel("Adres placówki(Miasto): ",JLabel.RIGHT);
			lMfCiti.setBounds(5, 105, 200, 20);
			add(lMfCiti);
		txtMfCiti = new JTextField();
			txtMfCiti.setBounds(210, 105, 100,20);
			txtMfCiti.addActionListener(this);
			txtMfCiti.setToolTipText("W tym polu należy wpisać miasto");
			add(txtMfCiti);
			
		saveData = new JButton("Zapisz");
			saveData.setBounds(5,130,75,30);
			saveData.addActionListener(this);
			add(saveData);
		loadData = new JButton("Wczytaj");
			loadData.setBounds(85,130,75,30);
			loadData.addActionListener(this);
			add(loadData);
		closeWindow = new JButton("Zamknij");
			closeWindow.setBounds(165,130,75,30);
			closeWindow.addActionListener(this);
			add(closeWindow);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == closeWindow ){
			Object[] options = {"Tak", "Nie"};
			int value = JOptionPane.showOptionDialog(null, "Napewno chcesz zamknąć to okno. Pamiętaj nie zapisane dane zostaną utracone",
					"Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null,options,options[0]
					);
			if (value == 0)
				dispose();
		}
		//save data
		if (source == saveData) {
			//przypisz dane z odpowiednich pól do pól w klasie
			userInfo.mfName = txtMfName.getText();
			userInfo.mfMail = txtMfMail.getText();
			userInfo.mfAdres = txtMfAdres.getText();
			userInfo.mfPost = txtMfPost.getText();
			userInfo.mfCiti = txtMfCiti.getText();
			//zapisz obiekt
			SaveUserData.saveObject(userInfo);
			
		} else if (source == loadData){
			try {
				//wczytaj obiekt
				userInfo = GetterSavedObject.getUserObject();
				//przypisanie pól do odpowiednich pól
				txtMfName.setText(userInfo.mfName);
				txtMfMail.setText(userInfo.mfMail);
				txtMfAdres.setText(userInfo.mfAdres);
				txtMfPost.setText(userInfo.mfPost);
				txtMfCiti.setText(userInfo.mfCiti);
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(TestWindow.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
