/**
 * <h0>Clase Matriz</h0>
 * @author <h1>Chema_Fernández</h1>
 * 
 * <h2>Clase para construir matrices y poder realizar diferentes operaciones con ellas.</h2>
 * 
 * @see <h2>StringBuilder</h2>
 * Usada para sobreescribir el método toString.
 * @see <h2>Arrays</h2>
 * Se usa para copiar arrays dentro de algunos métodos.
 * */
package dam.net.jmfm.ejercicio2;

import java.lang.StringBuilder;
import java.util.Arrays;
/**
 * 
 * @author Chema_Fernández
 *
 */
public class MatrizD {
    private final double precision = 0.00009;
    private double[][] numeros_clase;
    private boolean datosCambiados;
    private double determinante;


    public MatrizD(int filas, int columnas){
        this.numeros_clase = new double[filas][columnas];

    }
    /**
     * CONSTRUCTOR DE OBJETOS DE LA CLASE MATRIZ PERMITE GENERAR OBJETOS DE LA CLASE MatrizD
     * @param numeros
     * @throws IllegalArgumentException si la matriz no es simétrica
     * */
    public MatrizD(double[]...numeros) throws IllegalArgumentException{
        this.numeros_clase = Arrays.copyOf(numeros, numeros.length);
        int filas = numeros_clase.length;
        int columnas = numeros_clase[0].length;
        int cont_colum = 0;
        boolean astimetrica = false;
        
        for(int i = 0; i < numeros.length; i++){
            for(int k = 0; k < numeros_clase[i].length;k++){
                cont_colum = numeros_clase[i].length;
            }
            if(columnas != cont_colum){
                astimetrica = true;
                if(astimetrica == true) throw new IllegalArgumentException("LA MATRIZ NO ES SIMÉTRICA");
            }
        }
    }
    /**
     * DEVUELVE EL ARRAY DE LA MATRIZ
     * @return Devuelve un array bidimensional con el array de la matriz
     */
    protected double[][] getTabla(){
        return numeros_clase;
    }
    /**
     * DEVUELVE EL NÚMERO DE FILAS DE LA MATRIZ
     * @return Devuelve el número de filas de la matriz
     */
    public int getFilas(){
        return numeros_clase.length;
    }
    /**
     * DEVUELVE EL NÚMERO DE COLUMNAS DE LA MATRIZ
     * @return Devuelve el número de columnas de la matriz
     */
    public int getColumnas(){
        if(numeros_clase[0] == null) return 0;
        return numeros_clase[0].length;
    }
    /**
     *OBTIENE UN DATO EN UNA POSICIÓN DE LA MATRIZ
     * @param f 
     * Se proporciona el número de fila
     * @param c 
     * Se proporciona el número de columna
     * @return Devuelve un valor de tipo double con el valor almacenado en la fila 
     * y columna dados como parámetro
     * @throws IndexOutOfBoundsException Si la fila o la columna están fuera de rango, lanza 
     * la excepción argumento ilegal avisando del error.
     */
    public double getDato(int f, int c){
        if(f > numeros_clase.length | c > numeros_clase[0].length) {
            throw new IndexOutOfBoundsException("LA FILA O LA COLUMNA ESTÁN FUERA DE RANGO");
        }
        return numeros_clase[c][f];
    }
    /**
     * CAMBIA UN DATO EN UNA POSICIÓN DE LA MATRIZ
     * @param f 
     * Se proporciona el número de fila
     * @param c 
     * Se proporciona el número de columna
     * @param valor
     * Cambia el valor de una posición de la matriz
     */
    public void setDato(int f, int c, double valor){
        numeros_clase[f][c] = valor;
        this.datosCambiados = true;
    }
    /**
     * DEVUELVE LOS VALORES DE UNA FILA
     * @param f 
     * Posición de fila
     * @return Devuelve un array simple con los valores de una fila
     */
    double[] getFila(int f){
        double[] fila = new double[numeros_clase[f].length];
        for(int i = f; i < f+1; i++){
            for(int j = 0; j < numeros_clase[f].length; j++){
                fila[j] = numeros_clase[i][j];
            }
        }
        return fila;
    }
    /**
     * DEVUELVE LOS VALORES DE UNA COLUMNA
     * @param c 
     * Posición de columna 
     * @return Devuelve un array simple con los valores de una columna
     */
    double[] getColumna(int c){
        double[] columna = new double[numeros_clase[c].length];
        for(int i=0; i<columna.length; i++){
            for(int j = c; j < c+1; j++){
                columna[i] = numeros_clase[i][j];
            }
        }
        return columna;
    }
    /**
     * 
     * @param pos 
     * Posición donde se inserta la fila.
     * @param v 
     * Array simple con los valores de la fila.
     * @throws IllegalArgumentException Si la fila dada está fuera de rango, lanza la excepción argumento 
     * ilegal "Dimensiones incompatibles".
     */
    void insertaFila(int pos, double[] v){
        
        if(v == null | v.length > this.numeros_clase.length){
            throw new IllegalArgumentException("DIMENSIONES INCOMPATIBLES");
        }

        if(pos < 0 | pos > this.numeros_clase.length) pos = this.numeros_clase.length;
        
        //Copia exacta del array de la clase con un espacio mas.
        
        double[][] numeros_clase_copia = new double[getFilas()+1][numeros_clase[0].length];
        System.out.println(numeros_clase[0].length);
        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < this.numeros_clase[0].length;j++){
            	if(i >= pos) {
            		numeros_clase_copia[i+1][j] = this.numeros_clase[i][j];
            	}else {
            		numeros_clase_copia[i][j] = this.numeros_clase[i][j];
                  //numeros_clase_copia[i][j] = this.numeros_clase[i][j];
            	}
                
            }
        }
        
        for(int i = 0; i < v.length; i++) {
        	for(int j = 0; j < v.length; j++) {
        		numeros_clase_copia[pos][j] = v[j];
        	}
        }
        this.datosCambiados = true;
        this.numeros_clase = Arrays.copyOf(numeros_clase_copia, numeros_clase_copia.length);
    }

    /**
     * 
     * @param pos 
     * Posición donde se inserta la fila.
     * @param v 
     * Array simple con los valores de la fila.
     * @throws IllegalArgumentException Si la columna dada está fuera de rango, lanza 
     * la excepción argumento ilegal "Dimensiones incompatibles".
     */
    void insertaColumna(int pos, double[] v){
        if(v == null | v.length > this.numeros_clase[0].length){
            throw new IllegalArgumentException("DIMENSIONES INCOMPATIBLES");
        }

        if(pos < 0 | pos > this.numeros_clase.length) pos = this.numeros_clase.length;
        
        /**
         * Copia exacta del array de la clase con un espacio mas.
         */
        double[][] numeros_clase_copia = new double[this.numeros_clase.length][getColumnas()+1];
        for(int i = 0; i < this.numeros_clase.length; i++){
            for(int j = 0; j < getColumnas();j++){
                
            	if(j >= pos) {
            		numeros_clase_copia[i][j+1] = this.numeros_clase[i][j];
            	}else {
            		numeros_clase_copia[i][j] = this.numeros_clase[i][j];
                    
            	}
                
            }
        }

        for(int i = 0; i < v.length; i++) {
        	for(int j = 0; j < v.length; j++) {
        		numeros_clase_copia[i][pos] = v[i];
        	}
        }
        this.datosCambiados = true;
        this.numeros_clase = Arrays.copyOf(numeros_clase_copia, numeros_clase_copia.length);
    }
    /**
     * 
     * @param pos
     * Posición de la fila que se va a borrar
     * @return Devuelve un array simple con los valores guardados en la fila borrada
     */
    double[] borraFila(int pos){
        double[] fila = new double[this.numeros_clase[0].length];

        double[][] copia = new double[getFilas()-1][getColumnas()];

        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                if(i == pos && i < this.numeros_clase.length-1){
                    copia[i][j] = this.numeros_clase[i+1][j];
                    for(int k = 0; k < fila.length; k++){
                        fila[k] = this.numeros_clase[pos][k];
                    }
                }
                else if(i < pos){
                    copia[i][j] = this.numeros_clase[i][j];
                }
                else if(i > pos && i < this.numeros_clase.length-1){
                    copia[i][j] = this.numeros_clase[i+1][j];
                }
                
            }
        }
        this.datosCambiados = true;
        this.numeros_clase = copia;
        return fila;
    }
    /**
     * 
     * @param pos
     * Posición de la columna a borrar
     * @return Devuelve un array con los valores de la columna borrada
     */
    double[] borraColumna(int pos){
        double[] columna = new double[this.numeros_clase[0].length];
        double[][] copia = new double[getFilas()][getColumnas()-1];

        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                if(j == pos && j < this.numeros_clase.length-1){
                    copia[i][j] = this.numeros_clase[i][j+1];
                    
                    for(int k = 0; k < columna.length; k++){
                        columna[k] = this.numeros_clase[pos][k];
                    }
                }
                else if(j < pos){
                    copia[i][j] = this.numeros_clase[i][j];
                }
                else if(j > pos && j < this.numeros_clase.length-1){
                    copia[i][j] = this.numeros_clase[i][j+1];
                }
                
            }
        }
        this.datosCambiados = true;
        this.numeros_clase = copia;
        return columna;
    }
    /**
     * OPERACIONES BÁSICAS
     * @return I
     * DEvuelve la matriz identidad de la matriz actual
     * @throws IllegalStateException Si las dimensiones (filas y columnas) no coinciden, lanza 
     * la excepción argumento ilegal "No es cuadrada".
     */
    public MatrizD I(){
    	if(this.getFilas() != this.getColumnas()) {
    		throw new IllegalStateException("NO ES CUADRADA");
    	}
        double[][] copia = new double[getFilas()][getColumnas()];
        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                if( i == j) copia[i][j] = 1;
                else copia[i][j] = 0;
            }
        }
        MatrizD identidad = new MatrizD(copia);
        
        return identidad;
    }
    /**
     * MATRIZ TRANSPUESTA
     * @return T
     * Devuelve la matriz transpuesta de la actual
     */
    public MatrizD T(){
        double[][] copia = new double[getColumnas()][getFilas()];
        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                copia[j][i] = this.numeros_clase[i][j];
            }
        }
        MatrizD transpuesta = new MatrizD(copia);
        return transpuesta;
    }
    /**
     * SUMA DE MATRICES
     * @param matriz
     * Como parámetro se pasa la matriz  a la que se va a sumar a la actual
     * @return Una nueva matriz con la suma de ambas matrices
     * @throws IllegalArgumentException Si las dimensiones (filas y columnas) de ambas no coinciden, lanza 
     * la excepción argumento ilegal "Dimensión incompatible".
     */
    public MatrizD mas(MatrizD matriz){
    	if(getFilas() != matriz.getFilas() | getColumnas() != matriz.getColumnas()) {
    		throw new IllegalArgumentException("DIMENSION INCOMPATIBLE.");
    	}
        double[][] m3 = new double[getFilas()][getColumnas()];
        double[][] m2 = matriz.getTabla();

        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                m3[i][j] = this.numeros_clase[i][j] + m2[i][j];
            }
        }

        MatrizD sumada = new MatrizD(m3);
        this.datosCambiados = true;
        return sumada;
    }
    /**
     * RESTA DE MATRICES
     * @param matriz
     * Se pasa como parámetro la matriz que se va a sumar
     * @return Devuelve una matriz con los valores de la resta de ambas matrices.
     * @throws IllegalArgumentException Si las dimensiones (filas y columnas) de ambas no coinciden, lanza 
     * la excepción argumento ilegal "Dimensión incompatible".
     */
    public MatrizD menos(MatrizD matriz){
    	if(getFilas() != matriz.getFilas() | getColumnas() != matriz.getColumnas()) {
    		throw new IllegalArgumentException("DIMENSION INCOMPATIBLE.");
    	}
        double[][] m3 = new double[getFilas()][getColumnas()];
        double[][] m2 = matriz.getTabla();

        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                m3[i][j] = this.numeros_clase[i][j] - m2[i][j];
            }
        }

        MatrizD restada = new MatrizD(m3);
        this.datosCambiados = true;
        return restada;
    }
    /**
     * MULTIPLICAR VALORES DE UNA MATRIZ POR UN ESCALAR
     * @param d
     * Valor de tipo double con el escalar que se va a multiplicar los valores de la matriz
     * @return Devuelve la matriz con sus valores multiplicados por el escalar
     */
    public MatrizD por(double d){
        double[][] m2 = new double[getFilas()][getColumnas()];
        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                m2[i][j] = this.numeros_clase[i][j] * d;
            }
        }
        MatrizD mult_escalar = new MatrizD(m2);
        this.datosCambiados = true;
        return mult_escalar;
    }
    /**
     * MULTIPLICACIÓN DE MATRICES DE MATRICES
     * @param matriz que es pasada para multiplicar por la actual
     * @return Devuelve una nueva matriz con el resultado de la multiplicación de ambas matrices
     * @throws IllegalArgumentException Si las dimensiones (filas y columnas) de ambas no coinciden, lanza 
     * la excepción argumento ilegal "Dimensión incompatible".
     */
    public MatrizD por(MatrizD matriz){
        if(matriz == null | matriz.getFilas() != getColumnas()){
            throw new IllegalArgumentException("DIMENSION INCOMPATIBLE.");
        }

        double[][] m2 = matriz.getTabla();
        double[][] m3 = new double[getFilas()][matriz.getColumnas()];

        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < matriz.getColumnas(); j++){
                for(int k = 0; k < getColumnas(); k++){
                    m3[i][j] += this.numeros_clase[i][k] * m2[k][j]; 
                }
            }
        }
        MatrizD mult_matriz = new MatrizD(m3);
        this.datosCambiados = true;
        return mult_matriz;
    }
    /**
     * MULTIPLICACIÓN 1 A 1 DE LOS VALORES DE 2 MATRICES
     * @param matriz
     * Matriz de la cual se van a extraer los valores
     * @return Matriz con el resultado de la multiplicación 1 a 1 de los 
     * valores de ambas matrices
     * @throws IllegalArgumentException Si las dimensiones (filas y columnas) de ambas no coinciden, lanza 
     * la excepción argumento ilegal "Dimensión incompatible".
     */
    public MatrizD por1a1(MatrizD matriz){
        if(getFilas() != matriz.getFilas() | getColumnas() != matriz.getColumnas()){
            throw new IllegalArgumentException("DIMENSIÓN INCOMPATIBLE");
        }
        double[][] m2 = matriz.getTabla();
        double[][] m3 = new double[getFilas()][getColumnas()];

        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                m3[i][j] = this.numeros_clase[i][j] * m2[i][j];
            }
        }

        MatrizD mult_1a1 = new MatrizD(m3);
        this.datosCambiados = true;
        return mult_1a1;
    }
    /**
     *MÉTODOS DE OPERACIONES ESTADÍSTICAS
     * CÁLCULO DE LA MEDIA DE LOS VALORES DE UNA COLUMNA
     * @param x
     * Valor de la columna donde se va a operar
     * @return Valor de la media
     */
    double media(int x){
        double media = 0;
        for(int f = 0; f < getFilas(); f++){
            media += this.numeros_clase[f][x];
        }
        return media/getFilas();
    }
    /**
     * CÁLCULO DE LA VARIANZA DE LOS VALORES DE UNA COLUMNA
     * @param x
     * Valor de la columna donde se va a operar
     * @return Valor de la varianza
     */
    double varianza(int x){
        double varianza = 0;
        for(int f = 0; f < getFilas(); f++){
            varianza += Math.pow(this.numeros_clase[f][x]-media(x), 2);
        }
        return varianza/getFilas();
    }
    /**
     * CÁLCULO DE LA VARIANZA DE LOS VALORES DE 2 COLUMNAS
     * @param x
     * Valor de la primera columna
     * @param y
     * Valor de la segunda columna
     * @return Valor de la covarianza de los valores de 2 columnas
     */
    double covar(int x, int y){
        double covar = 0;
        for(int f = 0; f < getFilas(); f++){
            covar += (this.numeros_clase[f][x]- media(x)) * (this.numeros_clase[f][y]- media(y));
        }
        return covar/getFilas();
    }
    /**
     *DEVUELVE UNA NUEVA MATRIZ CON LA COLUMNA Y LA FILA PASADAS POR PARÁMETROS BORRADAS.
     *
     * @param pf
     * Parámetro con el número de la fila a borrar.
     * @param pc
     * Parámetro con el número de la columna a borrar.
     * @return Devuelve una nueva matriz con la fila y la columna pasadas por 
     * parámetros borradas
     */
    MatrizD cofactor(int pf, int pc){
        MatrizD cofactor = new MatrizD(this.numeros_clase);
        cofactor.borraColumna(pc);
        cofactor.borraFila(pf);
        return cofactor;
    }
    /**
     * CÁLCULO DEL DETERMINANTE SEGÚN LA REGLA DE LAPLACE
     * 
     * @return Devuelve el determinante de la matriz.
     * @throws IllegalStateException Si el número de filas no coincide con el número de columnas 
     * (cuadrada) lanza una excepción
     */
    double det(){
        if(getFilas() != getColumnas()) throw new IllegalStateException("NO ES CUADRADA");
        //if(this.datosCambiados == false) return this.determinante;

        if(getFilas() == 1 && getColumnas() == 1){
            determinante = this.numeros_clase[0][0];
        }
        else if(getFilas() == 2 && getColumnas() == 2){
            determinante = this.numeros_clase[0][0] * this.numeros_clase[1][1] - this.numeros_clase[0][1] * this.numeros_clase[1][0];
        }else{
            for(int i = 0; i < getFilas(); i++){
                for(int j = 0; j < getColumnas(); j++){
                    MatrizD copia = new MatrizD(this.numeros_clase);
                    copia.borraFila(i); copia.borraColumna(j);
                    this.determinante += this.numeros_clase[i][j] * (Math.pow(-1, i+j)) * copia.det();
                }
            }
        }

        return this.determinante;
    }
    /**
     * CÁLCULO DE LA MATRIZ ADJUNTA
     * 
     * @return Devuelve la matriz adjunta
     * devuelve una nueva matriz C donde cada elemento C[i][j] es el
     * determinante de la matriz cofactor(i,j) multiplicada por -1 
     * elevado a la suma de i y j.
     */
    MatrizD adj(){
        double[][] copia = new double[getFilas()][getColumnas()];
        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                copia[i][j] = Math.pow(-1, i+j) * this.cofactor(i, j).det(); 
            }
        }
        MatrizD matriz = new MatrizD(copia);
        return matriz;
    }
    /**
     * CÁLCULO DE LA MATRIZ INVERSA
     * 
     * @return Devuelve la matriz inversa
     * Es un método para calcular la inversa (A -1) de la matriz this 
     * (que llamamos A en las fórmulas) que se basa en usar su determinante |A|.
     * Si el número de filas no coincide con el número de columnas (cuadrada)
     * lanza una excepción
     */
    MatrizD invDet(){
        double det = det();
        if(getFilas() != getColumnas()) {
            throw new IllegalStateException("NO ES CUADRADA");
        }
        return adj().T().por(1/det);
        

    }
    /**
     * CÁLCULO DE LA MATRIZ INVERSA USANDO EL MÉTODO DE GAUSS-JORDAN
     * 
     * @return Devuelve la matriz inversa
     * Este método calcula la inversa (A^-1 de la matriz 
     * actual (A) utilizando el método de Gauss-Jordan.
     */
    MatrizD invGJ(){
        /**
         * Se fusionan la matriz principal con su matriz identidad
         */
        MatrizD identidad = I();
        double[][] copia = getTabla();
        double[][] ident = identidad.getTabla();
        double[][] array_final = new double [getFilas()][getColumnas()*2];

        for(int i = 0; i < getFilas(); i++){
            for(int j = 0; j < getColumnas(); j++){
                array_final[i][j] = copia[i][j];
                array_final[i][j+getColumnas()] = ident[i][j];     
            }
        }
        MatrizD mfinal = new MatrizD(array_final);
        //Lógica de la función
        for(int p = 1; p < mfinal.getFilas(); p++){
            if(this.numeros_clase[p][p] == 0){
                
                for(int i = p+1; i < mfinal.getFilas(); i++){
                    if(array_final[i][p] == 0){
                        throw new IllegalStateException("NO TIENE INVERSA");   
                    }
                    
                    double[] cambio_1 = mfinal.borraFila(p);
                    double[] cambio_2 = mfinal.borraFila(i);
                    mfinal.insertaFila(p, cambio_2);
                    mfinal.insertaFila(i, cambio_1);
                }
            }
        }
        return mfinal;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        double columnas = numeros_clase[0].length;
        for(int i = 0; i < numeros_clase.length;i++){
            sb.append("|");
            for(int j = 0; j < columnas; j++){
                sb.append(numeros_clase[i][j] + "\t");
            }
            sb.append("\b\b\b\b\b"+"|");
            sb.append("\n");
        }
        return sb.toString();
        
    }

}    
