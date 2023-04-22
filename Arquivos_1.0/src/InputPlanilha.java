import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class InputPlanilha {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream entrada = new FileInputStream("C:\\Users\\victo\\eclipse-workspace\\Arquivos_1.0\\src\\arquivoxls.xls");
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(entrada);
		HSSFSheet hssfSheet = hssfWorkBook.getSheetAt(0);
//		O getSheet() encontra as referências baseadas no nome da Planilha. Exemplo: getSheet("Minha Planilha.xls")
//		O getSheetAt() encontra as referências baseadas no número de planilhas em um arquivo
//		. Exemplo, em um arquivo tem a planilha1, planilha2 e planilha3. Com getSheetAt(0) pegamos a planilha1.
	
		Iterator<Row> numeroLinha = hssfSheet.iterator();
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
//		O Iterator<Row> cria um iterator para as linhas (Row) da minha planilha.
		
		while (numeroLinha.hasNext()) {
			Pessoa pessoa = new Pessoa();
			Row linha = numeroLinha.next();
//			Nesse caso, o Iterator é como uma linha. Ele começa no 0 e com o comando next() vai para a linha 1.
//			Assim como eu não pego um atributo de uma List<Pessoa>, não consigo transformar um Iterator<Row> em celulas.
//			Para isso, é necessário atribuir um elemento da "lista" e realizar a operação.
			
			Iterator<Cell> numeroCelula = linha.iterator();
			while (numeroCelula.hasNext()) {
				Cell celula = numeroCelula.next();
				switch (celula.getColumnIndex() ) {
				case 0: {
					pessoa.setNome(celula.getStringCellValue());
					break;
					}
				case 1: {
					pessoa.setEmail(celula.getStringCellValue());
					break;
					}
				case 2: {
					pessoa.setIdade(Double.valueOf(celula.getNumericCellValue()).intValue());
					break;
					}
				}
			}
			listaPessoas.add(pessoa);
		}
		entrada.close();
		
		for (Pessoa pessoa2 : listaPessoas) {
			System.out.println(pessoa2);
			
		}
	
	}
}
