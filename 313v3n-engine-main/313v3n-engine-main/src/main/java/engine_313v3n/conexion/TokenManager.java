package engine_313v3n.conexion;

import org.json.JSONObject;

public class TokenManager {
    public static void parseToken(String tokenJson) {
        // Parsea el token JSON
        JSONObject json = new JSONObject(tokenJson);

        // Extrae los valores individuales del token
        String accessToken = json.getString("access_token");
        String tokenType = json.getString("token_type");
        String refreshToken = json.getString("refresh_token");
        int expiresIn = json.getInt("expires_in");
        String scope = json.getString("scope");

        // Imprime los valores del token por consola
        System.out.println("Access Token: " + accessToken);
        System.out.println("Token Type: " + tokenType);
        System.out.println("Refresh Token: " + refreshToken);
        System.out.println("Expires In: " + expiresIn);
        System.out.println("Scope: " + scope);
    }
}
