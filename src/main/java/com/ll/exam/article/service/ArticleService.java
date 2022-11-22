package com.ll.exam.article.service;

import java.util.List;

import com.ll.exam.annotation.Autowired;
import com.ll.exam.annotation.Service;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.article.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	public List<ArticleDto> getArticles() {
		return articleRepository.getArticles();
	}
}
