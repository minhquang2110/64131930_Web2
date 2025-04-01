package quangnm.models;

public class Personal {
    private String MSSV, hoTen;
    private double dtb;

    public Personal(String MSSV, String hoTen, double d) {
        this.MSSV = MSSV;
        this.hoTen = hoTen;
        this.dtb = d;
    }

    public String getMSSV() {
        return MSSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getDTB() {
        return dtb;
    }
    public void setMSSV(String id) {
        MSSV=id;
    }
    public void setHoTen(String hoTen) {
        this.hoTen=hoTen;
    }
    public void setDiem(double diem) {
        this.dtb=diem;
    }
}

