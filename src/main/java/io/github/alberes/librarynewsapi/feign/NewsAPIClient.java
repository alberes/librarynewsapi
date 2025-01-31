package io.github.alberes.librarynewsapi.feign;

import feign.RequestLine;
import io.github.alberes.librarynewsapi.dto.ArticleDTO;
import io.github.alberes.librarynewsapi.dto.ArticlesListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "newsapi", url = "${newsapi.client.url}")
public interface NewsAPIClient {

    @GetMapping("/v2/everything")
    ArticlesListDTO getArticles(
            @RequestParam("q") String q,
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("domains") String domains,
            @RequestParam("apiKey") String apiKey);

    @GetMapping("/v2/top-headlines")
    ArticlesListDTO getTopArticles(
            @RequestParam("country") String country,
            @RequestParam("category") String category,
            @RequestParam("sources") String sources,
            @RequestParam("apiKey") String apiKey);

}
