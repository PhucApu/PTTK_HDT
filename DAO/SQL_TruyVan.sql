-- --SUPPLIER VA ADDRESS Supplier

-- -- xem dữ liệu
-- SELECT * FROM tblSupplier
-- SELECT * FROM tblAddressSupplier

--  SELECT * FROM tblAddressSupplier,tblSupplier
--  WHERE Ma = MaNCC

-- -- Them du lieu

-- -- Nha cung cap 1
-- INSERT INTO tblSupplier ( Ma , Ten , SoDT, Email )
-- VALUES ('NCC001','Meow','0823072871','Meow@gmail.com')

-- INSERT INTO tblAddressSupplier ( MaNCC, SoNha, Quan, ThanhPho)
-- VALUES ('NCC001', 'Số 85 Võ Thị Kế', 'Quận 5', 'TP Tân An')
-- -- Nha cung cap 2
-- INSERT INTO tblSupplier ( Ma , Ten , SoDT, Email )
-- VALUES ('NCC002','Cats','0917452962','Cats@gmail.com')

-- INSERT INTO tblAddressSupplier ( MaNCC, SoNha, Quan, ThanhPho)
-- VALUES ('NCC002', 'Số 86 Võ Thị Kế', 'Quận 5', 'TP Tân An')
-- -- Nha cung cap 3
-- INSERT INTO tblSupplier ( Ma , Ten , SoDT, Email )
-- VALUES ('NCC003','Dogs','02723822871','phucapDogs@gmail.com')

-- INSERT INTO tblAddressSupplier ( MaNCC, SoNha, Quan, ThanhPho)
-- VALUES ('NCC003', 'Số 87 Võ Thị Kế', 'Quận 5', 'TP Tân An')
-- -- Nha cung cap 4
-- INSERT INTO tblSupplier ( Ma , Ten , SoDT, Email )
-- VALUES ('NCC004','SangNgai','02723822871','SangNgai@gmail.com')

-- INSERT INTO tblAddressSupplier ( MaNCC, SoNha, Quan, ThanhPho)
-- VALUES ('NCC004', 'Số 88 Võ Thị Kế', 'Quận 6', 'TP HCM')

-- -- Xoa du lieu 
-- -- DELETE tblSupplier where Ma = 'NCC005' 
-- -- DELETE tblAddressSupplier WHERE MaNCC = 'NCC005'

-- -- PRODUCTS , FOOD, DRINK

-- -- Xem du lieu
-- SELECT * FROM tblFood
-- SELECT * FROM tblDrink
-- SELECT * FROM tblProducts

-- SELECT * FROM tblProducts,tblFood
-- WHERE tblProducts.Ma_Product = tblFood.Ma_Food

-- SELECT * FROM tblProducts,tblDrink
-- WHERE tblProducts.Ma_Product = tblDrink.Ma_Drink 

-- -- UPDATE tblDrink SET Alcoholic = 'No' WHERE Ma_Drink ='D001' 
-- -- Them du lieu

-- -- Food 1: Gà rán 
-- INSERT INTO tblProducts ( Ma_Product, Name, Price, Taxes, ExpiryDate, Ma_Supplier, SoLuong)
-- VALUES ('F001','Gà rán',10,5,'10/02/2020','NCC001',10)

-- INSERT INTO tblFood ( Ma_Food, Vegetarian, Frozenfood)
-- VALUES ('F001','No','Yes')

-- --Food 2: Pizza
-- INSERT INTO tblProducts ( Ma_Product, Name, Price, Taxes, ExpiryDate, Ma_Supplier, SoLuong)
-- VALUES ('F002','Pizza',10,5,'10/02/2020','NCC001',10)

-- INSERT INTO tblFood ( Ma_Food, Vegetarian, Frozenfood)
-- VALUES ('F002','No','Yes')

-- -- Food 3: Hot dog
-- INSERT INTO tblProducts ( Ma_Product, Name, Price, Taxes, ExpiryDate, Ma_Supplier, SoLuong)
-- VALUES ('F003','Hot dog',10,5,'10/02/2020','NCC002',10)

-- INSERT INTO tblFood ( Ma_Food, Vegetarian, Frozenfood)
-- VALUES ('F003','No','Yes')

-- -- Drink 1: Coca
-- INSERT INTO tblProducts ( Ma_Product, Name, Price, Taxes, ExpiryDate, Ma_Supplier, SoLuong)
-- VALUES ('D001','Coca',10,5,'10/02/2020','NCC003',10)

-- INSERT INTO tblDrink ( Ma_Drink, Alcoholic)
-- VALUES ('D001','No')

-- -- Drink 2: Pepsi
-- INSERT INTO tblProducts ( Ma_Product, Name, Price, Taxes, ExpiryDate, Ma_Supplier, SoLuong)
-- VALUES ('D002','Pepsi',10,5,'10/02/2020','NCC004',10)

-- INSERT INTO tblDrink ( Ma_Drink, Alcoholic)
-- VALUES ('D002','No')

-- -- Xoa du lieu
-- -- DELETE tblFood WHERE Ma_Food = 'F001'
-- -- DELETE tblProducts WHERE Ma_Product = 'F001'

