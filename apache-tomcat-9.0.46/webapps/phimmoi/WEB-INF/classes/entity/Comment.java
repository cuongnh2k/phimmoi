package entity;

public class Comment {
	private long id;
	private String content;
	private long user_id;
	private String time;
	private String name;
	private long phim_id;
	private boolean edit;

	public Comment() {
		super();
	}

	public Comment(long id, String content, long user_id, String time, String name, long phim_id, boolean edit) {
		super();
		this.id = id;
		this.content = content;
		this.user_id = user_id;
		this.time = time;
		this.name = name;
		this.phim_id = phim_id;
		this.edit = edit;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public long getPhim_id() {
		return phim_id;
	}

	public void setPhim_id(long phim_id) {
		this.phim_id = phim_id;
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
		return "Comment [id=" + id + ", content=" + content + ", user_id=" + user_id + ", time=" + time + ", name="
				+ name + ", phim_id=" + phim_id + ", edit=" + edit + "]";
	}

}
