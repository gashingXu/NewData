package com.sixin.web.controller.broad;
import com.sixin.broad.domain.Organization;
import com.sixin.broad.domain.Termap;
import com.sixin.broad.service.ITermapService;
import com.sixin.common.core.controller.BaseController;
import com.sixin.framework.util.ShiroUtils;
import com.sixin.system.domain.SysUser;
import com.sixin.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 地图管理 服务层
 *
 * @author 张鸿权
 * @date 2019-01-18
 */
@Controller
@RequestMapping("/broad/map")
public class TermapController extends BaseController
{
	@Autowired
	private ITermapService mapService;
	@Autowired
	private ISysUserService sysUserService;
	private String prefix = "broad/map";

	@GetMapping("/list")
	public String list(ModelMap mmap,Organization organization){
		SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
		Long userid =  currentUser.getUserId();
		//int returnId = new Long(userid).intValue();
		int roleid = sysUserService.selectRoleid(userid);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
		String aid = String.valueOf(sysUserService.selectAid(userid));//通过所获取的userid去广播用户表中查询用户所属区域的Aid
		List<Termap> mapinfoList ;
		/*判断用户等级，若为超级管理员则可查看全部内容，否则只能查看自己的内容*/
		if(roleid != 1){
			organization.setAid(aid);
			mapinfoList = mapService.selectMap(organization);//通过所获取的Aid去查询用户所属区域对应的数据
		}else{
			mapinfoList = mapService.selectMap(organization);}
		mmap.put("mapinfoList", mapinfoList);
		return prefix+"/termap";
	}
}