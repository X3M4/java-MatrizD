package dam.net.jmfm.ejercicio2;


public class test {
    public static void main(String[] args){
        /* MatrizD m1 = new MatrizD( new double[][]{ {1,2,3}, {4,5,6}, {7,8,9} } );
        System.out.println("columnas: "+m1.getFilas());
        System.out.println( m1 );
        double[] fila_copia = Arrays.copyOf(m1.getColumna(1), m1.getColumna(1).length);

        m1.insertaFila(1, fila_copia);
        m1.insertaFila(1, fila_copia);
        System.out.println("columnas: "+m1.getFilas());
        System.out.println(m1);

        m1.insertaFila(2, fila_copia);
        
        System.out.println(m1);
        double[]fila_borrada = (m1.borrarFila(2));
        m1.borrarFila(2);
        
        System.out.println(m1);
        for(int i = 0; i < fila_borrada.length; i++){
            System.out.println(fila_borrada[i]);
        }

         MatrizD m3 = new MatrizD( new double[][] {{1,2,3}, {2,3,4}, {3,4,5}});
        System.out.println(m3);
        m3.insertaColumna(2, new double[] {7,8,9} );
        System.out.println(m3.getColumnas());
        System.out.println(m3);
        m3.insertaColumna(2, new double[] {1, 1, 1} );
        m3.insertaColumna(3, new double[] {9, 0, 1} );
        System.out.println("columnas: "+m3.getColumnas());

        System.out.println(m3);

        MatrizD m1 = new MatrizD( new double[][] { {1,2,3}, {4,5,6}, {7,8,9} } );
        System.out.println(m1);
        m1.borraColumna(1);
        System.out.println(m1); 
        MatrizD m1 = new MatrizD( new double[][] { {1,2,3}, {4,5,6}, {7,8,9} } );
        System.out.println(m1.I());

        MatrizD m2 = new MatrizD( new double[][] { {1, 2, 3}, {4, 5, 6} } );
    System.out.println( m2 );
    System.out.println( m2.T() ); 

    MatrizD m1 = new MatrizD( new double[][] { {1, 2, 3}, {4, 5, 6}});
    MatrizD m2 = new MatrizD( new double[][] { {1, 2, 3}, {1, 2, 3}});
    System.out.println(m1.menos(m2)); 

    MatrizD m1 = new MatrizD( new double[][] { {1, 2, 3}, {4, 5, 6} });
    System.out.println(m1.por(3)); 

    MatrizD m1 = new MatrizD( new double[][] { {1, 2, 3}, {4, 5, 6} } );
    MatrizD m2 = new MatrizD( new double[][] { {1, 2}, {3, 4}, {5, 6} } );
    System.out.println(m1.por(m2)); 
    
    MatrizD m1 = new MatrizD( new double[][] { {1, 2, 3}, {4, 5, 6} });
    MatrizD m2 = new MatrizD( new double[][] { {1, 2, 3}, {1, 2, 3} });
    System.out.println(m1.por1a1(m2)); 
    
    MatrizD m1 = new MatrizD( new double[][] { {1, 2, 3}, {4, 5, 6} });
    System.out.println(m1);
    System.out.println("media = " + m1.media(1));
    System.out.println("varianza = " + m1.varianza(1));
    System.out.println("Covarianza = " + m1.covar(0, 1)); */
    
    MatrizD m1 = new MatrizD( new double[][]{ {0,0,1}, {0,2,0}, {3,0,0} } );
    System.out.println(m1.invGJ());

    
    }
}
