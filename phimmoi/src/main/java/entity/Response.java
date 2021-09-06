package entity;

public class Response {
	private int id;
	private String content;
	private long user_id;
	private int comment_id;
	private String time;
	private String name;
	private int phim_id;

	public Response() {
		super();
	}

	public Response(int id, String content, long user_id, int comment_id,  String time, String name,int phim_id) {
		super();
		this.id = id;
		this.content = content;
		this.user_id = user_id;
		this.comment_id = comment_id;
		this.phim_id = phim_id;
		this.time = time;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getPhim_id() {
		return phim_id;
	}

	public void setPhim_id(int phim_id) {
		this.phim_id = phim_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", content=" + content + ", user_id=" + user_id + ", comment_id=" + comment_id
				+ ", phim_id=" + phim_id + ", time=" + time + ", name=" + name + "]";
	}

}
