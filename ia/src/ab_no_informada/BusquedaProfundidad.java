package ab_no_informada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BusquedaProfundidad {
    public Nodo metodo_iterativo(int[] estado_inicial, int[] solucion) {
        boolean solucionado=false;
        Stack<Nodo> nodos_no_expandidos=new Stack<Nodo>();
        ArrayList<int[]> visitados = new ArrayList<int[]>();
        Nodo nodoInicial=new Nodo(); //creamos el objeto nodo inicial
        nodoInicial.setDatos(estado_inicial); //Ponemos el array al nodo inicial
        nodos_no_expandidos.push(nodoInicial); //POner el nodo inicial a la PILA

        while(!solucionado){
            Nodo nodo=nodos_no_expandidos.pop();
            visitados.add(nodo.getDatos());

            if(Arrays.equals(nodo.getDatos(), solucion)){
                solucionado=true;
                return nodo;
            }else{
                int data[]=nodo.getDatos(); //Sacando el contenido del nodo
                int datoi[]={data[1],data[0],data[2],data[3]}; //Intermcabio Izquierda
                int datoc[]={data[0],data[2],data[1],data[3]}; //Intercambio al centro
                int datod[]={data[0],data[1],data[3],data[2]}; //Intercambio a la derecha

                Nodo hijoIzquierdo=new Nodo(); //Creando los objetos nodos
                Nodo hijoCentral=new Nodo();
                Nodo hijoDerecho=new Nodo();

                hijoIzquierdo.setDatos(datoi); //ponemos los arrays a los nodos
                hijoCentral.setDatos(datoc);
                hijoDerecho.setDatos(datod);
                if(!contiene(visitados, datoi))
                    nodos_no_expandidos.push(hijoIzquierdo); //ponemos los nodos a la pila

                if(!contiene(visitados, datoc))
                    nodos_no_expandidos.push(hijoCentral);

                if(!contiene(visitados, datod))
                    nodos_no_expandidos.push(hijoDerecho);

                ArrayList<Nodo> nhijos = new ArrayList<Nodo>();
                nhijos.add(hijoIzquierdo);
                nhijos.add(hijoCentral);
                nhijos.add(hijoDerecho);
                nodo.setHijos(nhijos);


            }
        }
        return null;
    }

    public Nodo metodo_recursivo(Nodo nodo_inicial, int[] solucion, ArrayList visitados) {
        Stack<Nodo> nodos_no_expandidos=new Stack<Nodo>();
        visitados.add(nodo_inicial.getDatos());
        nodos_no_expandidos.push(nodo_inicial);
        Nodo nodo=nodos_no_expandidos.pop();
        if(Arrays.equals(nodo.getDatos(), solucion)){
            return nodo;
        }else{
            int data[]=nodo.getDatos(); //Sacando el contenido del nodo
            int datoi[]={data[1],data[0],data[2],data[3]}; //Intermcabio Izquierda
            int datoc[]={data[0],data[2],data[1],data[3]}; //Intercambio al centro
            int datod[]={data[0],data[1],data[3],data[2]}; //Intercambio a la derecha

            Nodo hijoIzquierdo=new Nodo(); //Creando los objetos nodos
            Nodo hijoCentral=new Nodo();
            Nodo hijoDerecho=new Nodo();

            hijoIzquierdo.setDatos(datoi); //ponemos los arrays a los nodos
            hijoCentral.setDatos(datoc);
            hijoDerecho.setDatos(datod);

            if(!contiene(visitados, datoi))
                nodos_no_expandidos.push(hijoIzquierdo); //ponemos los nodos a la pila

            if(!contiene(visitados, datoc))
                nodos_no_expandidos.push(hijoCentral);

            if(!contiene(visitados, datod))
                nodos_no_expandidos.push(hijoDerecho);

            ArrayList<Nodo> nhijos=new ArrayList<Nodo>();
            nhijos.add(hijoIzquierdo);
            nhijos.add(hijoCentral);
            nhijos.add(hijoDerecho);
            nodo_inicial.setHijos(nhijos);

            for(Nodo nodoHijo: nodo_inicial.getHijos()){
                if(!contiene(visitados,nodoHijo.getDatos())){
                    Nodo sol = metodo_recursivo(nodoHijo,solucion,visitados);
                    if(sol!=null){
                        return sol;
                    }
                }
            }
            return null;
        }
    }
    public Nodo metodo_recursivo_h(Nodo nodo_inicial, int[] solucion, ArrayList visitados) {
        Stack<Nodo> nodos_no_expandidos=new Stack<Nodo>();
        visitados.add(nodo_inicial.getDatos());
        nodos_no_expandidos.push(nodo_inicial);
        Nodo nodo=nodos_no_expandidos.pop();
        if(Arrays.equals(nodo.getDatos(), solucion)){
            return nodo;
        }else{
            int data[]=nodo.getDatos(); //Sacando el contenido del nodo
            int datoi[]={data[1],data[0],data[2],data[3]}; //Intermcabio Izquierda
            int datoc[]={data[0],data[2],data[1],data[3]}; //Intercambio al centro
            int datod[]={data[0],data[1],data[3],data[2]}; //Intercambio a la derecha

            Nodo hijoIzquierdo=new Nodo(); //Creando los objetos nodos
            Nodo hijoCentral=new Nodo();
            Nodo hijoDerecho=new Nodo();

            hijoIzquierdo.setDatos(datoi); //ponemos los arrays a los nodos
            hijoCentral.setDatos(datoc);
            hijoDerecho.setDatos(datod);

            if(!contiene(visitados, datoi))
                nodos_no_expandidos.push(hijoIzquierdo); //ponemos los nodos a la pila

            if(!contiene(visitados, datoc))
                nodos_no_expandidos.push(hijoCentral);

            if(!contiene(visitados, datod))
                nodos_no_expandidos.push(hijoDerecho);

            ArrayList<Nodo> nhijos=new ArrayList<Nodo>();
            nhijos.add(hijoIzquierdo);
            nhijos.add(hijoCentral);
            nhijos.add(hijoDerecho);
            nodo_inicial.setHijos(nhijos);

            for(Nodo nodoHijo: nodo_inicial.getHijos()){
                if(!contiene(visitados,nodoHijo.getDatos())&&heuristica(nodo_inicial,nodoHijo)){
                    Nodo sol = metodo_recursivo_h(nodoHijo,solucion,visitados);
                    if(sol!=null){
                        return sol;
                    }
                }
            }
            return null;
        }
    }



    public static boolean contiene(ArrayList<int[]> visitados, int[] buscado){
        for(int[] v: visitados){
            if(Arrays.equals(v,buscado)){
                return true;
            }
        }
        return false;
    }

    public boolean heuristica(Nodo padre, Nodo hijo){
        int calidad_padre = 0;
        int calidad_hijo = 0;
        int[] dato_padre  = padre.getDatos();
        int[] dato_hijo = hijo.getDatos();
        //for (int i: dato_padre) {
        for(int i = 1; i < dato_padre.length; i++){
            if(dato_padre[i]>dato_padre[i-1]){
                calidad_padre++;
            }
            if(dato_hijo[i]>dato_hijo[i-1]){
                calidad_hijo++;
            }
        }
        if(calidad_hijo>=calidad_padre){
            return true;
        }else{
            return false;
        }
    }

}
