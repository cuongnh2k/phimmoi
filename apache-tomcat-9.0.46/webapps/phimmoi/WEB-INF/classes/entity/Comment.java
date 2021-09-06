package entity;

public class Comment {
	private int id;
	private String content;
	private long user_id;
	private String time;
	private String name;
	private int phim_id;

	public Comment() {
		super();
	}

	public Comment(int id, String content, long user_id, String time, String name, int phim_id) {
		super();
		this.id = id;
		this.content = content;
		this.user_id = user_id;
		this.time = time;
		this.name = name;
		this.phim_id = phim_id;
	}

	public int getPhim_id() {
		return phim_id;
	}

	public void setPhim_id(int phim_id) {
		this.phim_id = phim_id;
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
		return "Comment [id=" + id + ", content=" + content + ", user_id=" + user_id + ", phim_id=" + phim_id
				+ ", time=" + time + ", name=" + name + "]";
	}

}
