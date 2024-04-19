import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Bienvenido al sistema de registro de usuarios.");
        System.out.print("Ingrese su nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();


        Usuario usuario = new Usuario(nombre, correo, contrasena);
        if (usuario.validarInformacion()) {
            System.out.println("Registro exitoso. Gracias por registrarse.");
        } else {
            System.out.println("Error: La información ingresada no es válida.");
        }
    }
}

class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public boolean validarInformacion() {
        return validarNombre() && validarCorreo() && validarContrasena();
    }

    private boolean validarNombre() {

        String regex = "^[A-Za-zÁáÉéÍíÓóÚúñÑ\\s-]+$";
        return nombre.matches(regex);
    }

    private boolean validarCorreo() {

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return correo.matches(regex);
    }

    private boolean validarContrasena() {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return contrasena.matches(regex);
    }
}