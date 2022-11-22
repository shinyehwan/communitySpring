package com.ll.exam.article.repository;

import java.util.List;

import com.ll.exam.annotation.Autowired;
import com.ll.exam.annotation.Repository;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.mymap.MyMap;
import com.ll.exam.mymap.SecSql;

@Repository
public class ArticleRepository {

	@Autowired
	private MyMap myMap;
	public List<ArticleDto> getArticles() {
		SecSql sql = myMap.genSecSql();
		sql
			.append("SELECT * FROM article ORDER BY id DESC");
		return sql.selectRows(ArticleDto.class);
	}
}
