package entity;

public class User {
	private long id;
	private String name;
	private String history;

	public User() {
		super();
	}

	public User(long id, String name, String history) {
		super();
		this.id = id;
		this.name = name;
		this.history = history;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", history=" + history + "]";
	}

}
