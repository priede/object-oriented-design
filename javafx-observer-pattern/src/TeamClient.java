
public class TeamClient implements Client{
	
	private String myteam = null; 

	private String sportname = null; 
	private String hometeam = null; 
	private String awayteam = null; 
	private String homescore = null;
	private String awayscore = null; 
	
	public TeamClient(String s, ScoreService ss) {
		myteam = s; 
		ss.addClient(this);
	}
	
	public void printstats() {
		System.out.println("New score in "+ myteam + " " + sportname + ": " + hometeam + " " +  homescore + " " + awayteam + " " + awayscore);
	}


	public void newScore(String sport, String hometeam, String awayteam, String homescore, String awayscore) {
		if(hometeam.equals(myteam)) {
			this.hometeam = myteam; 
			
			this.sportname = sport;
			this.awayteam = awayteam; 
			this.homescore = homescore; 
			this.awayscore = awayscore; 
			printstats();
		}
		else if (awayteam.equals(myteam)) {
			this.awayteam = myteam; 
			
			this.sportname = sport;
			this.hometeam = hometeam;
			this.homescore = homescore; 
			this.awayteam = awayteam; 
			this.awayscore = awayscore; 
			printstats(); 
		}
	}	
}
