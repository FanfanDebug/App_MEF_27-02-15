import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class test {

	public static void main(String[] args) {
		String id = "Maelios";
		String pwd = "M@elios6";
		// TODO Auto-generated method stub
		OSession os = new OSession(id, pwd, "s128-fr.ogame.gameforge.com");
		HtmlPage page = os.log();
		OParser secondPage = new OParser(); 
		String web ="<input type='hidden' name='token' value='6a7a0ff86a819da0077a922505f80c3b' /> >";//page.asXml()
		
		
		try {
			//System.out.println(os.getDefencePage());
			System.out.println(secondPage.getToken(os.getDefencePage().asXml()));
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(os.getDefencePage().asXml());
	}

}
