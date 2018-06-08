package com.zc.blog.controller;

import com.zc.blog.pojo.blog;
import com.zc.blog.service.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public List<blog> list(@RequestParam("title")String title,
                           @RequestParam("summary")String summary,
                           @RequestParam("content")String content,
                           @RequestParam(value = "pageIndex",defaultValue = "0")int pageInex,
                           @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){

        Pageable pageable = new PageRequest(pageInex, pageSize);
        Page<blog> page = blogRepository.findDistinctBlogByTitleLikeOrSummaryLikeOrContentLike(title, summary,content, pageable);
        return page.getContent();
    }
}
