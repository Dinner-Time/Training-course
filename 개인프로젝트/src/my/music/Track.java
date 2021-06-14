package my.music;

public class Track {
	private String selectedImage;
	private String selectedImageTitle;
	private String selectedMusic;
	
	public String getSelectedImageTitle() {
		return selectedImageTitle;
	}
	public void setSelectedImageTitle(String selectedImageTitle) {
		this.selectedImageTitle = selectedImageTitle;
	}
	public String getSelectedImage() {
		return selectedImage;
	}
	public void setSelectedImage(String selectedImage) {
		this.selectedImage = selectedImage;
	}
	public String getSelectedMusic() {
		return selectedMusic;
	}
	public void setSelectedMusic(String selectedMusic) {
		this.selectedMusic = selectedMusic;
	}
	public Track(String selectedImage, String selectedImageTitle, String selectedMusic) {
		super();
		this.selectedImage = selectedImage;
		this.selectedImageTitle = selectedImageTitle;
		this.selectedMusic = selectedMusic;
	}
	
	
}
