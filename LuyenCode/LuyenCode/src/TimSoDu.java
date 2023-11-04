import java.util.Scanner;

public class TimSoDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte number[] = new byte[2];
        number[0] = sc.nextByte();
        number[1] = sc.nextByte();
        System.out.println(number[0] + number[1]);
    }
}
