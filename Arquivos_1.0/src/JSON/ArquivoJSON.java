package JSON;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ArquivoJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Victor Rocha");
		usuario1.setLogin("victor");
		usuario1.setSenha("1234");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Fernanda Muniky");
		usuario2.setLogin("fernanda");
		usuario2.setSenha("abcd");
		
		List<Usuario> usuarios = new ArrayList<Usuario>(); 
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		String jsonUser = new GsonBuilder().setPrettyPrinting().create().toJson(usuarios);
		
//		Ao invés de usar o Gson().toJson() estou usando GsonBuilder().setPrettyPrinting().create() para 
//		criar uma apresentação mais organizada.
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\victo\\eclipse-workspace\\Treinamento_JDEV\\Arquivos_1.0\\src\\JSONFiles\\usuarioJson.json");
		
//		Aqui utiliza-se o FileWriter pois será criado um objeto com todas as informações do Usuario. Esse Obj irá 
//		representar um arquivo Json existente no caminho. A Classe FileWriter serve para editar um arquivo
		
//		OBSERVACAO: Aqui, diferente das aulas anteriores, não armazeno um arquivo no File e passo no FileWriter. 
//		Aqui, passo direto no FileWriter.
		
		fileWriter.write(jsonUser); /** escreve O ARQUIVO em memória para que o flush() escreva no disco**/
		fileWriter.flush();
		fileWriter.close();
		
//		-----------------------------------LENDO ARQUIVO JSON-----------------------------------
		
		FileReader fileReader = new FileReader("C:\\Users\\victo\\eclipse-workspace\\Treinamento_JDEV\\Arquivos_1.0\\src\\JSONFiles\\usuarioJson.json");
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
//		O trecho acima é equivalente ao uso do Scanner. Ele irá ler o conteúdo de um Json e atribuir em um JsonArray.
//		Exemplo:
		
//		[
//		 {
//			"nome":"João",
//			"idade":25
//		 },
//		 {
//		 	"nome":"Maria",
//		    "idade":30
//		 }
//		]

//		Cada bloco de chaves é como se fosse um Obj atribuido dentro de uma Lista
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			
//			Aqui, estou pegando cada bloco do arquivo Json que está na lista e atribuindo a um objeto jsonElement
//			Contudo, preciso converter o objeto de jsonElement para um objeto de Usuario (new Gson().fromJson(jsonElement, Usuario.class);)
			
			listaUsuarios.add(usuario);
		}
		System.out.println(listaUsuarios);

	}
}
