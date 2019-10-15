package cardboard.calcular.melhor.transportadora;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cardboard.transportadora.enums.EnumPrioridadeTransporte;
import cardboard.transportadora.enums.EnumTipoTransporte;
import cardboard.transportadora.modelo.Transportadora;

public class CalcularMelhorTransportadora {
	
	public String calcula(List<Transportadora> transportadoras, long distancia, EnumPrioridadeTransporte prioridade) {
		String msg = "";
		Map<Integer, Map<Integer, Double>> mapTransportadoras = new TreeMap<>();
		transportadoras.stream().forEach(transportadora -> {
			this.setaMapTransportadoras(mapTransportadoras, distancia, transportadora, EnumPrioridadeTransporte.MENOR_PRECO);
			this.setaMapTransportadoras(mapTransportadoras, distancia, transportadora, EnumPrioridadeTransporte.MENOR_TEMPO);
		});
		mapTransportadoras.get(EnumPrioridadeTransporte.MENOR_PRECO.getId()).values().
		return msg;
	}
	
	public String calcula(List<Transportadora> transportadoras, long distancia,
			EnumPrioridadeTransporte prioridade, EnumTipoTransporte tipoTransporte) {
		return "";	
	}
	
	private void setaMapTransportadoras(Map<Integer, Map<Integer, Double>> mapTransportadoras, long distancia,
			Transportadora transportadora, EnumPrioridadeTransporte prioridade) {
		mapTransportadoras.put(prioridade.getId(), new TreeMap<>());
		mapTransportadoras.get(prioridade.getId()).put(transportadora.getCodigoTransportadora(),
				prioridade.getId() == EnumPrioridadeTransporte.MENOR_PRECO.getId()
						? this.calculaPrecoFinalTransportadora(distancia, transportadora.getValor())
						: this.calculaTempoFinalTransportadora(distancia, transportadora.getTempo()));
	}
	
	private double calculaPrecoFinalTransportadora(long distancia, double valor) {
		return (distancia * valor) / 10;
	}
	
	private double calculaTempoFinalTransportadora(long distancia, int tempo) {
		return distancia * tempo;
	}

}