package engine_313v3n.conexion;

public class Main {
    static public String HTTP_PROTOCOL = "http://";
    static public String HTTPS_PROTOCOL = "https://";
    static public String HOST = "frparvm97723807.corp.capgemini.com";
    static public String PORT = "8280";

    public static void main(String[] args) {
        Llamadas conexion = new Llamadas();
        String username = "313v3nWhite";
        String password = "DBC";
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