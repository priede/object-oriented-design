
public class PEratioAnalyst extends AnalystDecorator{
	
	public PEratioAnalyst(StockAnalyst a){
		super(a);
	}

	private double getPERatio() {
		double price = Double.parseDouble(getPrice()); 
		double earnings = Double.parseDouble(getEarnings()); 
		double PEratio = price/earnings; 
		return PEratio; 
	}
	
	private String getPrice() {
		return a.getVals("shareprice"); 
	}
	
	private String getEarnings() { 
		return a.getVals("earnings"); 
	}
	
	public String reasons() {
		double PE = getPERatio(); 
		if(PE == 12.0) {
			return a.reasons() + "\n" + "\t" + "Stock PE ratio is 12, which is average."; 
		}
		else if(PE < 12.0) {
			return a.reasons() + "\n" + "\t" +  "Stock PE ratio is below 12 and considered to be underpriced.";
		}
		return a.reasons() + "\n" + "\t" + "Stock PE ratio is above 12 and considered to be overpriced."; 
	}

	public double confidenceLevel() { 
		double PE = getPERatio(); 
		double result = 1 - (PE / 24); 
		return (a.confidenceLevel() + result)/2; 
	}
	
}
