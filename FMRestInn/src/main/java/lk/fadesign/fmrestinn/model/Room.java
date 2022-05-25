package lk.fadesign.fmrestinn.model;

public class Room {
	private int id;
	private String title;
	private String description;
	private int price;
	private String bed;
	private String type;
	private int count;
	private String image;
	
	public Room() {}	
	
	
	
	public Room(int id) {
		super();
		this.id = id;
	}



	public Room(int id, String title, String description, int price, String bed, String type, int count) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.bed = bed;
		this.type = type;
		this.count = count;
	}

	public Room(String title, String description, int price, String bed, String type, int count) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.bed = bed;
		this.type = type;
		this.count = count;
	}

	public Room(String title, String description, int price, String bed, String type, int count, String image) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.bed = bed;
		this.type = type;
		this.count = count;
		this.image = image;
	}
	
	public Room(int id, String title, String description, int price, String bed, String type, int count, String image) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.bed = bed;
		this.type = type;
		this.count = count;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getBed() {
		return bed;
	}
	
	public void setBed(String bed) {
		this.bed = bed;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
