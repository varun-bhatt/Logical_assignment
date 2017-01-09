
public class Getter {
	
	String source;
	String dest;
	String cc;
	int cost;
	int time;
	
	public Getter()
	{
		
	}
	public Getter(String source, String dest, String cc, int cost, int time) {
		super();
		this.source = source;
		this.dest = dest;
		this.cc = cc;
		this.cost = cost;
		this.time = time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
	
}
