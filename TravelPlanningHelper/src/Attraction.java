
public class Attraction {
private double lat1,lon1;
	
	public Attraction(double lat1,double lon1) {
		this.lat1 = lat1;
		this.lon1 = lon1;
	}
	
	public double getDistanceFromLatLonInKm(double lat2,double lon2) {
	    int R = 6371; // Radius of the earth in k
	    double dLat = Math.toRadians(lat2-lat1);  // deg2rad below
	    double dLon = Math.toRadians(lon2-lon1); 
	    double a = 
	      Math.sin(dLat/2) * Math.sin(dLat/2) +
	      Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * 
	      Math.sin(dLon/2) * Math.sin(dLon/2); 
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
	    double d = R * c; // Distance in km
	    return d;
	  }

	public double getSiteX() {
		return lat1;
	}

	public double getSiteY() {
		return lon1;
	}
}
