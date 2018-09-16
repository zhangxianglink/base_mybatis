package cn.zx.pojo;

import java.util.List;

public class Command {
	
	private Integer id;
	private String cname;
	private String description;
	private List<C_Content> contents;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<C_Content> getContents() {
		return contents;
	}
	public void setContents(List<C_Content> contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "Command [id=" + id + ", cname=" + cname + ", description=" + description + ", contents=" + contents
				+ "]";
	}
	
	

}
