package AliParser;

public class Item {
	private Integer productId;
	private String productTitle;
	private String currentPrice;
	private String originalPrice;
	private String discount;
	private String orders;
	private String productImage;
	private String productDetailUrl;
	
	public Item() {
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDetailUrl() {
		return productDetailUrl;
	}

	public void setProductDetailUrl(String productDetailUrl) {
		this.productDetailUrl = productDetailUrl;
	}

	@Override
	public String toString() {
		return "---------------------Item------------------" + System.lineSeparator()
				+ "productId = " + productId + System.lineSeparator()
				+ "productTitle = " + productTitle + System.lineSeparator()
				+ "currentPrice = " + currentPrice + System.lineSeparator()
				+ "originalPrice = " + originalPrice + System.lineSeparator()
				+ "discount = " + discount + System.lineSeparator()
				+ "orders = " + orders + System.lineSeparator()
				+ "productImage = " + productImage + System.lineSeparator()
				+ "productDetailUrl = " + productDetailUrl;
	}
	
}
