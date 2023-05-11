package DTO;
import java.io.Serializable;
    public class ChiTietHDDTO implements Serializable {
        public String MaSP;
        public int soluong;
        public int gia;

        //Xây dựng hàm không tham số
        public ChiTietHDDTO() {
            this.MaSP = null;
            this.soluong = 0;
            this.gia = 0;
        }
        //Xây dựng hàm có tham số
        public ChiTietHDDTO(String MaSP, int soluong, int gia) {
            this.MaSP = MaSP;
            this.soluong = soluong;
            this.gia = gia;
        }

        public void xuatThongTin(String maHD)
        {
            System.out.printf("│%-20s│%-20s│%-20s│\n", getMaSP(),getSoluong(),getGia());
        }

        public String getMaSP() {
            return MaSP;
        }

        public void setMaSP(String MaSP) {
            this.MaSP = MaSP;
        }

        public int getSoluong() {
            return soluong;
        }

        public void setSoluong(int soluong) {
            this.soluong = soluong;
        }

        public int getGia() {
            return gia;
        }

        public void setGia(int gia) {
            this.gia = gia;
        }

    }
