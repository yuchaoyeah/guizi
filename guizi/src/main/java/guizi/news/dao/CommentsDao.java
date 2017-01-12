package guizi.news.dao;

import guizi.news.entity.Comments;

import java.io.Serializable;
import java.util.List;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import commons.db.MongoDao;

public class CommentsDao extends MongoDao<Comments, Serializable>{
	
	public List<Comments> loadL1Comments(String newsId,String order) {
		Query<Comments> query = this.createQuery();
		query.field("newsId").equal(newsId);
		query.or(query.criteria("ccommentId").equal(""),query.criteria("ccommentId").doesNotExist());
		query.order(order);
		return query.asList();
	}
	
	public void incUps(String commentId) {
		UpdateOperations<Comments> ops = morphiaDao.createUpdateOperations();
		ops.inc("up");
		morphiaDao.updateFirst(createQuery().field("id").equal(commentId), ops);
	}
	
	public void incDowns(String commentId) {
		UpdateOperations<Comments> ops = morphiaDao.createUpdateOperations();
		ops.inc("down");
		morphiaDao.updateFirst(createQuery().field("id").equal(commentId), ops);
	}
}
