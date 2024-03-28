
public class Site extends Attraction{
	private String name;
	
	public Site(String name,double sitex,double sitey) {
		super(sitex,sitey);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
