package parking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class PaymentServiceTestBase {

	@Before
	public void init() {
		service = makePaymentService();
	}

	abstract protected PaymentService makePaymentService();

	PaymentService service;

	@Test
	public void shouldPay10OnFirstHour() {
		long code = enterTheParkingAt(0);
		int amount = calcPaymentAt(code, 60 * 60 * 1000L - 1);
		Assert.assertEquals(10, amount);
}

	@Test
	public void shouldPay13OnTheHourMark() {
		long code = enterTheParkingAt(0);
		int amount = calcPaymentAt(code, 60 * 60 * 1000L);
		Assert.assertEquals(13, amount);
	}

	@Test
	public void shouldPay16OnTheHourAnd15MinMark() {
		long code = enterTheParkingAt(0);
		int amount = calcPaymentAt(code, (60 + 15) * 60 * 1000L);
		Assert.assertEquals(16, amount);
	}

	private int calcPaymentAt(long code, long time) {
		assumeCurrTimeIs(time);
		int amount = service.calcPayment(code);
		return amount;
	}

	private long enterTheParkingAt(int time) {
		assumeCurrTimeIs(time);
		return service.enterParking();
	}

	abstract protected void assumeCurrTimeIs(long time);
}