package guizi.news.dao;

import guizi.news.entity.News;

import java.io.Serializable;

import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import commons.db.MongoDao;

public class NewsDao extends MongoDao<News, Serializable>{
	
	public boolean incComments(String newsId) {
		UpdateOperations<News> ops = morphiaDao.createUpdateOperations();
		ops.inc("comments");
		UpdateResults rst = morphiaDao.updateFirst(createQuery().field("id").equal(newsId), ops);
		if(rst.getUpdatedExisting()) {
			return true;
		}else {
			return false;
		}
	}
}
