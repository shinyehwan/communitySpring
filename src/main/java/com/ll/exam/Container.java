package com.ll.exam;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


import org.reflections.Reflections;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.ArticleController;
import com.ll.exam.home.HomeController;

public class Container {

	private static final ArticleController articleController;
	private static final HomeController homeController;

	static {

		articleController = (ArticleController)Ut.cls.newObj(ArticleController.class, "");
		homeController = (HomeController)Ut.cls.newObj(HomeController.class, "");

	}
	public static ArticleController getArticleController() {
		return articleController;
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

	public static HomeController getHomeController() {
		return homeController;
	}
}
