package cardboard.transportadora.enums;

public enum EnumPrioridadeTransporte {

	MENOR_PRECO(1, "Menor preco"), MENOR_TEMPO(2, "Menor tempo");

	private int id;
	private String descricao;

	private EnumPrioridadeTransporte(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static EnumPrioridadeTransporte getPrioridade(int id) {
		for (EnumPrioridadeTransporte prioridade : EnumPrioridadeTransporte.values()) {
			if (prioridade.id == id) {
				return prioridade;
			}
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}