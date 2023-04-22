import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePOI {

	public static void main(String[] args) throws IOException {
		
		File arquivo = new File("C:\\Users\\victo\\eclipse-workspace\\Arquivos_1.0\\src\\arquivoxls.xls");
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();		
		
		pessoa1.setNome("Victor Rocha");
		pessoa1.setEmail("victor@hotmail.com");
		pessoa1.setIdade(20);
		
		pessoa2.setNome("Fernanda Muniky");
		pessoa2.setEmail("fernanda@hotmail.com");
		pessoa2.setIdade(20);
		
		listaPessoa.add(pessoa1);
		listaPessoa.add(pessoa2);
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(); /** Será usado para escrever na planilha **/
		HSSFSheet hssfSheet = hssfWorkBook.createSheet("Planilha JDev Treinamento"); /** Cria a planilha **/
		
		int numeroLinha = 0;
		for (Pessoa p : listaPessoa) {
			Row linha = hssfSheet.createRow(numeroLinha ++); /** Cria a linha da planilha**/
			int celula = 0;
			Cell celulaNome = linha.createCell(celula ++);
			Cell celulaEmail = linha.createCell(celula ++);
			Cell celulaIdade = linha.createCell(celula ++);
			
			celulaNome.setCellValue(p.getNome());
			celulaEmail.setCellValue(p.getEmail());
			celulaIdade.setCellValue(p.getIdade());
			
//		Fazendo um paralelo ao File,o hssfWorkBook é o File, o HSSFSheet faz referência ao arquivo em si, 
//		o Row guarda informações da linha e o Cell da célula.
			
		}
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		hssfWorkBook.write(saida);
		saida.flush();
		saida.close();
		
		
	}
	
}
