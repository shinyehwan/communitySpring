package com.ll.exam;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.article.repository.ArticleRepository;
import com.ll.exam.article.service.ArticleService;
import com.ll.exam.home.HomeController;

public class AppTest {
	@Test
	void junit_assertThat() {
		int rs = 10 + 20;
		assertThat(rs).isEqualTo(30);
	}

	@Test
	void ioc__homeController() {
		HomeController homeController = Container.getObj(HomeController.class);
		assertThat(homeController).isNotNull();
	}
	@Test
	void ioc__homeController__싱글톤() {
		HomeController homeController1 = Container.getObj(HomeController.class);
		HomeController homeController2 = Container.getObj(HomeController.class);
		assertThat(homeController2).isEqualTo(homeController1);
	}


	@Test
	void ioc__articleController() {
		ArticleController articleController = Container.getObj(ArticleController.class);
		assertThat(articleController).isNotNull();
	}
	@Test
	void ioc__articleController__싱글톤() {
		ArticleController articleController1 = Container.getObj(ArticleController.class);
		ArticleController articleController2 = Container.getObj(ArticleController.class);
		assertThat(articleController2).isEqualTo(articleController1);
	}

	@Test
	void ioc__Controller들을_스캔하여_수집() {
		List<String> names = Container.getControllerNames();
		assertThat(names).contains("home");
		assertThat(names).contains("article");
	}

	@Test
	public void ioc__articleService() {
		ArticleService articleService = Container.getObj(ArticleService.class);

		assertThat(articleService).isNotNull();
	}

	@Test
	public void ioc__articleService__싱글톤() {
		ArticleService articleService1 = Container.getObj(ArticleService.class);
		ArticleService articleService2 = Container.getObj(ArticleService.class);

		assertThat(articleService2).isEqualTo(articleService1);
	}

	@Test
	public void articleController를_생성할때_articleService도_같이_생성() {
		ArticleController articleController = Container.getObj(ArticleController.class);

		ArticleService articleService = Ut.reflection.getFieldValue(articleController, "articleService", null);

		assertThat(articleService).isNotNull();
	}
	@Test
	public void articleService를_생성할때_articleRepository도_같이_생성() {
		ArticleService articleService = Container.getObj(ArticleService.class);

		ArticleRepository articleRepository = Ut.reflection.getFieldValue(articleService, "articleRepository", null);

		assertThat(articleRepository).isNotNull();
	}
}
