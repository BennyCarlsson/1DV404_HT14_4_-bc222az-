
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LoginTest {
	
	@Test
	public void testLoginExistingTeam() throws IOException{
		Login login = new Login();
		//check if logged in
		assertEquals(false, login.teamLoggedIn());
		//try logg in
		assertEquals(true, login.tryLoginTeam("lag1"));
		//check if logged in
		assertEquals(true, login.teamLoggedIn());
		//get teamname that is logged in
		assertEquals("lag1", login.teamNameLoggedIn());
	}
	@Test
	public void testLoginNonExistingTeam() throws IOException{
		Login login = new Login();
		assertEquals(false, login.tryLoginTeam("EjRegistreratLag"));
	}
	@Test
	public void testLoginSecretary(){
		Login login = new Login();
		assertEquals(false, login.secretaryLoggedIn());
		assertEquals(true, login.tryLogInSecretary("sekreterare"));
		assertEquals(true, login.secretaryLoggedIn());
	}

}
