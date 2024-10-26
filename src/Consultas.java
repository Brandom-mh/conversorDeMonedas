import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Consultas {
    String origen;
    String destino;
    float cantidad;

    Consultas(String origen, String destino, float cantidad){
        this.origen=origen;
        this.destino=destino;
        this.cantidad=cantidad;
    }


    public Consultas() {
        //TODO Auto-generated constructor stub
    }

    public void consulta() {
        try {
            // URL del servicio
            String url_str = "https://v6.exchangerate-api.com/v6/b61727c05f18dd392af8b5b3/pair/"+origen+"/"+destino+"/"+cantidad; // Eliminar espacio extra en la URL
            URL url = new URL(url_str);

            // Abrir la conexión
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Parsear la respuesta JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Acceder al campo "result"
            Double req_result = jsonobj.get("conversion_result").getAsDouble();
            System.out.println(req_result); 

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
