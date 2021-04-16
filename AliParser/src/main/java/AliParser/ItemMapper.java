package AliParser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ItemMapper {
	private List<Item> items;
	private JSONObject obj;
	private JSONArray arr;

	public List<Item> getItems(String json) {
		try {
			items = new ArrayList<>();
			obj = new JSONObject(json);
			arr = obj.getJSONArray("results");

			for (int i = 0; i < arr.length(); i++) {
				Item item = new Item();
				item.setProductId(arr.getJSONObject(i).getInt("productId"));
				item.setProductTitle(arr.getJSONObject(i).getString("productTitle"));
				item.setCurrentPrice(arr.getJSONObject(i).getString("minPrice"));
				item.setOriginalPrice(arr.getJSONObject(i).getString("oriMinPrice"));
				String discount = arr.getJSONObject(i).getString("discount") == null ? "0" : arr.getJSONObject(i).getString("discount");
				item.setDiscount(discount);
				item.setOrders(arr.getJSONObject(i).getString("orders"));
				item.setProductImage(arr.getJSONObject(i).getString("productImage"));
				item.setProductDetailUrl(arr.getJSONObject(i).getString("productDetailUrl"));

				items.add(item);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return items;
	}
}
