import javafx.scene.image.Image;

public class YellowFish implements FishType {
	private Image leftimage, rightimage;

	public YellowFish() {
		leftimage  = new Image("images/Lyellowfish.gif");
		rightimage = new Image("images/Ryellowfish.gif");
	}

	public Image leftImage() {
		return leftimage;
	}

	public Image rightImage() {
		return rightimage;
	}
}
