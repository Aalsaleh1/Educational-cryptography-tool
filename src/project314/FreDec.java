package project314;

public class FreDec {
	public static void main(String args[]) {
		freqAnalysis("");
	}
	public static void freqAnalysis(String ecryptedWord) {
		if(ecryptedWord=="") {
			return;
		}
		String decryptedWord = ecryptedWord.toUpperCase();
		String freqLitters = "etaoinshrdlcumwfgypbvkjqxz";
		System.out.println(decryptedWord);
		String[] newArr = detectDublicate(decryptedWord);

		for (int i = 0; i < 3; i++) {
			if (newArr[i] == "") {
				break;
			}
			System.out.println(newArr[i].charAt(0) + "->" + freqLitters.charAt(i) + " ");
			decryptedWord = decryptedWord.replace(Character.toUpperCase(newArr[i].charAt(0)), freqLitters.charAt(i));
			System.out.println(decryptedWord);

		}

	}

	public static String[] insertionSort(String[] arr) {// descending
		int counter = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == "" || arr[i] == null) {
				break;
			}
			counter++;
			int j = i;
			while (j > 0 && Integer.parseInt(Character.toString(arr[j - 1].charAt(1))) < Integer
					.parseInt(Character.toString(arr[j].charAt(1)))) {
				String tempS = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tempS;
				j--;
			}
		}

		return arr;
	}

	private static String[] detectDublicate(String word) {

		char[] unique = word.toCharArray();
		String[] xx = new String[word.length()];

		int counter = 0;
		int xCounter = 0;
		for (int i = 0; i < xx.length; i++) {
			xx[i] = "";
		}

		for (int i = 0; i < unique.length; i++) {
			for (int j = i + 1; j < unique.length; j++) {
				if (unique[i] == unique[j]) {
					counter++;
					unique[j] = ' ';
				}
			}
			xx[xCounter] += unique[i];
			xx[xCounter] += (counter + 1);

			xCounter++;
			counter = 0;
		}
		counter = 0;
		String[] newArr = new String[xx.length];
		for (int i = 0; i < xx.length; i++) {
			newArr[counter] = "";
			if (unique[i] == ' ') {
				continue;
			}
			newArr[counter] = xx[i];
			counter++;
		}

		newArr = insertionSort(newArr);
		return newArr;
	}
}
