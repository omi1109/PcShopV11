package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Product;

/**
 * 商品情報用のDAO
 * @author M.Takahashi
 */
public class ProductDAO {

	/**
	 * 商品名の部分一致検索
	 * @param name 商品名（部分一致文字列）
	 * @return 結果の商品情報リスト
	 * @throws Exception
	 */
	public List<Product> selectByName(String name) throws Exception {

		// 結果格納用
		List<Product> productList = new ArrayList<Product>();

		String sql = " SELECT * FROM m_product WHERE product_name LIKE ? ";

		try (Connection con = MyConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, "%" + name + "%");

			try (ResultSet res = pstmt.executeQuery()) {
				while (res.next()) {
					String productId = res.getString("product_id");
					String productName = res.getString("product_name");
					int price = res.getInt("price");
					
					// １件分のオブジェクトを生成してリストに追加
					Product product 
						= new Product(productId, productName, price);
					productList.add(product);
				}
			}
		}

		return productList;
	}
	
	/**
	 * 商品情報登録
	 * @param product 商品情報
	 * @return 処理件数
	 * @throws Exception
	 */
	public int insert(Product product)  throws Exception {
		String sql = " INSERT INTO m_product                    " +
					 "        (product_id, product_name, price) " +
					 " VALUES ( ? , ? , ? )                     ";
		
		int result = 0;

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = MyConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getPrice());

			// SQLステートメントの実行
			result = pstmt.executeUpdate();
		}

		return result;
	}
	
	/**
	 * 商品情報更新
	 * @param product 商品情報
	 * @return 処理件数
	 * @throws Exception
	 */
	public int update(Product product)  throws Exception {
		String sql = " UPDATE m_product       " +
					 " SET product_name = ? , " + 
					 "     price = ?          " +
					 " WHERE product_id = ?   ";
		
		int result = 0;

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = MyConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getProductId());

			// SQLステートメントの実行
			result = pstmt.executeUpdate();
		}

		return result;
	}
	
	/**
	 * 商品情報削除
	 * @param productId 対象の商品ID
	 * @return 処理件数
	 * @throws Exception
	 */
	public int delete(String productId) throws Exception {
		String sql = " DELETE FROM m_product  " +
					 "  WHERE product_id = ?  ";

		int result = 0;

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = MyConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1, productId);

			// SQLステートメントの実行
			result = pstmt.executeUpdate();
		}

		return result;
	}
	
}
