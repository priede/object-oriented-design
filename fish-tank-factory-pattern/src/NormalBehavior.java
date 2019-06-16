
public class NormalBehavior implements FishBehavior{
	public double xspeed() {
		return 2.0; 
	}
	public double yspeed() {
		return 1.0;
	}
	public double xDirectionChangePct() {
		return 0.1;
	}
	public double yDirectionChangePct() {
		return 0.5;
	}
	public double xinitialpos() {
		return Aquarium.INIT_TANK_WD / 3; 
	}
	public double yinitialpos() {
		return Aquarium.INIT_TANK_HT / 3;
	}
}
