package lin.linorder.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lin.linorder.models.Staff;
import lin.linorder.service.CommonService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.http.HttpRequest;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CommonAction extends ActionSupport implements ServletRequestAware {
	private String provinceID;
	private String cityID;
	private HttpSession session;
	private HttpServletRequest request =ServletActionContext.getRequest();
	
	private CommonService commonService;
	public CommonAction(){
		
	}

	/**
	 * 获取城市json
	 */
	public void getCitys(){
		/* 获得response */
        HttpServletResponse response = ServletActionContext.getResponse();
        /*设置字符集为'UTF-8'*/
        response.setCharacterEncoding("UTF-8");
		
		List<?> citys = commonService.getCitys(provinceID);
		System.out.println("commonaction_getcity: in citys="+citys);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"province","hibernateLazyInitializer"}); //设置忽略字段
		JSONArray jsonCitys = JSONArray.fromObject(citys, jsonConfig);
		System.out.println(jsonCitys);
		try {
			PrintWriter out = response.getWriter();
			out.print(jsonCitys);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}


	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = this.request.getSession();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	
}
