package com.Learner;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	int Id;
	String street;
	String city;

}
