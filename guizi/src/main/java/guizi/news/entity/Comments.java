package guizi.news.entity;

import guizi.news.enums.Device;

import java.util.Date;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Transient;

import commons.entity.BaseEntity;

@Entity
public class Comments extends BaseEntity{
	@Indexed
	private String newsId;
	private String userId;
	private String name;//冗余字段--评论者名称
	private String avatar;//冗余字段--评论者头像
	private String content;
	@Indexed
	private Date createTime;
	private int up;//顶
	private int down;//踩
	
	private String ccommentId;//评论的评论的Id
	private Device device;
	
	@Transient
	private List<Comments> childs;
	
	public String getNewsId() {
		return newsId;
	}
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public String getCcommentId() {
		return ccommentId;
	}
	public void setCcommentId(String ccommentId) {
		this.ccommentId = ccommentId;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public List<Comments> getChilds() {
		return childs;
	}
	public void setChilds(List<Comments> childs) {
		this.childs = childs;
	}
}
