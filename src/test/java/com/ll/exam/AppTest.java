package com.ll.exam;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ll.exam.article.ArticleController;

public class AppTest {
	@Test
	void junit_assertThat() {
		int rs = 10 + 20;
		assertThat(rs).isEqualTo(30);
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
