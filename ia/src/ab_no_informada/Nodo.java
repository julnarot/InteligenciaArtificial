package ab_no_informada;

import java.util.List;

public class Nodo {
    int[] datos;
    Nodo padre;
    List<Nodo> hijos;
    public int[] getDatos() {
        return datos;
    }

    public void setDatos(int[] datos) {
        this.datos = datos;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public List<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(List<Nodo> hijos) {
        this.hijos = hijos;
        if(hijos != null){
            for (Nodo n: hijos
                 ) {
                n.padre = this;
            }
        }
    }



}
