package commons.bean;

public class Msg {
	private boolean suc;
	private String desc;
	private int code;
	private Object data;
	
	public Msg(boolean suc) {
		this.suc = suc;
	}
	
	public Msg(String desc) {
		this.desc = desc;
	}
	
	public Msg(boolean suc,String desc) {
		this.suc = suc;
		this.desc = desc;
	}
	
	public Msg(boolean suc,Object data) {
		this.suc = suc;
		this.data = data;
	}
	
	public Msg(boolean suc,int code,String desc) {
		this.suc = suc;
		this.code = code;
		this.desc = desc;
	}
	
	public Msg(boolean suc,int code,String desc,Object data) {
		this.suc = suc;
		this.code = code;
		this.desc = desc;
		this.data = data;
	}
	
	public static Msg createScuMsg() {
		return new Msg(true);
	}
	
	public static Msg createSucMsg(String desc) {
		return new Msg(true,desc);
	}
	
	public static Msg createSucMsg(Object data) {
		return new Msg(true,data);
	}
	
	public static Msg createFailMsg(String desc) {
		return new Msg(false,desc);
	}
	
	public static Msg createFailMsg(int code,String desc) {
		return new Msg(false,code,desc);
	}

	public boolean isSuc() {
		return suc;
	}

	public void setSuc(boolean suc) {
		this.suc = suc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public String toString() {
		return "suc: "+suc+" ,code: "+code+" ,desc: "+desc;
	}
}
