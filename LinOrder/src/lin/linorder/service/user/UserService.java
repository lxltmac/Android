package lin.linorder.service.user;

import java.util.List;


import lin.linorder.dao.user.UserDao;
import lin.linorder.models.Staff;
import lin.linorder.models.user.User;


public class UserService {
	private UserDao userDao;
	
	/**
	 * ǰ̨�û����
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		return userDao.addUser(user);
	}

	/**
	 * Android�û��˵ĵ�½
	 * @param user
	 * @return
	 */
	public User loginAndroid(String name, String password) {
		User user = userDao.loadUser(name);
//		System.out.println("userservice_login: user="+user);
		if(user != null){
			//�˶����룬�Ƿ񶳽��ɾ��
			if(user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteUserById(int id){
		if(userDao.deleteUserById(id)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ����id��ȡ��Ϣ
	 * @param id
	 * @return
	 */
	public User queryUserById(int id){
		User user;
		user = userDao.queryUserById(id);
		return user;
	}
	/**
	 * ���²���
	 * @param newFood
	 * @return
	 */
	public boolean updateUser(User user){
		return userDao.updateUser(user);
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<User> queryAllUsers(){
		List<User> users;
		users=userDao.queryAllUsers();
	    return users;
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<User> queryByPage(int pageNo,int pageSize){
			List<User> users;
			users=userDao.queryByPage(pageNo,pageSize);
			return users;
		}
	
	/**
	 * ��鵱ǰ�û��Ƿ����
	 * @return
	 */
	public boolean checkUsername(String username){
		User user = userDao.loadUser(username);
		if(user == null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * ����name��ȡ��Ϣ
	 * @param name
	 * @return
	 */
	public User queryUserByName(String username){
		User user;
		user = userDao.queryUserByName(username);
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
}
