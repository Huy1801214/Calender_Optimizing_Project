package model;

public class GiaoVien extends ThongTin {
	private MonHoc monHoc;
	
	public GiaoVien(String ma, String ten) {
		super(ma, ten);
		// TODO Auto-generated constructor stub
	}

	public GiaoVien(String ma, String ten, MonHoc monHoc) {
		super(ma, ten);
		this.monHoc = monHoc;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	
	
}
