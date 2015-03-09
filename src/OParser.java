import java.io.IOException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;


public class OParser {
	/**
	 * 
	 */
	public OParser(){
		
	}
	/**
	 * 
	 * @param pageWeb (the html code of the webPage
	 * @return the token of the client
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws FailingHttpStatusCodeException 
	 */
	public static String getToken(String pageWeb) throws IOException, InterruptedException{
		//example of token : <input type="hidden" name="token" value="17c14c00c98d51d15e81c1eb85de8c55"/>
		//split the webPage on line 
		String[] splited = pageWeb.split("\n");
		//declare a variable that will contain the token
		String token="";
		//search the lines, who contain : name="token"
		for(int x=0;x<splited.length; x++){
			if(splited[x].indexOf("name=\"token\"")!=-1){
				token = token + splited[x];
			}
		}
		//split the contain of token on the space
		splited = token.split(" ");
		//search the case who contain : value=
		for(int x=0;x<splited.length; x++){
			if(splited[x].indexOf("value=")!=-1){
				token = splited[x];
			}
		}
		//last split on the token, we split on : "
		splited = token.split("\"");
		//and the token is the second line of the table, index 1
		token = splited[1];
		//return the token
		return token;
	}
}
