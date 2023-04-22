import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivos {

	
	public static void main(String[] args) throws IOException {
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		
		pessoa1.setNome("Victor Rocha");
		pessoa1.setEmail("victor@hotmail.com");
		pessoa1.setIdade(20);
		
		pessoa2.setNome("Fernanda Muniky");
		pessoa2.setEmail("fernanda@hotmail.com");
		pessoa2.setIdade(20);
		
		File arquivo = new File("C:\\Users\\victo\\eclipse-workspace\\Arquivos_1.0\\src\\dadosPessoas.csv");
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter escreverNoArquivo = new FileWriter(arquivo);
		escreverNoArquivo.write(pessoa1.getNome()+";"+pessoa1.getEmail()+";"+pessoa1.getIdade());
		escreverNoArquivo.write("/n");
		escreverNoArquivo.write(pessoa2.getNome()+";"+pessoa2.getEmail()+";"+pessoa2.getIdade());
		escreverNoArquivo.flush();
		escreverNoArquivo.close();
//		A Classe File do java é a responsável por manipular os arquivos no pc.
//		Contudo, é a Classe FileWriter que manipula o conteúdo de um arquivo específico.
//		Essa classe faz isso através de um Buffer(armazenamento temporário de memória). 
//		Quando usamos o comando write(); o FileWriter escreve o conteúdo no Buffer, e através
//		do comando flush(); esse conteúdo é transferido  para o arquivo em si.
	}
	
}
