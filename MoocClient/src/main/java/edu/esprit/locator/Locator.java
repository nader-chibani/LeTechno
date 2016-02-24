package edu.esprit.locator;

import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Locator {
	static Context context;
	static Map<String, Object> cache = new HashMap<>();
	public static final String MODULE_NAME = "mooc";

	public static Object lookup(String ejbName, Class viewclass)

	{
		try {
			String jndiName = MODULE_NAME + "/" + ejbName + "!" + viewclass.getCanonicalName();
			if (context == null)
				context = new InitialContext();

			Object proxy = null;
			if (!cache.containsKey(ejbName)) {

				proxy = context.lookup(jndiName);
			} else {

				proxy = cache.get(ejbName);
			}
			return proxy;
		} catch (Exception e) {

			return null;
		}
	}
}
