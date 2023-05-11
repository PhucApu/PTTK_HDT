package BUS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import DTO.*;
import DAO.*;

public class StaffsBUS implements Serializable {
    public ArrayList<StaffDTO> staffs;
    ManagerDAO temp_Manager = new ManagerDAO();
    FullTimeStaffDAO temp_FullTimeStaff = new FullTimeStaffDAO();
    SeasonalStaffDAO temp_SeasonalStaff = new SeasonalStaffDAO();

    public ArrayList<StaffDTO> getStaffs() {
        return staffs;
    }

    public void setStaffs(ArrayList<StaffDTO> staffs) {
        this.staffs = staffs;
    }
    
    public StaffsBUS() {
        this.staffs = new ArrayList<>();
        // Address address = new Address("TPHCM","Quận 7","Lê Văn Lương");
        // Staff nv1 = new SeasonalStaff("NV001","111111111","Nguyễn Thanh
        // Sang","Nam",address,"11/02/2004","123",25000,80);
        // themSeasonStaff_database((SeasonalStaff)nv1);
        // staffs.add(nv1);
        // Staff nv2 = new FullTimeStaff("NV002","123456789","Phúc Apu
        // Trương","Nam",address,"20/11/2003","123",4000000,1.8f,29);
        // staffs.add(nv2);
        // themFullTimeStaff_database((FullTimeStaff)nv2);
        // // Staff nv3 = new FullTimeStaff("NV003","987654321","Vũ Lê Khánh
        // Trinh","Khác",address,"20/11/2003","123",3900000,1.3f,30);
        // // staffs.add(nv3);
        // Staff nv4 = new Manager("NV004","333333333","Lê Tấn Minh
        // Toàn","Nam",address,"31/01/2002","123",4000000,1.8f,30,500000);
        // staffs.add(nv4);
        // themManager_database((Manager) nv4);
    }

    public void addList_SeasonalStaff(ArrayList<SeasonalStaffDTO> list) {
        if (list != null) {
            for (SeasonalStaffDTO iterable_element : list) {
                this.staffs.add(iterable_element);
            }
        }
    }

    public void addList_FullTimeStaff(ArrayList<FullTimeStaffDTO> list) {
        if (list != null) {
            String[] check_id_manager = new String[this.staffs.size()]; // check xem neu nv da lam quan ly roi thi ko
                                                                        // lam full time
            int index = 0;
            for (StaffDTO iterable_element : this.staffs) {
                check_id_manager[index] = iterable_element.getId();
                index++;
            }
            for (FullTimeStaffDTO iterable_element : list) {
                int flag = 0;
                for (int i = 0; i < index; i++) {
                    if (iterable_element.getId().equals(check_id_manager[i])) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    this.staffs.add(iterable_element);
                }

            }
        }
    }

    public void addList_Manager(ArrayList<ManagerDTO> list) {
        if (list != null) {
            for (ManagerDTO iterable_element : list) {
                this.staffs.add(iterable_element);
            }
        }
    }

    public boolean themNhanVien_2(StaffDTO staff) {
        if (staff instanceof SeasonalStaffDTO) {
            if (themSeasonStaff_database((SeasonalStaffDTO) staff)) {
                return true;
            }
            return false;
        } else if (staff instanceof ManagerDTO) {
            if (themManager_database((ManagerDTO) staff)) {
                return true;
            }
            return false;
        } else {
            if (themFullTimeStaff_database((FullTimeStaffDTO) staff)) {
                return true;
            }
            return false;
        }
    }


    // check DN
    public StaffDTO checkDN(String id, String pass){
        StaffDTO staffDTO = null;
        for (StaffDTO iterable_element : this.staffs) {
            if(iterable_element.getId().equals(id) && iterable_element.getPassWord().equals(pass)){
                staffDTO = iterable_element;
                return staffDTO;
            }
        }
        return null;
    }


