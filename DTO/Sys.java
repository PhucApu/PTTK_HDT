package DTO;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.*;

// ┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │ ─
public class Sys implements Serializable {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    public static final Pattern STAFF_ID = Pattern.compile("^N+V+[0-9]{3}$");
    public static final Pattern PHONE_FORMAT = Pattern.compile("^0[0-9]{9,10}$");
    public static final Pattern CCCD_FORMAT = Pattern.compile("^0[0-9]{11}$");

    public static final ImageIcon ERROR_ICON = new ImageIcon("image_icon\\close.png");
    public static final ImageIcon WARNING_ICON = new ImageIcon("image_icon\\warning.png");
    public static final ImageIcon SUSSCESS_ICON = new ImageIcon("image_icon\\checked.png");

    static String repeatStr(String str, int n) {
        String line = "";
        for (int i = 0; i < n; i++)
            line += str;
        return line;
    }

    public static void Error_dialog(String thongbao) {
        JOptionPane.showMessageDialog(null, thongbao, "ERROR", JOptionPane.OK_CANCEL_OPTION, ERROR_ICON);
    }

    public static void Warning_dialog(String thongbao) {
        JOptionPane.showMessageDialog(null, thongbao, "WARNING", JOptionPane.OK_CANCEL_OPTION, WARNING_ICON);
    }

    public static void Success_dialog(String thongbao) {

        JOptionPane.showMessageDialog(null, thongbao, "SUSCESS", JOptionPane.OK_CANCEL_OPTION, SUSSCESS_ICON);
    }

