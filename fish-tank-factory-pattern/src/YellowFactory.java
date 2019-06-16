public enum YellowFactory implements FishFactory {
   INSTANCE; 
   public FishType create() {
      return new YellowFish();
   }
   public FishBehavior newBehave() {
	   return new ErraticBehavior(); 
   }
}