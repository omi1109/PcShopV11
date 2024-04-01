package dto;

/**
 * ユーザ情報を表す
 * @author M.Takahashi
 */
public class Product {
	/**
	 * 商品ID
	 */
	private String productId;
	
	/**
	 * 商品名
	 */
	private String productName;
	
	/**
	 * 単価
	 */
	private int price;

	/**
	 * 引数なしコンストラクタ
	 */
	public Product() {
	}

	/**
	 * 引数ありコンストラクタ
	 * @param productId 商品ID
	 * @param productName 商品名
	 * @param price 単価
	 */
	public Product(String productId, String productName, int price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	/**
	 * 商品IDの取得
	 * @return 商品ID
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * 商品IDの設定
	 * @param productId セットする 商品ID
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * 商品名の取得
	 * @return 商品名
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 商品名の設定
	 * @param productName セットする 商品名
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 単価の取得
	 * @return 単価
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 単価の設定
	 * @param price セットする 単価
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
}
