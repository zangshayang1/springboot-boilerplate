/**
 * 
 */
package parking;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import parking.jpa.JpaParkingStore;
import parking.jpa.ParkingEntry;
import parking.jpa.ParkingEntryRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories( basePackageClasses = ParkingEntryRepository.class )

public class JpaPaymentTest extends PaymentServiceTestBase {
	
	@SpringBootConfiguration
	@EnableJpaRepositories( basePackageClasses = ParkingEntryRepository.class )
	public static class TestConfig extends  JpaRepositoryTestConfig{
		public TestConfig() {
			super(ParkingEntry.class);
		}
	}
	
	private ClockMock clock = new ClockMock();
	
	@Autowired
	private ParkingEntryRepository repository;

	@Override
	protected PaymentService makePaymentService() {
		return new PaymentServiceImpl(clock, new JpaParkingStore(repository));
	}

	@Override
	protected void assumeCurrTimeIs(long time) {
		clock.setCurrTime(time);
	}
}
