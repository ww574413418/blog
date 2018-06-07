package com.zc.blog.pojo;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;

@Document(indexName = "blog",type = "blog",shards = 1, replicas = 0, refreshInterval = "-1")
public class blog implements Serializable {

    private String id;
    private String title;
    private String summary;
    private String content;

    protected blog() {
    }

    public blog(String id, String title, String summary, String content) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public blog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
