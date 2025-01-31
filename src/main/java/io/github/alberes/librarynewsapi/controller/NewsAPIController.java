package io.github.alberes.librarynewsapi.controller;

import io.github.alberes.librarynewsapi.dto.ArticleDTO;
import io.github.alberes.librarynewsapi.dto.ArticlesListDTO;
import io.github.alberes.librarynewsapi.feign.NewsAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/newsapi/v1")
public class NewsAPIController {

    @Autowired
    private NewsAPIClient newsAPIClient;

    @Value("${newsapi.client.apikey}")
    private String apiKey;

    @GetMapping("/everything/authors")
    public ResponseEntity<List<ArticleDTO>> authors(@RequestParam Map<String,String> searchParams){

        ArticlesListDTO authos = this.newsAPIClient.getArticles(
                searchParams.get("q"),
                searchParams.get("from"),
                searchParams.get("to"),
                searchParams.get("sortBy"),
                searchParams.get("domains"),
                apiKey
        );

        if(authos.getArticles().isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(authos.getArticles());
    }

    @GetMapping("/top-headlines/authors")
    public ResponseEntity<List<ArticleDTO>> topAuthors(@RequestParam Map<String,String> searchParams){

        ArticlesListDTO authos = this.newsAPIClient.getTopArticles(
                searchParams.get("country"),
                searchParams.get("category"),
                searchParams.get("sources"),
                apiKey
        );

        if(authos.getArticles().isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(authos.getArticles());
    }
}
