
public class Neutral implements StockAnalyst{
	private StockInfo s; 
	
	public Neutral(StockInfo s){
		this.s = s; 
	}

	public String reasons() {
		return "The market's future is unclear.";
	}

	public double confidenceLevel() {
		double a = 0.50; 
		return a;
	}
	
	public String getVals(String key) {
		return s.getVals(key);
	}
}
