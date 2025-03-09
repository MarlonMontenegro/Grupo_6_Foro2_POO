import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

// Clase base Equipo
class Equipo {
    protected String fabricante;
    protected String modelo;
    protected String microprocesador;
    protected String memoria;

    public Equipo(String fabricante, String modelo, String microprocesador, String memoria) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return "Fabricante: " + fabricante + "\nModelo: " + modelo + "\nMicroprocesador: " + microprocesador + "\nMemoria: " + memoria;
    }
}

// Subclase Desktop
class Desktop extends Equipo {
    private final String tarjetaGrafica;
    private final String tamanoTorre;
    private final String capacidadDiscoDuro;

    public Desktop(String fabricante, String modelo, String microprocesador, String memoria, String tarjetaGrafica, String tamanoTorre, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorre = tamanoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTarjeta Grafica: " + tarjetaGrafica + "\nTamanio de Torre: " + tamanoTorre + "\nCapacidad de Disco Duro: " + capacidadDiscoDuro;
    }
}

// Subclase Laptop
class Laptop extends Equipo {
    private final String tamanoPantalla;
    private final String capacidadDiscoDuro;

    public Laptop(String fabricante, String modelo, String microprocesador, String memoria, String tamanoPantalla, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTamanio de Pantalla: " + tamanoPantalla + "\nCapacidad de Disco Duro: " + capacidadDiscoDuro;
    }
}

// Subclase Tablet
class Tablet extends Equipo {
    private final String tamanoPantalla;
    private final String tipoPantalla;
    private final String tamanoMemoriaNAND;
    private final String sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador, String memoria, String tamanoPantalla, String tipoPantalla, String tamanoMemoriaNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tamanoPantalla = tamanoPantalla;
        this.tipoPantalla = tipoPantalla;
        this.tamanoMemoriaNAND = tamanoMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTamanio de Pantalla: " + tamanoPantalla + "\nTipo de Pantalla: " + tipoPantalla + "\nTamanio de Memoria NAND: " + tamanoMemoriaNAND + "\nSistema Operativo: " + sistemaOperativo;
    }
}

// Clase principal
public class RegistroEquipos {

    private static final ArrayList<Desktop> desktops = new ArrayList<>();
    private static final ArrayList<Laptop> laptops = new ArrayList<>();
    private static final ArrayList<Tablet> tablets = new ArrayList<>();

