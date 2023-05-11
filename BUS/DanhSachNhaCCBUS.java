package BUS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import DAO.*;
import DTO.*;
public class DanhSachNhaCCBUS implements Serializable, DanhSachBUS {
       private ArrayList<SupplierDTO> listNhaCungCap = new ArrayList<>();
       private int count;
       SupplierDAO temp = new SupplierDAO();

       public DanhSachNhaCCBUS() {
        AddressDTO address1 = new AddressDTO("TPHCM", "Bình Tân", "Chiến lược");
        AddressDTO address2 = new AddressDTO("Hà Nội", "Ba Đình", "Thương đau đầy ải nhân gian");

        SupplierDTO A = new SupplierDTO("Meow", address1, "0904549523", "Meow@gmail.com", getID());
        SupplierDTO B = new SupplierDTO("Fish", address2, "0345549844", "Fish@gmail.com", getID());
        themNCC_database(A);
        themNCC_database(B);
        listNhaCungCap.add(A);
        listNhaCungCap.add(B);
        setlistNhaCungCap(listNhaCungCap);
    }

       public DanhSachNhaCCBUS(ArrayList<SupplierDTO> arr) {
              this.listNhaCungCap = arr;
              this.count = arr.size();
          }
      
          public ArrayList<SupplierDTO> getListNCC() {
              return listNhaCungCap;
          }
          public void setCount(int count) {
                 this.count = count;
          }
          // Lấy mã nhà cung cấp tiếp theo
          public String getID() {
              count++;
              Integer a = count;
              String str = a.toString();
              while (str.length() != 3)
                  str = "0" + str;
              str = "NCC" + str;
              return str;
          }

          public boolean xoaNcc_2(SupplierDTO supplier){
              if(xoaNcc_database(supplier))
              {
                  return true;
              }
              return false;
          }
          public SupplierDTO timKiemTheoID(String id) {
            for (SupplierDTO supplier : listNhaCungCap)
                if (supplier.getMa().equals(id))
                    return supplier;
            return null;
        }
          public ArrayList<SupplierDTO> timKiem_2(String tuKhoa){
              ArrayList<SupplierDTO> listFilter = new ArrayList<>();
              for (SupplierDTO Supplier : listNhaCungCap) {
                  if (Supplier.getMa().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                          Supplier.getAddress().thongtin().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                          ||
                          Supplier.getEmail().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                          Supplier.getName().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                          Supplier.getSdt().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))) {
                      listFilter.add(Supplier);
                  }
              }
              if (listFilter.isEmpty())
                  return null;
              else{
                  return listFilter;
              }
      
          }

          public boolean themNCC_database(SupplierDTO supplier) {
              try {
                  if(temp.save(supplier) == false){
                      return false;
                  }
                  
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return true;
      
          }
      
          public boolean xoaNcc_database(SupplierDTO supplier) {
              try {
                  if(temp.delete(supplier) == false){
                      return false;
                  } 
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return true;
          }
          public boolean suaNCC_database(SupplierDTO supplier){
              try {
                  if(temp.update(supplier)){
                      return true;
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
              return false;
          }
          public void setlistNhaCungCap(ArrayList<SupplierDTO> listNhaCungCap) {
            this.listNhaCungCap = listNhaCungCap;
        }
        public ArrayList<SupplierDTO> getListNhaCungCap() {
               return listNhaCungCap;
        }

       @Override
       public void xuatTieuDe() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'xuatTieuDe'");
       }

       @Override
       public void xuatDS() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'xuatDS'");
       }

       @Override
       public String getMaSP_Food() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'getMaSP_Food'");
       }

       @Override
       public String getMaSP_Drink() {
              // TODO Auto-generated method stub
              throw new UnsupportedOperationException("Unimplemented method 'getMaSP_Drink'");
       }
}
