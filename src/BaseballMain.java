/**
 * Created by johnkrawulski on 4/13/17.
 */
public class BaseballMain {
    public static void main(String[] args) {

        BaseballUtility utils = new BaseballUtility();

        BaseballGame teams = new BaseballGame();

        utils.setTeamAName("Braves");
        utils.setTeamBName("White Sox");
        utils.printTeamOverview();
        utils.printRosterAVis();
        utils.printRosterBHome();


        //Start 9 inning game
        int inning;
        for (inning = 0; inning < 9; inning++)
            teams.generateGame();
        System.out.println("End of No Extra Inning Game, "+ inning +" Innings");
        utils.printFormat();
        System.out.println(utils.getTeamAName()+" "+teams.runsVisTotal);
        System.out.println(utils.getTeamBName()+" "+teams.runsHomeTotal);

        while (teams.runsVisTotal==teams.runsHomeTotal) {
            inning = inning + 1;
            teams.generateGame();
            System.out.println("End of Extra Inning Game, " + inning + " Innings");
            utils.printFormat();
            System.out.println(utils.getTeamAName() + " " + teams.runsVisTotal);
            System.out.println(utils.getTeamBName() + " " + teams.runsHomeTotal);
        }

    }


}
