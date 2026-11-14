package co.edu.uniquindio.poo.estructuras;

import co.edu.uniquindio.poo.servicios.ReglasPuntos;
import java.util.HashMap;

public class TablaPuntos {

    private HashMap<String, Integer> puntos = new HashMap<>();

    // Suma puntos a un cliente (lo crea si no existe)
    public void sumar(String idCliente, int cantidad) {
        puntos.put(idCliente, obtener(idCliente) + cantidad);
    }

    // Resta puntos (sirve para revertir una transacción)
    public void restar(String idCliente, int cantidad) {
        int nuevo = Math.max(0, obtener(idCliente) - cantidad);
        puntos.put(idCliente, nuevo);
    }

    // Devuelve los puntos de un cliente (0 si no existe)
    public int obtener(String idCliente) {
        return puntos.getOrDefault(idCliente, 0);
    }

    // Registra una transacción: calcula y suma sus puntos
    public int registrar(String idCliente, String tipo, double monto) {
        int ganados = ReglasPuntos.calcularPuntos(tipo, monto);
        sumar(idCliente, ganados);
        return ganados;
    }
}