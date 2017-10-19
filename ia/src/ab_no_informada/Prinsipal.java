package ab_no_informada;

import java.util.ArrayList;
import java.util.Arrays;

public class Prinsipal {
    public static void main(String []args){
        int[] estado_inicial = {2,1,4,3};
        int[] solucion = {1,2,3,4};
        ArrayList<int[]> visitados = new ArrayList<int[]>();
        ArrayList<Nodo> mejor_solucion = new ArrayList<Nodo>();
        Nodo nodo_inicial = new Nodo();
        nodo_inicial.setDatos(estado_inicial);

        System.out.println("######BUSQUEDAD EN AMPLITUD###### ");
        BusquedaAmplitud ba = new BusquedaAmplitud();

        System.out.println(">>metodo Iterativo ");
        Nodo nodo_si = ba.AlIterativo(estado_inicial, solucion);
        while(nodo_si.padre!=null){
            System.out.println(Arrays.toString(nodo_si.getDatos()));
            nodo_si = nodo_si.padre;
        }
        System.out.println(Arrays.toString(nodo_inicial.getDatos()));


        /*System.out.println(">>metodo recursivo");
        Nodo nodo_s = ba.AlRecursivo(nodo_inicial, solucion, visitados);
        while(nodo_s.padre!=null){
            System.out.println(Arrays.toString(nodo_s.getDatos()));
            nodo_s = nodo_s.padre;
        }
        System.out.println(Arrays.toString(nodo_inicial.getDatos()));
        */

        /*System.out.println("metodo recursivo usando heuristica");
        Nodo nodo_sh = ba.AlRecursivo_h(nodo_inicial, solucion, visitados);
        while(nodo_sh.padre!=null){
            System.out.println(Arrays.toString(nodo_sh.getDatos()));
            nodo_sh = nodo_sh.padre;
        }
        System.out.println(Arrays.toString(nodo_inicial.getDatos()));*/

        /*System.out.println("metodo recursivo usando heuristica Mejor solucion");
        ba.AlRecursivo_h_m(nodo_inicial, solucion, visitados, 0);
        Nodo nodo_shm = mejor_solucion.get(1);
        while(nodo_shm.padre!=null){
            System.out.println(Arrays.toString(nodo_shm.getDatos()));
            nodo_shm = nodo_shm.padre;
        }
        System.out.println(Arrays.toString(nodo_inicial.getDatos()));*/

        System.out.println("######BUSQUEDAD EN PROFUNDIDAD###### ");
        BusquedaProfundidad bp = new BusquedaProfundidad();

        /*System.out.println(">>metodo Iterativo ");
        Nodo nodo_isi = bp.metodo_iterativo(estado_inicial, solucion);
        while(nodo_isi.padre!=null){
            System.out.println(Arrays.toString(nodo_isi.getDatos()));
            nodo_isi = nodo_isi.padre;
        }
        System.out.println(Arrays.toString(nodo_inicial.getDatos()));*/

        /*System.out.println(">>metodo Recursivo ");
        Nodo nodo_isr = bp.metodo_recursivo(nodo_inicial, solucion, visitados);
        while(nodo_isr.padre!=null){
            System.out.println(Arrays.toString(nodo_isr.getDatos()));
            nodo_isr = nodo_isr.padre;
        }
        System.out.println(Arrays.toString(nodo_inicial.getDatos()));*/

        /*System.out.println(">>metodo Recursivo con heuristica");
        Nodo nodo_isrh = bp.metodo_recursivo_h(nodo_inicial, solucion, visitados);
        while(nodo_isrh.padre!=null){
            System.out.println(Arrays.toString(nodo_isrh.getDatos()));
            nodo_isrh = nodo_isrh.padre;
        }
        System.out.println(Arrays.toString(nodo_inicial.getDatos()));*/


    }
}
