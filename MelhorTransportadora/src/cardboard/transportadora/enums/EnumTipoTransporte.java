package cardboard.transportadora.enums;

public enum EnumTipoTransporte {

	TERRESTRE(1, "Terrestre"), AEREO(2, "Aereo");

	private int id;
	private String descricao;

	private EnumTipoTransporte(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static EnumTipoTransporte getTipo(int id) {
		for (EnumTipoTransporte tipo : EnumTipoTransporte.values()) {
			if (tipo.id == id) {
				return tipo;
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