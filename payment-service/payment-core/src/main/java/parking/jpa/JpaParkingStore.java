package parking.jpa;

import parking.ParkingStore;

public final class JpaParkingStore implements ParkingStore {

	private ParkingEntryRepository repository;

	public JpaParkingStore(ParkingEntryRepository repository) {
		this.repository = repository;
	}

	@Override
	public long fetchParkingEntry(long code) {
		ParkingEntry entry = repository.findOne(code);
		return entry.getTime();
	}

	@Override
	public long addParkingEntry(long time) {
		ParkingEntry entry = new ParkingEntry();
		entry.setTime(time);
		return repository.save(entry).getCode();
	}
}