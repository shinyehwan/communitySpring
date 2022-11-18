package com.ll.exam;

import java.util.List;

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
		return List.of("home", "article");
	}
}
