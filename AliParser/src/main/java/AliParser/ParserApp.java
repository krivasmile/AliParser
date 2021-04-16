package AliParser;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.List;


public class ParserApp {
	final private static Integer itemsNeeded = 100;  										//set how many items you need

	public static void main(String[] args) throws Exception {
		UrlReader urlReader = new UrlReader();
		RequestAliExpessBuilder requestAliExpessBuilder = new RequestAliExpessBuilder();
		CSVBuilder csvBuilder = new CSVBuilder();
		
		List<URL> requestslist = requestAliExpessBuilder.getRequestsList(itemsNeeded); 
		List<Item> items = urlReader.getAllItems(requestslist);								
		
		File file = new File("products.csv");
		csvBuilder.buildCSV(file, items);
		
		Desktop.getDesktop().open(file);
	}
}
