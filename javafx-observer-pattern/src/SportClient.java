
public class SportClient implements Client{
	
	private String sportname = null; 
	private String hometeam = null; 
	private String awayteam = null; 
	private String homescore = null;
	private String awayscore = null; 
	
	public SportClient(String s, ScoreService ss) {
		sportname = s; 
		ss.addClient(this);
	}
	
	public void printstats() {
		System.out.println("New " + sportname + " score: " + hometeam + " " +  homescore + " " + awayteam + " " + awayscore);
	}

	public void newScore(String sport, String hometeam, String awayteam, String homescore, String awayscore) {
		if(sport.equals(sportname)) {
			this.hometeam = hometeam;
			this.awayteam = awayteam; 
			this.homescore = homescore; 
			this.awayscore = awayscore; 
			printstats(); 
		}
	}

}
