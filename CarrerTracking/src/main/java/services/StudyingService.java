package services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import configs.MySqlConnection;
import models.Section;
import models.StudyInfor;
import models.University;

public class StudyingService implements IStudyingService {

	public StudyInfor GetInfors() {
		StudyInfor result = new StudyInfor();

		Connection conn = null;
		try {
			conn = MySqlConnection.getConnection();
			String sql = "{CALL sp_getInfoStudying()}";
			CallableStatement stmt = conn.prepareCall(sql);

			boolean hasResults = stmt.execute();

			if (hasResults) {
				try (ResultSet rs = stmt.getResultSet()) {
					while (rs.next()) {
						University university = new University();
						university.setMaTruong(rs.getString("MaTruong"));
						university.setDiaChi(rs.getString("DiaChi"));
						university.setTenTruong(rs.getString("TenTruong"));
						university.setSoDT(rs.getString("SoDT"));
						result.university.add(university);
					}
				}
			}

			if (stmt.getMoreResults()) {
				try (ResultSet rs = stmt.getResultSet()) {
					while (rs.next()) {
						Section section = new Section();
						section.setMaNganh(rs.getString("MaNganh"));
						section.setTenNganh(rs.getString("TenNganh"));
						section.setLoaiNganh(rs.getString("LoaiNganh"));
						result.section.add(section);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
