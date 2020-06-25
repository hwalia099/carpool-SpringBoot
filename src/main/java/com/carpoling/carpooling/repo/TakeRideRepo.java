package com.carpoling.carpooling.repo;


import com.carpoling.carpooling.model.*;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class TakeRideRepo extends TakeRide{

    @Autowired
    MongoTemplate mongoTemplate;

    public List<OfferRide> searchRide(String pickup,String drop,String time) {
    	Query query = new Query();
    	query.addCriteria(Criteria.where("pickup").is(pickup).and("drop").is(drop).and("time").gt(time));
    	List<OfferRide> users = mongoTemplate.find(query,OfferRide.class);
    	return users;
    }
   

}