    // loi mat tieu oi :))
    public static Clip Sound_GioiThieu() {
        try {
            File file = new File("image_icon\\Howl_castel-‐-Được-tạo-bằng-Clipchamp.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            return clip;
            // if( mode == 1)
            // {
            // clip.start();
            // }
            // else{
            // clip.stop();
            // }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public static void Sound_Click() {
        try {
            File file = new File("image_icon\\mixkit-arcade-game-jump-coin-216.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.start();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void Sound_Error() {
        try {
            File file = new File("image_icon\\mixkit-click-error-1110.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.start();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void Sound_Success() {
        try {
            File file = new File("image_icon\\short-success-sound-glockenspiel-treasure-video-game-6346.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.start();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Nhận input id nhân viên
    public static String takeStaffIDInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(Sys.toGreenText(nhapGi));
            try {
                String input = sc.nextLine();
                if (input.isEmpty())
                    Sys.printError("Bạn chưa có nhập gì hết");
                else if (input.length() != 5)
                    Sys.printError("ID Nhân Viên phải có 5 kí tự");
                else if (!(STAFF_ID.matcher(input).find())) {
                    Sys.printError("ID nhân viên không đúng định dạng");
                } else
                    return input;
            } catch (NoSuchElementException e) {
                Sys.printError("Bạn chưa có nhập gì hết");
            }
        }

    }

    public static boolean takeStaffIDInput_2(String input) {
        try {
            if (input.isEmpty())
                return false;
            else if (input.length() != 5)
                return false;
            else if (!(STAFF_ID.matcher(input).find())) {
                return false;
            }
        } catch (NoSuchElementException e) {
            Sys.printError("Bạn chưa có nhập gì hết");
        }
        return true;
    }

    // Nhận input float
    public static float takeFloatInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(Sys.toGreenText(nhapGi));
            try {
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                Sys.printError("Bạn chỉ được phép nhập số");
            }
        }
    }

    public static boolean takeFloatInput_2(String nhapGi) {
        try {
            float number = Float.parseFloat(nhapGi);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // Nhận input int
    public static int takeIntegerInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(Sys.toGreenText(nhapGi));
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input <= 0)
                    Sys.printError("Không chấp nhận số <= 0");
                else
                    return input;
            } catch (NumberFormatException e) {
                Sys.printError("Bạn chỉ được phép nhập số");

            }
        }
    }

    public static boolean takeIntegerInput_2(String nhapGi) {
        try {
            int input = Integer.parseInt(nhapGi);
            if (input <= 0)
                return false;

        } catch (NumberFormatException e) {
            Sys.printError("Bạn chỉ được phép nhập số");
            return false;
        }
        return true;
    }

    public static int takeSoLuongCanTao(String nhapGi) {
        int num;
        while (true) {
            num = Sys.takeIntegerInput(nhapGi);
            if (num > 5) {
                Sys.printMessage("Số lượng của bạn hơi nhiều");
                System.out.println("1. Tiếp tục");
                System.out.println("2. Nhập lại");
                if (Sys.takeInputChoice(1, 2) == 1)
                    return num;
                else
                    continue;
            }
            break;
        }
        return num;
    }

    public static String takeStringInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(Sys.toGreenText(nhapGi));
            try {
                String input = sc.nextLine();
                if (input.isEmpty())
                    Sys.printError("Bạn chưa có nhập gì hết");
                else if (input.length() > 100)
                    Sys.printError("Chiều dài chuỗi vượt quá 100");
                else
                    return input;
            } catch (NoSuchElementException e) {
                Sys.printError("Bạn chưa có nhập gì hết");
            }
        }
    }

    public static int takeInputChoice(int min, int max) {
        String choice;
        Scanner sc = new Scanner(System.in);
        int sln = 0;
        while (true) {
            if (sln == 0)
                System.out.print(toGreenText("Nhập lựa chọn: "));
            else if (sln < 2)
                System.out.print("Nhập lại lựa chọn: ");
            else
                System.out.print(Sys.toYellowText("Hãy nhìn lại lựa chọn rồi nhập -_- : "));
            choice = sc.nextLine();
            try {
                int result = Integer.parseInt(choice);
                if (result >= min && result <= max)
                    return result;
                printError("Lựa chọn của bạn không đúng lắm");
            } catch (NumberFormatException e) {
                Sys.printError("Bạn chỉ được phép nhập số");
            }
            sln++;
        }
    }

    public static String takeDateInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(Sys.toGreenText(nhapGi));
            try {
                String input = sc.nextLine();
                if (input.isEmpty())
                    Sys.printError("Bạn chưa có nhập gì hết");
                else if (input.length() > 14)
                    Sys.printError("Chiều dài chuỗi vượt quá 14");
                else if (!checkDateFormat(input))
                    Sys.printError("Ngày không đúng định dạng");
                else
                    return input;
            } catch (NoSuchElementException e) {
                Sys.printError("Bạn chưa có nhập gì hết");
            }
        }
    }

    public static boolean takeDateInput_2(String input) {
        try {
            if (input.isEmpty())
                return false;
            else if (input.length() > 14)
                return false;
            else if (!checkDateFormat(input))
                return false;

        } catch (NoSuchElementException e) {
            Sys.printError("Bạn chưa có nhập gì hết");
        }
        return true;
    }

    public static String takePhoneNumberInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(nhapGi);
            try {
                String input = sc.nextLine();
                int check = Integer.parseInt(input);
                if (input.isEmpty())
                    Sys.printError("Bạn chưa có nhập gì hết");
                else if (input.length() != 10 && !PHONE_FORMAT.matcher(input).find())
                    Sys.printError("Số điện thoại không hợp lệ");
                else
                    return input;
            } catch (NoSuchElementException e) {
                Sys.printError("Bạn chưa có nhập gì hết");
            } catch (NumberFormatException e) {
                Sys.printError("Điện thoại chỉ chấp nhận số");
            }
        }
    }

    public static boolean takePhoneNumberInput_2(String input) {
        try {
            if (input.isEmpty())
                return false;
            else if (PHONE_FORMAT.matcher(input).find())
                return true;
        } catch (NoSuchElementException e) {
            Sys.printError("Bạn chưa có nhập gì hết");
        } catch (NumberFormatException e) {
            Sys.printError("Điện thoại chỉ chấp nhận số");
        }
        return false;
    }

    // Load file tham số obj là obj là cần load. Trả về null nếu lỗi và obj nếu đúng
    public static Object load(Object obj, String filename) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException | NullPointerException | NoClassDefFoundError IOE) {
            printError("Load " + filename + " thất bại => tạo dữ liệu mặc định");
            return null;
        }
        printMessage("Load " + filename + " thành công");
        return obj;
    }

    // Save file tham số obj là obj cần save
    public static void save(Object obj, String filename) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(obj);
            Sys.printMessage("Save " + filename + " thành công");
        } catch (IOException e) {
            e.printStackTrace();
            Sys.printError("Save " + filename + " thất bại");
        }
    }

    public static String getDateNow() {
        LocalDate date = LocalDate.now();
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }

    public static void clearScreen() {
        Sys.printMessage("Nhập bất kỳ để tiếp tục");
        Scanner cn = new Scanner(System.in);
        cn.nextLine();
        System.out.printf("%5s", repeatStr("\n", 5));
    }

    public static void printMessage(String message) {
        System.out.printf("%30s " + TEXT_GREEN + " *** %s *** " + TEXT_RESET + " %30s%n", Sys.repeatStr(" ", 30),
                message, Sys.repeatStr(" ", 30));
    }

    public static String printError(String message) {
        System.out.printf("%30s " + TEXT_RED + " *** %s *** " + TEXT_RESET + " %30s%n", Sys.repeatStr(" ", 30), message,
                Sys.repeatStr(" ", 30));
        return message;
    }

    public static float Thue(int gia) {
        return Math.round(gia * 0.5);
    }

    public static boolean checkDateFormat(String date) {
        try {
            String[] part = date.split("/");
            int day = Integer.parseInt(part[0]);
            int month = Integer.parseInt(part[1]);
            int year = Integer.parseInt(part[2]);
            int maxDay = 31;
            switch (month) {
                // case 1, 3, 5, 7, 8, 10, 12:{
                // maxDay = 31;
                // break;
                // }
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    maxDay = 31;
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    maxDay = 30;
                    break;
                }
                // case 4, 6, 9, 11:
                // maxDay = 30;
                // break;
                case 2: {
                    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                        maxDay = 29;
                    } else {
                        maxDay = 28;
                    }
                    break;
                }
                default:
                    return false;

            }
            if (day <= 0 || day > maxDay)
                return false;

            return year > 1900 && year < 2030;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    // kiem tra ngay truoc va sau
    public static boolean compareDay(String dayBefor, String dayAfter) {
        try {
            if (checkDateFormat(dayBefor) == true && checkDateFormat(dayAfter) == true) {
                String[] arrDayBefore = dayBefor.split("/");
                int day_1 = Integer.parseInt(arrDayBefore[0]);
                int month_1 = Integer.parseInt(arrDayBefore[1]);
                int year_1 = Integer.parseInt(arrDayBefore[2]);

                String[] arrDayAfter = dayAfter.split("/");
                int day_2 = Integer.parseInt(arrDayAfter[0]);
                int month_2 = Integer.parseInt(arrDayAfter[1]);
                int year_2 = Integer.parseInt(arrDayAfter[2]);
                int flag = 0;

                if (year_1 <= year_2) {
                    if (month_1 <= month_2) {
                        if (day_1 <= day_2) {
                            flag = 1;
                        }
                    }
                }
                if (flag == 1) {
                    return true;
                }
                if (flag == 0) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static String toBlueText(String text) {
        return TEXT_BLUE + text + TEXT_RESET;
    }

    public static String toGreenText(String text) {
        return TEXT_GREEN + text + TEXT_RESET;
    }

    public static String toYellowText(String text) {
        return TEXT_YELLOW + text + TEXT_RESET;
    }

    // kiểm tra thời gian có nằm trong khoàng thời gian nào đó hay không
    public static boolean kiemTraKhoangThoiGian(String from, String between, String to) {
        Date dateFrom;
        Date dateTo;
        Date dateBetween;
        try {
            dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(from);
            dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(to);
            dateBetween = new SimpleDateFormat("dd/MM/yyyy").parse(between);
        } catch (ParseException e) {
            return false;
        }

        return dateBetween.after(dateFrom) && dateBetween.before(dateTo);
    }

    //
    public static boolean kiemTraKhoangThoiGianTrongThang_nam_2023(String date, int month_check) {
        if (checkDateFormat(date)) {
            String[] part = date.split("/");
            // int day = Integer.parseInt(part[0]);
            int month = Integer.parseInt(part[1]);
            // int year = Integer.parseInt(part[2]);
            if (month == month_check) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static String Check_email(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        String Match = "/[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*@gmail\\.com$/gm";
        while (true) {
            System.out.print(Sys.toGreenText(nhapGi));
            try {
                String input = sc.nextLine();
                if (Pattern.matches(Match, input) == true)
                    return input;
                else if (input.isEmpty())
                    Sys.printError("Bạn chưa có nhập gì hết");
                else
                    Sys.printError("Không đúng định dạng email");

            } catch (NoSuchElementException e) {
                Sys.printError("Bạn chưa có nhập gì hết");
            }
            // catch (Exception e){
            // return Sys.printError("Không đúng định dạng email");
            // }
        }
    }
    // public static boolean Check_email_2(String nhapGi){
    // String Match = "/[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*@gmail\\ .com$/gm";
    // try {
    // if (Pattern.matches(Match, nhapGi) == true)
    // return true;
    // else if (nhapGi.isEmpty())
    // return false;

    // } catch (NoSuchElementException e) {
    // Sys.printError("Bạn chưa có nhập gì hết");
    // }
    // return false;
    // }
    public static boolean Check_email_2(String email) {

        try {
            String regex = "@gmail\\.com$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (email.isEmpty())
                return false;
            else
                return matcher.find();

        } catch (NoSuchElementException e) {
            System.err.println("Bạn chưa nhập gì hết !");
        }
        return false;
    }

    // public static String nhapIDNhaCungCap(DanhSachNhaCCBUS dsncc) {
    // String idncc;
    // do {
    // dsncc.xuatDS();
    // idncc = Sys.takeStringInput("Nhập ID nhà cung cấp: ");
    // if (dsncc.timKiemTheoID(idncc) == null)
    // printError("Không có nhà cung cấp này");
    // else
    // return idncc;
    // } while (true);
    // }

    public static boolean nhapIDNhaCungCap_2(DanhSachNhaCCBUS dsncc, String id) {
        // dsncc.xuatDS();
        if (dsncc.timKiemTheoID(id) == null)
            return false;
        else
            return true;
    }

    public static Boolean takeBoolean(String NhapGi) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(Sys.toGreenText(NhapGi));
            String chon = sc.nextLine();
            if (chon.equals("Y")) {
                return true;
            }
            if (chon.equals("N")) {
                return false;
            } else {
                Sys.printError("****Nhập lại****");
            }

        } while (true);

    }

    public static String takeMaSP() {
        Scanner sc = new Scanner(System.in);
        String Match1 = "F{1}\\d{3}";
        String Match2 = "D{1}\\d{3}";
        String maSP;
        do {
            System.out.print(Sys.toGreenText("Nhập mã SP theo form D (hoặc F) theo sao là 3 số: "));
            maSP = sc.nextLine();
            if (Pattern.matches(Match1, maSP) == false && Pattern.matches(Match2, maSP) == false) {
                Sys.printError("Nhập ai form!! Nhập lại");
            } else {
                return maSP;
            }

        } while (true);
    }

    public static boolean takeMaSP_2(String maSP) {
        String Match1 = "F{1}\\d{3}";
        String Match2 = "D{1}\\d{3}";
        if (Pattern.matches(Match1, maSP) == false && Pattern.matches(Match2, maSP) == false) {
            return false;
        } else {
            return true;
        }
    }

    public static String takeDate_expiry(String date) {
        String[] part = date.split("/");
        int day = Integer.parseInt(part[0]);
        int month = Integer.parseInt(part[1]);
        int year = Integer.parseInt(part[2]);
        int year_ex = year + 2;

        return day + "/" + month + "/" + year_ex;
    }

    public static String takeDayFormat_(String date){
        String[] part = date.split("/");
        int day = Integer.parseInt(part[0]);
        int month = Integer.parseInt(part[1]);
        int year = Integer.parseInt(part[2]);

        return day + "." + month + "." + year;
    }

    public static String takeDate_Before_expiry(String date) {
        String[] part = date.split("/");
        int day = Integer.parseInt(part[0]);
        int month = Integer.parseInt(part[1]);
        int year = Integer.parseInt(part[2]);
        int year_ex = year - 2;

        return day + "/" + month + "/" + year_ex;
    }

    public static boolean subStrInStrIgnoreCase(String str, String subStr) {
        return str.toLowerCase(Locale.ROOT).contains(subStr.toLowerCase(Locale.ROOT));
    }

    // public static String nhapMaSP(ListProductsBUS kho) {
    // String maSP;
    // do {
    // kho.xuatDS();
    // maSP = Sys.takeStringInput("Nhập mã sản phẩm: ");
    // if (kho.timkiemsp(maSP) == null)
    // printError("Không có mã sản phầm này");
    // else
    // return maSP;
    // } while (true);
    // }

    public static boolean nhapMaSP_2(ListProductsBUS kho, String maSP) {
        // kho.xuatDS();
        if (kho.timkiemsp(maSP) == null)
            // printError("Không có mã sản phầm này");
            return false;
        else
            return true;
    }

    public static String takeGenderInput(String nhapGi) {
        System.out.println(nhapGi);
        System.out.println("1.Nam");
        System.out.println("2.Nữ");
        System.out.println("3.Khác");
        while (true) {
            int choice = takeInputChoice(1, 3);
            switch (choice) {
                case 1:
                    return "Nam";
                case 2:
                    return "Nữ";
                case 3:
                    return "Khác";
            }
        }
    }

    public static String takeCMND(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(nhapGi);
            try {
                String input = sc.nextLine();
                if (input.isEmpty())
                    Sys.printError("Bạn chưa có nhập gì hết");
                else if (input.length() != 12 && !CCCD_FORMAT.matcher(input).find())
                    Sys.printError("Số CCCD không hợp lệ");
                else
                    return input;
            } catch (NoSuchElementException e) {
                Sys.printError("Bạn chưa có nhập gì hết");
            } catch (NumberFormatException e) {
                Sys.printError("CCCD chỉ chấp nhận số");
            }
        }
    }

    public static boolean takeCMND_2(String input) {
        try {
            if (input.isEmpty())
                return false;
            else if (input.length() != 12 && !CCCD_FORMAT.matcher(input).find())
                return false;
        } catch (NoSuchElementException e) {
            Sys.printError("Bạn chưa có nhập gì hết");
        } catch (NumberFormatException e) {
            Sys.printError("CCCD chỉ chấp nhận số");
        }
        return true;
    }

    public static void PrintBill(HoaDonDTO hoaDon, ListProductsBUS listProducts, float tienkhachdua) {
        try {
            String maHD = hoaDon.getMahd();
            PrintWriter printWriter = new PrintWriter(new File("HoaDon\\" + maHD + ".txt"), "UTF-8");
            String date = hoaDon.getTimexuat();
            String maNv = hoaDon.getManv();
            String nhande = String.format("%-50s%-50s%-50s\n", Sys.repeatStr("", 50), "DTSP STORE",
                    Sys.repeatStr("", 50));
            String diachi = String.format("%-40s%-80s%-40s\n", Sys.repeatStr("", 35),
                    "Số 273 An Dương Vương TP HỒ CHÍ MINH", Sys.repeatStr("", 30));
            String gachphancach_1 = String.format("%-15s%-80s%-40s\n", Sys.repeatStr("", 35), Sys.repeatStr("-", 80),
                    Sys.repeatStr("", 30));
            String HoaDon = String.format("%-47s%-80s%-40s\n", Sys.repeatStr("", 35), "PHIẾU THANH TOÁN",
                    Sys.repeatStr("", 30));
            String soHD = String.format("%-40s%-80s%-40s\n", Sys.repeatStr("", 35), "Số HD:               " + maHD,
                    Sys.repeatStr("", 30));
            String Ngay = String.format("%-40s%-80s%-40s\n", Sys.repeatStr("", 35), "Ngày:                " + date,
                    Sys.repeatStr("", 30));
            String maNV = String.format("%-40s%-80s%-40s\n", Sys.repeatStr("", 35), "Nhân viên:           " + maNv,
                    Sys.repeatStr("", 30));
            String gachphancach_2 = String.format("%-15s%-80s%-40s\n", Sys.repeatStr("", 35), Sys.repeatStr("-", 80),
                    Sys.repeatStr("", 30));
            // phan chi tiet hoa don
            String nhandeCT = String.format("%-20s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", Sys.repeatStr("", 20), "TÊN",
                    Sys.repeatStr("", 30), "MÃ SP", Sys.repeatStr("", 20), "SL", Sys.repeatStr("", 20), "ĐƠN GIÁ");
            printWriter.print(nhande);
            printWriter.print(diachi);
            printWriter.print(gachphancach_1);
            printWriter.print(HoaDon);
            printWriter.print(soHD);
            printWriter.print(Ngay);
            printWriter.print(maNV);
            printWriter.print(gachphancach_2);
            printWriter.print(nhandeCT);

            DanhSachCTHDBUS danhSachCTHD = hoaDon.getDsCTHD();
            for (ChiTietHDDTO chiTietHD : danhSachCTHD.getCthd()) {
                for (ProductsDTO products : listProducts.getArr()) {
                    if (products.getMaSP().equals(chiTietHD.getMaSP())) {
                        String nameSP = products.getNameProduct();
                        String maSP = chiTietHD.getMaSP();
                        int sl = chiTietHD.getSoluong();
                        int dongia = chiTietHD.getGia();
                        String CThoadon = String.format("%-20s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n",
                                Sys.repeatStr("", 20), nameSP, Sys.repeatStr("", 30), maSP, Sys.repeatStr("", 20), sl,
                                Sys.repeatStr("", 20), dongia);
                        printWriter.print(CThoadon);
                    }
                }
            }
            String gachphancach_3 = String.format("%-15s%-80s%-40s\n", Sys.repeatStr("", 35), Sys.repeatStr("-", 80),
                    Sys.repeatStr("", 30));
            printWriter.print(gachphancach_3);

            // thanh tien
            String ThanhTien = String.format("%-40s%-15s%-10s%-10s\n\n", Sys.repeatStr("", 35), "Thành tiền:",
                    Sys.repeatStr("", 50), hoaDon.getTongtien());
            printWriter.print(ThanhTien);
            // tien thoi lai
            float tiendu = tienkhachdua - hoaDon.getTongtien();
            String tienkhach = String.format("%-40s%-8s%-8s%-10s\n\n", Sys.repeatStr("", 35), "Tiền khách đưa :",
                    Sys.repeatStr("", 50), tienkhachdua);
            printWriter.print(tienkhach);

            String tienthoilai = String.format("%-40s%-10s%-10s%-10s\n\n", Sys.repeatStr("", 35), "Tiền thối lại :",
                    Sys.repeatStr("", 50), tiendu);
            printWriter.print(tienthoilai);

            String thue_label = String.format("%-40s%-80s%-40s\n\n", Sys.repeatStr("", 35),
                    "(Giá trên đã bao gồm thuế GTGT)", Sys.repeatStr("", 30));
            printWriter.print(thue_label);

            String gachphancach_4 = String.format("%-15s%-80s%-40s\n", Sys.repeatStr("", 35), Sys.repeatStr("-", 80),
                    Sys.repeatStr("", 30));
            printWriter.print(gachphancach_4);

            String camon = String.format("%-43s%-80s%-40s\n", Sys.repeatStr("", 35), "CÁM ƠN VÀ HẸN GẶP LẠI !!",
                    Sys.repeatStr("", 30));
            printWriter.print(camon);

            String sdt = String.format("%-40s%-80s%-40s\n", Sys.repeatStr("", 35), "Tổng đài liên hệ: 0823072871",
                    Sys.repeatStr("", 30));
            printWriter.print(sdt);

            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test đọc thử excel
    public static void readExcel(String name) throws IOException {
        // Excel_PhieuNhap\hello.xlsx
        FileInputStream file = new FileInputStream("Excel_PhieuNhap\\" + name + ".xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0
        FormulaEvaluator formular = wb.getCreationHelper().createFormulaEvaluator(); // lay gia tri trong cac Row

        // cach doc 1:

        // for (Row row : sheet) {
        // for (Cell cell : row) {
        // switch(formular.evaluate(cell).getCellType()) {
        // case STRING:
        // System.out.print(cell.getStringCellValue());;
        // break;
        // case NUMERIC:
        // System.out.print(cell.getNumericCellValue());;
        // break;
        // }
        // }
        // System.out.println();
        // }

        // cach doc 2: hay dung
        double[] phantram = new double[10];
        int index_phantam = 0;

        String[] day = new String[10];
        int index_day = 0;

        String[] TenSP = new String[10];
        int index_tenSP = 0;

        String[] maSP = new String[10];
        int index_ma = 0;

        // doc ngay thong ke
        // for (Row row : sheet) {
        // if (row.getRowNum() == 0) {
        // for (int i = 0; i < 2; i++) {
        // day[index_day] = row.getCell(i).getStringCellValue();
        // index_day++;
        // }
        // }
        // }

        int flag = 0; // check loi du lieu
        for (Row row : sheet) {
            // System.out.println(row.getRowNum());
            try {
                // Doc ngay
                if (row.getRowNum() == 0) {
                    for (int i = 0; i < 2; i++) {
                        day[index_day] = row.getCell(i).getStringCellValue();
                        index_day++;
                    }
                }
                // doc ma san pham
                if (row.getRowNum() == 1) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        maSP[index_ma] = row.getCell(i).getStringCellValue();
                        index_ma++;
                    }
                }
                // doc tenSP
                if (row.getRowNum() == 2) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        TenSP[index_tenSP] = row.getCell(i).getStringCellValue();
                        index_tenSP++;
                    }
                }
                // doc phan tram
                if (row.getRowNum() == 3) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        phantram[index_phantam] = row.getCell(i).getNumericCellValue();
                        index_phantam++;

                    }
                }
            } catch (Exception e) {
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Loi du lieu");
            return;
        }
        for (int i = 0; i < index_day; i++) {
            System.out.print(day[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < index_ma; i++) {
            System.out.println(TenSP[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < index_ma; i++) {
            System.out.println(maSP[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < index_ma; i++) {
            System.out.println(phantram[i]);
        }

        // for(int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua
        // cot cuoi cung
        // System.out.println(row.getCell(i));
        // }

        wb.close();
        file.close();
    }

    // tao file Excel
    public static boolean createExcelFile(String namepath){
        boolean taoFile = false;
        try {
            File file = new File(namepath);
            // System.out.println(file.createNewFile());
            taoFile = file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taoFile;
    }

    // test ghi thu
    public static void writeExcel(String name) throws IOException {

        // tao file excel
        boolean taoFile = false;
        try {
            File file = new File("Excel_PhieuNhap\\" + name + ".xlsx");
            // System.out.println(file.createNewFile());
            taoFile = file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (taoFile == false) {
            return;
        }
        FileOutputStream file = new FileOutputStream("Excel_PhieuNhap\\" + name + ".xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(); // dua ve dang file excel
        XSSFSheet work_sheet = wb.createSheet("name");
        // tao doi tuong dong va 2 cot
        XSSFRow row;
        XSSFCell cell_A;
        XSSFCell cell_B;
        // for (int i = 0; i < 10; i++) {
        // row = work_sheet.createRow(i); // tao dong i
        // cell_A = row.createCell(0); // tao cot 0
        // cell_A.setCellValue("hell"); // set gia tri cot 0
        // cell_B = row.createCell(1); // tao cot 1
        // cell_B.setCellValue(i+1); // set gia tri o cot 1
        //
        // }
        // ghi ngay thong ke
        XSSFRow row_day = work_sheet.createRow(0);
        XSSFCell cell_day;
        for (int i = 0; i < 2; i++) {
            // row_day = work_sheet.createRow(0);
            cell_day = row_day.createCell(i);
            cell_day.setCellValue(10 + i + "/10/2020");
        }
        // ghi ma sp
        XSSFRow row_maSP = work_sheet.createRow(1);
        XSSFCell cell_maSP;
        cell_maSP = row_maSP.createCell(0);
        cell_maSP.setCellValue("Ma sp");
        for (int i = 1; i < 5; i++) {
            cell_maSP = row_maSP.createCell(i);
            cell_maSP.setCellValue("F001");
        }

        // ghi ten sp
        XSSFRow row_tenSP = work_sheet.createRow(2);
        XSSFCell cell_tenSP;
        cell_tenSP = row_tenSP.createCell(0);
        cell_tenSP.setCellValue("Ten sp");
        for (int i = 1; i < 5; i++) {
            cell_tenSP = row_tenSP.createCell(i);
            cell_tenSP.setCellValue("Gan ran");
        }
        // ghi phan tram

        XSSFRow row_phantram = work_sheet.createRow(3);
        XSSFCell cell_phantram;
        cell_phantram = row_phantram.createCell(0);
        cell_phantram.setCellValue("Phan tram");
        for (int i = 1; i < 5; i++) {
            cell_phantram = row_phantram.createCell(i);
            cell_phantram.setCellValue(i);
        }

        wb.write(file);
        wb.close();
        file.close();
    }

    // phieu nhap va phieu xuat
    // doc ngay thong ke
    public static ArrayList<String> readExcel_ngayTKPhieuNhap(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> dayTK = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            // Doc ngay
            try {
                if (row.getRowNum() == 0) {
                    for (int i = 1; i < 3; i++) {
                        dayTK.add(row.getCell(i).getStringCellValue());
                    }
                    break;
                }
                
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }
        wb.close();
        file.close();
        return dayTK;
    }

    // doc maSP
    public static ArrayList<String> readExcel_maSPTKPhieuNhap(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> maSP = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            // Doc ngay
            try {
                if (row.getRowNum() == 1) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        maSP.add(row.getCell(i).getStringCellValue());
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }
        wb.close();
        file.close();
        return maSP;
    }

    public static ArrayList<String> readExcel_tenSPTKPhieuNhap(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> nameSP = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            // Doc ngay
            try {
                if (row.getRowNum() == 2) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        nameSP.add(row.getCell(i).getStringCellValue());
                    }
                    break;
                }

            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }
        wb.close();
        file.close();
        return nameSP;
    }

    public static ArrayList<Double> readExcel_PhanTramSPPhieuNhap(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0
        // khai bao cac mang chua thong tin co trong file
        ArrayList<Double> Phantram = new ArrayList<Double>();
        // tra ve mang double
        int flag = 0; // check loi du lieu
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 3) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        Phantram.add(row.getCell(i).getNumericCellValue());
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            System.out.println("Loi du lieu");
            return null;
        }

        wb.close();
        file.close();
        return Phantram;
    }

    public static ArrayList<String> readExcel_PhieuNhapCoTongTienLonNhat(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> phieuNhap = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 4) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        phieuNhap.add((row.getCell(i).getStringCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return phieuNhap;
    }

    public static ArrayList<String> readExcel_NhanVienNhapNhieuPhieuNhat(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> nhanvien = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 5) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        nhanvien.add((row.getCell(i).getStringCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return nhanvien;
    }

    public static ArrayList<String> readExcel_NhaCungCapNhapNhieuNhat(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> nhaCC = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 6) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        nhaCC.add((row.getCell(i).getStringCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return nhaCC;
    }

    // ghi file phieu nhap excel
    public static boolean writeExcel_TKPhieuNhap(String pathname, ArrayList<String> NgayThongKe, ArrayList<String> maSP,
            ArrayList<String> nameSP, ArrayList<Double> phantramSP, ArrayList<String> maPhieu, ArrayList<String> maNv,
            ArrayList<String> maNCC) throws IOException {

        FileOutputStream file = new FileOutputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(); // dua ve dang file excel
        XSSFSheet work_sheet = wb.createSheet("name");
        int flag = 0;
        try {
            // ngay thong ke
            XSSFRow row_day = work_sheet.createRow(0); // tao moi dong dau
            XSSFCell cell_day;
            cell_day = row_day.createCell(0);
            cell_day.setCellValue("Ngày thống kê: ");
            for (int i = 1; i < 3; i++) {
                cell_day = row_day.createCell(i);
                cell_day.setCellValue(NgayThongKe.get(i-1));
            }
            // ghi ma sp
            XSSFRow row_maSP = work_sheet.createRow(1);
            XSSFCell cell_maSP;
            cell_maSP = row_maSP.createCell(0);
            cell_maSP.setCellValue("Mã SP");
            int size1 = maSP.size();
            for (int i = 1; i <= size1; i++) {
                cell_maSP = row_maSP.createCell(i);
                cell_maSP.setCellValue((maSP.get(i - 1)));
            }
            // ghi ten sp
            XSSFRow row_nameSP = work_sheet.createRow(2);
            XSSFCell cell_nameSP;
            cell_nameSP = row_nameSP.createCell(0);
            cell_nameSP.setCellValue("Tên sp: ");
            int size2 = nameSP.size();
            for (int i = 1; i <= size2; i++) {
                cell_nameSP = row_nameSP.createCell(i);
                cell_nameSP.setCellValue((nameSP.get(i - 1)));
            }
            // ghi phan tram
            XSSFRow row_phantram = work_sheet.createRow(3);
            XSSFCell cell_phantram;
            cell_phantram = row_phantram.createCell(0);
            cell_phantram.setCellValue("Phần trăm:");
            int size3 = phantramSP.size();
            for (int i = 1; i <= size3; i++) {
                cell_phantram = row_phantram.createCell(i);
                cell_phantram.setCellValue((phantramSP.get(i - 1)));
            }
            // ghi phieu nhap nhieu tien nhat
            XSSFRow row_ph = work_sheet.createRow(4);
            XSSFCell cell_ph;
            cell_ph = row_ph.createCell(0);
            cell_ph.setCellValue("Phiếu nhập có tổng tiền lớn nhất: ");
            int size5 = maPhieu.size();
            for (int i = 1; i <= size5; i++) {
                cell_ph = row_ph.createCell(i);
                cell_ph.setCellValue((maPhieu.get(i - 1)));
            }
            // nhan vien nhap nhieu nhat
            XSSFRow row_maNv = work_sheet.createRow(5);
            XSSFCell cell_maNv;
            cell_maNv = row_maNv.createCell(0);
            cell_maNv.setCellValue("Nhân viên nhập nhiều phiếu nhất: ");
            int size4 = maNv.size();
            for (int i = 1; i <= size4; i++) {
                cell_maNv = row_maNv.createCell(i);
                cell_maNv.setCellValue((maNv.get(i - 1)));
            }
            // nha cung cap nhap nhieu nhat
            XSSFRow row_maNCC = work_sheet.createRow(6);
            XSSFCell cell_maNCC;
            cell_maNCC = row_maNCC.createCell(0);
            cell_maNCC.setCellValue("Nhà cung cấp nhập nhiều hàng nhất: ");
            int size6 = maNCC.size();
            for (int i = 1; i <= size6; i++) {
                cell_maNCC = row_maNCC.createCell(i);
                cell_maNCC.setCellValue((maNCC.get(i - 1)));
            }

            wb.write(file);
            wb.close();
            file.close();
        } catch (Exception e) {
            flag = 1;
            e.printStackTrace();
        }
        if(flag == 1){
            return false;
        }
        return true;
    }

    public static boolean writeExcel_TKPhieuXuat(String pathname, ArrayList<String> NgayThongKe, ArrayList<String> maSP,
            ArrayList<String> nameSP, ArrayList<Double> phantramSP, ArrayList<String> maPhieu, ArrayList<String> maNv) throws IOException {

        FileOutputStream file = new FileOutputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(); // dua ve dang file excel
        XSSFSheet work_sheet = wb.createSheet("name");
        int flag = 0;
        try {
            // ngay thong ke
            XSSFRow row_day = work_sheet.createRow(0); // tao moi dong dau
            XSSFCell cell_day;
            cell_day = row_day.createCell(0);
            cell_day.setCellValue("Ngày thống kê: ");
            for (int i = 1; i < 3; i++) {
                cell_day = row_day.createCell(i);
                cell_day.setCellValue(NgayThongKe.get(i-1));
            }
            // ghi ma sp
            XSSFRow row_maSP = work_sheet.createRow(1);
            XSSFCell cell_maSP;
            cell_maSP = row_maSP.createCell(0);
            cell_maSP.setCellValue("Mã SP");
            int size1 = maSP.size();
            for (int i = 1; i <= size1; i++) {
                cell_maSP = row_maSP.createCell(i);
                cell_maSP.setCellValue((maSP.get(i - 1)));
            }
            // ghi ten sp
            XSSFRow row_nameSP = work_sheet.createRow(2);
            XSSFCell cell_nameSP;
            cell_nameSP = row_nameSP.createCell(0);
            cell_nameSP.setCellValue("Tên sp: ");
            int size2 = nameSP.size();
            for (int i = 1; i <= size2; i++) {
                cell_nameSP = row_nameSP.createCell(i);
                cell_nameSP.setCellValue((nameSP.get(i - 1)));
            }
            // ghi phan tram
            XSSFRow row_phantram = work_sheet.createRow(3);
            XSSFCell cell_phantram;
            cell_phantram = row_phantram.createCell(0);
            cell_phantram.setCellValue("Phần trăm:");
            int size3 = phantramSP.size();
            for (int i = 1; i <= size3; i++) {
                cell_phantram = row_phantram.createCell(i);
                cell_phantram.setCellValue((phantramSP.get(i - 1)));
            }
            // ghi phieu nhap nhieu tien nhat
            XSSFRow row_ph = work_sheet.createRow(4);
            XSSFCell cell_ph;
            cell_ph = row_ph.createCell(0);
            cell_ph.setCellValue("Phiếu xuất có tổng tiền lớn nhất: ");
            int size5 = maPhieu.size();
            for (int i = 1; i <= size5; i++) {
                cell_ph = row_ph.createCell(i);
                cell_ph.setCellValue((maPhieu.get(i - 1)));
            }
            // nhan vien nhap nhieu nhat
            XSSFRow row_maNv = work_sheet.createRow(5);
            XSSFCell cell_maNv;
            cell_maNv = row_maNv.createCell(0);
            cell_maNv.setCellValue("Nhân viên xuất nhiều phiếu nhất: ");
            int size4 = maNv.size();
            for (int i = 1; i <= size4; i++) {
                cell_maNv = row_maNv.createCell(i);
                cell_maNv.setCellValue((maNv.get(i - 1)));
            }
            // nha cung cap nhap nhieu nhat
            

            wb.write(file);
            wb.close();
            file.close();
        } catch (Exception e) {
            flag = 1;
            e.printStackTrace();
        }
        if(flag == 1){
            return false;
        }
        return true;
    }

    // hoa don
    // doc ma nv
    public static ArrayList<String> readExcel_maNVTKHoaDon(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> nhanvien = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 1) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        nhanvien.add((row.getCell(i).getStringCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return nhanvien;
    }
    // ten nhan vien
    public static ArrayList<String> readExcel_nameNVTKHoaDon(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> nhanvien = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 2) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        nhanvien.add((row.getCell(i).getStringCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return nhanvien;
    }
    // so lan giao dich
    public static ArrayList<Double> readExcel_SoLanGiaDich(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<Double> sl = new ArrayList<Double>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 3) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        sl.add((row.getCell(i).getNumericCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return sl;
    }

    // so hoa don
    public static ArrayList<String> readExcel_nameHoaDonTKHoaDon(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<String> hoadon = new ArrayList<String>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 4) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        hoadon.add((row.getCell(i).getStringCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return hoadon;
    }
    // tong tien
    public static ArrayList<Double> readExcel_TongTienTKHoaDon(String pathname) throws IOException {
        FileInputStream file = new FileInputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(file); // dua ve dang file excel
        XSSFSheet sheet = wb.getSheetAt(0); // doc tu sheet 1 -> tuong ung voi so 0

        ArrayList<Double> sl = new ArrayList<Double>();
        int flag = 0;
        for (Row row : sheet) {
            try {
                // doc phan tram
                if (row.getRowNum() == 5) {
                    for (int i = 1; i < row.getLastCellNum(); i++) { // getLastCellNum: lay so cua cot cuoi cung
                        sl.add((row.getCell(i).getNumericCellValue()));
                    }
                    break;
                }
            } catch (Exception e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return null;
        }

        wb.close();
        file.close();
        return sl;
    }

    // ghi file hoa don
    public static boolean writeExcel_TKHoaDon(String pathname,ArrayList <String> NgayThongKe, ArrayList<String> maNV, ArrayList<String> nameNV,
            ArrayList<Double> solangiaodich, ArrayList<String> soHD, ArrayList<Double> tongtien) throws IOException {

        FileOutputStream file = new FileOutputStream(pathname);
        XSSFWorkbook wb = new XSSFWorkbook(); // dua ve dang file excel
        XSSFSheet work_sheet = wb.createSheet("name");
        int flag = 0;
        try {
            // ngay thong ke
            XSSFRow row_day = work_sheet.createRow(0); // tao moi dong dau
            XSSFCell cell_day;
            cell_day = row_day.createCell(0);
            cell_day.setCellValue("Ngày thống kê: ");
            for (int i = 1; i < 3; i++) {
                cell_day = row_day.createCell(i);
                cell_day.setCellValue(NgayThongKe.get(i-1));
            }
            // ghi ma nv
            XSSFRow row_maNV = work_sheet.createRow(1);
            XSSFCell cell_maNV;
            cell_maNV = row_maNV.createCell(0);
            cell_maNV.setCellValue("Mã nhân viên: ");
            int size1 = maNV.size();
            for (int i = 1; i <= size1; i++) {
                cell_maNV = row_maNV.createCell(i);
                cell_maNV.setCellValue((maNV.get(i - 1)));
            }
            // ghi ten nv
            XSSFRow row_nameNV = work_sheet.createRow(2);
            XSSFCell cell_nameNV;
            cell_nameNV = row_nameNV.createCell(0);
            cell_nameNV.setCellValue("Tên nhân viên: ");
            int size2 = nameNV.size();
            for (int i = 1; i <= size2; i++) {
                cell_nameNV = row_nameNV.createCell(i);
                cell_nameNV.setCellValue((nameNV.get(i - 1)));
            }
            // ghi so lan giao dich
            XSSFRow row_solangiaodich = work_sheet.createRow(3);
            XSSFCell cell_solangiaodich;
            cell_solangiaodich = row_solangiaodich.createCell(0);
            cell_solangiaodich.setCellValue("Số lần giao dịch:");
            int size3 = solangiaodich.size();
            for (int i = 1; i <= size3; i++) {
                cell_solangiaodich = row_solangiaodich.createCell(i);
                cell_solangiaodich.setCellValue((solangiaodich.get(i - 1)));
            }
            // ghi so hoa don
            XSSFRow row_HD = work_sheet.createRow(4);
            XSSFCell cell_HD;
            cell_HD = row_HD.createCell(0);
            cell_HD.setCellValue("Số hóa đơn: ");
            int size5 = soHD.size();
            for (int i = 1; i <= size5; i++) {
                cell_HD = row_HD.createCell(i);
                cell_HD.setCellValue((soHD.get(i - 1)));
            }
            // nhan vien nhap nhieu nhat
            XSSFRow row_tongtien = work_sheet.createRow(5);
            XSSFCell cell_tongtien;
            cell_tongtien = row_tongtien.createCell(0);
            cell_tongtien.setCellValue("Tổng tiền dựa trên hóa đơn: ");
            int size4 = tongtien.size();
            for (int i = 1; i <= size4; i++) {
                cell_tongtien = row_tongtien.createCell(i);
                cell_tongtien.setCellValue((tongtien.get(i - 1)));
            }
            // nha cung cap nhap nhieu nhat
            

            wb.write(file);
            wb.close();
            file.close();
        } catch (Exception e) {
            flag = 1;
            e.printStackTrace();
        }
        if(flag == 1){
            return false;
        }
        return true;
    }




    public static void main(String[] args) throws IOException {
        // System.out.println( Sys.Question_dialog("Nhap so"));
        // Sys.Warning_dialog("");
        // Sys.Error_dialog("");
        // Sys.Success_dialog("");
        // Scanner nhap = new Scanner(System.in);

        // Sys.Sound_Click();
        // Sys.Sound_GioiThieu(1);
        // Sys.Sound_Success();
        // int temp = nhap.nextInt();
        // Sys.Sound_GioiThieu(temp);
        // Sys.readExcel("hello");

        // ArrayList<String> day = Sys
        //         .readExcel_ngayTKPhieuNhap("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");
        // for (String iterable_element : day) {
        //     System.out.println(iterable_element);
        // }

        // ArrayList<String> nameSp = Sys
        //         .readExcel_tenSPTKPhieuNhap("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");

        // ArrayList<String> maSP = Sys
        //         .readExcel_maSPTKPhieuNhap("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");
        // for (String iterable_element : maSP) {
        //     System.out.println(iterable_element);
        // }

        // ArrayList<Double> phantram = Sys
        //         .readExcel_PhanTramSPPhieuNhap("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");

        // ArrayList<String> maPN = Sys
        //         .readExcel_PhieuNhapCoTongTienLonNhat("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");

        // ArrayList<String> maNv = Sys
        //         .readExcel_NhanVienNhapNhieuPhieuNhat("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");

        // ArrayList<String> maNCC = Sys
        //         .readExcel_NhaCungCapNhapNhieuNhat("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");

        // // Sys.writeExcel("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx");
        // Sys.writeExcel_TKPhieuXuat("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\oo.xlsx", day, maSP, nameSp,
        //         phantram, maPN, maNv);

        
        // ArrayList<String> maNV = Sys.readExcel_maNVTKHoaDon("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\HoaDon.xlsx");
        // for (String iterable_element : maNV) {
        //     System.out.println(iterable_element);
        // }
        // ArrayList<String> nameNV = Sys.readExcel_nameNVTKHoaDon("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\HoaDon.xlsx");
        // ArrayList<Double> solan = Sys.readExcel_SoLanGiaDich("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\HoaDon.xlsx");
        // ArrayList<String> hoadon = Sys.readExcel_nameHoaDonTKHoaDon("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\HoaDon.xlsx");
        // ArrayList<Double> tongtien = Sys.readExcel_TongTienTKHoaDon("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\HoaDon.xlsx");

       

        // Sys.writeExcel_TKHoaDon("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\HoaDon2.xlsx", day, maNV, nameNV, solan, hoadon, tongtien);


        // ArrayList<String> phieuNhap = Sys.readExcel_NhaCungCapNhapNhieuNhat("hello");
        // for (String iterable_element : phieuNhap) {
        // System.out.println(iterable_element);
        // }
        // Sys.writeExcel_NgayTKPhieuNhap("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx",
        // day);
        // Sys.writeExcel_maSPTKPhieuNhap("D:\\A\\JAVA\\DO_AN_JAVA_SWING\\Excel_PhieuNhap\\hi.xlsx",
        // maSP);

        // JFileChooser chooser = new JFileChooser();
        // int returnVal = chooser.showOpenDialog(null);
        // if (returnVal == JFileChooser.APPROVE_OPTION) {
        // System.out.println("You chose to open this file: " +
        // chooser.getSelectedFile().getPath());

        // }

        ArrayList<String> A = new ArrayList<>();
        A.add("a");
        A.add("b");
        ArrayList<String> B = new ArrayList<>();
        B.add("b");
        B.add("a");

        System.out.println(A.equals(B));
        
    }
}
