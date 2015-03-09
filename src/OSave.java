import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class OSave {
	public static void main(String[] args) throws IOException {
		
		String bel = "Beltegeuse" ;
		String pseudo = "Doudix" ;
		String mdp = "vtff" ;
		
		
		newOsave(bel,pseudo,mdp);
		OSave.getOsave().createFile();
		OSave.getOsave().writeInfo();
		OSave.getOsave().writeConstruction();
		OSave.getOsave().writeResearch();
		OSave.getOsave().writeVaisseaux();
		OSave.getOsave().writeDefense();
	}
		
	private static OSave oSaveInstance=null;
	
	String pseudo;
	String email;
	String mdp;
	String univers;
	PrintWriter writer;
	
	/**
	 * The constructor of the class.
	 * @param univers : The univers of the account
	 * @param pseudo : The player's pseudo
	 * @param mdp : The players password
	 * @throws IOException 
	 */
	private OSave(String univers, String pseudo, String mdp) throws IOException{
		this.univers=univers;
		this.pseudo=pseudo;
		this.mdp=mdp;
		email = "";
		writer = null;
	}
	
	/**
	 * This function create the only one object of the class.
	 * @param univers
	 * @param pseudo
	 * @param mdp
	 * @throws IOException 
	 */
	public static void newOsave(String uni, String pse, String mdp) throws IOException{
		if(oSaveInstance==null)
			oSaveInstance = new OSave(uni, pse, mdp);
	}
	
	/**
	 * This function return the object of the OSave class.
	 * @return oSaveInstance
	 */
	public static OSave getOsave(){
		return oSaveInstance;
	}
	
	/**
	 * This function return the player's universe
	 * @return
	 */
	public String getUnivers(){
		return univers;
	}
	
	
	/**
	 * This function return the player's pseudo
	 * @return
	 */
	public String getPseudo(){
		return pseudo;
	}
	
	/**
	 * This function return the player's password
	 * @return
	 */
	public String getMdp(){
		return mdp;
	}
	
	/**
	 * This function initialize the player's email
	 * @param mail
	 * @return
	 */
	public void setEmail(String mail){
		email = mail;
	}
	
	/**
	 * This function return the player's mail
	 * @return
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 *This function will create the file containing
	 * informations about the account
	 */
	public void createFile() throws IOException{	
		/*File f = new File("info.bat");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(f,"UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {e.printStackTrace();} */
		writer = new PrintWriter(new File("info.bat"), "UTF-8");
		writer.close();
	}
	
	public void writeInfo(){
		try
		{
		    String filename= "info.bat";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("login: " + "\n");
		    fw.write("	Universe: " + univers + "\n");
		    fw.write("	Pseudo: " + pseudo + "\n");
		    fw.write("	Password: " + mdp + "\n");			//Need fonction de cryptage
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}	
	}
	
	public void writeConstruction(){
		try
		{
		    String filename= "info.bat";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n");
		    fw.write("Batiments: " + "\n");
		    fw.write("	Ressources" + "\n");
		    fw.write("		Mine de m�tal: " + "\n");	//Need info sur mines
		    fw.write("		Mine de cristal: " + "\n");
		    fw.write("		Synth�tiseur de deut�rieum: " + "\n");
		    fw.write("		Centrale �lectrique solaire: " + "\n");
		    fw.write("		Centrale �lectrique de fusion: " + "\n");
		    fw.write("		Satellite solaire: " + "\n");
		    fw.write("	Installations: " + "\n");
		    fw.write("		Usine de robots: " + "\n");
		    fw.write("		Chantier spatial: " + "\n");
		    fw.write("		Laboratoire de recherche: " + "\n");
		    fw.write("		D�p�t de ravitaillement: " + "\n");
		    fw.write("		Silo de missiles: " + "\n");
		    fw.write("		Usine de nanites: " + "\n");
		    fw.write("		Terraformeur: " + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}	
	}
	
	public void writeResearch(){
		try
		{
		    String filename= "info.bat";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n");
			fw.write("Recherche:" + "\n");
			fw.write("	Recherche fondamentale:" + "\n");
			fw.write("		Technologie �nerg�tique: " + "\n");
			fw.write("		Technologie Laser: " + "\n");
			fw.write("		Technologie � ions: " + "\n");
			fw.write("		Technologie hyperespace: " + "\n");
			fw.write("		Technologie Plasma: " + "\n");
			fw.write("	Recherche en propulsion:" + "\n");
			fw.write("		R�acteur � combustion: " + "\n");
			fw.write("		R�acteur � impulsion: " + "\n");
			fw.write("		Propulsion hyperespace: " + "\n");
			fw.write("	Recherche avanc�e" + "\n");
			fw.write("		Technologie Espionnage: " + "\n");
			fw.write("		Technologie Ordinateur: " + "\n");
			fw.write("		Astrophysique: " + "\n");
			fw.write("		R�seau de recherche intergalactique: " + "\n");
			fw.write("		Technologie Graviton: " + "\n");
			fw.write("	Recherche de combat: " + "\n");
			fw.write("		Technologie Armes: " + "\n");
			fw.write("		Technologie Bouclier: " + "\n");
			fw.write("		Technologie Protection des vaisseauw spatiaux: " + "\n");
			fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}	
		
	}
	
	public void writeVaisseaux(){
		try
		{
		    String filename= "info.bat";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n");
		    fw.write("Chantier spatial: " + "\n");
		    fw.write("	Vaisseaux civils:" + "\n");
		    fw.write("		Petit transporteur: " + "\n");	//Need info sur mines
		    fw.write("		Grand transporteur: " + "\n");
		    fw.write("		Vaisseau de colonisation: " + "\n");
		    fw.write("		Recycleur: " + "\n");
		    fw.write("		Sonde d'espionnage: " + "\n");
		    fw.write("	Vaisseaux de combat: " + "\n");
		    fw.write("		Chasseur l�ger: " + "\n");
		    fw.write("		Chasseur lourd: " + "\n");
		    fw.write("		Croiseur: " + "\n");
		    fw.write("		Vaisseau de bataille: " + "\n");
		    fw.write("		Traqueur: " + "\n");
		    fw.write("		Bombardier: " + "\n");
		    fw.write("		Destructeur: " + "\n");
		    fw.write("		ETOILE DE LA MORT: " + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}	
	}
	
	public void writeDefense(){
		try
		{
		    String filename= "info.bat";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n");
		    fw.write("D�fense: " + "\n");
		    fw.write("		Lanceur de missiles: " + "\n");
		    fw.write("		Artillerie laser l�g�re: " + "\n");
		    fw.write("		Artillerie laser lourde: " + "\n");
		    fw.write("		Canon de Gauss: " + "\n");
		    fw.write("		Artillerie � ions: " + "\n");
		    fw.write("		Lanceur de plasma: " + "\n");
		    fw.write("		Petit bouclier: " + "\n");
		    fw.write("		Grand bouclier: " + "\n");
		    fw.write("		Missile d'interception: " + "\n");
		    fw.write("		Missile interplan�taire: " + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}	
	}
}
