package co.edu.uniquindio.poo.servicios;

public class ReglasPuntos {

    // Puntos que gana un cliente por una transacción
    public static int calcularPuntos(String tipo, double monto) {
        int bloques = (int) (monto / 100); // cada 100 unidades = 1 bloque

        switch (tipo.toUpperCase()) {
            case "DEPOSITO":      return bloques * 1;
            case "RETIRO":        return bloques * 2;
            case "TRANSFERENCIA": return bloques * 3;
            default:              return 0;
        }
    }

    // Rango según los puntos acumulados
    public static String calcularRango(int puntos) {
        if (puntos <= 500)  return "Bronce";
        if (puntos <= 1000) return "Plata";
        if (puntos <= 5000) return "Oro";
        return "Platino";
    }
}