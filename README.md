# Student Management 

## Mô tả
**Dự án quản lý sinh viên với ngôn ngữ Java, chạy dự án bằng Console**.
Dự án quản lý sinh viên là một dự án chạy **Console** giúp thực hiện các chức năng **CRUD (Create, Read, Update, Delete)** cho sinh viên, quản lý dữ liệu cá nhân và học lực của sinh viên.
Dự án sử dụng Array, Collection, File, Enum.... để thực hiện các chức năng hiển thị sinh viên theo học lực, điểm trung bìn.

## Người
Thông tin của mỗi người bao gồm:
- **Id**: Số dương, không trùng, tự động tăng.
- **Tên**: Chuỗi < 100 ký tự, không rỗng.
- **Ngày sinh**: Ngày giờ từ năm 1900, không null.
- **Địa chỉ**: Chuỗi < 300 kí tự.
- **Chiều cao**: Đơn vị cm, từ 50.0 - 300.0.
- **Cân nặng**: Đơn vị kg, từ 5.0 - 1000.0.

## Sinh viên
Sinh viên kế thừa Người, bao gồm các thông tin bổ sung:
- **Mã sinh viên**: Chuỗi 10 ký tự không trùng, không null.
- **Trường đang theo học**: Chuỗi < 200 kí tự, không null.
- **Năm bắt đầu học đại học**: Số 4 chữ số từ 1900, không null.
- **Điểm trung bình tích luỹ**: Từ 0.0 đến 10.0.

## Các chức năng

### CREATE (Tạo sinh viên theo ID)
- Yêu cầu dữ liệu phải phù hợp mới lưu, cần thông báo lỗi ra console.
- Khi thêm thành công, in thông tin sinh viên thêm mới thành công ra console.
- Lưu trữ sinh viên vào mảng tĩnh hoặc động.

### READ (Tìm kiếm sinh viên theo ID)
- Chức năng tìm kiếm sinh viên theo Id.
- Hiển thị kết quả:
  - Không tìm thấy: Không có dữ liệu phù hợp.
  - In kết quả ra console.

### Update (Cập nhập sinh viên theo ID)
- Tìm kiếm chính xác sinh viên để cập nhật.
- Yêu cầu dữ liệu phải phù hợp mới lưu, cần thông báo lỗi ra console.
- Khi thêm thành công, in thông tin sinh viên sau khi sửa ra console.
- Lưu trữ sinh viên vào mảng tĩnh hoặc động.

### Delete (Xóa sinh viên theo ID)
- Xoá sinh viên khỏi mảng tĩnh hoặc động.
- Nếu không tồn tại sinh viên cần thông báo lỗi.
- Khi mảng tĩnh có thay đổi, cần điều chỉnh lại các phần tử.

## Các tính năng nâng cao

### Mảng động (ArrayList)
- Chuyển từ mảng tĩnh sang mảng động để cải thiện hiệu suất và linh hoạt hơn trong việc quản lý danh sách sinh viên.(Array->ArrayList)

### Học lực
- Thêm trường học lực cho sinh viên dạng enum:
  - Điểm < 3: Kém.
  - 3 <= điểm < 5: Yếu.
  - 5 <= điểm < 6.5: Trung bình.
  - 6.5 <= điểm < 7.5: Khá.
  - 7.5 <= điểm < 9: Giỏi.
  - Điểm >= 9: Xuất sắc.
- Tự động cập nhật học lực khi nhập hoặc sửa điểm.

### Thống kê học lực và điểm trung bình
- Hiển thị % học lực của các sinh viên trong danh sách, sắp xếp từ cao xuống thấp.
- Hiển thị % điểm trung bình của các sinh viên trong danh sách (Map)

### Lọc danh sách theo học lực
- In ra màn hình danh sách các sinh viên theo học lực nhập từ bàn phím.

### Lưu trữ
- Lưu trữ danh sách sinh viên vào file khi dừng chương trình.

## **Hướng dẫn sử dụng**
1. Clone dự án từ repository.
2. Cấu hình môi trường phát triển Java.
3. Chạy chương trình bằng cách chạy file main Java.
4. Thực hiện các chức năng CRUD cho sinh viên qua các lựa chọn trong menu console.
5. Sử dụng các tính năng nâng cao để quản lý hiệu quả danh sách sinh viên.

