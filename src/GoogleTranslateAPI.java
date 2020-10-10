import java.io.IOException;

import com.darkprograms.speech.translator.GoogleTranslate;

public class GoogleTranslateAPI {
	public static String translate(String text) {
		String res = "";
		try {
			System.out.println("Done!");
			res = GoogleTranslate.translate("vi",text);
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();

		}
		return res;


	}

	public static void main(String[] args) {
		
		//Read this ma bro :)
		//When you go on google translate website and you translate from English to Igbo for example
		//you can see the url is :
		// https://translate.google.com/#en/ig/How%20are%20you
		//so the code for IGBO is "ig"
		//see my examples below , i will make tutorial on youtube don't worry
		System.out.println(translate("how are you"));
		

		
	}
	
}
