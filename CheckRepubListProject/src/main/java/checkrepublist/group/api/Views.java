package checkrepublist.group.api;


public interface Views {
	
	public static interface Common { }
	
	public static interface Admin extends Common { }
	public static interface Voyageur extends Common {}
	public static interface Voyage extends Common {}
	public static interface Critere extends Common {}
	
	public static interface MaterielRef extends Admin {}
	
	public static interface VoyageDetail extends Voyage { }
	
	public static interface VoyageurDetail extends Voyageur { }
    
	public static interface MaterielDetail extends MaterielRef {}
	public static interface CritereDetail extends Critere {}

}
