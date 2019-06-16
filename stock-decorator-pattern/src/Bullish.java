
public class Bullish implements StockAnalyst{
	private StockInfo s; 
	
	public Bullish(StockInfo s){
		this.s = s; 
	}

	public String reasons() {
		return "I think the market is going up.";
	}

	public double confidenceLevel() {
		double a = 0.70; 
		return a;
	}

	public String getVals(String key) {
		return s.getVals(key);
	}
}
