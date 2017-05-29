package com.hb.day03.model;

public class SimpleVo {

	private int sabun,cnt;
	private String name,nalja;
	
	public SimpleVo() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNalja() {
		return nalja;
	}
	public void setNalja(String nalja) {
		this.nalja = nalja;
	}
	@Override
	public String toString() {
		return "SimpleVo [sabun=" + sabun + ", cnt=" + cnt + ", name=" + name + ", nalja=" + nalja + "]";
	}
	
	
	
	
}
