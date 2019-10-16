package cardboard.transportadora.modelo;

public class MelhorTransportadora {

	private int codigo;
	private double melhorCalculo;
	private boolean empateTransportadoras;

	public MelhorTransportadora() {
		this.codigo = 0;
		this.melhorCalculo = 0.0;
		this.empateTransportadoras = false;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getMelhorCalculo() {
		return melhorCalculo;
	}

	public void setMelhorCalculo(double melhor) {
		this.melhorCalculo = melhor;
	}

	public boolean isEmpateTransportadoras() {
		return empateTransportadoras;
	}

	public void setEmpateTransportadoras(boolean empateTransportadoras) {
		this.empateTransportadoras = empateTransportadoras;
	}

}