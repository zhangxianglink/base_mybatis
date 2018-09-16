package cn.zx.pojo;

public class C_Content {

	private Integer id;
	private String content;
	private Integer c_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "C_Content [id=" + id + ", content=" + content + ", c_id=" + c_id + "]";
	}
	
	
}
