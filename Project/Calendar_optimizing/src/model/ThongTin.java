package model;

public abstract class ThongTin {
	private String ma;
	private String ten;

	public ThongTin(String ma, String ten) {
		this.ma = ma;
		this.ten = ten;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}
