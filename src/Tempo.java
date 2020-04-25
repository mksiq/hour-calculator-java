
public class Tempo {


	private int totalMinutes;
	private int hours;
	private int minutes;


	public Tempo(int hours, int minutes, int totalMinutes) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.totalMinutes = totalMinutes+hoursToMinutes(hours)+minutes;
	}

	
	public double getTotalMinutes() {
		return totalMinutes;
	}


	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
	}


	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return this.hoursToMinutes(this.hours)+minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Tempo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double minutesToHours(){
		return this.minutes/60;

	}

	public int hoursToMinutes(int hours){
		return hours*60;
	}

	@Override
	public String toString() {
		int horas = this.totalMinutes/60;
		int minutos = this.totalMinutes%60;
		return horas + "H " + minutos + "m";
	}
	
	
}
