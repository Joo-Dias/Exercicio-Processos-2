package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController Kc = new KillController();

		String process = "";
		int n = 0;
		int processP;
		
		while (n != 5) {
			n = Integer.parseInt(JOptionPane.showInputDialog(
					"Selecione uma opção: \n 1 - para mostrar o sistema operacional \n 2 - para mostrar a lista de processos \n 3 - para matar um processo pelo PID \n 4 - para matar um processo pelo nome \n 5 - para finalizar o programa "));
			switch (n) {
			case 1:
				JOptionPane.showMessageDialog(null, "Seu Sistema operacional é: " + Kc.getOS());
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Olhe para o console: ");
				Kc.listaProcessos(process);
				break;
			case 3:
				processP = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo: "));
				Kc.mataPid(processP);
				break;
			case 4:
				String name = JOptionPane.showInputDialog(null, "Digite o nome do processo: ");
				Kc.mataNome(name);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Programa finalizado! :)");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Por favor insira um valor válido!");
			}

		}

	}
}
