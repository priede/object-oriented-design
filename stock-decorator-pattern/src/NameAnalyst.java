

public class NameAnalyst extends AnalystDecorator{
	
	public NameAnalyst(StockAnalyst a){
		super(a);
	}
	
	public double opinion() {
		if(vals().toUpperCase().contains("A"))
			return 1;
		return 0; 
	}
	
	private String vals() {
		return a.getVals("name"); 
	}
	
	public String reasons() {
		if(opinion() == 0) {
			return a.reasons() + "\n" + "\t" + "Stocks beginning without 'A' are bad karma.";
		}
	
		return a.reasons() + "\n" + "\t" +  "Stock begins with 'A', in the clear!"; 
	}
	
	public double confidenceLevel() {
		return (a.confidenceLevel() + opinion())/2; 
	}
}
