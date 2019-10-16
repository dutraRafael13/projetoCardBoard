package cardboard.calcular.melhor.transportadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cardboard.transportadora.enums.EnumPrioridadeTransporte;
import cardboard.transportadora.enums.EnumTipoTransporte;
import cardboard.transportadora.modelo.MelhorTransportadora;
import cardboard.transportadora.modelo.Transportadora;

public class CalcularMelhorTransportadora {
	
	public void calcula(List<Transportadora> transportadoras, long distancia, EnumPrioridadeTransporte prioridade, EnumTipoTransporte tipoTransporte) {
		Map<Integer, Map<Integer, Double>> mapTransportadoras = new TreeMap<>();
		transportadoras.stream().forEach(transportadora -> {
			this.setaMapTransportadoras(mapTransportadoras, distancia, transportadora, EnumPrioridadeTransporte.MENOR_PRECO);
			this.setaMapTransportadoras(mapTransportadoras, distancia, transportadora, EnumPrioridadeTransporte.MENOR_TEMPO);
		});
		List<MelhorTransportadora> melhoresPrecos = listaMelhores(mapTransportadoras, EnumPrioridadeTransporte.MENOR_PRECO);
		List<MelhorTransportadora> melhoresTempos = listaMelhores(mapTransportadoras, EnumPrioridadeTransporte.MENOR_TEMPO);
		if (prioridade.getId() == EnumPrioridadeTransporte.MENOR_PRECO.getId() && melhoresPrecos.size() == 1) {
			System.out.println("Melhor transportadora: " + melhoresPrecos.get(0).getCodigo());
		} 
	}

	private List<MelhorTransportadora> listaMelhores(Map<Integer, Map<Integer, Double>> mapTransportadoras, EnumPrioridadeTransporte prioridade) {
		boolean captura = true;
		List<MelhorTransportadora> melhores = new ArrayList<>();
		MelhorTransportadora melhorTransportadora = new MelhorTransportadora();
		while (captura) {
			melhorTransportadora = this.retornaMelhorTransportadora(mapTransportadoras.get(prioridade.getId()), melhorTransportadora);
			melhores.add(melhorTransportadora);
			if (melhorTransportadora.isEmpateTransportadoras()) {
				melhorTransportadora.setEmpateTransportadoras(false);
			} else {
				captura = false;
			}
		}
		return melhores;
	}
	
	private MelhorTransportadora retornaMelhorTransportadora(Map<Integer, Double> mapTransportadoras, MelhorTransportadora melhor) {
		mapTransportadoras.keySet().stream().forEach(transportadora -> {
			double calculoTransportadora = mapTransportadoras.get(transportadora);
			if (melhor.getMelhorCalculo() == 0) {
				melhor.setCodigo(transportadora);
				melhor.setMelhorCalculo(calculoTransportadora);
			} else if (melhor.getMelhorCalculo() > calculoTransportadora){
				melhor.setCodigo(transportadora);
				melhor.setMelhorCalculo(calculoTransportadora);
			} else if (melhor.getMelhorCalculo() ==  calculoTransportadora && melhor.getCodigo() != transportadora) {
				melhor.setEmpateTransportadoras(true);
			}
		});
		return melhor;
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