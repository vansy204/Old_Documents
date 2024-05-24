CREATE DATABASE QLSINHVIEN
ON
(
	NAME = 'qlisinhvien_data',
	FILENAME = 'D:\SQL\qlisinhvien.mdf'
)
LOG ON
(
	NAME ='qlisinhvien_log',
	FILENAME = 'D:\SQL\qlisinhvien.ldf'
)

USE QLSINHVIEN

CREATE TABLE LOP
(
	MaLop CHAR(7) PRIMARY KEY,
	TenLop NVARCHAR(50),
	SiSo tinyint CHECK (SiSo > 0)
)

CREATE TABLE MONHOC
(
	MaMH CHAR(6) PRIMARY KEY,
	TenMH NVARCHAR(50),
	TCTL tinyint CHECK (TCTL >= 0),
	TCTH tinyint CHECK (TCTH >= 0)
)

CREATE TABLE SINHVIEN
(
	MSSV CHAR(6) PRIMARY KEY,
	HoTen NVARCHAR(50),
	NTNS DATE,
	PHAI BIT,
	MaLop CHAR(7),
    FOREIGN KEY (MaLop) REFERENCES LOP(MaLop)
)

CREATE TABLE DIEMSV
(
	MSSV CHAR(6),
	MaMH CHAR(6),
	DIEM DECIMAL(3,1),
	PRIMARY KEY(MSSV,MaMH),
	FOREIGN KEY (MSSV) REFERENCES SINHVIEN(MSSV),
    FOREIGN KEY (MaMH) REFERENCES MONHOC(MaMH),
    CHECK (DIEM IS NULL OR (DIEM >= 0 AND DIEM <= 10)) 
)

--CAU 1: THEM MOT DONG MOI VAO BANG SINHVIEN
INSERT INTO SINHVIEN(MSSV,HOTEN,NTNS,PHAI,MALOP)
VALUES (190001,N'Đào Thị Tuyết Hoa','08/03/2001',0,'19DTH02')

--CAU 2:Hãy đổi tên môn học ‘Lý thuyết đồ thị ’thành ‘Toán rời rạc’
UPDATE MONHOC
SET TENMH = N'Toán rời rạc'
WHERE TENMH = N'Lý thuyết đồ thị'

--CAU 3:Hiển thị tên các môn học không có thực hành
SELECT MONHOC.TENMH
FROM MONHOC
WHERE MONHOC.TCTH = 0

--CAU 4:Hiển thị tên các môn học vừa có lý thuyết, vừa có thực hành
SELECT MONHOC.TENMH
FROM MONHOC
WHERE MONHOC.TCTH != 0 AND MONHOC.TCTL !=0

--CAU 5: In ra tên các môn học có ký tự đầu của tên là chữ ‘C’
SELECT MONHOC.TENMH
FROM MONHOC
WHERE MONHOC.TENMH LIKE 'C%' 

--CAU 6:Liệt kê thông tin những sinh viên mà họ chứa chữ ‘Thị’.
SELECT SINHVIEN.HOTEN
FROM SINHVIEN
WHERE SINHVIEN.HOTEN LIKE N'%Thị%' 

--CAU 7:In ra 2 lớp có sĩ số đông nhất (bằng nhiều cách). Hiển thị: Mã lớp, Tên lớp, Sĩ số
SELECT TOP 2 * 
FROM LOP ORDER BY LOP.SISO DESC


--CAU 8:In danh sách SV theo từng lớp: MSSV, Họ tên SV, Năm sinh, Phái (Nam/Nữ).
SELECT LOP.MALOP,SINHVIEN.MSSV,SINHVIEN.HOTEN,YEAR(SINHVIEN.NTNS) AS 'NAM SINH',CASE WHEN SINHVIEN.PHAI = 1 THEN 'Nam' ELSE N'Nữ' END AS TUOI
FROM SINHVIEN,LOP
WHERE SINHVIEN.MALOP = LOP.MALOP

--CAU 9:Cho biết những sinh viên có tuổi ≥ 20, thông tin gồm: Họ tên sinh viên, Ngày sinh, Tuổi
SELECT HoTen, NTNS AS NgaySinh, DATEDIFF(YEAR, NTNS, GETDATE()) AS Tuoi
FROM SINHVIEN
WHERE DATEDIFF(YEAR, NTNS, GETDATE()) >= 20

--CAU 10: Liệt kê tên các môn học SV đã dự thi nhưng chưa có điểm.
SELECT SINHVIEN.MSSV,SINHVIEN.HOTEN, DIEMSV.DIEM
FROM SINHVIEN,DIEMSV
WHERE SINHVIEN.MSSV = DIEMSV.MSSV AND DIEMSV.DIEM IS NULL

