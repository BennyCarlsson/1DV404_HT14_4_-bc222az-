import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class RegisterTest {

	@Test
	public void testRegisterGoodName() {
		Register register = new Register();
		assertEquals(true, register.validateName("goodName"));
	}
	@Test
	public void testRegisterBadName() {
		Register register = new Register();
		assertEquals(false, register.validateName("sekreterare"));
		assertEquals(false,register.validateName("0"));
	}
	@Test
	public void testRegisterAlreadyRegistered() throws IOException {
		Register register = new Register();
		assertEquals(false, register.tryRegister("lag1"));
		assertEquals(false, register.checkIfTeamNameIsAvailable("lag1"));
	}


}
