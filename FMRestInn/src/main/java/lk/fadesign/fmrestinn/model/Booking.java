package lk.fadesign.fmrestinn.model;

public class Booking {
	private int id;
	private User user;
	private Room room;
	private String checkin;
	private String checkout;
	private int bed;
	private String meal;
	private int rooms;
	private int totalcost;	
	private String status;
	
	
	
	public Booking(int id, User user, Room room, String checkin, String checkout, int bed, String meal, int rooms,
			int totalcost) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
		this.bed = bed;
		this.meal = meal;
		this.rooms = rooms;
		this.totalcost = totalcost;
	}

	public Booking(User user, Room room, String checkin, String checkout, int bed, String meal, int rooms,
			int totalcost) {
		super();
		this.user = user;
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
		this.bed = bed;
		this.meal = meal;
		this.rooms = rooms;
		this.totalcost = totalcost;
	}

	public Booking(int id, User user, Room room, String checkin, String checkout, int bed, String meal,
			int rooms, int totalcost, String status) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
		this.bed = bed;
		this.meal = meal;
		this.rooms = rooms;
		this.totalcost = totalcost;
		this.status = status;
	}
	
	public Booking(User user, Room room, String checkin, String checkout, int bed, String meal,
			int rooms, int totalcost, String status) {
		super();
		this.user = user;
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
		this.bed = bed;
		this.meal = meal;
		this.rooms = rooms;
		this.totalcost = totalcost;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
