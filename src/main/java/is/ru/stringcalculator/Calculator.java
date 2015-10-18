package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("//[")) {
			String temp = "";
			for(int i = 0 ; i < sizeOfString(text) ; i++) {
				if(at(text, i) != '/' && at(text, i) != '[') {
					temp += at(text, i);
				}
			}
			String temp2 = temp.substring(0, temp.indexOf(']'));
			String delimiters = "";
			for(int j = 0 ; j < sizeOfString(temp2) ; j++) {
				delimiters += "\\" + at(temp2, j);
			}

			delimiters = "(" + delimiters + ")";
			String numbers = temp.substring(temp.indexOf(']')+2, temp.length());
			return sum(splitNumbers(numbers, delimiters));
		}
		else if(text.contains("//")) {
			String delimiters = text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
			String numbers = text.substring(text.lastIndexOf("\n") + 1);
			return sum(splitNumbers(numbers, delimiters));
		}
		else if(text.contains(",") || text.contains("\n")){
			String delimiters = ",|\n";
			return sum(splitNumbers(text, delimiters));
		}
		else {
			return toInt(text);
		}
	}

	private static int sizeOfString(String s) {
		return s.length();
	}

	private static char at(String s, int iter) {
		return s.charAt(iter);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiters){
	    return numbers.split(delimiters);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String negativeNumbers = "";
        for(String number : numbers){
        	if(toInt(number) < 0) {
        		negativeNumbers += number + ",";
        	}
		    if(toInt(number) <= 1000) {
				total += toInt(number);
        	}
		}

		if(!negativeNumbers.isEmpty()) {
			String temp = negativeNumbers.substring(0, negativeNumbers.length()-1);
			throw new RuntimeException("Negatives not allowed:"+ temp);
		}
		return total;
    }



}