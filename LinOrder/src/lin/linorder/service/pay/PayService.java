package lin.linorder.service.pay;

import java.util.List;

import lin.linorder.dao.pay.PayDao;
import lin.linorder.models.pay.Pay;


public class PayService {
	private PayDao payDao;
	
	/**
	 * �˵����
	 * @param user
	 * @return
	 */
	public boolean addPay(Pay pay){
		return payDao.addPay(pay);
	}

	
	/**
	 * ɾ��
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
	 * ����id��ȡ��Ϣ
	 * @param id
	 * @return
	 */
	public Pay queryPayById(int id){
		Pay pay;
		pay = payDao.queryPayById(id);
		return pay;
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Pay> queryAllPays(){
		List<Pay> pays;
		pays=payDao.queryAllPays();
	    return pays;
	}
	
	
	/**
	 * ��ҳ��ѯ
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
	 * ��ҳ��ѯ
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
