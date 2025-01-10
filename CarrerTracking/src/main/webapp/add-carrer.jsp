<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Form Thêm Sinh Viên và Tốt Nghiệp</title>
    <link rel="stylesheet" href="../style.css" />
    <style>
      /* Kiểu cho thông báo lỗi */
      .error-message {
        color: red;
        font-size: 0.7em;
        display: none;
        /* Ẩn thông báo lỗi theo mặc định */
      }
    </style>
  </head>

  <body>
    <!-- Form thêm sinh viên và thông tin tốt nghiệp -->
    <form>
      <fieldset>
        <legend>Thông tin sinh viên</legend>
        <label for="SoCMND">Số CMND:</label>
        <input type="text" id="SoCMND" name="SoCMND" /><br />
        <span class="error-message" id="cmndError">Vui lòng nhập Số CMND</span>
        <br />
        <label for="HoTen">Họ và Tên:</label>
        <input type="text" id="HoTen" name="HoTen" /><br />
        <br />
        <label for="Email">Email:</label>
        <input type="email" id="Email" name="Email" /><br />
        <br />
        <label for="SoDT">Số điện thoại:</label>
        <input type="text" id="SoDT" name="SoDT" /><br />
        <br />
        <label for="DiaChi">Địa chỉ:</label>
        <input type="text" id="DiaChi" name="DiaChi" /><br />
        <br />
      </fieldset>

      <fieldset>
        <legend>Thông tin tốt nghiệp</legend>

        <label for="MaNganh">Mã ngành:</label>
        <select id="MaNganh" name="MaNganh">
          <option value="-1">--- Chọn mã ngành ---</option></select
        ><br />
        <span class="error-message" id="MaNganhError"
          >Vui lòng chọn mã ngành</span
        >
        <br />
        <label for="MaTruong">Mã trường:</label>
        <select id="MaTruong" name="MaTruong">
          <option value="-1">--- Chọn mã trường ---</option>
        </select>
        <span class="error-message" id="maTruongError"
          >Vui lòng chọn mã trường</span
        >
        <br />
        <br />
        <label for="HeTN">Hệ tốt nghiệp:</label>
        <input type="text" id="HeTN" name="HeTN" /><br />
        <br />
        <label for="NgayTN">Ngày tốt nghiệp:</label>
        <input type="date" id="NgayTN" name="NgayTN" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"/><br />
        <span class="error-message" id="NgayTNError">Vui lòng nhập Ngày tốt nghiệp không thể lớn hơn ngày hiện tại.</span>
        <br />
        <label for="LoaiTN">Loại tốt nghiệp:</label>
        <select id="LoaiTN" name="LoaiTN">
          <option value="Xuất sắc">Xuất sắc</option>
          <option value="Giỏi">Giỏi</option>
          <option value="Khá">Khá</option>
          <option value="Trung bình">Trung bình</option></select
        ><br />
        <br />
      </fieldset>

      <button type="button">Thêm Sinh Viên và Tốt Nghiệp</button>
    </form>
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
    $(document).ready(function () {
      // Gọi server để lấy thông tin
      $.get(
        "http://localhost:9090/CarrerTracking/StudyingInfor",
        function (response) {
          if (response.isSuccess) {
            const sections = response.data.section;
            const universities = response.data.university;

            // Duyệt qua mảng sections và gán vào select "Mã ngành"
            const $maNganhSelect = $("#MaNganh");
            sections.forEach((section) => {
              $maNganhSelect.append(
                $("<option></option>")
                  .attr("value", section.section)
                  .text(section.tenNganh)
              );
            });

            // Duyệt qua mảng universities và gán vào select "Mã trường"
            const $maTruongSelect = $("#MaTruong");
            universities.forEach((university) => {
              $maTruongSelect.append(
                $("<option></option>")
                  .attr("value", university.maTruong)
                  .text(university.tenTruong)
              );
            });
          } else {
            alert("Không thể tải thông tin từ server!");
          }
        }
      );

      $("button").click(function () {
        let flg = true;
        if ($("#SoCMND").val() !== "") {
          $("#cmndError").hide();
        } else {
        	flg = false;
          $("#cmndError").show();
        }

        if ($("#MaNganh").val() == -1) {
        	flg = false;
          $("#MaNganhError").show();
        } else {
          $("#MaNganhError").hide();
        }

        if ($("#MaTruong").val() == -1) {
        	flg = false;
          $("#maTruongError").show();
        } else {
          $("#maTruongError").hide();
        }

        const ngayTN = $("#NgayTN").val();
        const today = new Date().toISOString().split("T")[0];
        if (ngayTN > today) {
        	flg = false;
        	$("#NgayTNError").show();
        }
        else{
        	$("#NgayTNError").hide();
        }
      });
    });
  </script>
</html>
