import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GetResults {
	
	//returns a list with the results for the team
	public List<String> getResultsForTeam(String teamName) throws IOException{
		List<String> list = FileHandler.getTeamAndContestRegister();
		List<String> result = new ArrayList();
		result.add(teamName);
		int score = 0;
 		for(int i = 0; i < list.size(); i++){
			String[] parts = list.get(i).split(":");
			if(parts[1].equals(teamName)){
				result.add(parts[0]+": "+parts[2]);
				score += Integer.parseInt(parts[2]);
			}
		}
 		result.add("Poäng: "+score);
 		return result;
	}
	
	//returns a list with the results for the contest
	public List<String> getResultsForContest(String contest) throws IOException{
		List<String> list = FileHandler.getTeamAndContestRegister();
		List<String> result = new ArrayList();
		result.add(contest);
		for(int i = 0; i < list.size(); i++){
			String[] parts = list.get(i).split(":");
			if(parts[0].equals(contest)){
				result.add(parts[1]+": "+parts[2]);
			}
		}

		return result;
	}
	
	//returns a list with results of every teams total scores for the season
	public static List<String> getResultsForSeason() throws IOException{
		List<String> ScoreList = FileHandler.getTeamAndContestRegister();
		List<String> teams = FileHandler.getAllTeams();
		List<String> result = new ArrayList();
		for(int i = 0; i < teams.size(); i++){
			int score = 0;
			for(int y = 0; y < ScoreList.size(); y++){
				String[] parts = ScoreList.get(y).split(":");
				if(teams.get(i).equals(parts[1])){
					score += Integer.parseInt(parts[2]);
				}
			}
			result.add(teams.get(i)+": "+score);
		}
		
		return result;
	}
}
