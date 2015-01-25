import java.io.IOException;

public class Login {
	private Boolean teamLoggedIn = false;
	private String teamNameLoggedIn = null;
	private Boolean secretaryLoggedIn = false;
	public boolean teamLoggedIn(){
		return this.teamLoggedIn;
	}
	public boolean secretaryLoggedIn(){
		return this.secretaryLoggedIn;
	}
	public String teamNameLoggedIn(){
		return this.teamNameLoggedIn;
	}
	public boolean loginValidator(String input){
		if(input != null){
			return false;
		}
		if(input.equals("0")){
			return false;
		}
		return true;
	}
	public boolean tryLogInSecretary(String input){
		String secretary = "sekreterare";
		if(input.equals(secretary)){
			this.secretaryLoggedIn = true;
			return true;
		}
		return false;
	}
	public boolean tryLoginTeam(String input) throws IOException{
		FileHandler filehandler = new FileHandler();
		if(filehandler.checkIfTeamExist(input)){
			this.teamLoggedIn = true;
			this.teamNameLoggedIn = input;
			return true;
		}
		return false;
	}
}













