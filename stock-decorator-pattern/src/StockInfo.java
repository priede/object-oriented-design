import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockInfo {
	private File f;
	private ArrayList<ArrayList> info = new ArrayList();  

	StockInfo(String filename) {
		f = new File(filename);		
		fileInfo(); 
	}

	public void fileInfo() {
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				Scanner sc2 = new Scanner(sc.nextLine());
				ArrayList<String> subinfo = new ArrayList(); 
				while(sc2.hasNext()) {
					String s = sc2.next(); 
					subinfo.add(s); 
				}
				info.add(subinfo);
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getVals(String key) {
		String vals = ""; 
		for(ArrayList<String> i : info) {
			if(i.get(0).equals(key)) {
				for(int j = 1; j < i.size() ; j++) {
					vals += i.get(j); 
				}
			}
		}
		return vals ; 
	}
}
