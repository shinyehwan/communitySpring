package com.ll.exam;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ll.exam.article.ArticleController;
import com.ll.exam.home.HomeController;

public class AppTest {
	@Test
	void junit_assertThat() {
		int rs = 10 + 20;
		assertThat(rs).isEqualTo(30);
	}

	@Test
	void ioc__homeController() {
		HomeController homeController = Container.getHomeController();
		assertThat(homeController).isNotNull();
	}
	@Test
	void ioc__homeController__싱글톤() {
		HomeController homeController1 = Container.getHomeController();
		HomeController homeController2 = Container.getHomeController();
		assertThat(homeController2).isEqualTo(homeController1);
	}


	@Test
	void ioc__articleController() {
		ArticleController articleController = Container.getArticleController();
		assertThat(articleController).isNotNull();
	}
	@Test
	void ioc__articleController__싱글톤() {
		ArticleController articleController1 = Container.getArticleController();
		ArticleController articleController2 = Container.getArticleController();
		assertThat(articleController2).isEqualTo(articleController1);
	}

	@Test
	void ioc__Controller들을_스캔하여_수집() {
		List<String> names = Container.getControllerNames();
		assertThat(names).contains("home");
		assertThat(names).contains("article");
	}
}
