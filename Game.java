import java.util.Scanner;
public class Game
{
    // instance variables - replace the example below with your own
    private int range;
    private int guess;
    private int target;
    private int count;
    private boolean isHigher;
    
    public Game(int range)
    {
        this.range=range;
        target = (int)(Math.random() * range);
    }

    public void play()
    {
        Scanner sc = new Scanner(System.in); 
        while(makeGuess(guess)!=true){
            System.out.println("Enter a guess from 0 to "+range+": ");
            guess=sc.nextInt();
            
        }
    }
    public void newTaregt(){
        target = (int)(Math.random() * range);
    }
    public boolean makeGuess(int x){
        if(x==target){
            System.out.println("correct");
            return true;
        }else{
            count++;
            if(x>target){
                System.out.println("lower");
                isHigher=false;
                return false;
            }else{
                System.out.println("higher");
                isHigher=true;
                return false;
            }
        }
    }
    public void setRange(int r){
        range=r;
    }
    public int getCount(){
        return count;
    }
    public boolean getIsHigher(){
        return isHigher;
    }
}
