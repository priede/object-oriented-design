public enum AngelFactory implements FishFactory {
   INSTANCE; 
   public FishType create() {
      return new AngelFish();
   }
   public FishBehavior newBehave() {
	   return new NormalBehavior(); 
   }
}