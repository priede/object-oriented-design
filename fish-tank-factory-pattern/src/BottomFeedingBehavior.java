
public class BottomFeedingBehavior implements FishBehavior{
	public double xspeed() {
		return 2.0; 
	}
	public double yspeed() {
		return 0;
	}
	public double xDirectionChangePct() {
		return 0.1;
	}
	public double yDirectionChangePct() {
		return 0;
	}
	public double xinitialpos() {
		return Aquarium.INIT_TANK_WD / 3; 
	}
	public double yinitialpos() {
		return Aquarium.INIT_TANK_HT / 1.5;
	}
}
