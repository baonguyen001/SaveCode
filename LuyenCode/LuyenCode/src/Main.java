import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, tong, hieu,tich;
        float thuong;
        a = scan.nextInt();
        b = scan.nextInt();

        tong = a + b;
        hieu = a - b;
        tich = a * b;

        System.out.println(tong);
        System.out.println(hieu);
        System.out.println(tich);


        if(b != 0){
            thuong = (float) (a*1.0 / b);
            System.out.printf("%.2f", thuong);
        }else{
            System.out.println("ERROR");
        }
    }
}