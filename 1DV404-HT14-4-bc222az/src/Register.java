import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Register {
	public boolean tryRegister(String input) throws IOException{
		if(validateName(input) && checkIfTeamNameIsAvailable(input)){
			return true;
		}
		return false;
	}
	public boolean validateName(String teamName){
		if(teamName.equals("0") || teamName.equals("sekreterare") || teamName.equals(" ")|| teamName.equals("")){
			return false;
		}
		return true;
	}
	
	public boolean checkIfTeamNameIsAvailable(String input) throws IOException{
		FileHandler filehandler = new FileHandler();
		if(filehandler.checkIfTeamExist(input)){
			//returns false here if name is already taken
			return false;
		}
		//returns true if available
		return true;
	}
}
