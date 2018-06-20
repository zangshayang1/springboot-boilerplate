package parking.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParkingEntry {
	@Id
	@GeneratedValue
	Long code;

	long time;

	public Long getCode() {
		return code;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}