package parking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import parking.jpa.JpaParkingStore;
import parking.jpa.ParkingEntryRepository;
import parking.web.PaymentController;

@Configuration
public class MainConfig {

	@Bean
	protected Clock clock() {
		return new Clock() {
			@Override
			public long now() {
				return System.currentTimeMillis();
			}
		};
	}

	@Bean
	ParkingStore parkingStore(ParkingEntryRepository repository) {
		return new JpaParkingStore(repository);
	}

	@Bean
	PaymentService paymentService(Clock clock, ParkingStore parkingStore) {
		return new PaymentServiceImpl(clock, parkingStore);
	}

	@Bean
	PaymentController paymentController(PaymentService paymentService) {
		return new PaymentController(paymentService);
	}
}