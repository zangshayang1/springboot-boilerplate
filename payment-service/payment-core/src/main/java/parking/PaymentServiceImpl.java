package parking;
public class PaymentServiceImpl implements PaymentService {

	private PaymentPolicy paymentPolicy = new PerHourPaymentPolicy();
	private Clock clock;
	private ParkingStore store;

	public PaymentServiceImpl(Clock clock, ParkingStore store) {
		this.clock = clock;
		this.store = store;
	}

	public long enterParking() {
		long entryTime = clock.now();
		return store.addParkingEntry(entryTime);
	}

	public int calcPayment(long code) {
		long paymentTime = clock.now();
		long entryTime = store.fetchParkingEntry(code);
		return paymentPolicy.calcPayment(entryTime, paymentTime);
	}

}