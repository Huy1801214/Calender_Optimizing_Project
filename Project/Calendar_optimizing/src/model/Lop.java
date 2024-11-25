package model;

public class Lop extends ThongTin{
	private MonHoc monHoc;
	private Phong phong;
	
	public Lop(String ma, String ten) {
		super(ma, ten);
		// TODO Auto-generated constructor stub
	}

	public Lop(String ma, String ten, MonHoc monHoc, Phong phong) {
		super(ma, ten);
		this.monHoc = monHoc;
		this.phong = phong;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	
	
}
