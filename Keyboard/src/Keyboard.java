
public class Keyboard {
	
	public static void main(String[] args) {
		String words = "QUERO TRABALHAR NA WDEV";
		int sizeString = words.length();
		String result = new String();
		String anterior = "";
		for(int i = 0; i < sizeString; i++) {
			
			if(String.valueOf(words.charAt(i)).equals(" ")) {
				result += "0";
			}else {
				String x = NumericKeyboard.valueOf(String.valueOf(words.charAt(i))).toString().trim();
				if(anterior != "" && anterior.charAt(0) == x.charAt(0)) {		
					result += "_";
				}					
				result += NumericKeyboard.valueOf(String.valueOf(words.charAt(i)));
				
				anterior = NumericKeyboard.valueOf(String.valueOf(words.charAt(i))).toString();
			}
		}
		System.out.println(result);
	}
}
