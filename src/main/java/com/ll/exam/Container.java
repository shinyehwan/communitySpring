package com.ll.exam;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reflections.Reflections;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.ArticleController;
import com.ll.exam.home.HomeController;

public class Container {

	private static final Map<Class,Object> objects;

	static {
		objects = new HashMap<>();
		Reflections ref = new Reflections("com.ll.exam");
		for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)){
			objects.put(cls, Ut.cls.newObj(cls, null));
		}
	}
	public static <T> T getObj(Class<T> cls) {
		return (T)objects.get(cls);
	}


	public static List<String> getControllerNames() {
		List<String> names = new ArrayList<>();

		Reflections ref = new Reflections("com.ll.exam");
		for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)){
			String name = cls.getSimpleName();
			name = Ut.str.decapitalize(name);
			names.add(name.replace("Controller", ""));
		}
		return names;
	}
}
