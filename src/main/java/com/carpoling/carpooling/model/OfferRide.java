package com.carpoling.carpooling.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "offer")
public class OfferRide {
	 private String name;
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String pickup;
	  private String drop;
	  private String car;
	  private String cost;
	  private String time;
	  public OfferRide() {}
	public OfferRide(String pickup, String drop, String car, String cost, String time,String name) {
		super();
		this.pickup = pickup;
		this.drop = drop;
		this.car = car;
		this.cost = cost;
		this.time = time;
		this.name=name;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getDrop() {
		return drop;
	}
	public void setDrop(String drop) {
		this.drop = drop;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}

}
