public enum OctoFactory implements FishFactory {
   INSTANCE; 
   public FishType create() {
      return new Octopus();
   }
   public FishBehavior newBehave() {
	   return new BottomFeedingBehavior(); 
   }
}