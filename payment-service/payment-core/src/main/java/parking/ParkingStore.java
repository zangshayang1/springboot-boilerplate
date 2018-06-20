package parking;

public interface ParkingStore {
	long addParkingEntry(long time);
	long fetchParkingEntry(long code); 
}