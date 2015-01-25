import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;


public class ContestsTest {
	@Test
	public void testCheckIfContestExist(){
		//check if the contest exist
		Contests contests = new Contests();
		assertEquals(true, contests.checkIfContestExist("contest1"));
		assertEquals(false, contests.checkIfContestExist("nonExistingContest"));
	}
	@Test
	public void testRegisterTeam() throws IOException{
		Contests contests = new Contests();
		assertEquals(true, contests.registerTeamToContestForTest("lag5", "contest2"));
	}
	@Test
	public void testRegisterExistingTeam() throws IOException{
		Contests contests = new Contests();
		//testar att registrera redan existerande data
		assertEquals(false, contests.registerTeamToContestForTest("lag1", "contest1"));
		//testar validerings metoderna enskilt
		assertEquals(true, contests.checkIfTeamAlreadyRegisteredToContest("lag1", "contest1"));
		assertEquals(true, FileHandler.CheckIfTeamRegisteredToContest("lag1", "contest1"));
	}
	@Test
	public void testGivePointsToTeam() throws IOException{
		Contests contests= new Contests();
		//give lag1 1 point
		assertEquals(true, contests.givePoints("contest1", "lag1", 1));
		//take one point from lag1
		assertEquals(true, contests.givePoints("contest1", "lag1", -1));
	}
	@Test
	public void testGivePointsBadly() throws IOException{
		Contests contests = new Contests();
		//non existing contest, non exsisint team
		assertEquals(false,  contests.givePoints("nonExistingContest", "nonExistingTem",1));
		//existing contest, non existing team
		assertEquals(false,  contests.givePoints("contest1", "nonExistingTem",1));
		//non existing contest, existing team
		assertEquals(false,  contests.givePoints("nonExistingContest", "lag1",1));
	}
}


