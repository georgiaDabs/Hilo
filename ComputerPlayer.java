

public class ComputerPlayer
{
    // instance variables - replace the example below with your own
    private int range;
    private int guess;
    private int lowerBound;
    private int upperBound;
    public int count;
    /**
     * Constructor for objects of class ComputerPlayer
     */
    public ComputerPlayer(int range)
    {
        this.range=range;
        upperBound=range;
        lowerBound=0;
    }

    public void playGame(){
        Game game=new Game(range);
        while(game.makeGuess(makeGuess())!=true){
            if(game.getIsHigher()){
                lowerBound=guess;
            }else{
                upperBound=guess;
            }
            
        }
        count=game.getCount();
    }
    public void setRange(int r){
        range=r;
    }
    public int makeGuess(){
        range=upperBound-lowerBound;
        guess=(int)(Math.random() * range)+lowerBound;;
        System.out.println("pc guesses "+guess);
        return guess;
    }
    public int getCount(){
        return count;
    }
}
