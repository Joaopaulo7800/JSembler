package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class GravarArquivo {

	private BufferedReader saida;
	private BufferedWriter saida2;

	public void abrirArquivo(String nomeArquivo) {

		try {
			saida2 = new BufferedWriter(new FileWriter(nomeArquivo));
		} catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nÃ£o encontrado");
		} catch (IOException excecao) {
			System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
		}
	}

	public void fecharArquivo() {

		try {
			saida.close();
		} catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de escrita: " + excecao);
		}
	}

	public void escrever(String textoEntrada) {

		try {
			saida.write(textoEntrada);
			saida.newLine();
		} catch (IOException excecao) {
			System.out.println("Erro de entrada/saÃ­da " + excecao);
		}
	}
}
