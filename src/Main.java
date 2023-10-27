public class Main implements Runnable {

    int contador = 0;

    public void incrementarContador() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contador++;
    }

    public int obtenerContador() {
        return contador;
    }

    @Override
    public void run() {
        incrementarContador();
        System.out.println("Valor luego de incrementar el " + Thread.currentThread().getName() + ": " + obtenerContador());
    }

    public static void main(String[] args) {
        Main contador = new Main();
        Thread hilo1 = new Thread(contador, "primer hilo");
        Thread hilo2 = new Thread(contador, "segundo hilo");
        Thread hilo3 = new Thread(contador, "tercer hilo");

        //La llamada a start() hace que se ejecute el método run
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