    public static void main(String[] args)  {
        while (true) {
            // Opciones del menú con botones
            String[] opciones = {"Registrar equipo", "Ver equipos", "Salir"};

            // Mostrar el menú con botones
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opcion:",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0] // Opción seleccionada por defecto
            );

            // Procesar la selección
            if (seleccion == -1 || seleccion == 2) { // Si el usuario cierra o elige "Salir"
                System.exit(0);
            } else if (seleccion == 0) {
                registrarEquipo();
            } else if (seleccion == 1) {
                verEquipos();
            }
        }
    }

    private static void registrarEquipo() {
        // Opciones para mostrar en el JOptionPane
        String[] opciones = {"Desktop", "Laptop", "Tablet"};

        // Mostrar el cuadro de diálogo con botones en lugar de input de texto
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de equipo:",
                "Registro de Equipos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]  // Opción seleccionada por defecto
        );

        // Verificar la selección del usuario
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "No selecciono ningun equipo.");
            return;
        }

        // Ejecutar la opción seleccionada
        switch (seleccion) {
            case 0:
                registrarDesktop();
                break;
            case 1:
                registrarLaptop();
                break;
            case 2:
                registrarTablet();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Seleccion invalida.");
        }
    }

    private static void registrarDesktop() {
        JPanel panel = crearPanelEquipo("Desktop");
        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Desktop", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String fabricante = ((JTextField) panel.getComponent(1)).getText();
            String modelo = ((JTextField) panel.getComponent(3)).getText();
            String microprocesador = ((JTextField) panel.getComponent(5)).getText();
            String memoria = ((JTextField) panel.getComponent(7)).getText();
            String tarjetaGrafica = ((JTextField) panel.getComponent(9)).getText();
            String tamanoTorre = ((JTextField) panel.getComponent(11)).getText();
            String capacidadDiscoDuro = ((JTextField) panel.getComponent(13)).getText();

            if (validarDatos(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamanoTorre, capacidadDiscoDuro)) {
                desktops.add(new Desktop(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamanoTorre, capacidadDiscoDuro));
                JOptionPane.showMessageDialog(null, "Desktop registrado exitosamente.");
            }
        }
    }

    private static void registrarLaptop() {
        JPanel panel = crearPanelEquipo("Laptop");
        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Laptop", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String fabricante = ((JTextField) panel.getComponent(1)).getText();
            String modelo = ((JTextField) panel.getComponent(3)).getText();
            String microprocesador = ((JTextField) panel.getComponent(5)).getText();
            String memoria = ((JTextField) panel.getComponent(7)).getText();
            String tamanoPantalla = ((JTextField) panel.getComponent(9)).getText();
            String capacidadDiscoDuro = ((JTextField) panel.getComponent(11)).getText();

            if (validarDatos(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDiscoDuro)) {
                laptops.add(new Laptop(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDiscoDuro));
                JOptionPane.showMessageDialog(null, "Laptop registrada exitosamente.");
            }
        }
    }

    private static void registrarTablet() {
        JPanel panel = crearPanelEquipo("Tablet");
        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Tablet", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String fabricante = ((JTextField) panel.getComponent(1)).getText();
            String modelo = ((JTextField) panel.getComponent(3)).getText();
            String microprocesador = ((JTextField) panel.getComponent(5)).getText();
            String memoria = ((JTextField) panel.getComponent(7)).getText();
            String tamanoPantalla = ((JTextField) panel.getComponent(9)).getText();
            String tipoPantalla = obtenerTipoPantalla();
            String tamanoMemoriaNAND = ((JTextField) panel.getComponent(11)).getText();
            String sistemaOperativo = ((JTextField) panel.getComponent(13)).getText();

            if (validarDatos(fabricante, modelo, microprocesador, memoria, tamanoPantalla, tamanoMemoriaNAND)) {
                tablets.add(new Tablet(fabricante, modelo, microprocesador, memoria, tamanoPantalla, tipoPantalla, tamanoMemoriaNAND, sistemaOperativo));
                JOptionPane.showMessageDialog(null, "Tablet registrada exitosamente.");
            }
        }
    }

    private static JPanel crearPanelEquipo(String tipo) {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Fabricante:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Modelo:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Microprocesador:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Memoria:"));
        panel.add(new JTextField());
        
        switch (tipo) {
            case "Desktop":
                panel.add(new JLabel("Tarjeta Grafica:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Tamanio de Torre:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Capacidad de Disco Duro:"));
                panel.add(new JTextField());
                break;
            case "Laptop":
                panel.add(new JLabel("Tamanio de Pantalla:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Capacidad de Disco Duro:"));
                panel.add(new JTextField());
                break;
            case "Tablet":
                panel.add(new JLabel("Tamanio de Pantalla:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Tamanio de Memoria NAND:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Sistema Operativo:"));
                panel.add(new JTextField());
                break;
            default:
                break;
        }
        return panel;
    }

    private static boolean validarDatos(String... datos) {
        for (String dato : datos) {
            if (dato == null || dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados.");
                return false;
            }
        }
        return true;
    }

    private static String obtenerTipoPantalla() {
        String tipoPantalla = "";
        while (true) {
            String opcion = JOptionPane.showInputDialog("Tipo de Pantalla:\n1. Capacitiva\n2. Resistiva");
            switch (opcion) {
                case "1":
                    tipoPantalla = "Capacitiva";
                    return tipoPantalla;
                case "2":
                    tipoPantalla = "Resistiva";
                    return tipoPantalla;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no válida");
            }
        }
    }

    private static void verEquipos() {
        // Opciones del menú en botones
        String[] opciones = {"Desktop", "Laptop", "Tablet", "Cancelar"};

        // Mostrar cuadro de diálogo con botones
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de equipo que desea ver:",
                "Ver Equipos Registrados",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0] // Opción por defecto
        );

        // Si el usuario cancela, salir del método
        if (seleccion == -1 || seleccion == 3) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Procesar la selección del usuario
        switch (seleccion) {
            case 0: // Desktop
                mostrarEquipos(desktops, "Desktops Registrados");
                break;
            case 1: // Laptop
                mostrarEquipos(laptops, "Laptops Registradas");
                break;
            case 2: // Tablet
                mostrarEquipos(tablets, "Tablets Registradas");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarEquipos(java.util.List<?> lista, String titulo) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay " + titulo.toLowerCase() + ".");
        } else {
            StringBuilder builder = new StringBuilder();
            lista.forEach(equipo -> builder.append(equipo.toString()).append("\n\n"));
            JOptionPane.showMessageDialog(null, builder.toString(), titulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
