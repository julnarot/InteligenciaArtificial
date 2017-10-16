package ab_no_informada;

import java.util.ArrayList;
import java.util.Arrays;

public class Prinsipal {
    public static void main(String []args){
        int[] estado_inicial = {2,1,4,3};
        int[] solucion = {1,2,3,4};
        ArrayList<int[]> visitados = new ArrayList<int[]>();
        BusquedaAmplitud ba = new BusquedaAmplitud();

        System.out.println("Busqueda en amplitud recursiva usando heuristica");
        Nodo nodo_inicial = new Nodo();
        nodo_inicial.setDatos(estado_inicial);
        Nodo nodo_solucion = ba.AlRecursivo(nodo_inicial, solucion, visitados);
        //System.out.println(Arrays.toString(nodo_solucion.getDatos()));
        while(nodo_solucion.padre!=null){
            System.out.println(Arrays.toString(nodo_solucion.getDatos()));
            nodo_solucion = nodo_solucion.padre;
        }




    }
}
