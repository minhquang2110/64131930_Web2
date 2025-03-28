package quangnm.models;

public class Personal {
    private String MSSV, hoTen;
    private int namSinh;
    private boolean gioiTinh;

    public Personal(String MSSV, String hoTen, int namSinh, boolean gioiTinh) {
        this.MSSV = MSSV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
    }

    public String getMSSV() {
        return MSSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getGioiTinh() {
        if(this.gioiTinh==true) {
        	return "Nam";
        }else {
        	return "Nữ";
        }
    }
}

