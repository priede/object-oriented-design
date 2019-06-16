
public class ErraticBehavior implements FishBehavior{
	public double xspeed() {
		return 9.0; 
	}
	public double yspeed() {
		return 9.0;
	}
	public double xDirectionChangePct() {
		return 0.5;
	}
	public double yDirectionChangePct() {
		return 0.9;
	}
	public double xinitialpos() {
		return Aquarium.INIT_TANK_WD / 3; 
	}
	public double yinitialpos() {
		return Aquarium.INIT_TANK_HT / 3;
	}
}

