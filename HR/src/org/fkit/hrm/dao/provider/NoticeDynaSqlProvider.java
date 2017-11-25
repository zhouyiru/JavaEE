package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Notice;

import static org.fkit.hrm.util.common.HrmConstants.NOTICETABLE;;


public class NoticeDynaSqlProvider {
	// ��ҳ��̬��ѯ
	public String selectWhitParam(final Map<String, Object> params){
		final String sql =  new SQL(){
			{
				SELECT("N.*,ROWNUM RN");
				FROM(NOTICETABLE+" N");
				if(params.get("notice") != null){
					Notice notice = (Notice)params.get("notice");
					if(notice.getTitle() != null && !notice.getTitle().equals("")){
						WHERE("  title LIKE CONCAT(CONCAT('%',#{notice.title}),'%') ");
					}
					if(notice.getContent() != null && !notice.getContent().equals("")){
						WHERE("  content LIKE CONCAT(CONCAT('%',#{notice.content}),'%') ");
					}
				}
				/*******************************************************/
				if(params.get("pageModel")!=null)
				{
					WHERE("ROWNUM<=(#{pageModel.pageSize}*#{pageModel.pageIndex})");
				}
				/*******************************************************/
			}
		}.toString();
		String pageSql=new SQL()
		{
			{
				SELECT("*");
				FROM("("+sql+")");
				WHERE("RN>#{pageModel.firstLimitParam}");
			}
		}.toString();
		
		System.out.println("in page!");
		System.out.println(pageSql);
		return pageSql;
	}	
	// ��̬��ѯ������
	public String count(final Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(NOTICETABLE);
				if(params.get("notice") != null){
					Notice notice = (Notice)params.get("notice");
					if(notice.getTitle() != null && !notice.getTitle().equals("")){
						WHERE("  title LIKE CONCAT(CONCAT('%',#{notice.title}),'%') ");
					}
					if(notice.getContent() != null && !notice.getContent().equals("")){
						WHERE("  content LIKE CONCAT(CONCAT('%',#{notice.content}),'%') ");
					}
				}
			}
		}.toString();
	}	
	// ��̬����
	public String insertNotice(final Notice notice){
		
		return new SQL(){
			{
				INSERT_INTO(NOTICETABLE);
				VALUES("id", "seq_tb_user.nextval");
				if(notice.getTitle() != null && !notice.getTitle().equals("")){
					VALUES("title", "#{title}");
				}
				if(notice.getContent() != null && !notice.getContent().equals("")){
					VALUES("content", "#{content}");
				}
				if(notice.getUser() != null && notice.getUser().getId() != null){
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}
	// ��̬����
	public String updateNotice(final Notice notice){
		
		return new SQL(){
			{
				UPDATE(NOTICETABLE);
				if(notice.getTitle() != null && !notice.getTitle().equals("")){
					SET(" title = #{title} ");
				}
				if(notice.getContent() != null && !notice.getContent().equals("")){
					SET(" content = #{content} ");
				}
				if(notice.getUser() != null && notice.getUser().getId() != null){
					SET(" user_id = #{user.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
