package gmes;


public class JuegoVida {
    static int[][] antes = new int[12][12];
    static int[][] despues = new int[12][12];
    public static void main(String[] args) {
        int i,j;
        String linea;
        antes[5][5]=1;
        antes[5][7]=1;
        antes[6][6]=1;
        antes[7][6]=1;
        antes[8][6]=1;
        while(true) {
            for (i=1 ; i<=10 ; i++) {
                for (j=1 ; j<=10 ; j++) {
                    despues[i][j] = nuevoEstado(i,j);
                }
            }
            // mostrar celulas
            for (i=1 ; i<=10 ; i++) {
                linea="";
                for (j=1 ; j<=10 ; j++) {
                    if (antes[i][j] == 1)
                        linea += "o";
                    else
                        linea += ".";
                }
                System.out.println(linea);
            }
            // copiar celulas
            for (i=1 ; i<=10 ; i++) {
                for (j=1 ; j<=10 ; j++) {
                    antes[i][j] = despues[i][j];
                }
            }
            System.out.println("-------------------");

            try {
                Thread.sleep(200);
            } catch (Exception e) {}
        }
    }
    private static int nuevoEstado(int i, int j) {
        int vecinos;
        vecinos = antes[i-1][j-1]+antes[i][j-1]+antes[i+1][j-1];
        vecinos += antes[i-1][j]+antes[i+1][j];
        vecinos += antes[i-1][j+1]+antes[i][j+1]+antes[i+1][j+1];
        if ((vecinos == 3) && (antes[i][j] == 0))
            return 1;
        else if (((vecinos == 2) || (vecinos == 3)) && (antes[i][j]==1))
            return 1;
        else
            return 0;
    }
}