package cardboard.transportadora.modelo;

public class Transportadora {
	
	private int id;
	private int codigoTransportadora;
	private int idTipoTransporte;
	private double valor;
	private int tempo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoTransportadora() {
		return codigoTransportadora;
	}

	public void setCodigoTransportadora(int codigoTransportadora) {
		this.codigoTransportadora = codigoTransportadora;
	}

	public int getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(int idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

}