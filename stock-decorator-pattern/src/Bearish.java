
public class Bearish implements StockAnalyst{
	private StockInfo s; 
//	private String reason = ""; 
	
	public Bearish(StockInfo s){
		this.s = s; 
	}

	public String reasons() {
		return "I think the stock market is not looking good."; 
	}

	public double confidenceLevel() {
		double a = 0.30; 
		return a;
	}
	
	public String getVals(String key) {
		return s.getVals(key);
	}
//	
//	public void addreason(String r) {
//		reason = reason + r; 
//	}
}
