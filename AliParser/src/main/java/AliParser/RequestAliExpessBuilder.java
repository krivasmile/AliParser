package AliParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RequestAliExpessBuilder {
	final private Integer itemOnRequest = 12;
	final private static String host = "https://gpsfront.aliexpress.com";
	final private static String nameRequest = "/getRecommendingResults.do?";
	final private static String widgetParam = "&widget_id=5547572";
	final private static String platformParam = "&platform=pc";
	final private static String postbackParam = "&postback=1";
	private List<URL> requestsList;

	public List<URL> getRequestsList(Integer itemsCount) throws MalformedURLException {
		try {
			requestsList = new ArrayList<>();

			int count = itemsCount / itemOnRequest; 				// as we can can receive only 12 products, we must know count of requests

			if (count >= 1) {
				for (int i = 0; i < count; i++) {
					requestsList.add(buildURL(itemOnRequest, itemOnRequest * i)); 			// add request links to list
				}
				int remainderItems = itemsCount % itemOnRequest;
				if (remainderItems != 0) {
					requestsList.add(buildURL(remainderItems, count * itemOnRequest)); 		// add remainder request links to list														 
				}
			} else {
				requestsList.add(buildURL(itemsCount, count)); 								// if we need less than 12 products
			}
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		return requestsList;
	}

	private static URL buildURL(Integer limit, Integer offset) throws MalformedURLException {
		return new URL(host + nameRequest + widgetParam + platformParam + postbackParam + "&limit=" + limit + "&offset=" + offset);
	}
}
