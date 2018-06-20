package parking;

public class PerHourPaymentPolicy implements PaymentPolicy {

	private static final int INTERVAL_MINUTES = 15;
	private static final int INTERVAL_RATE = 3;
	private static final int HOUR_RATE = 10;

	public int calcPayment(long entryTime, long paymentTime) {
		long timeInParking = paymentTime - entryTime;
		if (timeInParking < minAsMillis(60)) {
			return HOUR_RATE;
		}
		int numOnIntervals = intervalsToPay(timeInParking - minAsMillis(60));
		return HOUR_RATE + numOnIntervals * INTERVAL_RATE;
	}

	private static int intervalsToPay(long timeInParking) {
		return 1 + (int) (timeInParking / minAsMillis(INTERVAL_MINUTES));
	}

	private static long minAsMillis(int min) {
		return min * 60 * 1000L;
	}

}