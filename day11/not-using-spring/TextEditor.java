package com.cdac.notusingspring;

public class TextEditor {

	public void loadTextFile(String filename) {
		System.out.println("loading " + filename);
		SpellChecker sp = new SpellChecker();
		sp.checkSpellingMistakes(filename);
	}
}
