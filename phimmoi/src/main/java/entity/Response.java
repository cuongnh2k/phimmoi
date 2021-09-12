package entity;

public class Response {
	private long id;
	private String content;
	private long user_id;
	private long comment_id;
	private String time;
	private String name;
	private long phim_id;
	private boolean edit;

	public Response() {
		super();
	}

	public Response(long id, String content, long user_id, long comment_id, String time, String name, long phim_id,
			boolean edit) {
		super();
		this.id = id;
		this.content = content;
		this.user_id = user_id;
		this.comment_id = comment_id;
		this.phim_id = phim_id;
		this.time = time;
		this.name = name;
		this.edit = edit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getComment_id() {
		return comment_id;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}

	public long getPhim_id() {
		return phim_id;
	}

	public void setPhim_id(long phim_id) {
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

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", content=" + content + ", user_id=" + user_id + ", comment_id=" + comment_id
				+ ", time=" + time + ", name=" + name + ", phim_id=" + phim_id + ", edit=" + edit + "]";
	}

}
