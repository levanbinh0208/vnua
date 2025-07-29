CREATE TABLE User (
                          ID varchar(100) PRIMARY KEY,
                          HoTen NVARCHAR(100),
                          ChucVu nvarchar(100),
                          ThongTin nvarchar(1000),
                          MaPhong INT,
                          FOREIGN KEY (MaPhong) REFERENCES PhongBan(MaPhong)
);

CREATE TABLE ChucVu (
                        MaChucVu INT PRIMARY KEY,
                        TenChucVu NVARCHAR(100)
);

CREATE TABLE PhongBan (
                          MaPhong INT PRIMARY KEY,
                          TenPhong NVARCHAR(100)
);
