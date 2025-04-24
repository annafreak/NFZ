class Medicines {

    private String[] name;
    private double[] price;
    private double[] refund;

    public Medicines(String[] name, double[] price, double[] refund) {
        this.name = new String[name.length];
        this.price = price;
        this.refund = refund;

        for (int i = 0; i < name.length; i++) {

            this.name[i] = name[i].substring(0, 1).toUpperCase() + name[i].substring(1).toLowerCase();

        }


    }

    public double price(String medicine, boolean insured) {

        medicine = medicine.toUpperCase();
        for (int i = 0; i < name.length; i++) {
            if (medicine.equals(name[i])) {
                if (insured) {
                    return price[i] * (1 - refund[i]);

                } else {
                    return price[i];
                }
            }
        }

        return -1;

    }

    public String maxrefund() {
        double maxPrice = 0;
        int index = 0;
        for (int i = 0; i < name.length; i++) {
            double refundPrice = price[i] * refund[i];
            if (refundPrice > maxPrice) {
                maxPrice = refundPrice;
                index = i;
            }
        }
        return name[index];
    }

    public double totalCost() {
        double suma = 0;
        for (double c : price) {
            suma += c;
        }
        return suma;
    }

    public void wyswietl() {
        for (int i = 0; i < name.length; i++) {
            System.out.printf("%s – cena : %.2f zł, refundacja: %.2f (czyli %.0f%%)%n",
                    name[i], price[i], refund[i], refund[i] * 100);
        }
    }
}


public class Main {
    public static void main(String[] args) {
    String[] name = {"aspiryna", "ibuprofen", "paracetamol",};
    double[] price ={4.5, 23.2, 13.0};
    double[] refund ={0.3, 0.1, 0.2};
    Medicines medicine = new Medicines(name, price, refund);
    System.out.println(medicine.maxrefund());
    System.out.println(medicine.totalCost());
    medicine.wyswietl();
    double price1 = medicine.price("ibuprofen",true);
    System.out.println("cena ibuprofenu dla ubezpieczonego to "+ price1);
    double price2 = medicine.price("paracetamol",false);
    String maxRefund = medicine.maxrefund();
    System.out.println("leki z najwieksza refundacja piueniedzy" + maxRefund);
    double totalCost = medicine.totalCost();
        System.out.println("calkowity koszt wszystkich lekow : " + totalCost + "zł");



    }
}