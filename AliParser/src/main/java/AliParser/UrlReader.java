package AliParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlReader {

	private List<Item> items;
	private ItemMapper itemMapper;

	public List<Item> getAllItems(List<URL> requestsList) {
		try {
			items = new ArrayList<>();
			itemMapper = new ItemMapper();
			for (int i = 0; i < requestsList.size(); i++) {
				String json = readUrl(requestsList.get(i));
				items.addAll(itemMapper.getItems(json));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return items;
	}

	private static String readUrl(URL url) throws IOException {
		BufferedReader reader = null;
		StringBuffer buffer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
				reader.close();
		}
		return buffer.toString();
	}
}
