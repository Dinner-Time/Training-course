package my.game.model;

public class Track {
	private String selectedImage;
	private String gameStartButtonBasic;
	private String gameStartButtonEntered;
	private String selectedMusic;
	
	public String getGameStartButtonBasic() {
		return gameStartButtonBasic;
	}
	public void setGameStartButtonBasic(String gameStartButtonBasic) {
		this.gameStartButtonBasic = gameStartButtonBasic;
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
	public String getGameStartButtonEntered() {
		return gameStartButtonEntered;
	}
	public void setGameStartButtonEntered(String gameStartButtonEntered) {
		this.gameStartButtonEntered = gameStartButtonEntered;
	}
	public Track(String selectedImage, String gameStartButtonBasic, String gameStartButtonEntered, String selectedMusic) {
		super();
		this.selectedImage = selectedImage;
		this.gameStartButtonBasic = gameStartButtonBasic;
		this.gameStartButtonEntered = gameStartButtonEntered;
		this.selectedMusic = selectedMusic;
	}
	
	
}
