package com.carpoling.carpooling.controller;
import com.carpoling.carpooling.model.OfferRide;
import com.carpoling.carpooling.model.TakeRide;
//import  com.carpoling.carpooling.model.TakeRide;
import com.carpoling.carpooling.repo.OfferRideRepo;
import com.carpoling.carpooling.repo.TakeRideRepo;
import com.carpoling.carpooling.repo.TakeRideRepo;
import java.util.List; 
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
@RestController
public class OfferRideController {
	@Autowired
	OfferRideRepo okrepo;
	@Autowired
	TakeRideRepo tkrepo;
	@RequestMapping(value = "/addRide", method = RequestMethod.POST)
   public OfferRide addRide(@RequestBody OfferRide ok)
   { 
		//System.out.println(ok.getPickup()+"     " + ok.getDrop() + "  "+ ok.getTime());
		okrepo.save(ok);
		return ok;
    }
	@RequestMapping(value = "/getRide", method = RequestMethod.GET)
	 public List<OfferRide> getRide(@RequestBody OfferRide ok)
	 {   //OfferRide ok=new OfferRide();
		String pickup=ok.getPickup();
		String drop=ok.getDrop();
	    String time=ok.getTime();
		System.out.println(pickup+"     " + drop + "  "+ time);
		return tkrepo.searchRide(pickup,drop,time);
	 }
	 @RequestMapping(value = "/search",method = RequestMethod.GET)
	 public List<OfferRide> getRideFilter(@RequestBody OfferRide ok){
		 List<OfferRide> users = okrepo.findByPickupLikeOrderByCostAsc("delhi");
		 return users;
	 }
	
}