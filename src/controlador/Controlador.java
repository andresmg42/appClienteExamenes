package controlador;

import java.util.ArrayList;

import Models.Examen;
import Models.Pregunta;
import views.Gui;

public class Controlador {
    private Examen examen;
    private Pregunta actual;
    int indicePreguntaActual;

    Gui gui;
    conexion con;

    public Controlador() {
        this.gui = new Gui(this);
        this.con = new conexion(gui, this);
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

}
