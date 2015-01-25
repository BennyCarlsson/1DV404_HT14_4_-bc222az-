import java.io.IOException;
import java.util.Arrays;


public class Contests {
	static final String[] contestList = new String[] {"contest1", "contest2", "contest3"};
	
	public void registerTeamToContest(String team, String contest) throws IOException{
		if(checkIfContestExist(contest) && checkIfTeamIsRegistered(team)){
			if(!checkIfTeamAlreadyRegisteredToContest(team, contest)){
				FileHandler.registerTeamToContest(team, contest);
			}
		}
	}
	//same function as registerTeamToContest but returns true if it pass the validation
	public boolean registerTeamToContestForTest(String team, String contest) throws IOException{
		if(checkIfContestExist(contest) && checkIfTeamIsRegistered(team)){
			if(!checkIfTeamAlreadyRegisteredToContest(team, contest)){
				//FileHandler.registerTeamToContest(team, contest);
				return true;
			}
		}
		return false;
	}
	
	//returns false if team is not registered to contest
	public boolean givePoints(String contest, String team, int points) throws IOException{
		if(checkIfTeamAlreadyRegisteredToContest(team, contest)){
			FileHandler.addPoints(contest, team, points);
			return true;
		}
		return false;
	}
	
	public boolean checkIfContestExist(String contest){
		if(Arrays.asList(contestList).contains(contest)){
			return true;
		}
		return false;
	}
	//returns true if team is already registered
	public boolean checkIfTeamAlreadyRegisteredToContest(String team, String contest) throws IOException{
		if(FileHandler.CheckIfTeamRegisteredToContest(team,contest)){
			return true;
		}
		return false;
	}
	
	//returns true if team already exist
	public boolean checkIfTeamIsRegistered(String team) throws IOException{
		if(FileHandler.checkIfTeamExist(team)){
			return true;
		}
		return false;
	}
}