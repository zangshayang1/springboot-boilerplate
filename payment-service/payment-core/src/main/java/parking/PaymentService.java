package parking;

public interface PaymentService {

	long enterParking();

	int calcPayment(long code);

}