package lin.linorder.service.pay;

import java.util.List;

import lin.linorder.dao.pay.PayDao;
import lin.linorder.models.pay.Pay;


public class PayService {
	private PayDao payDao;
	
	/**
	 * 账单添加
	 * @param user
	 * @return
	 */
	public boolean addPay(Pay pay){
		return payDao.addPay(pay);
	}

	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean deletePayById(int id){
		if(payDao.deletePayById(id)){
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
	public Pay queryPayById(int id){
		Pay pay;
		pay = payDao.queryPayById(id);
		return pay;
	}
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<Pay> queryAllPays(){
		List<Pay> pays;
		pays=payDao.queryAllPays();
	    return pays;
	}
	
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<Pay> queryByPage(int pageNo,int pageSize){
			List<Pay> pays;
			pays=payDao.queryByPage(pageNo,pageSize);
			return pays;
		}
		
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<Pay> queryByPageNum(int pageNo,int pageSize,String tableNum){
			List<Pay> pays;
			pays=payDao.queryByPageNum(pageNo,pageSize,tableNum);
			return pays;
		}


	public PayDao getPayDao() {
		return payDao;
	}


	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}
	
}
