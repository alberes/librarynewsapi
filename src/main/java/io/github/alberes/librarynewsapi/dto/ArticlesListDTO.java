package io.github.alberes.librarynewsapi.dto;

import java.util.ArrayList;
import java.util.List;

public class ArticlesListDTO {

    List<ArticleDTO> articles;

    public ArticlesListDTO() {
        this.articles = new ArrayList<ArticleDTO>();
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }
}
