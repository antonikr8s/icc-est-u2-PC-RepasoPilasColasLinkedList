package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {

        Stack<Character> pila = new Stack<>();

        for (char c : texto.toCharArray()) {
            pila.push(c);
        }

        StringBuilder cadenaInvertida = new StringBuilder();
        while (!pila.isEmpty()) {
            cadenaInvertida.append(pila.pop());
        }

        return cadenaInvertida.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public static boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        Map<Character, Character> pares = new HashMap<>();

        pares.put(')', '(');
        pares.put(']', '[');
        pares.put('}', '{');

        for (char c : expresion.toCharArray()) {
            if (pares.containsValue(c)) {
                // apertura: (, [, {
                pila.push(c);
            } else if (pares.containsKey(c)) {
                // cierre: ), ], }
                if (pila.isEmpty() || pila.pop() != pares.get(c)) {
                    return false; // no esta balanceado {[()]}
                }
            }

        }

        return pila.isEmpty(); // esta vacia si esta balanceada
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public static List<Integer> ordenarPila(Stack<Integer> pila) {
        //creamos una pila vacia
        Stack<Integer> pilaAuxiliar = new Stack<>();

        //saca un elemento  de la pila original y busca donde colocarlo en la pila auxiliar
        while (!pila.isEmpty()) {
            int temp = pila.pop();

            // mueve elementos de pilaAuxiliar a pila original si son mayores que temp
            while (!pilaAuxiliar.isEmpty() && pilaAuxiliar.peek() > temp) {
                pila.push(pilaAuxiliar.pop());
            }

            // inserta temp en su lugar correcto
            pilaAuxiliar.push(temp);
        }

        // extrae los elementos ordenados desde la pila auxiliar hacia una lista
        List<Integer> resultadoOrdenado = new ArrayList<>();
        while (!pilaAuxiliar.isEmpty()) {
            resultadoOrdenado.add(pilaAuxiliar.pop());
        }

        return resultadoOrdenado;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public static LinkedList<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (Integer numero : original) {
            if (numero % 2 == 0) {
                pares.add(numero); // pares
            } else {
                impares.add(numero); // impares
            }
        }

        // combina las listas: primero pares | luego impares
        LinkedList<Integer> resultado = new LinkedList<>();
        resultado.addAll(pares);
        resultado.addAll(impares);

        return resultado;
    }

}
