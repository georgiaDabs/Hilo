import java.util.Scanner;
public class GameManager
{
    private int total;
    private int plays;
    private int range;
    ComputerPlayer pc;
    Game userGame;
    private int pcScore;
    private int userScore;
    private int pcTotal=0;
    private int userTotal=0;
    private int userRange=0;
    private int pcRange=0;
    Scanner sc = new Scanner(System.in); 
    
    public void intro(){
        System.out.println("what would you like the range to be");
        range=sc.nextInt();
        userRange=range;
        pcRange=range;
    }

    public GameManager(){
        System.out.println("what would you like the range to be");
        range=sc.nextInt();
        userRange=range;
        pcRange=range;
    }

    public void play(){
        userGame=new Game(userRange);
        plays++;
        userGame.play();
        total+=userGame.getCount();
        System.out.println("you scored "+userGame.getCount()+" the average is " +total/plays);
    }

    public void playPC(){
        pc =new ComputerPlayer(pcRange);
        pc.playGame();
        System.out.println("PC got number after "+pc.getCount()+" goes");
    }

    public void compete(){
        playPC();
        play();
        pcScore=pc.getCount();
        userScore=userGame.getCount();
        if(pcScore==userScore){
            System.out.println("game is drawn");
        }else if(pcScore<userScore){
            System.out.println("pc won");
            pcTotal++;
        }else{
            System.out.println("user won");
            userTotal++;
        }

    }

    public void startGame(){
        System.out.println("to finish game enter -1");
        while(sc.nextInt()!=-1){
            compete();
            System.out.println(pcTotal+" to Computer "+userTotal +" to user");
            System.out.println("to finish game enter -1");
            if((pcTotal-userTotal)>1){
                System.out.println("pc more than one ahead making pcGame harder....");
                pcRange=pcRange/2;
            }else if((userTotal-pcTotal)>1){
                System.out.println("user more than one ahead making userGame harder....");
                userRange=userRange*2;
            }
        } 
    }

}
