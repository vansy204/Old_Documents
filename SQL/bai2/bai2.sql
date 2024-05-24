 hydCREATE DATABASE QUANLYSINHVIEN
ON
	(
		NAME = 'quanlysinhvien_data',
		FILENAME = 'D:\SQL\bai2\quanlysinhvien.mdf'
	)
LOG ON
	(
		NAME = 'quanlysinhvien_log',
		FILENAME = 'D:\SQL\bai2\quanlysinhvien.log'
	)
USE QUANLYSINHVIEN
CREATE TABLE LOP
	(
		MaLop CHAR(7) PRIMARY KEY,
		TenLop NVARCHAR(50), 
		SiSo TINYINT CHECK(SiSo > 0)
	)
CREATE TABLE MONHOC
	(
		MaMH CHAR(7) PRIMARY KEY, 
		TenMH NVARCHAR(50), 
		TCLT TINYINT CHECK(TCLT >= 0), 
		TCTH TINYINT CHECK(TCTH >= 0)
	)

CREATE TABLE SINHVIEN
	(
		MSSV CHAR(7) PRIMARY KEY, 
		HoTen NVARCHAR(50), 
		NTNS DATE, 
		Phai BIT, 
		MaLop CHAR(7),
		FOREIGN KEY(MaLop) REFERENCES LOP(MaLop)
		ON UPDATE CASCADE
	)
CREATE TABLE DIEMSV
	(
		MSSV CHAR(7), 
		MaMH CHAR(7), 
		Diem DECIMAL(3,1),
		PRIMARY KEY (MSSV,MaMH),
		FOREIGN KEY (MSSV) REFERENCES SINHVIEN(MSSV)
		ON UPDATE CASCADE

	)

-- cau 1: Thêm một dòng mới vào bảng SINHVIEN với giá trị: --

INSERT INTO SINHVIEN 
	(MSSV, HoTen, NTNS, Phai,MaLop)
VALUES
	('190001', N'Đào Thị Tuyết Hoa', '08/03/2001',0,'19DTH02');
-- kiem tra cau 1 --
SELECT *
FROM QUANLYSINHVIEN.dbo.SINHVIEN

DELETE FROM SINHVIEN WHERE MSSV = '190001' 

-- cau 2:Hãy đổi tên môn học ‘Lý thuyết đồ thị ’thành ‘Toán rời rạc’.--
UPDATE QUANLYSINHVIEN.dbo.MONHOC
SET TenMH = N'Toán Rời Rạc'
WHERE TenMH = N'Lý thuyết đồ thị'

-- kiem tra cau 2 --
SELECT *
FROM QUANLYSINHVIEN.dbo.MONHOC

-- cau 3:Hiển thị tên các môn học không có thực hành.
SELECT TenMH
FROM MONHOC
WHERE TCTH = 0

-- cau 4: Hiển thị tên các môn học vừa có lý thuyết, vừa có thực hành.
SELECT TenMH
FROM MONHOC
WHERE (TCLT !=0) AND (TCTH !=0)

-- cau 5: In ra tên các môn học có ký tự đầu của tên là chữ ‘C’.
SELECT TenMH
FROM MONHOC
WHERE TenMH LIKE 'C%';

-- cau 6: Liệt kê thông tin những sinh viên mà họ chứa chữ ‘Thị’.

SELECT *
FROM SINHVIEN
WHERE (SELECT ( CHARINDEX(N'Thị',SINHVIEN.HoTen))) != 0

-- cau 7: In ra 2 lớp có sĩ số đông nhất (bằng nhiều cách). Hiển thị: Mã lớp, Tên lớp, Sĩ số. Nhận xét?

SELECT TOP 2 WITH TIES MaLop, TenLop , SiSo
FROM QUANLYSINHVIEN.dbo.LOP
ORDER BY SiSo DESC


-- 8-	In danh sách SV theo từng lớp: MSSV, Họ tên SV, Năm sinh, Phái (Nam/Nữ).
SELECT	SV.MaLop AS LỚP,
		SV.MSSV AS MSSV,
		SV.HoTen AS HỌ_TÊN, 
		SV.NTNS AS NĂM_SINH,
		CASE WHEN SV.Phai = 1 THEN 'NAM' ELSE N'Nữ' END AS PHÁI
FROM SINHVIEN SV
INNER JOIN LOP L ON SV.MaLop = L.MaLop
GROUP BY SV.MaLop,SV.MSSV, SV.HoTen, SV.NTNS, SV.Phai;

