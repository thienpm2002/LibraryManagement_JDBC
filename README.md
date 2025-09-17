# 📚 Hệ Thống Quản Lý Thư Viện (Java + JDBC + MySQL + Maven)

Dự án quản lý thư viện đơn giản được xây dựng bằng **Java**, **JDBC**, **MySQL** và **Maven**.  
Hệ thống hỗ trợ 2 vai trò: **Admin** và **User**, mỗi vai trò có menu chức năng riêng.

---

## ⚡ Chức năng

### 🔹 Admin
- `1. Liệt kê sách` – Xem tất cả sách trong thư viện
- `2. Thêm sách` – Thêm sách mới
- `3. Cập nhật sách` – Chỉnh sửa thông tin sách
- `4. Xóa sách` – Xóa sách
- `5. Liệt kê người dùng` – Xem tất cả người dùng
- `6. Xóa người dùng` – Xóa tài khoản người dùng
- `0. Đăng xuất`

### 🔹 User
- `1. Liệt kê sách` – Xem danh sách sách hiện có
- `2. Mượn sách` – Mượn sách
- `3. Trả sách` – Trả sách
- `4. Cập nhật tên` – Chỉnh sửa thông tin cá nhân
- `0. Đăng xuất`

---

## 🛠️ Công nghệ sử dụng
- **Java 17+**
- **JDBC** (MySQL Connector/J)
- **MySQL 8+**
- **Maven**

---

## 📂 Cấu trúc dự án
project-root/
│── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── ... (controller, dao, models, database, v.v.)
│ └── test/
│ └── App.java
│── sql/
│ ├── data.sql # Script tạo database + bảng + dữ liệu mẫu
│
│── pom.xml
│── README.md

## ⚙️ Cài đặt

### 1. Clone project
```bash
git clone https://github.com/ten-cua-ban/library-management.git
cd library-management

### 2. Tạo database và bảng
Chạy file data.sql trong MySQL

### 3. Cấu hình kết nối Database
db.url=jdbc:mysql://localhost:3306/library_db
db.user=root
db.password=yourpassword

### 4. Build & Run
mvn clean compile
mvn exec:java -Dexec.mainClass="com.project.App"

## 🚀 Sử dụng

Khi chương trình chạy, bạn có thể đăng nhập với tư cách:

Admin – vào menu quản trị.

User – vào menu người dùng.

Sau đó nhập số để chọn chức năng.

Nếu không có tài khoản có thê đăng ký.
