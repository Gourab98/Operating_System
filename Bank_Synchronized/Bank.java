package Thread_2;

public class Bank extends Thread {
    public int tNo;
    public Bank(int tNo){
        this.tNo=tNo;
    }
    
    public void run(){
        if(this.tNo==1){
            for(int i=0;i<5;i++){
                while(ThreadSyn.mutex==1){
                //wait    
                }
                ThreadSyn.mutex=1;
                opration();
            }
        }
        else {
            for(int i=0;i<5;i++){
                while(ThreadSyn.mutex==1){
                    //wait;
                }
                ThreadSyn.mutex =1;
                opration();
            }
        }
    }
    public synchronized void opration(){
        if(this.tNo==1){
            ThreadSyn.balance = ThreadSyn.balance + 1000;
            System.out.println("New balance is "+ ThreadSyn.balance + " for Thread "+ this.tNo);
            ThreadSyn.mutex=0;
        }
        else if(this.tNo==2){
            ThreadSyn.balance = ThreadSyn.balance - 1000;
            System.out.println("New balance is "+ ThreadSyn.balance + " for Thread "+ this.tNo);
            ThreadSyn.mutex=0;
        }
            
    }
    
}
