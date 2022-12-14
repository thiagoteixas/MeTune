package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.Gson;

import dao.SongDAO;
import dao.UserDAO;
import model.Song;

public class WebService {
	
	private final String urlAcesso = "http://8a9b92a5-8e84-409e-afc2-d665805e70f4.eastus2.azurecontainer.io/score";
	private final String KEY_LOCATION = "keys.txt";
	private boolean DEBUG_STATUS = false; 
	private String tokenAcesso;
	public String bodyStart = "{\"Inputs\":{\"input1\": [{\"user_id\": \"";
	public String bodyMiddle =  "\", \"song_id\": ";
	public String bodyEnd = "}]}, \"GlobalParamenters\":{}}";
	
	public WebService() {
		start();
	}
	
	public WebService(boolean debugStatus) {
		DEBUG_STATUS = debugStatus;
		start();
	}
	
	private void start() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(KEY_LOCATION));
			
			String aux = br.readLine();
			
			if (aux == null || aux == "") {
				System.out.println("Erro arquivo de chaves vazio");
			}
			
			tokenAcesso = (aux.split("="))[1];
			br.close();
			
			if (DEBUG_STATUS)
				System.out.println("chave de acesso: " + tokenAcesso);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getRecomentation(int user_id, int song_id) {
		
		int res = -1;
		
		HttpClient apt_request = new HttpClient();
		apt_request.setFollowRedirects(false);
		
		ContentResponse response = null;

		try {
			apt_request.start();
			
//			System.out.println(new StringContentProvider(test.bodyStart + 1 + test.bodyMiddle + 2 + test.bodyEnd));
			
			response = apt_request.newRequest(urlAcesso)
					.header(HttpHeader.ACCEPT, "application/json")
					.header(HttpHeader.CONTENT_TYPE, "application/json")
					.header(HttpHeader.AUTHORIZATION, "Bearer " + tokenAcesso)
					.method(HttpMethod.POST)
					.content(new StringContentProvider(bodyStart + user_id + bodyMiddle + song_id + bodyEnd), "application/json")
					.send();
			
			if (DEBUG_STATUS)
				System.out.println("Resposta da requisicao: " + response.getContentAsString());
			
			
			apt_request.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] aux = response.getContentAsString().split("\"");
		String aa = aux[aux.length-2];
		
		if (DEBUG_STATUS) {				
			System.out.println("Array de split: " + Arrays.toString(aux));
			System.out.println("ID da musica: " + aa);
		}
		
//		res = Integer.parseInt(aa);
		res = Integer.parseInt(aa) % 10;
		Song song = new SongDAO().get(res);
		
		if (song == null) {
			return "{}";
		}
		
		return new Gson().toJson(song);

	}
}
