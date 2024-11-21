public class Main {
    public static void check1(short[] w, double[] x, double[][] z) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 19; j++) {
                switch (w[i]) {
                    case 24:
                        z[i][j] = Math.atan(Math.cos(Math.pow((1.0 / 4.0) / (0.25 - Math.pow(Math.E, x[j])), x[j] * (x[j] - 1.0 / 3.0))));
                        break;
                    case 4, 8, 10, 14, 16, 18:
                        z[i][j] = Math.pow(x[j] * (x[j] + 1.0 / 4.0) - 1, 3) * (Math.pow(Math.cos(x[j]), (Math.pow(x[j], x[j] * (1.0 / 2.0 + x[j]))) / 2.0) + 1);
                        break;
                    default:
                        z[i][j] = Math.pow(x[j] - (0.25 / 2.0) / (3.0 / 4.0), 3);
                        break;
                }
            }
        }
    }

    public static void check2(short[] w, double[] x, double[][] z) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 19; j++) {
                switch (w[i]) {
                    case 24 ->
                            z[i][j] = Math.atan(Math.cos(Math.pow((1.0 / 4.0) / (0.25 - Math.pow(Math.E, x[j])), x[j] * (x[j] - 1.0 / 3.0))));
                    case 4, 8, 10, 14, 16, 18 ->
                            z[i][j] = Math.pow(x[j] * (x[j] + 1.0 / 4.0) - 1, 3) * (Math.pow(Math.cos(x[j]), (Math.pow(x[j], x[j] * (1.0 / 2.0 + x[j]))) / 2.0) + 1);
                    default -> z[i][j] = Math.pow(x[j] - (0.25 / 2.0) / (3.0 / 4.0), 3);
                }
            }
        }
    }

    public static void beautifulOutput(double[][] z) {
        for (double[] j : z) {
            for (double i : j) {
                System.out.printf("%11.3f", i);
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        // Подсчёт массива w
        short[] w;
        w = new short[(24 - 2) / 2 + 1];
        int p = 0;
        for (short i = 24; i >= 2; i -= 2) {
            w[p] = i;
            p++;
        }
        // Подсчёт массива x
        double[] x;
        x = new double[19];
        for (int i = 0; i < 19; i++) {
            x[i] = Math.random() * 11 - 6.0;
        }
        // Подсчёт массива z
        double[][] z = new double[12][19];
        double[][] z1 = new double[12][19];
        // Решение + вывод
        check1(w, x, z);
        beautifulOutput(z);
        check2(w, x, z1);
        System.out.println("\n\n");
        beautifulOutput(z1);
    }
}
