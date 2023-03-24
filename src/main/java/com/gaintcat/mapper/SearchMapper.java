package com.gaintcat.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gaintcat.model.product.Product;

@Mapper
public interface SearchMapper {
	/**
	 * 取得跟分類下的總筆數
	 * @param category_id
	 * @return
	 */
	@Select({"<script>",
		"SELECT COUNT(id) FROM product WHERE isUsed = 1",
		" <if test='pid != null and cid == null'> AND category_id IN (SELECT id FROM category WHERE parent_id = #{pid} AND isUsed = 1)</if>",
		" <if test='cid != null'> AND category_id = #{cid}</if>",
		"</script>"})
	public Integer getSearchTotalRow(Integer pid, Integer cid);
	
	/**
	 * 透過篩選器的值回傳結果
	 * @param pid
	 * @param cid
	 * @param minPrice
	 * @param maxPrice
	 * @param brands
	 * @param sort
	 * @return
	 */
	@Select({"<script>",
		"SELECT id, brand_id, category_id, pet_id, title, inventory, price, special, small_img FROM product WHERE isUsed = 1",
		" <if test='pid != null and cid == null'> AND category_id IN (SELECT id FROM category WHERE parent_id = #{pid} AND isUsed = 1)</if>",
		" <if test='cid != null'> AND category_id = #{cid}</if>",
		" AND (price BETWEEN #{minPrice} AND #{maxPrice})",
		"<if test='brands.length != 0'>",
		" AND brand_id IN ",
		"<foreach collection='brands' item='bid' index='index' open='(' separator=',' close=')' nullable='true'>#{bid}</foreach>",
		"</if>",
		"<if test='keyword != null'>",
		" AND title LIKE CONCAT('%', #{keyword}, '%')",
		"</if>",
		" ORDER BY price ",
		" <if test='sort == \"ASC\"'>ASC</if>",
		" <if test='sort == \"DESC\"'>DESC</if>",
		"LIMIT #{page}, 12",
		"</script>"})
	public ArrayList<Product> getProducts(Integer pid, Integer cid, Double minPrice, Double maxPrice, Integer[] brands, String keyword, String sort, Integer page);
	
	/**
	 * 回傳透過篩選器搜尋出來的結果總筆數
	 * @param pid
	 * @param cid
	 * @param minPrice
	 * @param maxPrice
	 * @param brands
	 * @param sort
	 * @return
	 */
	@Select({"<script>",
		"SELECT COUNT(id) FROM product WHERE isUsed = 1",
		" <if test='pid != null and cid == null'> AND category_id IN (SELECT id FROM category WHERE parent_id = #{pid} AND isUsed = 1)</if>",
		" <if test='cid != null'> AND category_id = #{cid}</if>",
		" AND (price BETWEEN #{minPrice} AND #{maxPrice})",
		"<if test='brands.length != 0'>",
		" AND brand_id IN ",
		"<foreach collection='brands' item='bid' index='index' open='(' separator=',' close=')' nullable='true'>#{bid}</foreach>",
		"</if>",
		"<if test='keyword != null'>",
		" AND title LIKE CONCAT('%', #{keyword}, '%')",
		"</if>",
		"</script>"})
	public Integer getTotalRow(Integer pid, Integer cid, Double minPrice, Double maxPrice, Integer[] brands, String keyword);
	
}