-- -- DELETE tblDrink WHERE Ma_Drink = 'D001'
-- -- DELETE tblProducts WHERE Ma_Product = 'D001'

-- -- STAFF (MANAGER, FULLTIMESTAFF, SEASONALSTAFF ) va ADDRESS STAFF

-- -- Xem thong tin
SELECT * FROM tblStaff
SELECT * FROM tblSeasonalStaff
SELECT * FROM tblFullTimeStaff
SELECT * FROM tblManager
SELECT * FROM tblAddressStaff

-- SELECT * FROM tblStaff,tblAddressStaff
-- WHERE tblAddressStaff.ID_NV = tblStaff.ID

-- -- Them du lieu

-- -- Staff 1: Seasonal staff 
-- INSERT INTO tblStaff (ID, Name, Date_in, Gender, CMND, Password, Salary)
-- VALUES ('NV001','Trương Công Phúc','10/2/2022','Nam','111111111','123',500000)
-- INSERT INTO tblSeasonalStaff (ID_Seasonal,HourlyWage,WorkHours)
-- VALUES ('NV001',20,8)
-- INSERT INTO tblAddressStaff(ID_NV,SoNha,Quan,ThanhPho)
-- VALUES ('NV001','Số 136 Huỳnh Văn Gấm','Quận 5','TP Tân An')

-- -- Staff 2: FullTime Staff 
-- INSERT INTO tblStaff (ID, Name, Date_in, Gender, CMND, Password, Salary)
-- VALUES ('NV002','Đỗ Tiến Đạt','10/2/2022','Nam','555555555','123','500000')
-- INSERT INTO tblFullTimeStaff (ID_FullTimeStaff,BaseSalary,BonusRate,WorkDay)
-- VALUES ('NV002',500000,8,8)
-- INSERT INTO tblAddressStaff(ID_NV,SoNha,Quan,ThanhPho)
-- VALUES ('NV002','Số 137 Huỳnh Văn Gấm','Quận 5','TP Tân An')

-- -- Staff 3: Seasonal staff 
-- INSERT INTO tblStaff (ID, Name, Date_in, Gender, CMND, Password, Salary)
-- VALUES ('NV003','Trần Khang Thịnh','10/2/2022','Nam','666666666','123',500000)
-- INSERT INTO tblSeasonalStaff (ID_Seasonal,HourlyWage,WorkHours)
-- VALUES ('NV003',20,8)
-- INSERT INTO tblAddressStaff(ID_NV,SoNha,Quan,ThanhPho)
-- VALUES ('NV003','Số 139 Huỳnh Văn Gấm','Quận 5','TP Tân An')

-- -- Staff 4: Manager
-- INSERT INTO tblStaff (ID, Name, Date_in, Gender, CMND, Password, Salary)
-- VALUES ('NV004','Nguyễn Thanh Sang','10/2/2022','Nam','666666666','123',500000)
-- INSERT INTO tblFullTimeStaff (ID_FullTimeStaff,BaseSalary,BonusRate,WorkDay)
-- VALUES ('NV004',500000,8,8)
-- INSERT INTO tblManager (ID_Manager,Allowance)
-- VALUES('NV004',5)
-- INSERT INTO tblAddressStaff(ID_NV,SoNha,Quan,ThanhPho)
-- VALUES ('NV004','Số 140 Huỳnh Văn Gấm','Quận 5','TP Tân An')

-- -- Xoa du lieu

-- DELETE tblAddressStaff WHERE ID_NV = 'NV006'
-- DELETE tblSeasonalStaff WHERE ID_Seasonal = 'NV006'
-- DELETE tblFullTimeStaff WHERE ID_FullTimeStaff = 'NV001'
-- DELETE tblManager WHERE ID_Manager = 'NV001'
-- DELETE tblStaff WHERE ID = 'NV006'

-- -- PHIEU NHAP

-- -- xem du lieu
-- SELECT * FROM tblPhieu
-- SELECT * FROM tblPhieuNhap
-- SELECT * FROM tblChiTietPhieuNhap

-- SELECT * FROM tblPhieuNhap,tblChiTietPhieuNhap
-- WHERE ID_PhieuNhap = ID_CTPhieuNhap

-- -- Them du lieu

-- -- Phieu nhap 1 : Coca
-- INSERT INTO tblPhieu (ID,ID_NV,Ngay,Tongtien)
-- VALUES ('N001','NV001','10/02/2020',50)

-- INSERT INTO tblPhieuNhap(ID_PhieuNhap,MaNSX,TinhTrang)
-- VALUES('N001','NCC001','Chưa nhập')

-- INSERT INTO tblChiTietPhieuNhap(ID_CTPhieuNhap,TenSP,MaSP,SoLuong,DonGia)
-- VALUES('N001','Coca','D001',5,10)

-- -- Phieu nhap 2: Ga ran, Coca
-- INSERT INTO tblPhieu (ID,ID_NV,Ngay,Tongtien)
-- VALUES ('N002','NV001','10/02/2020',100)

