package com.mysimcard.tools;

public class Contact01 {
	
	private long id;
	private String name;
	private String count;
	private int counti;
	public String maintext;
	public String titrtext;
	
	
	public String getmaintext(){
		return maintext;
	}
	
	public String gettitrtext(){
		return titrtext;
	}
	
	
	
	public long getId(){
		return id;
	}
	
	public String getcount(){
		return count;
	}
	
	public int getcounti(){
		return counti;
	}
	
	public String getIdInString(){
		return Long.toString(id);
	}
	
	
	public String getName(){
		return name;
	}
	
	
	
	public void setId(long id){
		this.id=id;
	}
	
	public void setcount(String count){
		this.count=count;
	}
	
	public void setmaintext(String maintext){
		this.maintext=maintext;
	}
	
	public void settitrtext(String titrtext){
		this.titrtext=titrtext;
	}
	
	public void setcounti(int counti){
		this.counti=counti;
	}
	
	public void setName(String name){
		this.name=name;
	}

}
