package swaggerAPI;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainClass {

	public static void main(String[] args) throws IOException, InterruptedException  {
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://petstore.swagger.io/v2/pet/findByStatus?status=sold&status=pending&status=available"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // 2. Recoge mediante petición HTTP, el JSON que retorna el endpoint /pet/findByStatus y lista
        // mediante una función los nombres de las mascotas que se hayan vendido.
        
        // Construct petList, a list of Pets returned by the API request
        Gson gson = new Gson();
        Type petListType = new TypeToken<List<Pet>>(){}.getType();
        PetList petList = new PetList(gson.fromJson(response.body(), petListType));
         String petListJSON = gson.toJson(petList);
         System.out.println(petListJSON);
        
        // use the petList method to get the {id, name} for each sold pet
        System.out.println(gson.toJson(petList.petsByStatusIdName("status")));
             
        // 3. Crea una clase cuyo constructor requiera de la estructura de datos anterior y realiza un método
        // que pueda recorrerla para poder identificar cuantas mascotas se llaman igual.
        System.out.println(gson.toJson(petList.getNameCount()));
	}

}
