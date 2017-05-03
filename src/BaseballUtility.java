import java.util.Objects;

/**
 * Created by johnkrawulski on 4/13/17.
 */
public class BaseballUtility {

    int number;
    private String teamAName;
    private String teamBName;
    String[] rosterA = {"Doug1", "Aaron2", "Dean3", "Evan4", "Allen5", "Danny6", "Jim7", "Jeff8", "Richard9"};
    String[] rosterB = {"Frank1", "Miquel2", "Juan3", "Chris4", "Pete5", "Mike6", "Eric7", "Andrew8", "Clint9"};
    static int[] bases = {0,0,0};
    int runsVis=0;
    int runsHome=0;



    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String team2Name) {
        this.teamBName = team2Name;
    }



    // Generation of random number to determine batting result
    public int randomNumber() {
        number = (int) ((Math.random() * 100) + 1);
        //System.out.println(number);
        return number;
    }

    // Printing of Team Names
    public void printTeamOverview() {

        System.out.println(teamAName + " vs " + teamBName);
        System.out.println("**************************************");

    }

    //Printing of Rosters
    public void printRosterAVis() {
        System.out.println(teamAName+" Roster");
        System.out.println("**************************************");
        for (int i = 0; i < rosterA.length; i++)
            System.out.println(rosterA[i]);
        System.out.println("**************************************");

    }

    public void printRosterBHome() {
        System.out.println(teamBName+" Roster");
        System.out.println("**************************************");
        for (int i = 0; i < rosterB.length; i++)
            System.out.println(rosterB[i]);
        System.out.println("**************************************");

    }

    public void printFormat(){
        System.out.println("**************************************");
    }


    //code to advance base runners for Home team based on type of hit
    public int evalBasesHome(String bat) {

        //commented out code to use for debugging evaulation of bases with hits
        //for(int t=0; t<bases.length;t++)
        //System.out.println(bases[t]);

        if (Objects.equals(bat, "Single")) {

                if (bases[2] == 1) {
                    runsHome = runsHome + 1;
                    bases[2] = 0;
                }
                if (bases[1] == 1) {
                    bases[1] = 0;
                    bases[2] = 1;

                }
                if (bases[0] == 1) {
                    bases[1] = 1;
                }
                    bases[0]=1;

        }

        if (Objects.equals(bat, "Double")) {
            if (bases[2] == 1) {
                runsHome = runsHome + 1;
                bases[2] = 0;
            }
            if (bases[1] == 1) {
               runsHome = runsHome + 1;

            }
            if (bases[0] == 1) {
                bases[2] = 1;
                bases[1] = 1;
                bases[0] = 0;
            }
                bases[1]=1;
        }

        if (Objects.equals(bat, "Triple")) {
            if (bases[2] == 1) {
                runsHome = runsHome + 1;
                bases[2] = 1;
            }
            if (bases[1] == 1) {
                runsHome = runsHome + 1;
                bases[1] = 0;

            }
            if (bases[0] == 1) {
                runsHome = runsHome + 1;
                bases[0] = 0;
            }
                bases[2]=1;

        }

        if (Objects.equals(bat, "Home Run")) {
            if (bases[2] == 1) {
                runsHome = runsHome + 1;
                bases[2] = 0;
            }
            if (bases[1] == 1) {
                runsHome = runsHome + 1;
                bases[1] = 0;

            }
            if (bases[0] == 1) {
                runsHome = runsHome + 1;
                bases[0] = 0;
            }
            runsHome = runsHome + 1;

        }
            return runsHome;

    }

    //code to advance base runners for Visitor team based on type of hit
    public int evalBasesVis(String bat) {

        //commented out code to use for debugging evaulation of bases with hits
        //for(int t=0; t<bases.length;t++)
        //    System.out.println(bases[t]);

        if (Objects.equals(bat, "Single")) {

            if (bases[2] == 1) {
                runsVis = runsVis + 1;
                bases[2] = 0;
            }
            if (bases[1] == 1) {
                bases[1] = 0;
                bases[2] = 1;

            }
            if (bases[0] == 1) {
                bases[1] = 1;
            }
            bases[0]=1;

        }

        if (Objects.equals(bat, "Double")) {
            if (bases[2] == 1) {
                runsVis = runsVis + 1;
                bases[2] = 0;
            }
            if (bases[1] == 1) {
                runsVis = runsVis + 1;

            }
            if (bases[0] == 1) {
                bases[2] = 1;
                bases[1] = 1;
                bases[0] = 0;
            }
            bases[1]=1;
        }

        if (Objects.equals(bat, "Triple")) {
            if (bases[2] == 1) {
                runsVis = runsVis + 1;
                bases[2] = 1;
            }
            if (bases[1] == 1) {
                runsVis = runsVis + 1;
                bases[1] = 0;

            }
            if (bases[0] == 1) {
                runsVis = runsVis + 1;
                bases[0] = 0;
            }
            bases[2]=1;

        }

        if (Objects.equals(bat, "Home Run")) {
            if (bases[2] == 1) {
                runsVis = runsVis + 1;
                bases[2] = 0;
            }
            if (bases[1] == 1) {
                runsVis = runsVis + 1;
                bases[1] = 0;

            }
            if (bases[0] == 1) {
                runsVis = runsVis + 1;
                bases[0] = 0;
            }
            runsVis = runsVis + 1;

        }
        return runsVis;

    }
        //method to clear the bases
        public void clearBases(){
            for(int r=0;r<bases.length;r++)
            bases[r]=0;

        }

}








