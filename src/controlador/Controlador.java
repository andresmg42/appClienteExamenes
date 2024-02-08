package controlador;

import java.util.ArrayList;

import Models.Examen;
import Models.Pregunta;
import views.Gui;

public class Controlador {

    private Examen examen;
    private Pregunta actual;
    private int indicePreguntaActual;

    private String paquete;
    private ArrayList<String> preguntasSinSeparar;
    private ArrayList<ArrayList<String>> listaPreguntas;

    private String nombreExamen;
    private String tiempoExamen;

    Gui gui;
    conexion con;

    public Controlador() {
        this.gui = new Gui(this);
        this.con = new conexion(gui, this);
        this.paquete = "";

        // provicional
        // this.examen = new Examen("andres", 14, "text");

    }

    public void setExamen(Examen examen) {
        this.examen = examen;

    }

    public Examen getExamen() {
        return examen;
    }

    public void sacarPreguntaActual(String i) {
        indicePreguntaActual = Integer.parseInt(i);

    }

    public void GuardarRespuesta(String respuesta) {
        if (examen.getPreguntas().get(indicePreguntaActual).getOpcionCorrecta().equals(respuesta)) {

            examen.getPreguntas().get(indicePreguntaActual).setEstado("RESPONDIDA");

        }

    }

    public void cambiarEstadoDePregunta(String estado) {
        examen.getPreguntas().get(indicePreguntaActual).setEstado("OCUPADA");

    }

    public Pregunta getActual() {
        return actual;
    }

    public void setActual(Pregunta actual) {
        this.actual = actual;
    }

    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public conexion getCon() {
        return con;
    }

    public void setCon(conexion con) {
        this.con = con;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public ArrayList<String> getPreguntasSinSeparar() {
        return preguntasSinSeparar;
    }

    public void setPreguntasSinSeparar(ArrayList<String> listaPreguntas) {
        this.preguntasSinSeparar = listaPreguntas;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getTiempoExamen() {
        return tiempoExamen;
    }

    public void setTiempoExamen(String tiempoExamen) {
        this.tiempoExamen = tiempoExamen;
    }

    public ArrayList<ArrayList<String>> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(ArrayList<ArrayList<String>> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public void desempaquetar() {
        this.preguntasSinSeparar = new ArrayList<>();
        String[] datos = paquete.split(",");
        nombreExamen = datos[datos.length - 1];
        tiempoExamen = datos[datos.length - 2];
        for (int i = 0; i < datos.length; i++) {
            if (i != datos.length - 1 && i != datos.length - 2) {
                preguntasSinSeparar.add(datos[i]);
            }
        }

    }

    public void separarPreguntas() {
        listaPreguntas = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < preguntasSinSeparar.size(); i++) {
            if (i % 7 == 0) {
                for (int j = 0; j < preguntasSinSeparar.size(); j++) {
                    if (j >= i && j < (i + 7)) {
                        aux.add(preguntasSinSeparar.get(j));
                    }

                }
                listaPreguntas.add(aux);

            }
        }
    }

    // public static void main(String[] args) {
    // ArrayList<Integer> lista = new ArrayList<>();
    // for (int i = 0; i < 10; i++) {
    // lista.add(i);
    // }

    // for (int j : lista) {
    // System.out.println(j);
    // }
    // }

}