-- INSERT INTO tblPhieuNhap(ID_PhieuNhap,MaNSX,TinhTrang)
-- VALUES('N002','NCC001','Chưa nhập')

-- INSERT INTO tblChiTietPhieuNhap(ID_CTPhieuNhap,TenSP,MaSP,SoLuong,DonGia)
-- VALUES('N002','Coca','D001',5,10)
-- INSERT INTO tblChiTietPhieuNhap(ID_CTPhieuNhap,TenSP,MaSP,SoLuong,DonGia)
-- VALUES('N002','Gà rán','F001',5,10)

-- -- Phieu nhap 3: Pizza, Coca
-- INSERT INTO tblPhieu (ID,ID_NV,Ngay,Tongtien)
-- VALUES ('N003','NV001','10/02/2020',100)

-- INSERT INTO tblPhieuNhap(ID_PhieuNhap,MaNSX,TinhTrang)
-- VALUES('N003','NCC001','Chưa nhập')

-- INSERT INTO tblChiTietPhieuNhap(ID_CTPhieuNhap,TenSP,MaSP,SoLuong,DonGia)
-- VALUES('N003','Coca','D001',5,10)
-- INSERT INTO tblChiTietPhieuNhap(ID_CTPhieuNhap,TenSP,MaSP,SoLuong,DonGia)
-- VALUES('N003','Pizza','F002',5,10)

-- -- Xoa 
-- DELETE tblChiTietPhieuNhap WHERE ID_CTPhieuNhap = 'N004'
-- DELETE tblPhieuNhap WHERE ID_PhieuNhap = 'N004'
-- DELETE tblPhieu WHERE ID = 'N004'

-- -- HOA DON

-- -- -- xem du lieu
-- SELECT * FROM tblHoaDon
-- SELECT * FROM tblCTHoaDon

-- SELECT * FROM tblHoaDon,tblCTHoaDon
-- WHERE MaHD = Ma

-- -- Them du lieu
-- -- Hoa don 1: 
-- INSERT INTO tblHoaDon (Ma,MaNV,ThoiGianXuat,TinhTrang,TongTien)
-- VALUES ('HD001','NV001','20/02/2020','Đã bán',30)

-- INSERT INTO tblCTHoaDon (MaHD,MaSP,SoLuong,DonGia)
-- VALUES ('HD001','F001',3,10)
-- -- Hoa don 2:
-- INSERT INTO tblHoaDon (Ma,MaNV,ThoiGianXuat,TinhTrang,TongTien)
-- VALUES ('HD002','NV001','20/02/2020','Đã bán',60)

-- INSERT INTO tblCTHoaDon (MaHD,MaSP,SoLuong,DonGia)
-- VALUES ('HD002','F001',3,10)
-- INSERT INTO tblCTHoaDon (MaHD,MaSP,SoLuong,DonGia)
-- VALUES ('HD002','F002',3,10)

-- -- Xoa
-- DELETE tblCTHoaDon WHERE MaHD = 'HD004'
-- DELETE tblHoaDon WHERE Ma = 'HD009'

-- -- Phieu Xuat

-- -- xem du lieu
-- SELECT * from tblPhieu
-- SELECT * FROM tblPhieuXuat
-- SELECT * FROM tblChiTietPhieuXuat

-- SELECT * FROM tblPhieuXuat,tblChiTietPhieuXuat
-- WHERE ID_PhieuXuat = ID_CTPhieuXuat

-- -- them du lieu
-- -- Phieu xuat 1
-- INSERT INTO tblPhieu (ID,ID_NV,Ngay,Tongtien)
-- VALUES ('X001','NV001','20/02/2022',30)

-- INSERT INTO tblPhieuXuat(ID_PhieuXuat,ID_HoaDon,TinhTrang)
-- VALUES ('X001','HD001','Đã xuất kho')

-- INSERT INTO tblChiTietPhieuXuat (ID_CTPhieuXuat,MaSP,TenSP,SoLuong,DonGia)
-- VALUES ('X001','F001','Gà rán',3,10)

-- -- Phieu xuat 2
-- INSERT INTO tblPhieu (ID,ID_NV,Ngay,Tongtien)
-- VALUES ('X002','NV001','20/02/2022',60)

-- INSERT INTO tblPhieuXuat(ID_PhieuXuat,ID_HoaDon,TinhTrang)
-- VALUES ('X002','HD002','Đã xuất kho')

-- INSERT INTO tblChiTietPhieuXuat (ID_CTPhieuXuat,MaSP,TenSP,SoLuong,DonGia)
-- VALUES ('X002','F001','Gà rán',3,10)
-- INSERT INTO tblChiTietPhieuXuat (ID_CTPhieuXuat,MaSP,TenSP,SoLuong,DonGia)
-- VALUES ('X002','F002','Pizza',3,10)

-- -- xoa du lieu
-- DELETE tblChiTietPhieuXuat WHERE ID_CTPhieuXuat = 'X001'
-- DELETE tblPhieuXuat WHERE ID_PhieuXuat = 'X001'
-- DELETE tblPhieu WHERE ID = 'X003'




















