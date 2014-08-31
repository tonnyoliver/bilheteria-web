package br.com.cepep.bilheteria.modelo;

public enum Status {
	
	LIVRE("Livre"),RESERVADA("Reservada"),VENDIDA("Vendida");
	
	private String status;
	
	Status(String status){
		this.status = status;
	}
	
	@Override
	public String toString() {
		return status;
	}
	
}
