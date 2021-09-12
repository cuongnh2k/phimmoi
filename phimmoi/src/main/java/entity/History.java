package entity;

public class History {
	private long id;
	private String title;
	private String time;

	public History() {
		super();
	}

	public History(long id, String title, String time) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", name=" + title + ", time=" + time + "]";
	}

}
