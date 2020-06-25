package com.carpoling.carpooling.repo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.carpoling.carpooling.model.OfferRide;
public interface OfferRideRepo extends MongoRepository<OfferRide,String> {
	List<OfferRide> findByPickupLikeOrderByCostAsc(String string);
	//List<OfferRide> findByPickupLikeOrderByTimeAsc(String string);5
}
