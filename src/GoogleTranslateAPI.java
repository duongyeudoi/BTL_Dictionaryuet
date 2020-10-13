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
		

		System.out.println(translate("how are you"));
		

		
	}
	
}
