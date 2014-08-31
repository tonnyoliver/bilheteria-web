package br.com.cepep.bilheteria.modelo;

public enum PerfilUsuario {
	
	ADMIN("Admin"),
	VENDEDOR("Vendedor"),
	VENDEDOR_SUBSTITUTO("Substituto");
	
	private String perfil;

	private PerfilUsuario(String perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return perfil;
	}
	
}
