import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

/**
 * 
 * @author Pc-Francois
 * @version 1.0
 * This class deal with the login event
 *
 */

public class OSession {

	Boolean isLog; // Indicate if the Session is start (user is connected)
	String pseudo;
	String password;
	String universe;
	HtmlPage currentPage;
	
	final WebClient webClient = new WebClient();
	
	/**
	 * The class contructor
	 * @param login : The user login
	 * @param pass : The user password
	 * @param uni : The user universe
	 */
	public OSession(String login,String pass,String uni) {
		pseudo=login;
		password=pass;
		universe=uni;
		isLog=false;
		currentPage=null;
	}
	
	/**
	 * This function will check if the user
	 * is log or not by testing
	 * @return The state of the connection
	 */
	private boolean amILog(){
		
		//OParser op = new OParser();
		
		if(currentPage==null){
			return false;
		}
		
		try {
			currentPage = webClient.getPage("http://" + universe + "/game/index.php?page=overview");
		} catch (FailingHttpStatusCodeException | IOException e) {e.printStackTrace();}
		
		/*
		if(op.isOnLoginPage()){											// Class OParser, add the methode isOnLoginPage()
			
		}
		*/
		return true;
	}
	/**
	 * This method will try to connect the user
	 * to the Ogame main page
	 * @return HtmlPage witch contain the post response of the form
	 */
	public HtmlPage log(){
		
		this.amILog();
		
		if(!isLog){
			try {
				currentPage = webClient.getPage("http://fr.ogame.gameforge.com/");
			} catch (FailingHttpStatusCodeException e) {e.printStackTrace();} 
			  catch (MalformedURLException e) {e.printStackTrace();} 
			  catch (IOException e) {e.printStackTrace();}

		    // Get the form that we are dealing with and within that form, 
		    // find the submit button and the field that we want to change.
		    final HtmlForm form = currentPage.getFormByName("loginForm");
		    final HtmlSubmitInput button = form.getInputByValue("Login");
		    
		    final HtmlSelect univers = form.getSelectByName("uni");
		    final HtmlTextInput login = form.getInputByName("login");
		    final HtmlPasswordInput mdp = form.getInputByName("pass");

		    // Change the value of the text field
		    univers.setDefaultValue(universe);
		    login.setValueAttribute(pseudo);
		    mdp.setValueAttribute(password);

		    // Now submit the form by clicking the button and get back the second page.
			try {
				currentPage = button.click();
			} catch (IOException e) {e.printStackTrace();}
		}
		
		return currentPage;
	}
	
	/**
	 * This method disconect the user
	 */
	public void logOut(){
		
		this.amILog();
		if(isLog){
			try {
				currentPage = webClient.getPage("http://" + universe + "/game/index.php?page=logout");
			} catch (FailingHttpStatusCodeException | IOException e) {e.printStackTrace();}
		}
		isLog=false;
	}
	
	public HtmlPage getOverviewPage(){
		try {
			return webClient.getPage("http://" + universe + "/game/index.php?page=overview");
		} catch (FailingHttpStatusCodeException | IOException e) {e.printStackTrace();}
		
		return null;
	}
	
	public HtmlPage getDefencePage(){
		try {
			return webClient.getPage("http://" + universe + "/game/index.php?page=defense");
		} catch (FailingHttpStatusCodeException | IOException e) {e.printStackTrace();}
		
		return null;
	}
}
