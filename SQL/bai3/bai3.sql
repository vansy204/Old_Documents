CREATE DATABASE QLBONGDA
ON (
		NAME = 'QLBONGDA_DATA',
		FILENAME = 'D:\SQL\QLBONGDA_DATA.MDF'
	)
LOG ON
	(
		NAME = 'QLBONGDA_LOG',
		FILENAME ='D:\SQL\QLBONGDA_LOG.LDF'
	)

USE QLBONGDA
CREATE TABLE San
	(
		MaSan CHAR(3) PRIMARY KEY, 
		TenSan NVARCHAR(50), 
		DiaChi NVARCHAR(50)
	)
CREATE TABLE Doi
	(
		MaDoi CHAR(3) PRIMARY KEY, 
		TenDoi NVARCHAR(50), 
		MaSan CHAR(3),
		FOREIGN KEY (MaSan) REFERENCES San(MaSan)
		ON UPDATE CASCADE
	)
CREATE TABLE TranDau
	(
		MaTD CHAR(2) PRIMARY KEY, 
		MaSan CHAR(3), 
		Ngay DATE,
		Gio TIME,
		FOREIGN KEY (MaSan) REFERENCES San(MaSan)
	)
CREATE TABLE CT_TranDau
	(
		MaTD CHAR(2), 
		MaDoi CHAR(3), 
		SoBanThang TINYINT CHECK (SoBanThang >= 0),
		PRIMARY KEY(MaTD, MaDoi)
	)

-- CAU 1:In số trận đấu mà mỗi đội đã thi đấu. Hiển thị:  MaDoi, TenDoi.
SELECT
	d.MaDoi as [mã đội],
	d.TenDoi as [tên đội],
	count(cttd.MaDoi) as [số trận đấu]
FROM Doi d,CT_TranDau cttd
where cttd.MaDoi = d.MaDoi
group by d.MaDoi,d.TenDoi

-- cau 2: 1-	In kết quả trận đấu theo tỷ số:
--     MaTran  | Đội trận đấu | Tỷ số
--  01         | VN-TL        | 3-1

select 
	cttd.MaTD as [MaTran],
	CASE 
		WHEN cttd.MaTD LIKE '01'  THEN 'VN - TL'
		WHEN cttd.MaTD LIKE '02'  THEN 'VN - LA'
		WHEN cttd.MaTD LIKE '03'  THEN 'TL - CPC'	
		WHEN cttd.MaTD LIKE '04'  THEN 'VN - TL'
	END as [tran dau],
	CASE
		WHEN cttd.MaTD LIKE '01'  THEN '3-1'
		WHEN cttd.MaTD LIKE '02'  THEN '5-0'
		WHEN cttd.MaTD LIKE '03'  THEN '3-3'	
		WHEN cttd.MaTD LIKE '04'  THEN '2-0'
	END AS [Tỷ số]
from CT_TranDau cttd
group by MaTD

-- 3-	In kết quả mỗi trận theo điểm:
-- MaTran  | Doi  | Diem
--01	   | VN  |  3
--01       | TL   |  0 
select 
	cttd.MaTD as [Ma tran],
	cttd.MaDoi as [đội],
	max (cttd.SoBanThang) as [điểm]
from CT_TranDau cttd
group by cttd.MaTD, cttd.MaDoi

-- 4-	In mã đội, tên đội, tổng số điểm:
--      VN     |  Việt Nam  | 6   
select 
	d.MaDoi as [mã đội],
	d.TenDoi as[tên đội],
	sum(cttd.SoBanThang) as [tổng điểm]
from Doi d
left join CT_TranDau cttd on cttd.MaDoi = d.MaDoi
where cttd.MaDoi = d.MaDoi
group by d.MaDoi,d.TenDoi

-- 6-	Hiển thị các trận chưa đá:
--    Các trận chưa đá:
--       LA - CPC 
--       VN - CPC
