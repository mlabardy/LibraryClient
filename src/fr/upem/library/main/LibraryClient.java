package fr.upem.library.main;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;

import fr.upem.library.client.Client;
import fr.upem.library.client.User;
import fr.upem.library.element.Book;
import fr.upem.library.library.LibraryManager;



public class LibraryClient {

	public static void main(String[] args) throws ParseException {
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
			
		try {
			Registry registry = LocateRegistry.getRegistry();
			LibraryManager library = (LibraryManager)registry.lookup("LibraryManager");
			
			library.clear();
			
			Client user = User.create(123, "EUR", "marion", "Dupont", "marion@mlv.fr", "mdupont", library);
			library.addElement(Book.create(BookGenerator.autantEnEmporteLeVent()));
			user.commentElement("ce livre est génial !", BookGenerator.autantEnEmporteLeVent());
			
			System.out.println(library.display());
			
		} catch (RemoteException | NotBoundException e) {
			System.err.println("Trouble " + e);
		}
	
	}
	

}
