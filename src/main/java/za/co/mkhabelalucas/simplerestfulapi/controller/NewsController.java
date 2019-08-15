package za.co.mkhabelalucas.simplerestfulapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.co.mkhabelalucas.simplerestfulapi.constatns.Constants;
import za.co.mkhabelalucas.simplerestfulapi.entity.NewsEntity;
import za.co.mkhabelalucas.simplerestfulapi.service.NewsService;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET, value = "/getallnews")
    public List<NewsEntity> getAllNews() {
        return newsService.getAllNews();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getnewsbyid/{id}")
    public NewsEntity getNewsById(@PathVariable Long id) {

        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.ID_REQUIRED);
        } else {
            return newsService.getNewsById(id);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletenews/{id}")
    public void deleteNews(@PathVariable Long id) {

        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.ID_REQUIRED);
        } else {
            newsService.deleteNews(id);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/addnews", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNews(@RequestBody NewsEntity newsModel) {

        if (newsModel == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.NEWS_BODY_REQUIRED);
        } else {
            return new ResponseEntity<>(newsService.addNews(newsModel), HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updatenews/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateNews(@PathVariable Long id, @RequestBody NewsEntity newsModel) {

        if (newsModel == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.NEWS_BODY_REQUIRED);
        } else {
            return new ResponseEntity<>(newsService.updateNews(newsModel), HttpStatus.OK);
        }
    }
}
