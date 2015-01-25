import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class FileHandler {
	private static String path = "teams.txt";
	private static String path2 = "contestsAndTeams.txt";
	
	public void registerTeam(String teamName) throws IOException{
		File file = new File(path);
		PrintWriter out = new PrintWriter(new FileWriter(file, true));
	    out.append(teamName+":\n");
	    out.close();
	}
	
	//returns true if team exist
	static public boolean checkIfTeamExist(String teamName) throws IOException{
		List teams = getAllTeams();
		for(int i = 0; i < teams.size(); i++){
			if(teams.get(i).equals(teamName)){
				return true;
			}
		}
		return false;
	}
	
	public static List<String> getAllTeams() throws IOException{
		List teams = new ArrayList();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String string = "";
		while((string = br.readLine()) != null){
			String[] parts = string.split(":");
			for(int i = 0; i < parts.length; i++){
				teams.add(parts[i]);
			}
		}
		return teams;
	}
	
	public static void registerTeamToContest(String team, String contest) throws IOException{
		File file = new File(path2);
		PrintWriter out = new PrintWriter(new FileWriter(file, true));
	    out.append(contest + ":"+ team +":"+0+"\n");
	    out.close();
	}
	//returns true if team is registered to contest
	public static boolean CheckIfTeamRegisteredToContest(String team, String contest) throws IOException{
		List<String> list = getTeamAndContestRegister();
		for(int i = 0; i < list.size(); i++){
			String[] parts = list.get(i).split(":");
			for(int y = 0; y < parts.length; y++){
				if(parts[0].equals(contest) && parts[1].equals(team)){
					return true;
				}
			}
		}
		return false;
	}
	
	//gets information from txt file changes the points and then overwrites it.
	public static void addPoints(String contest, String team, int points) throws IOException{
		List<String> list = getTeamAndContestRegister();
		for(int i = 0; i < list.size(); i++){
			String[] parts = list.get(i).split(":");
			for(int y = 0; y < parts.length; y++){
				if(parts[0].equals(contest) && parts[1].equals(team)){
					int newPoints = Integer.parseInt(parts[2]) + points;
					list.set(i, parts[0]+":"+parts[1]+":"+newPoints);
				}
			}
		}
		File file = new File(path2);
		PrintWriter p = new PrintWriter(new FileWriter(file, false));
		for(int i = 0; i < list.size(); i++){
			p.append(list.get(i).toString()+"\n");
		}
		p.close();
	}
	public static List<String> getTeamAndContestRegister() throws IOException{
		List list = new ArrayList();
		BufferedReader br = new BufferedReader(new FileReader(path2));
		String string = "";
		while((string = br.readLine()) != null){
			list.add(string);
		}
		return list;
	}
}