    public ArrayList<StaffDTO> timtheoKey_2(String tuKhoa) {
        ArrayList<StaffDTO> ds_loc = new ArrayList<>();
        for (StaffDTO staff : this.staffs) {
            String city = staff.getAddress().getCity();
            String district = staff.getAddress().getDistrict();
            String street = staff.getAddress().getStreet();
            String chucVu = "";
            if (staff instanceof SeasonalStaffDTO) {
                chucVu = "SeasonalStaff";
            } else if (staff instanceof ManagerDTO) {
                chucVu = "Manager";
            } else if (staff instanceof FullTimeStaffDTO) {
                chucVu = "FullTimeStaff";
            }
            if (staff.getId().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                    || staff.getName().toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    ||
                    staff.getCmnd().toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    ||
                    staff.getDate().toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    ||
                    staff.getGender().toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    ||
                    staff.getPassWord().toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    ||
                    city.toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    ||
                    district.toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    ||
                    street.toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))
                    || chucVu.toLowerCase(Locale.ROOT)
                            .contains(tuKhoa.toLowerCase(Locale.ROOT))) {
                ds_loc.add(staff);
            }
        }
        return ds_loc;

    }

    public boolean suaNhanVien_2(StaffDTO staff) {
        if (staff instanceof SeasonalStaffDTO) {
            if (updateSeasonStaff_database((SeasonalStaffDTO) staff)) {
                return true;
            }
            return false;
        } else if (staff instanceof ManagerDTO) {
            if (updateManagerStaff_database((ManagerDTO) staff)) {
                return true;
            }
            return false;
        } else {
            if (updateFullTimeStaff_database((FullTimeStaffDTO) staff)) {
                return true;
            }
            return false;
        }
    }

    public boolean xoaNhanVien_2(StaffDTO staff) {
        if (staff instanceof SeasonalStaffDTO) {
            if (xoaSeasonStaff_database((staff.getId()))) {
                return true;
            }
            return false;
        } else if (staff instanceof ManagerDTO) {
            return false;
        } else {
            if (xoaFullTimeStaff_database((staff.getId()))) {
                return true;
            }
            return false;
        }
    }

    public ManagerDTO getManager_database(String idManager) {
        ManagerDTO manager = null;
        try {
            manager = temp_Manager.get(idManager);
            return manager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manager;
    }

    public FullTimeStaffDTO getFullTimeStaff_database(String idFullTimeStaff) {
        FullTimeStaffDTO fullTimeStaff = null;
        try {
            fullTimeStaff = temp_FullTimeStaff.get(idFullTimeStaff);
            return fullTimeStaff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullTimeStaff;
    }

    public SeasonalStaffDTO getSeasonalStaff_database(String idSeasonStaff) {
        SeasonalStaffDTO seasonalStaff = null;
        try {
            seasonalStaff = temp_SeasonalStaff.get(idSeasonStaff);
            return seasonalStaff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seasonalStaff;
    }

    private boolean themManager_database(ManagerDTO manager) {
        try {
            if (temp_Manager.save(manager)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean themFullTimeStaff_database(FullTimeStaffDTO fullTimeStaff) {
        try {
            if (temp_FullTimeStaff.save(fullTimeStaff)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean themSeasonStaff_database(SeasonalStaffDTO seasonalStaff) {
        try {
            if (temp_SeasonalStaff.save(seasonalStaff)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean xoaManager_database(String id) {
        try {
            if (temp_Manager.deleteById(id)) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean xoaFullTimeStaff_database(String id) {
        try {
            if (temp_FullTimeStaff.deleteById(id)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean xoaSeasonStaff_database(String id) {
        try {
            if (temp_SeasonalStaff.deleteById(id)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateManagerStaff_database(ManagerDTO manager) {
        try {
            if (temp_Manager.update(manager)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateFullTimeStaff_database(FullTimeStaffDTO dFullTimeStaff) {
        try {
            if (temp_FullTimeStaff.update(dFullTimeStaff)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateSeasonStaff_database(SeasonalStaffDTO seasonalStaff) {
        try {
            if (temp_SeasonalStaff.update(seasonalStaff)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
