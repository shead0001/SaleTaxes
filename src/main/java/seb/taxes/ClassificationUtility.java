package seb.taxes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import seb.taxes.type.GoodType;

/**
 * Utility per la determinazione della tipologia del bene a partire dal
 * nome(descrizione)
 * 
 * @author caponnetto
 *
 */
public class ClassificationUtility {

	/**
	 * Hashmap con l'associazione nome_bene --> tipo_bene
	 */
	public static final Map<String, GoodType> GOODS_TYPES = createMap();

	private static Map<String, GoodType> createMap() {
		final Map<String, GoodType> result = new HashMap<String, GoodType>();
		result.put("book", GoodType.BOOK);
		result.put("CD", GoodType.OTHER);
		result.put("chocolate", GoodType.FOOD);
		result.put("perfume", GoodType.OTHER);
		result.put("pills", GoodType.MEDICAL);
		return Collections.unmodifiableMap(result);
	}

	/*
	 * Restituisce la tipologia del bene a partire dal nome(descrizione)
	 */
	public static GoodType getGoodType(final String good) {
		return GOODS_TYPES.get(good);
	}
}
