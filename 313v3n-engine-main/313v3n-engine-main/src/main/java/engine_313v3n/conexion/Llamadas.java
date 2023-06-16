package engine_313v3n.conexion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Llamadas {
    private String token;

    public void realizarLlamadaGet(String protocolo, String host, String port, String username, String password, String grantType) {
        try {
            String url = protocolo + host + ":" + port + "/oauth/token?username=" + username + "&password=" + password + "&grant_type=" + grantType;
            URL urlObj = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Basic Y2xpZW50SWQ6c2VjcmV0");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Almacenar el token en la variable
                token = response.toString();
            } else {
                throw new RuntimeException("Error en la llamada GET. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la llamada GET: " + e.getMessage(), e);
        }
    }

    public String getToken() {
        return token;
    }
}