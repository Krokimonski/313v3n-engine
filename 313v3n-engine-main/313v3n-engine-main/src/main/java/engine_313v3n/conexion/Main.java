package engine_313v3n.conexion;

public class Main {
    static public String HTTP_PROTOCOL = "http://";
    static public String HTTPS_PROTOCOL = "https://";
    static public String HOST = "{{host}}";
    static public String PORT = "{{port}}";

    public static void main(String[] args) {
        Llamadas conexion = new Llamadas();
        String username = "admin";
        String password = "admin";
        String grantType = "password";

        try {
            // Realizar la llamada GET con los parámetros proporcionados
            conexion.realizarLlamadaGet(HTTP_PROTOCOL, HOST, PORT, username, password, grantType);

            // Obtener el token y imprimirlo por consola
            String token = conexion.getToken();
            System.out.println("Token: " + token);
            TokenManager.parseToken(token);
        } catch (RuntimeException e) {
            System.out.println("Error al realizar la llamada GET: " + e.getMessage());
        }
    }
}