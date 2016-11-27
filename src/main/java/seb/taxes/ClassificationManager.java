package seb.taxes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import seb.taxes.type.GoodType;

public class ClassificationManager {

	public static final Map<String, GoodType> MY_MAP = createMap();

	private static Map<String, GoodType> createMap() {
		Map<String, GoodType> result = new HashMap<String, GoodType>();
		result.put("book", GoodType.BOOK);
		result.put("CD", GoodType.OTHER);
		result.put("chocolate", GoodType.FOOD);
		result.put("perfume", GoodType.OTHER);
		result.put("pills", GoodType.MEDICAL);
		return Collections.unmodifiableMap(result);
	}

	public static GoodType getGoodType(String good) {
		return MY_MAP.get(good);
	}
}
