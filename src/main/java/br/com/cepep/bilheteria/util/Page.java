package br.com.cepep.bilheteria.util;

public enum Page {
	
	LOGIN("login.xhtml"),
	ADMIN("admin.xhtml"),
	BILHETERIA("bilheteria.xhtml");
	
	private String page;

	private Page(String page) {
		this.page = page;
	}
	
	public String getDescription(){
		return page;
	}
	
	@Override
	public String toString() {
		return page;
	}
	
}
