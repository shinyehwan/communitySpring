package com.ll.exam;

import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;

public class Ut {
	public static class cls{

		public static Object newObj(Class cls, Object defaultValue) {
			try {
				return cls.getDeclaredConstructor().newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static class str{
		public static String decapitalize(String string) {
			if (string == null || string.length() == 0) {
				return string;
			}

			char c[] = string.toCharArray();
			c[0] = Character.toLowerCase(c[0]);

			return new String(c);
		}
	}
}
