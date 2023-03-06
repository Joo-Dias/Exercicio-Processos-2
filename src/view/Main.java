package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController Kc = new KillController();

		String process = Kc.getOS();
		int n = 0;

		while (n != 5) {
			n = Integer.parseInt(JOptionPane.showInputDialog(
					"Selecione uma opção: 1 para mostrar o sistema operacional | 2 para mostrar a lista de processos | 3 para matar um processo pelo PID | 4 para matar um processo pelo nome | 5 para finalizar o programa "));
			switch (n) {
			case 1:
				JOptionPane.showMessageDialog(null, "Seu Sistema operacional é: " + process);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Olhe para o console: ");
				Kc.listaProcessos(process);
				break;
			case 3:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo: "));
				Kc.mataPid(pid);
				break;
			case 4:
				String name = JOptionPane.showInputDialog("Digite o nome do processo: ");
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
