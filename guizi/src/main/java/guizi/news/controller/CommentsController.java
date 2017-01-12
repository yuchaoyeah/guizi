package guizi.news.controller;

import guizi.BaseController;
import guizi.news.entity.Comments;
import guizi.news.entity.News;
import guizi.news.service.CommentsService;
import guizi.news.service.NewsService;
import guizi.user.entity.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import commons.bean.Msg;
import commons.utils.JsonUtils;

@Controller
@RequestMapping("/comments")
public class CommentsController extends BaseController{
	@Autowired
	private CommentsService commentsSer;
	@Autowired
	private NewsService newsSer;

	@RequestMapping("/loadComments")
	public void loadComments(String newsId,HttpServletRequest req,HttpServletResponse res) {
		List<Comments> comments = null;
		if(StringUtils.isNotBlank(newsId)) {
			comments = commentsSer.getComments(newsId);
		}
		if(comments != null) {
			responseJson(res, JsonUtils.toString(comments));
		}
	}
	
	@RequestMapping("/addComment")
	@ResponseBody
	public Msg addComments(String newsId,String ccommentId,String content,HttpServletRequest req) {
		if(StringUtils.isBlank(newsId) || StringUtils.isBlank(content)) {
			return Msg.createFailMsg("");
		}
		News news = newsSer.get(newsId);
		if(news == null) {
			return Msg.createFailMsg("");
		}
		User user = getCurrentUser(req);
		if(user == null) {
			return Msg.createFailMsg("");
		}
		commentsSer.addComment(newsId,ccommentId,content,user);
		return Msg.createScuMsg();
	}
	
	@RequestMapping("/up")
	@ResponseBody
	public Msg up(String commentId,int type,HttpServletRequest req) {
		if(StringUtils.isBlank(commentId)) {
			return Msg.createFailMsg("");
		}
		User user = getCurrentUser(req);
		if(user == null) {
			return Msg.createFailMsg("");
		}
		commentsSer.upComment(commentId,type);
		return Msg.createScuMsg();
	}
}
