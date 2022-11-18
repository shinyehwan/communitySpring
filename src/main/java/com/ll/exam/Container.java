package com.ll.exam;

import java.util.ArrayList;
import java.util.List;


import org.reflections.Reflections;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.ArticleController;

public class Container {

	private static final ArticleController articleController;

	static {
		articleController = new ArticleController();
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


}
