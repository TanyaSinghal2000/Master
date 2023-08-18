import java.util.Scanner;

public class CarDetails {
    int price;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ans = 'y';
        while (ans == 'y') {
                    System.out.println("model : ");
                    String model = sc.next();
                    System.out.println("type : ");
                    String type = sc.next();
                    System.out.println("price : ");
                    int price = sc.nextInt();
                    System.out.println("insuranceType : ");
                    String insuranceType = sc.next();
                    int car = detailCar(type, insuranceType, price);

            System.out.println("Do you want to enter details of any car (y/n):");
            ans = sc.next().charAt(0);
        }
    }
    private static int detailCar(String type, String insuranceType, int price){
        switch (type) {
            case "Hatchback":
                if (insuranceType.equals("basic")) {
                    int basic = (price * 5) / 100;
                    System.out.println(basic);
                }
                if (insuranceType.equals("premium")) {
                    int premium = (price * 5) / 100 + (((price * 5) / 100) * 20) / 100;
                    System.out.println(premium);
                }
                break;
            case "Sedan":
                if (insuranceType.equals("basic")) {
                    int total = (price * 8) / 100;
                    System.out.println(total);
                }
                if (insuranceType.equals("premium")) {
                    int premium = (price * 8) / 100 + (((price * 8) / 100) * 20) / 100;
                    System.out.println(premium);
                }
                break;
            case "SUV":
                if (insuranceType.equals("basic")) {
                    int total = (price * 10) / 100;
                    System.out.println(total);
                }
                if (insuranceType.equals("premium")) {
                    int premium = (price * 10) / 100 + (((price * 10) / 100) * 20) / 100;
                    System.out.println(premium);
                }
                break;
        }
        return price;
    }
}