import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class test {

	public static void main(String[] args) {
		String id = "MEF";
		String pwd = "MEF@27215";
		// TODO Auto-generated method stub
		OSession os = new OSession(id, pwd, "s128-fr.ogame.gameforge.com");
		HtmlPage page = os.log();
		OParser secondPage = new OParser(); 
		
		
		try {
			//System.out.println(os.getDefencePage());
			System.out.println(OParser.getToken(os.getDefencePage().asXml()));
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