-- 9-	Cho biết những sinh viên có tuổi ≥ 20, thông tin gồm: Họ tên sinh viên, Ngày sinh, Tuổi.

SELECT 
	SV.HoTen,
	SV.NTNS,
	2024 - YEAR(SV.NTNS) AS TUỔI
FROM SINHVIEN SV
WHERE 2024 - YEAR(SV.NTNS) >= 20

-- 10-	Liệt kê tên các môn học SV đã dự thi nhưng chưa có điểm.
SELECT	
	DSV.MaMH AS [MÃ MÔN HỌC],
	MH.TenMH AS [TÊN MÔN HỌC]
FROM DIEMSV DSV, MONHOC MH
WHERE (DSV.Diem IS NULL) AND (MH.MaMH = DSV.MaMH)

-- 11-	Liệt kê kết quả học tập của SV có mã số 170001. Hiển thị: MSSV, HoTen, TenMH, Diem.
SELECT 
	SV.MSSV AS [MÃ SỐ SINH VIÊN],
	SV.HoTen AS [HỌ TÊN SINH VIÊN],
	MH.TenMH AS [TÊN MÔN HỌC],
	DSV.Diem AS [ĐIỂM MÔN]

FROM SINHVIEN SV
LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
LEFT JOIN MONHOC MH ON DSV.MaMH = MH.MaMH
WHERE (SV.MSSV = 170001)  AND (DSV.MSSV = 170001)

-- 12-	Liệt kê tên sinh viên và mã môn học mà sv đó đăng ký với điểm trên 7 điểm.
SELECT 
	SV.HoTen AS [HỌ VÀ TÊN SINH VIÊN],
	DSV.MaMH AS [MÃ MÔN HỌC ĐĂNG KÝ],
	DSV.Diem AS [ĐIỂM MÔN HỌC]
FROM  SINHVIEN SV
LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
WHERE DSV.Diem > 7

-- 13-	Liệt kê tên môn học cùng số lượng SV đã học và đã có điểm.
SELECT
	MH.MaMH AS [MÃ MÔN HỌC],
	MH.TenMH AS [TÊN MÔN HỌC]
FROM MONHOC MH
RIGHT JOIN DIEMSV DSV ON MH.MaMH = DSV.MaMH
WHERE DSV.Diem IS NOT NULL


--14-	Liệt kê tên SV và điểm trung bình của SV đó.
SELECT 
	SV.HoTen AS [TÊN SINH VIÊN],
	ROUND (AVG(CAST (DSV.Diem AS FLOAT )),3) AS [ĐIỂM TRUNG BÌNH]
FROM SINHVIEN SV
LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
GROUP BY SV.HoTen

--15-	Liệt kê tên sinh viên đạt điểm cao nhất của môn học ‘Kỹ thuật lập trình’.
SELECT SV.HoTen AS [TÊN SINH VIÊN]
FROM SINHVIEN SV
LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
LEFT JOIN MONHOC MH ON DSV.MaMH = MH.MaMH
WHERE 
	(Diem = (SELECT MAX(DSV.Diem) 
	FROM DIEMSV DSV)) AND (MH.TenMH = N'Kỹ thuật lập trình') AND(DSV.MaMH = MH.MaMH)

-- 16-	Liệt kê tên SV có điểm trung bình cao nhất.
SELECT  
	SV.HoTen AS [TÊN SINH VIÊN],
	AVG(DSV.DIEM) AS [ĐIỂM TRUNG BÌNH]
FROM DIEMSV DSV
LEFT JOIN SINHVIEN SV ON DSV.MSSV = SV.MSSV
GROUP BY SV.HoTen, DSV.Diem
HAVING AVG(DSV.DIEM) = 
	(SELECT MAX(DSV.DIEM)	
	FROM DIEMSV DSV)
						
-- 17-	Liệt kê tên SV chưa		học môn ‘Toán rời rạc’.
SELECT SV.HoTen AS [TÊN SINH VIÊN]
FROM SINHVIEN SV
WHERE NOT EXISTS 
	(
		SELECT *
		FROM DIEMSV DSV
		WHERE (DSV.MaMH = 'COS202') AND (SV.MSSV = DSV.MSSV)
	)
-- 18-	Cho biết tổng sinh viên và tổng số sinh viên nữ.


-- cau 30
SELECT MH.TenMH AS [TÊN MÔN HỌC]
FROM MONHOC MH
WHERE MH.MaMH NOT IN 
	(
		SELECT MH.MaMH
		FROM MONHOC MH
		WHERE 
		EXCEPT
		SELECT DSV.MaMH
		FROM DIEMSV DSV
	)