--CAU 11:Liệt kê kết quả học tập của SV có mã số 170001. Hiển thị: MSSV, HoTen, TenMH, Diem
SELECT SINHVIEN.MSSV,SINHVIEN.HOTEN,MONHOC.TENMH,DIEMSV.DIEM
FROM SINHVIEN,DIEMSV,MONHOC
WHERE SINHVIEN.MSSV = 170001 AND SINHVIEN.MSSV = DIEMSV.MSSV AND MONHOC.MAMH = DIEMSV.MAMH

--CAU 12: Liệt kê tên sinh viên và mã môn học mà sv đó đăng ký với điểm trên 7 điểm
SELECT SINHVIEN.HOTEN,MONHOC.MAMH,DIEMSV.DIEM
FROM SINHVIEN,DIEMSV,MONHOC
WHERE DIEMSV.DIEM > 7 AND SINHVIEN.MSSV = DIEMSV.MSSV AND MONHOC.MAMH = DIEMSV.MAMH

--CAU 13: Liệt kê tên môn học cùng số lượng SV đã học và đã có điểm
SELECT MONHOC.TENMH,COUNT(DIEMSV.MSSV) AS 'SO LUONG SINH VIEN'
FROM SINHVIEN,DIEMSV,MONHOC
WHERE MONHOC.MAMH = DIEMSV.MAMH AND DIEMSV.DIEM IS NOT NULL AND SINHVIEN.MSSV = DIEMSV.MSSV
GROUP BY MONHOC.TENMH

--CAU 14: Liệt kê tên SV và điểm trung bình của SV đó
SELECT SINHVIEN.HOTEN,AVG(DIEMSV.DIEM) AS 'DIEM TRUNG BINH'
FROM SINHVIEN,DIEMSV,MONHOC
WHERE MONHOC.MAMH = DIEMSV.MAMH AND DIEMSV.DIEM IS NOT NULL AND SINHVIEN.MSSV = DIEMSV.MSSV
GROUP BY SINHVIEN.HOTEN

--CAU 15: Liệt kê tên sinh viên đạt điểm cao nhất của môn học ‘Kỹ thuật lập trình’.
SELECT SV.HOTEN,D.DIEM
FROM SINHVIEN SV,DIEMSV D,MONHOC M
WHERE	SV.MSSV = D.MSSV  AND
		M.MAMH = D.MAMH AND
		D.DIEM = (SELECT MAX(D1.DIEM) FROM DIEMSV D1,MONHOC M1 WHERE D1.MAMH = M1.MAMH AND M.TENMH = N'Kỹ thuật lập trình')

--cau 16: Liet ke ten sinh vien co diem trung binh cao nhat
SELECT Top(1) HoTen, (AVG(DIEM)) AS DTBINH
FROM SINHVIEN , DIEMSV
WHERE SINHVIEN.MSSV = DIEMSV.MSSV
GROUP BY HoTen
order by DTBINH DESC


--cau 17: Liet ke ten sinh vien chua hoc 'Toan roi rac'
 SELECT HoTen
 FROM SINHVIEN
 WHERE HoTen NOT IN	(	SELECT HoTen	
						FROM DIEMSV, MONHOC, SINHVIEN
						WHERE MONHOC.MaMH = DIEMSV.MaMH
						AND SINHVIEN.MSSV = DIEMSV.MSSV
						AND MONHOC.TenMH = N'Toán rời rạc')



 --cau18: Cho biet sinh vien co nam sinh cung voi sinh vien ten 'Danh'
 SELECT HoTen 
 FROM SINHVIEN
 WHERE YEAR(NTNS) IN 
 (
	SELECT YEAR(NTNS)
	FROM SINHVIEN
	WHERE HoTen LIKE N'%Danh'
) 

--CAU 19: cho biet tong sinh vien va tong so sinh vien nu
SELECT COUNT(*) AS TongSV ,
SUM(CASE WHEN PHAI = 0 THEN 1 ELSE 0 END) TongSVNu
FROM SINHVIEN

--cau 20: Danh sach cac sinh vien rot it nhat 1 mon
SELECT HoTen
FROM SINHVIEN, DIEMSV
WHERE SINHVIEN.MSSV = DIEMSV.MSSV AND DIEM < 5

