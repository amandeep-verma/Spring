package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	private int Aid;
	private String Aname;
	private String tech;
	
	@Autowired
	private Laptop l;
	
	public Laptop getL() {
		return l;
	}
	public void setL(Laptop l) {
		this.l = l;
	}
	
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Alien [Aid=" + Aid + ", Aname=" + Aname + ", tech=" + tech + "]";
	}
	
	public void show()
	{
		System.out.println("In Alien class");
		l.compile();
	}
	
}

