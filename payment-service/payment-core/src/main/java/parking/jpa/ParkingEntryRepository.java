package parking.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingEntryRepository extends CrudRepository<ParkingEntry, Long> {

}