package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			//db연결
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List listMembers(MemberVO memberVO) {
		List<MemberVO> membersList = new ArrayList();
		// 조회할 이름을 가져옴
		String _name = memberVO.getName();
		try {
			con = dataFactory.getConnection();
			// query변수에 t_member의 모든값을 저장
			String query = "select * from t_member";
			
			// _name변수 즉 검색하는 변수가 공백인지 확인
			if((_name!=null && _name.length()!=0)){
				// 공백이 아니면 그 이름에 해당하는 값들을 query변수에 저장
				 query+=" where name=?";
				 pstmt = con.prepareStatement(query);
				 pstmt.setString(1, _name);
			}else {
				// 공백이면 모든 값들을 저장
				pstmt = con.prepareStatement(query);	
			}
			
			
			System.out.println("prepareStatememt : " + query);
			ResultSet rs = pstmt.executeQuery();
			//rs가 끝날때까지 반복하면서 값을 가져와 vo.에 값을 저장
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				membersList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}

}
