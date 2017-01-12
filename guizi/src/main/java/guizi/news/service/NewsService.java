package guizi.news.service;

import guizi.news.dao.NewsDao;
import guizi.news.entity.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
	@Autowired
	private NewsDao newsDao;
	
	public News get(String newsId) {
		return newsDao.get(newsId);
	}
	
	public synchronized void incComments(String newsId) {
		newsDao.incComments(newsId);
	}
}
