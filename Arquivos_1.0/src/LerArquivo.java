import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {
	
	public static void main(String[] args) throws Exception{
		FileInputStream entradaArquivo = new FileInputStream(new File("C:\\Users\\victo\\eclipse-workspace\\Arquivos_1.0\\src\\dadosPessoas.txt"));
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
//		De modo simplificado, o FileInputStream vai captar o arquivo e o Scanner vai 
//		verificar o que há dentro dele
		
		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		while (lerArquivo.hasNext()) {
			Pessoa pessoa = new Pessoa();
			String linha = lerArquivo.nextLine();
			String[] dados = linha.split(";");
			
			pessoa.setNome(dados[0]);
			pessoa.setEmail(dados[1]);
			pessoa.setIdade(Integer.parseInt(dados[2]));
			
			listaPessoa.add(pessoa);
//			Enquanto houver informações dentro do arquivo Scanneado, o nextLine() irá
//			ler essas informações e colocar em uma String, que será o alvo faz nossas operações
			
//			No exemplo usado no método, uso um split para separar e setar as informações de cada linha
		}
		System.out.println(listaPessoa);
	}

}