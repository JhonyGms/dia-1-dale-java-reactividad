public class test {
    public static class CuentaBancaria {
        private double saldo;

        public CuentaBancaria(double saldoInicial) {
            this.saldo = saldoInicial;
        }

        public void realizarTransaccion(double cantidad) {
            double nuevoSaldo = saldo + cantidad;
            saldo = nuevoSaldo;
        }

        public double obtenerSaldo() {
            return saldo;
        }
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000);

        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cuenta.realizarTransaccion(10);
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cuenta.realizarTransaccion(-10);
            }
        });

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + cuenta.obtenerSaldo());
    }
}
