create database QLSV
on
(
	name = 'QLSV_Data',
	filename = 'C:\QLSV\QLSV.mdf'
)
log on
(
	name = 'QLSV_Log',
	filename = 'C:\QLSV\QLSV.ldf'
)
use QLSV
create table LOP
(
	MaLop	char(7) primary key,
	TenLop	nvarchar(50),
	SiSo	tinyint check(SiSo>0)
)
create table MONHOC
(
	MaMH	char(6) primary key,
	TenMH	nvarchar(50),
	TCLT	tinyint	check(TCLT>0),
	TCTH	tinyint check(TCTH>=0)
)
create table SINHVIEN
(
	MSSV	char(6) primary key,
	HoTen	nvarchar(50),
	NTNS	date,
	Phai	bit default 1, --bit: binary digits
	MaLop	char(7),
	foreign key (MaLop) references LOP(MaLop)
	on update cascade
	on delete set null
)
create table DIEMSV
(
	MSSV	char(5),
	MaMH	char(6),
	primary key(MSSV, MaMH),
	foreign key (MSSV) references SINHVIEN(MSSV)
	on update cascade
	on delete cascade,
	foreign key (MaMH) references MONHOC(MaMH)
	on update no action
	on delete no action,
	Diem	decimal(3,1) check(Diem between 0 and 10)
)
--
1-	Thêm một dòng mới vào bảng SINHVIEN với giá trị:
insert into SINHVIEN values('190001', N'Đào Thị Tuyết Hoa',	'8/3/2001', 0, '19DTH02')
--
select *
from SINHVIEN
--
delete from SINHVIEN where MSSV='190001'
--Chuyển kiểu gõ Date sang dd/mm/yyyy
set dateformat dmy
--Nhập lại
insert into SINHVIEN values('190001', N'Đào Thị Tuyết Hoa',	'8/3/2001', 0, '19DTH02')
--
2-	Hãy đổi tên môn học ‘Lý thuyết đồ thị’ thành ‘Toán rời rạc’.
update MONHOC
set TenMH=N'Toán rời rạc'
where TenMH=N'Lý thuyết đồ thị'
3-	Hiển thị tên các môn học không có thực hành.
4-	Hiển thị tên các môn học vừa có lý thuyết, vừa có thực hành.
5-	In ra tên các môn học có ký tự đầu của tên là chữ ‘C’.
... where HoTen like N'C%'
6-	Liệt kê thông tin những sinh viên mà họ chứa chữ ‘Thị’.
... where HoTen like NC'%Thị%'
7-	In ra 2 lớp có sĩ số đông nhất (bằng nhiều cách). Hiển thị: Mã lớp, Tên lớp, Sĩ số. 
Nhận xét?
--C1:
select *
from LOP
where SiSo = (select max(SiSo) from LOP) --Chỉ in ra 1 lớp
--C2:
select top 2 with ties *
from LOP
order by SiSo desc --Cách này thì in ra 3 lớp => Đúng
8-	In danh sách SV theo từng lớp: MSSV, Họ tên SV, Năm sinh, Phái (Nam/Nữ).
select MSSV, HoTen, year(NTNS) as [Năm sinh],
	   (case when Phai=1 then 'Nam'
	   else N'Nữ'
	   end) as [Phái]
from SINHVIEN
--Cách khác:
select MSSV, HoTen, year(NTNS) as [Năm sinh],
	   iif(Phai=1, 'Nam', N'Nữ') as [Phái]
from SINHVIEN
9-	Cho biết những sinh viên có tuổi ≥ 20, thông tin gồm: 
Họ tên sinh viên, Ngày sinh, Tuổi.
--Định dạng Ngày:
select getdate() --2024-03-12 15:36:32.540 AM|PM
select convert(varchar(10), getdate(), 101) --03/12/2024 (Anh/Mỹ)
select convert(varchar(10), getdate(), 102) --2024.03.12 (Nhật)
select convert(varchar(10), getdate(), 103) --12/03/2024 (Pháp/Việt)
select convert(varchar(10), getdate(), 104) --12.03.2024 (VN)
select convert(varchar(10), getdate(), 105) --12-03-2024 (VN)
--Các hàm rút trích thời gian
--12/3/2024
select datepart(dd, getdate()) --12
select datepart(mm, getdate()) --3
select datepart(yy, getdate()) --2024
select datepart(hh, getdate()) --15
select datepart(mi, getdate()) --41
select datepart(ss, getdate())
select HoTen, convert(varchar(10), NTNS, 103) as NTNS, [Tuổi]=year(getdate())-year(NTNS)
from SINHVIEN
10-	Liệt kê tên các môn học SV đã dự thi nhưng chưa có điểm.
select TenMH
from MONHOC M, DIEMSV D
where M.MaMH=D.MaMH and Diem is null
11-	Liệt kê kết quả học tập của SV có mã số 170001. Hiển thị: MSSV, HoTen, TenMH, Diem.
12-	Liệt kê tên sinh viên và mã môn học mà sv đó đăng ký với điểm trên 7 điểm.
13-	Liệt kê tên môn học cùng số lượng SV đã học và đã có điểm.
14-	Liệt kê tên SV và điểm trung bình của SV đó.
15-	Liệt kê tên sinh viên đạt điểm cao nhất của môn học ‘Kỹ thuật lập trình’.
16-	Liệt kê tên SV có điểm trung bình cao nhất.
17-	Liệt kê tên SV chưa học môn ‘Toán rời rạc’.
18-	Cho biết sinh viên có năm sinh cùng với sinh viên tên ‘Danh’.
19-	Cho biết tổng sinh viên và tổng số sinh viên nữ.
20-	Cho biết danh sách các sinh viên rớt ít nhất 1 môn.
select S.MSSV, HoTen
from SINHVIEN S, DIEMSV D
where S.MSSV=D.MSSV and Diem is not null and Diem<5
group by S.MSSV, HoTen
having count(Diem)>=1
21-	Cho biết MSSV, Họ tên SV đã học và có điểm ít nhất 3 môn.
select S.MSSV, HoTen
from SINHVIEN S, DIEMSV D
where S.MSSV=D.MSSV and Diem is not null
group by S.MSSV, HoTen
having count(Diem)>=3
22-	In danh sách sinh viên có điểm môn ‘Kỹ thuật lập trình’ cao nhất theo từng lớp.
23-	In danh sách sinh viên có điểm cao nhất theo từng môn, từng lớp.
24-	Cho biết những sinh viên đạt điểm cao nhất của từng môn.
25-	Cho biết MSSV, Họ tên SV chưa đăng ký học môn nào.
26-	Danh sách sinh viên có tất cả các điểm đều 10.
27-	Đếm số sinh viên nam, nữ theo từng lớp.
28-	Cho biết những sinh viên đã học tất cả các môn nhưng không rớt môn nào.
29-	Xóa tất cả những sinh viên chưa dự thi môn nào.
30-	Cho biết những môn đã được tất cả các sinh viên đăng ký học.
