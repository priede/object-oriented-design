public enum MeanFactory implements FishFactory {
   INSTANCE; 
   public FishType create() {
      return new MeanFish();
   }
   public FishBehavior newBehave() {
	   return new ErraticBehavior(); 
   }
}