package com.cdac.di.usingspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEditor")
public class TextEditor {

	//Dependency Injection (DI)
	@Autowired
	private SpellChecker sp;
	
	public void loadTextFile(String filename) {
		System.out.println("loading " + filename);
		//SpellChecker sp = new SpellChecker();
		sp.checkSpellingMistakes(filename);
	}
}
