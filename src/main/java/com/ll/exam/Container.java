package com.ll.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reflections.Reflections;

import com.ll.exam.annotation.Autowired;
import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.Service;

public class Container {

	private static final Map<Class,Object> objects;

	static {
		objects = new HashMap<>();
		scanComponents();
	}

	private static void scanComponents() {
		// 전체 레고 생성
		scanServices();
		scanControllers();

		// 레고 조립
		resolveDependenciesAllComponents();
	}

	private static void resolveDependenciesAllComponents() {
		for (Class cls : objects.keySet()) {
			Object o = objects.get(cls);

			resolveDependencies(o);
		}
	}

	private static void resolveDependencies(Object o) {
		Arrays.asList(o.getClass().getDeclaredFields())
			.stream()
			.filter(f -> f.isAnnotationPresent(Autowired.class))
			.map(field -> {
				field.setAccessible(true);
				return field;
			})
			.forEach(field -> {
				Class cls = field.getType();
				Object dependency = objects.get(cls);

				try {
					field.set(o, dependency);
				} catch (IllegalAccessException e) {

				}
			});
	}

	private static void scanServices() {
		Reflections ref = new Reflections("com.ll.exam");
		for (Class<?> cls : ref.getTypesAnnotatedWith(Service.class)){
			objects.put(cls, Ut.cls.newObj(cls, null));
		}
	}

	private static void scanControllers() {
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
