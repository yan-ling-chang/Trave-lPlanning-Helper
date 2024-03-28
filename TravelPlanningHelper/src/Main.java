
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Site oneZeroOne = new Site("101",25.034015253745892,121.56467565652719);
		Site exhibition = new Site("南港展覽館", 25.05674767102679,121.61807298218889);
		Site amusementPark = new Site("兒童新樂園",25.097294233523936,121.51503695215715);
		Site CKSmemorialHall = new Site("中正紀念堂",25.034655934625235,121.5215010282203);
		Site zoo = new Site("木柵動物園",24.99877740610815,121.5811251723995);
		Site nightMarket = new Site("士林夜市",25.088249233297443,121.52428822822138);
		
		
		ArrayList<Site>sites = new ArrayList<Site>();
		Scanner sc = new Scanner(System.in);
		
		sites.add(oneZeroOne);
		sites.add(exhibition);
		sites.add(amusementPark);
		sites.add(CKSmemorialHall);
		sites.add(zoo);
		sites.add(nightMarket);
		
		System.out.println("Please choose four sites from these sites below, "
				+ "your schedule will be the same as your input order:");
		String site = "";
		for(Site s:sites) {
			if(sites.indexOf(s)==0) {
				site += (sites.indexOf(s)+1)+")"+s.getName();
			}
			else {
				site += " "+(sites.indexOf(s)+1)+")"+s.getName();
			}
		}
		System.out.println(site);
		System.out.print("Your choice (input the number of the site):");
		int start = sc.nextInt();
		int op1 = sc.nextInt();
		int op2 = sc.nextInt();
		int op3 = sc.nextInt();
		System.out.print("Please input your transpotation budget(must be a positive number):");
		int budget = sc.nextInt();
		
		while(budget<=0) {
			System.out.print("Please input a positive number:");
			budget = sc.nextInt();
		}
		
		Transportation taxi = new Transportation("Taxi",5,70);
		Transportation goShare = new Transportation("goShare",2.5,50);
		Transportation car = new Transportation("car",2,80);
		
		ArrayList<Site>picked = new ArrayList<Site>();
		picked.add(sites.get(start-1));
		picked.add(sites.get(op1-1));
		picked.add(sites.get(op2-1));
		picked.add(sites.get(op3-1));
		
		double totalDistance = 0;
		for(Site dis:picked) {
			if(picked.indexOf(dis)<3) {
				totalDistance += dis.getDistanceFromLatLonInKm(picked.get(picked.indexOf(dis)+1).getSiteX()
						,picked.get(picked.indexOf(dis)+1).getSiteY());	
			}
		}
		
		taxi.calCostTaxi(totalDistance);
		taxi.time(totalDistance);
		goShare.calCostScooter(totalDistance);
		goShare.time(totalDistance);
		car.calCostTaxi(totalDistance);
		car.time(totalDistance);
		
		System.out.print(taxi.getInfo());
		if(taxi.cost(budget, totalDistance)) {
			System.out.println("  在預算內");
		}
		
		else {
			System.out.println("  超出預算");
		}
		System.out.print(goShare.getInfo());
		if(goShare.cost(budget, totalDistance)) {
			System.out.println("  在預算內");
		}
		
		else {
			System.out.println("  超出預算");
		}
		
		System.out.print(car.getInfo());
		if(car.cost(budget, totalDistance)) {
			System.out.println("  在預算內");
		}
		
		else {
			System.out.println("  超出預算");
		}
		
		for(Site p:picked) {
			if(picked.indexOf(p)==0) {
				System.out.print("Your schedule: "+p.getName());
			}
			else {
				System.out.print(" "+p.getName());
			}
		}
		sc.close();
	}

}
