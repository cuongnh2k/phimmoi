package entity;

public class Phim {
	private long id;
	private String type;
	private String category;
	private String episode;
	private String episodeURL;
	private String imageURL;
	private String title;
	private long view;
	private boolean report;
	private long sumEpisode;

	public Phim() {
		super();
	}

	public Phim(long id, String type, String category, String episode, String episodeURL, String imageURL, String title,
			long view, boolean report, long sumEpisode) {
		super();
		this.id = id;
		this.type = type;
		this.category = category;
		this.episode = episode;
		this.episodeURL = episodeURL;
		this.imageURL = imageURL;
		this.title = title;
		this.view = view;
		this.report = report;
		this.sumEpisode=sumEpisode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public String getEpisodeURL() {
		return episodeURL;
	}

	public void setEpisodeURL(String episodeURL) {
		this.episodeURL = episodeURL;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getView() {
		return view;
	}

	public void setView(long view) {
		this.view = view;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	public long getSumEpisode() {
		return sumEpisode;
	}

	public void setSumEpisode(long sumEpisode) {
		this.sumEpisode = sumEpisode;
	}

	@Override
	public String toString() {
		return "Phim [id=" + id + ", type=" + type + ", category=" + category + ", episode=" + episode + ", episodeURL="
				+ episodeURL + ", imageURL=" + imageURL + ", title=" + title + ", view=" + view + ", report=" + report
				+ ", sumEpisode=" + sumEpisode + "]";
	}

	

}
