package cardboard.comunica.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cardboard.calcular.melhor.transportadora.CalcularMelhorTransportadora;
import cardboard.transportadora.enums.EnumPrioridadeTransporte;
import cardboard.transportadora.enums.EnumTipoTransporte;
import cardboard.transportadora.modelo.Transportadora;

public class ComunicarWebService {
	
	private final String USER_AGENT = "Mozilla/5.0";
	
	public void comunica(String origem, String destino, int distancia, int tipoTransporte, int prioridade) {
		String url = "http://localhost:8080/service/transportadora";
		String json = this.enviaGet(url, "GET");
        Gson gson = new Gson();
        List<Transportadora> transportadoras = new ArrayList<>();
        Type transportadoraType = new TypeToken<List<Transportadora>>() {}.getType();
        transportadoras = gson.fromJson(json, transportadoraType);
		new CalcularMelhorTransportadora().calcula(transportadoras, distancia,
				EnumPrioridadeTransporte.getPrioridade(prioridade), EnumTipoTransporte.getTipo(tipoTransporte));
	}
	
	private String enviaGet(String url, String method) {
		StringBuffer response = new StringBuffer();
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			System.out.println("ComunicarWebService -  enviaGet() - Exception: " + e);
		}
		return response.toString();
    }

}