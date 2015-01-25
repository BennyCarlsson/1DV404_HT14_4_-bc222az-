import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class GetResultsTest {
	@Test
	public void getSeasonResultTest() throws IOException{
		GetResults getResults = new GetResults();
		List list = getResults.getResultsForSeason();
		assertNotNull(getResults.getResultsForSeason());
		assertTrue(list.size() > 1);
	}
	
	@Test
	public void getTeamResultTest() throws IOException{
		GetResults getResults = new GetResults();
		List list = getResults.getResultsForTeam("lag1");
		assertNotNull(list);
		assertTrue(list.size() > 1);
	}
	@Test
	public void getContestResultTest() throws IOException{
		GetResults getResults = new GetResults();
		List list = getResults.getResultsForContest("contest1");
		assertNotNull(list);
		assertTrue(list.size() > 1);
	}
}
