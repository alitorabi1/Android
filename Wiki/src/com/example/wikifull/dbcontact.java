package com.example.wikifull;



public class dbcontact {
	
	private long id;
	private String name;
	private String mode;
	private String link;
	private String code;
	private String swlast;
	private String matn;
	private String rez;
	private String count;
	private int counti;
	
	
	
	
	
	
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
	
	
	public String getname(){
		return name;
	}
	public String getmode(){
		return mode;
	}
	public String getlink(){
		return link;
	}
	public String getcode(){
		return code;
	}
	public String getswlast(){
		return swlast;
	}
	public String getmatn(){
		return matn;
	}
	public String getrez(){
		return rez;
	}
	
	
	
	
	public void setId(long id){
		this.id=id;
	}
	
	public void setcount(String count){
		this.count=count;
	}
	
	
	
	
	public void setcounti(int counti){
		this.counti=counti;
	}
	
	public void setname(String name){
		this.name=name;
	}
	public void setmode(String mode){
		this.mode=mode;
	}
	public void setlink(String link){
		this.link=link;
	}
	public void setcode(String code){
		this.code=code;
	}
	public void setswlast(String swlast){
		this.swlast=swlast;
	}
	public void setmatn(String matn){
		this.matn=matn;
	}
	public void setrez(String rez){
		this.rez=rez;
	}

}
