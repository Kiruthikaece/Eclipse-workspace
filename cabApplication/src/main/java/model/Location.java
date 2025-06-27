package model;

public class Location {
   
	private int id;
	private char locationName;
	private int distance;
	private int cabId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getlocationName() {
		return locationName;
	}
	public void setlocationName(char locationName) {
		this.locationName = locationName;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
}
