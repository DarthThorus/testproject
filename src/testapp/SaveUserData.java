/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author foltynp
 */
public class SaveUserData {
		
		public static void saveObject(UserInfo obj){
			
			try {
				//utwórzmy pseudoPlik
				File plik = new File("data/userData.dat");
				//przygotujmy strumienie
				FileOutputStream fOutStream = new FileOutputStream(plik);
				ObjectOutputStream oOutStream = new ObjectOutputStream(fOutStream);
				//zapis do pliku
				oOutStream.writeObject(obj);
			} catch (IOException ex) {
				JOptionPane.showConfirmDialog(null, "Błąd zapisu "+ ex, "Błąd Zapisu", JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(SaveUserData.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
}
