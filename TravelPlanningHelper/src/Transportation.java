
public class Transportation {
	private String name;
	private double speed,cost,time,costPerUnit;
	
	public Transportation(String name,double costPerUnit,double speed) {
		this.name = name;
		this.speed = speed;
		this.costPerUnit = costPerUnit;
	}
	
	public boolean cost(int budget,double distance) {
		if(budget>=cost) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double time(double distance) {
		time = distance/speed;
		return time;
	}
	
	public double calCostTaxi(double distance) {
		if(distance -1.25>0) {
			cost = (distance - 1.25)*costPerUnit + 70;
		}
		else {
			cost = 70;
		}
		return cost;
	}
	
	public double calCostScooter(double distance) {
		if(time(distance)*60 - 6 > 0) {
			cost = 15 + (time(distance) * 60 -6 ) * costPerUnit;
		}
		else {
			cost = 15;
		}
		return cost;
	}
	
	public String getInfo() {
		return String.format("by all %s	→ cost: %.0f NTD/time: %.1f hours",name,cost,time);
	}
	
}
