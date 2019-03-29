package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> parole;
	
	public AlienDictionary() {
		parole = new LinkedList<Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		for(int i=0; i<parole.size(); i++) {
			if(parole.get(i).getAlienWord().compareTo(alienWord)==0) {
				parole.get(i).setTranslation(translation);
				return;
			}
		}
		parole.add(new Word(alienWord, translation));
	}
	
	public String translateWord(String alienWord) {
		if(parole.size()==0)
			return null;
		
		for(int i=0; i<parole.size(); i++) {
			if(parole.get(i).getAlienWord().compareTo(alienWord)==0) {
				return parole.get(i).getTranslation();
			}
		}
		return null;
	}
	
	public void clearDictionary() {
		parole.clear();
	}
	

}
