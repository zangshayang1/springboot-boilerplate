package parking;

public interface PaymentPolicy {

	int calcPayment(long entryTime, long paymentTime);

}