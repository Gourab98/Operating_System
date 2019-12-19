package Thread_2;

public class ThreadSyn {
       public static int mutex, balance;
       public static void main(String[] args) {
        mutex = 0;
        balance =10000;
     
        Bank ac1=new Bank(1);
        Bank ac2=new Bank(2);
        
        ac1.start();
        ac2.start();
    }
}
