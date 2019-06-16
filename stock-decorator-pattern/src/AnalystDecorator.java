
public abstract class AnalystDecorator implements StockAnalyst{
	
	protected StockAnalyst a;
	
	public AnalystDecorator(StockAnalyst a){
		this.a = a; 
	}
	
	public String getVals(String key) {
		return a.getVals(key); 
	}
}
