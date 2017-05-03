import java.util.ArrayList;

/**
 * Created by johnkrawulski on 4/13/17.
 */
public class BaseballGame extends BaseballUtility {


    int atBat = 0;
    String batType = null;
    int homeBatCounter=0;
    int visitBatCounter=0;
    private static int nextBatterHome=0;
    private static int nextBatterVisit=0;
    int runsHomeTotal=0;
    int runsVisTotal=0;

    //Not req'd because of inheritance, used to show instantiation
    BaseballUtility bbUtil = new BaseballUtility();
    int inning=1;

    // code for Home team inning at bat
    public void generateHomeHalfInning() {
        //clear bases, reset outs, set next batter
        bbUtil.clearBases();
        int out = 0;
        homeBatCounter=nextBatterHome;

        //at bat based on random number generator
        while (out<3){
            atBat = randomNumber();
                    if (atBat < 71) {
                        batType = "Out";
                        out = out + 1;
                    } else if (atBat > 70 && atBat < 88) {
                        batType = "Single";
                    } else if (atBat > 87 && atBat < 95) {
                        batType = "Double";
                    } else if (atBat > 94 && atBat < 97) {
                        batType = "Triple";
                    } else
                        batType = "Home Run";

                    evalBasesHome(batType);
                    System.out.println(rosterB[homeBatCounter]+" At bat was a "+ batType);
                    homeBatCounter=homeBatCounter+1;
                    if (homeBatCounter>8){
                        homeBatCounter=0;
                    }

            }

        System.out.println("Inning runs = "+runsHome);
        runsHomeTotal = runsHomeTotal+runsHome;
        System.out.println("Home team total runs = "+runsHomeTotal);
        printFormat();
        nextBatterHome=homeBatCounter;
        runsHome=0;

    }

    // code for Visitor team inning at bat
    public void generateVisitorHalfInning() {
        //clear bases, reset outs, set next batter
        bbUtil.clearBases();
        int out = 0;
        visitBatCounter=nextBatterVisit;

        //Print inning header
        System.out.println("This is inning number "+inning);
        printFormat();

        //at bat based on random number generator
        while (out<3){
            atBat = randomNumber();
            if (atBat < 71) {
                batType = "Out";
                out = out + 1;
            } else if (atBat > 70 && atBat < 88) {
                batType = "Single";
            } else if (atBat > 87 && atBat < 95) {
                batType = "Double";
            } else if (atBat > 94 && atBat < 97) {
                batType = "Triple";
            } else
                batType = "Home Run";
            evalBasesVis(batType);
            System.out.println(rosterA[visitBatCounter]+" At bat was a "+ batType);
            visitBatCounter=visitBatCounter+1;
            if (visitBatCounter>8){
                visitBatCounter=0;
            }

        }

        System.out.println("Inning runs = "+runsVis);
        runsVisTotal = runsVisTotal+runsVis;
        System.out.println("Visitor team total runs = "+runsVisTotal);
        printFormat();
        nextBatterVisit=visitBatCounter;
        runsVis=0;
        inning=inning+1;


    }
//code to start game
    public void generateGame(){
        generateVisitorHalfInning();
        generateHomeHalfInning();

    }

}













