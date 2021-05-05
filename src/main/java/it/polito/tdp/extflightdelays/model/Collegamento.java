package it.polito.tdp.extflightdelays.model;

public class Collegamento {
	
	int a1id;
	int a2id;
	int mediaDistanza;
	
	public Collegamento(int a1id, int a2id, int mediaDistanza) {
		
		this.a1id = a1id;
		this.a2id = a2id;
		this.mediaDistanza = mediaDistanza;
		
	}

	public int getA1id() {
		return a1id;
	}

	public void setA1id(int a1id) {
		this.a1id = a1id;
	}

	public int getA2id() {
		return a2id;
	}

	public void setA2id(int a2id) {
		this.a2id = a2id;
	}

	public int getMediaDistanza() {
		return mediaDistanza;
	}

	public void setMediaDistanza(int mediaDistanza) {
		this.mediaDistanza = mediaDistanza;
	}
	
}
