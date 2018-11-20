package pl.manager.apiary.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomDropDownList {
	public static Map<Boolean, String> getList() {
		Map<Boolean, String> values = new LinkedHashMap<>();
		values.put(true, "Tak");
		values.put(false, "Nie");
		values.put(null, "Nie sprawdzano");
		return values;
	}
}
