package parking;
public class InMemPaymentTest extends PaymentServiceTestBase {

	ClockMock clock = new ClockMock();

	private final class StoreFake implements ParkingStore {
		@Override
		public long addParkingEntry(long time) {
			return time;
		}

		@Override
		public long fetchParkingEntry(long code) {
			return code;
		}
	}

	protected void assumeCurrTimeIs(long time) {
		clock.setCurrTime(time);
	}

	protected PaymentService makePaymentService() {
		return new PaymentServiceImpl(clock, new StoreFake());
	}
}