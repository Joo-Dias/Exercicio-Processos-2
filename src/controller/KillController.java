package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	// Método que retorna o Sistema Operacional
	private String os = System.getProperty("os.name");

	public String getOS() {
		return os;
	}
	
	// Método que lista os processos
	public void listaProcessos(String process) {
		if(os.contains("Windows")) {
			String lista = "TASKLIST /FO TABLE";
			callProcess(lista);
		} else if(os.contains("Linux" )) {
			String lista = "ps -ef";
			callProcess(lista);
		}
	}
	
	// Método que mata um processo pelo PID e finaliza ele
	public void mataPid(int param) {
		String windows = "TASKKILL /PID";
		String linux = "kill -9";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		if(os.contains("Windows")) {
			pid = param;
			try {
				buffer.append(windows);
				buffer.append(" ");
				buffer.append(pid);
				
				callProcess(buffer.toString());
			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.out.println(msgErro);
			}
		} else {
			try {
				buffer.append(linux);
				buffer.append(" ");
				buffer.append(pid);
				
				callProcess(buffer.toString());
			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.out.println(msgErro);
			}
		}
		
		
	}
	
	//Método que mata um processo pelo NOME e finaliza ele
	public void mataNome(String name) {
		String windows = "TASKKILL /IM";
		String linux = "pkill -f";
		StringBuffer buffer = new StringBuffer();
		if(os.contains("Windows")) {
			
			try {
				buffer.append(windows);
				buffer.append(" ");
				buffer.append(name);
				
				callProcess(buffer.toString());
			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.out.println(msgErro);
			}
		} else {
			
			try {
				buffer.append(linux);
				buffer.append(" ");
				buffer.append(name);
				
				callProcess(buffer.toString());
			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.out.println(msgErro);
			}
		}
		
	}
	
	// Método que executa um determinado processo
	public void callProcess(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
