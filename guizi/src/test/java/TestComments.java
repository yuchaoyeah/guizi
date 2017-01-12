import guizi.news.entity.Comments;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;


public class TestComments {

	@Test
	public void test() {
		Comments cmt = new Comments();
		cmt.setId("123");
		
		Comments ccmt = new Comments();
		ccmt.setId("456");
		ccmt.setCcommentId("123");
		Comments cccmt = new Comments();
		cccmt.setId("789");
		cccmt.setCcommentId("456");
		
		List<Comments> childs2 = new ArrayList<Comments>();
		childs2.add(cccmt);
		ccmt.setChilds(childs2);
		List<Comments> childs1 = new ArrayList<Comments>();
		childs1.add(ccmt);
		cmt.setChilds(childs1);
		
		String json = JSON.toJSONString(cmt);
		System.out.println(json);
	}

}
