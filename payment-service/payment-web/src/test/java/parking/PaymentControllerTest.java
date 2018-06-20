package parking;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import parking.web.PaymentController;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PaymentControllerTest extends PaymentServiceTestBase {

	@Configuration
	@Import({Application.class})
	public static class TestConfig {		
		@Bean
		protected ClockMock clock() {
			return new ClockMock();
		}
	}
	
	@Autowired
	PaymentController controller;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	ClockMock clock;
	
	@Override
	protected PaymentService makePaymentService() {
		return new PaymentService() {
			
			@Override
			public long enterParking() {
				return controller.enterParking();
			}
			
			@Override
			public int calcPayment(long code) {
				return controller.calcPayment(code);
			}
		};
	}

	@Override
	protected void assumeCurrTimeIs(long time) {
		clock.setCurrTime(time);
	}

}