package gz.itcast.b_validate;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;//���ձ��Ĳ���
	
	
	
	/*public void validateRegister() {
		if(user==null){
			super.addFieldError("user.error", "������дһ�����ݣ�");
		}else{
			//������д��������֤���߼�
			//System.out.println("������validate����");
			if(user.getName()==null || user.getName().equals("")){
				//�û���Ϊ��
				//�Ѵ�����Ϣ���������ϢMap����
				super.addFieldError("user.error.requried", "�û�������Ϊ�գ�");
			}
			if(user.getPassword()==null || user.getPassword().equals("")){
				//����Ϊ��
				//�Ѵ�����Ϣ���������ϢMap����
				super.addFieldError("password.error.requried", "���벻��Ϊ�գ�");
			}
		}
		
	}*/

	/**
	 * ���validate�����г����쳣����ô��ֱ�ӷ��ش���ҳ��
	 * ���validateû�г����쳣����ôֱ������ҵ�񷽷���register��
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		System.out.println("ע��ɹ�");
		
		
		return SUCCESS;
	}
	
	
	public String detail() throws Exception {
		System.out.println("�鿴�û���ϸ��Ϣ");
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