--cau 21:Cho biet MSSV, Ho ten SV da hoc va co diem it nhat 3 mon
SELECT SINHVIEN.MSSV, HoTen
FROM SINHVIEN, DIEMSV
WHERE SINHVIEN.MSSV = DIEMSV.MSSV	
GROUP BY SINHVIEN.MSSV, HoTen
HAVING COUNT(MaMH)>=3 
 
--cau 22: In danh sach sinh vien co diem mon'Ky thuat lap trinh' cao nhat theo tung lop

WITH RankedScores AS (
    SELECT
        SV.MaLop AS [LỚP],
		SV.HoTen AS [HỌ VÀ TÊN],
        DSV.MSSV AS [MÃ SỐ SINH VIÊN],
        DSV.Diem AS [ĐIỂM],
        RANK() OVER (PARTITION BY SV.MaLop ORDER BY DSV.Diem DESC) as Rank
    FROM SINHVIEN SV
    LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
    LEFT JOIN MONHOC MH ON MH.MaMH = DSV.MaMH
    WHERE MH.TenMH = N'Kỹ thuật lập trình'
)
SELECT [LỚP], [HỌ VÀ TÊN], [MÃ SỐ SINH VIÊN], [ĐIỂM]
FROM RankedScores
WHERE Rank = 1

--cau 23:Cho biết những sinh viên đạt điểm cao nhất của từng môn,từng lớp
WITH RankedScores AS (
    SELECT distinct
        SV.MaLop AS [LỚP],
		SV.HoTen AS [HỌ VÀ TÊN],
        DSV.MSSV AS [MÃ SỐ SINH VIÊN],
		MH.TenMH AS [TÊN MÔN HỌC],
        DSV.Diem AS [ĐIỂM],
		
        RANK() OVER (PARTITION BY L.MaLop ORDER BY DSV.Diem DESC) as Rank
    FROM SINHVIEN SV
    LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
    LEFT JOIN MONHOC MH ON MH.MaMH = DSV.MaMH
	LEFT JOIN LOP L ON L.MaLop = SV.MaLop
    
)
SELECT [LỚP], [HỌ VÀ TÊN],[TÊN MÔN HỌC], [MÃ SỐ SINH VIÊN], [ĐIỂM]
FROM RankedScores
WHERE Rank = 1



--cau 24:Cho biết những sinh viên đạt điểm cao nhất của từng môn.

WITH RankedScores AS (
    SELECT 
        SV.MaLop AS [LỚP],
		SV.HoTen AS [HỌ VÀ TÊN],
        DSV.MSSV AS [MÃ SỐ SINH VIÊN],
		MH.TenMH AS [TÊN MÔN HỌC],
        DSV.Diem AS [ĐIỂM],
		
        RANK() OVER (PARTITION BY MH.MaMH ORDER BY DSV.Diem DESC) as Rank
    FROM SINHVIEN SV
    LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
    LEFT JOIN MONHOC MH ON MH.MaMH = DSV.MaMH
    
)
SELECT [LỚP], [HỌ VÀ TÊN],[TÊN MÔN HỌC], [MÃ SỐ SINH VIÊN], [ĐIỂM]
FROM RankedScores
WHERE Rank = 1


-- cau25:Cho biết MSSV, Họ tên SV chưa đăng ký học môn nào.
SELECT SV.MSSV, SV.HoTen
FROM SINHVIEN SV
LEFT JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
WHERE DSV.MaMH IS NULL

-- cau 26:Danh sách sinh viên có tất cả các điểm đều 10.

SELECT SV.MSSV, SV.HoTen
FROM SINHVIEN SV
JOIN DIEMSV DSV ON SV.MSSV = DSV.MSSV
GROUP BY SV.MSSV, SV.HoTen
HAVING MIN(DSV.Diem) = 10

--27: Đếm số sinh viên nam, nữ theo từng lớp.

-- 29-	Xóa tất cả những sinh viên chưa dự thi môn nào.
DELETE FROM SINHVIEN
WHERE MSSV NOT IN (
    SELECT DISTINCT MSSV
    FROM DIEMSV
)

-- 28:Cho biết những sinh viên đã học tất cả các môn nhưng không rớt môn nào
SELECT SV.MSSV, SV.HoTen
FROM SINHVIEN SV
WHERE NOT EXISTS (
    SELECT 1
    FROM DIEMSV DSV
    WHERE DSV.MSSV = SV.MSSV AND DSV.Diem < 5
) AND EXISTS (
    SELECT 1
    FROM MONHOC MH
    WHERE NOT EXISTS (
        SELECT 1
        FROM DIEMSV DSV
        WHERE DSV.MSSV = SV.MSSV AND DSV.MaMH = MH.MaMH AND  MH.MaMH is null
    )
)
