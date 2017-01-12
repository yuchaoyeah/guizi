package guizi.news.service;

import guizi.news.dao.CommentsDao;
import guizi.news.entity.Comments;
import guizi.user.entity.User;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
	@Autowired
	private CommentsDao commentsDao;
	@Autowired
	private NewsService newsSer;
	
	public List<Comments> getComments(String newsId) {
		List<Comments> l1Comments = commentsDao.loadL1Comments(newsId,"-createTime");
		if(l1Comments != null && !l1Comments.isEmpty()) {
			for(Comments cmt : l1Comments) {
				reverseLoadChilds(cmt);
			}
		}
		return l1Comments;
	}
	
	public void reverseLoadChilds(Comments comment) {
		List<Comments> childs = loadChilds(comment);
		if(childs != null && !childs.isEmpty()) {
			comment.setChilds(childs);
			for(Comments cmt : childs) {
				reverseLoadChilds(cmt);
			}
		}
	}
	
	public List<Comments> loadChilds(Comments comment) {
		return commentsDao.createQuery().field("ccommentId").equal(comment.getId()).asList();
	}
	
	public void addComment(String newsId,String ccommentId,String content,User user) {
		Comments comment = new Comments();
		comment.setNewsId(newsId);
		comment.setCcommentId(ccommentId);
		comment.setUserId(user.getId());
		comment.setName(user.getInfo().getName());
		comment.setAvatar(user.getInfo().getPic());
		comment.setContent(content);
		comment.setCreateTime(new Date());
		commentsDao.save(comment);
		newsSer.incComments(newsId);
	}
	
	public synchronized void upComment(String commentId,int type) {
		if(type == 1) {
			commentsDao.incUps(commentId);
		}else if(type == -1) {
			commentsDao.incDowns(commentId);
		}
	}
}
