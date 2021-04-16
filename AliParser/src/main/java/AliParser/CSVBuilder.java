package AliParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class CSVBuilder {
	
	public void buildCSV(File file, List<Item> items) {
		try (PrintWriter writer = new PrintWriter(file)) {

		      StringBuilder sb = new StringBuilder();
		      String columnNamesList = "productId;productTitle;currentPrice;originalPrice;discount;orders;productImage;productDetailUrl";
		      sb.append(columnNamesList +"\n");

		      String divider = ";";
		      for (Item item : items) {
		    	  sb.append(item.getProductId() + divider);
		    	  sb.append(item.getProductTitle() + divider);
		    	  sb.append(item.getCurrentPrice()  + divider);
		    	  sb.append(item.getOriginalPrice()  + divider);
		    	  sb.append(item.getDiscount()  + divider);
		    	  sb.append(item.getOrders()  + divider);
		    	  sb.append(item.getProductImage()  + divider);
		    	  sb.append(item.getProductDetailUrl()  + divider);
		    	  sb.append('\n');
		      }

		      writer.write(sb.toString());
		      
		    } catch (FileNotFoundException e) {
		      System.out.println(e.getMessage());
		    }
	}
}
