package za.co.mkhabelalucas.simplerestfulapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mkhabelalucas.simplerestfulapi.constatns.Constants;
import za.co.mkhabelalucas.simplerestfulapi.entity.NewsEntity;
import za.co.mkhabelalucas.simplerestfulapi.repository.NewsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    Logger logger = Logger.getLogger(NewsService.class.getSimpleName());


    public List<NewsEntity> getAllNews() {
        return newsRepository.findAll();
    }

    public String addNews(NewsEntity newsModel) {

        if (newsRepository.save(newsModel).toString() != null) {

            return Constants.ADDED_SUCCESSFUL;
        } else {
            return Constants.FAILED;
        }
    }

    public NewsEntity getNewsById(Long id) {
        if (id == null) {
            throw new EntityNotFoundException("Please provide an Id");
        }
        return newsRepository.getOne(id);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    public String updateNews(NewsEntity newsModel) {

        if (newsRepository.save(newsModel).toString() != null) {

            return Constants.ADDED_SUCCESSFUL;
        } else {
            return Constants.FAILED;
        }
    }
}

