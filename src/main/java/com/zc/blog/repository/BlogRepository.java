package com.zc.blog.repository;

import com.zc.blog.pojo.blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BlogRepository extends ElasticsearchRepository<blog, String> {

	//Page<blog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
	Page<blog> findDistinctBlogByTitleLikeOrSummaryLikeOrContentLike(String title, String summary, String content,Pageable pageable);
}
