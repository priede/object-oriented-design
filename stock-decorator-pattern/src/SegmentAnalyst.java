
public class SegmentAnalyst extends AnalystDecorator {
	
	public SegmentAnalyst(StockAnalyst a){
		super(a);
	}

	private String vals() {
		return a.getVals("marketsegment"); 
	}

	private double opinion() {
		if(vals().contains("technology")) {
			return 0.80;
		}
		else if(vals().contains("auto")) {
			return 0.20;
		}
		else {
			return 0; 
		}
	}

	public String reasons() {
		if(opinion() == (0.20)) {
			return a.reasons() + "\n" + "\t" +  "Auto stocks are a bad risk.";
		}
		else if (opinion() == (0.80)) {
			return a.reasons() + "\n" + "\t" +  "We love tech stocks, solid investment!"; 
		}
		return a.reasons() + "\n" + "\t" + "Analyst has no opinion.";
	}

	public double confidenceLevel() {
		return (a.confidenceLevel() + opinion())/2; 
	}

}
