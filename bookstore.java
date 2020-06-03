package bookstore;

import java.util.Scanner;

public class bookstore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Books b=new Books();
        Return R = new Return(b);
        Get R1=new Get(b);
        //System.out.println("请输入你想要借的书数");
       // R1.r1=in.nextInt();
        //System.out.println("请输入你想要还的书数");
       // R.r = in.nextInt();
        //启动线程
        Thread t1 = new Thread(R);
        Thread t2= new Thread(R1);
        t1.start();
        t2.start();
    }
}
