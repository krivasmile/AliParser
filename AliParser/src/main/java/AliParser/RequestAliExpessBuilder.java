package AliParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RequestAliExpessBuilder {
	final private Integer ITEM_ON_REQUEST = 12;
	final private static String HOST = "https://gpsfront.aliexpress.com";
	final private static String NAME_REQUEST = "/getRecommendingResults.do?";
	final private static String WIDGET_PARAM = "&widget_id=5547572";
	final private static String PLATFORM_PARM = "&platform=pc";
	final private static String POSTBACK_PARAM = "&postback=1";
	private List<URL> requestsList;

	public List<URL> getRequestsList(Integer itemsCount) throws MalformedURLException {
		try {
			requestsList = new ArrayList<>();

			int count = itemsCount / ITEM_ON_REQUEST; 				// as we can can receive only 12 products, we must know count of requests

			if (count >= 1) {
				for (int i = 0; i < count; i++) {
					requestsList.add(buildURL(ITEM_ON_REQUEST, ITEM_ON_REQUEST * i)); 			// add request links to list
				}
				int remainderItems = itemsCount % ITEM_ON_REQUEST;
				if (remainderItems != 0) {
					requestsList.add(buildURL(remainderItems, count * ITEM_ON_REQUEST)); 		// add remainder request links to list														 
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
		return new URL(HOST + NAME_REQUEST + WIDGET_PARAM + PLATFORM_PARM + POSTBACK_PARAM + "&limit=" + limit + "&offset=" + offset);
	}
}
