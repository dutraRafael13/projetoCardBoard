package cardboard.transportadora.capturar.dados;

import java.util.Scanner;

import cardboard.comunica.web.service.ComunicarWebService;

public class CapturarDadosTransporte {
	
	Scanner captura;
	
	public CapturarDadosTransporte() {
		this.captura = new Scanner(System.in);
	}
	
	public void captura() {
		System.out.println("Melhor Transportadora, digite os dados da viagem");
		System.out.println("Origem: ");
		String origem = this.validaString(captura.nextLine());
		System.out.println("Destino: ");
		String destino = this.validaString(captura.nextLine());
		System.out.println("Distancia: ");
		int distancia = this.validaInteger(captura.nextInt());
		System.out.println("Tipo de transporte, 1 para Terreste 2 para Aéreo: ");
		int tipoTransporte = captura.nextInt();
		System.out.println("Prioridade, 1 menor preço 2 menor tempo: ");
		int prioridade = this.validaInteger(captura.nextInt());
		new ComunicarWebService().comunica(origem, destino, distancia, tipoTransporte, prioridade);
	}
	
	private String validaString(String entrada) {
		while (entrada.isEmpty()) {
			System.out.println("Campo obrigatório, necessário digitar algo!");
			entrada = captura.nextLine();
		}
		return entrada;
	}
	
	private int validaInteger(int entrada) {
		while (entrada == 0) {
			System.out.println("Campo obrigatório, necessário digitar algo!");
			entrada = captura.nextInt();
		}
		return entrada;
	}

}
