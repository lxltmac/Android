package lin.linorder.service.user;

import java.util.List;


import lin.linorder.dao.user.UserDao;
import lin.linorder.models.Staff;
import lin.linorder.models.user.User;


public class UserService {
	private UserDao userDao;
	
	/**
	 * 前台用户添加
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		return userDao.addUser(user);
	}

	/**
	 * Android用户端的登陆
	 * @param user
	 * @return
	 */
	public User loginAndroid(String name, String password) {
		User user = userDao.loadUser(name);
//		System.out.println("userservice_login: user="+user);
		if(user != null){
			//核对密码，是否冻结和删除
			if(user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	
	/**
	 * 删除
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
	 * 根据id获取信息
	 * @param id
	 * @return
	 */
	public User queryUserById(int id){
		User user;
		user = userDao.queryUserById(id);
		return user;
	}
	/**
	 * 更新操作
	 * @param newFood
	 * @return
	 */
	public boolean updateUser(User user){
		return userDao.updateUser(user);
	}
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<User> queryAllUsers(){
		List<User> users;
		users=userDao.queryAllUsers();
	    return users;
	}
	
	/**
	 * 分页查询
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
	 * 检查当前用户是否存在
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
	 * 根据name获取信息
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
