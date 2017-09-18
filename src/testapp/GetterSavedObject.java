/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author foltynp
 */
public class GetterSavedObject {
	private static UserInfo objectFromFile;
	private static void getUserData() throws ClassNotFoundException{
		try{
			UserInfo object;
			//utwórz ścierzkę do pliku
			File plik = new File("data/userData.dat");
			//otwacie strumienia odczytu
			FileInputStream fInStream = new FileInputStream(plik);
			ObjectInputStream oInStream = new ObjectInputStream(fInStream);
			object = (UserInfo) oInStream.readObject();
			objectFromFile = object;
		}
		catch(IOException ex){
			JOptionPane.showMessageDialog(null,"Błąd odczytu danych " +ex, "Błąd odczytu", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static UserInfo getUserObject() throws ClassNotFoundException{
			getUserData();
		return objectFromFile;
	}
}
