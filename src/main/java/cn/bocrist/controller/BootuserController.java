package cn.bocrist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.bocrist.entity.Bootuser;
import cn.bocrist.service.BootuserService;
@Controller
@RequestMapping("")
public class BootuserController {
	@Autowired
	private BootuserService bootuserservice;
	
	@RequestMapping("/")
	public String showIndex(){
	    return "index";
	}
	
	@RequestMapping("/del")
	public String deleteByPrimaryKey(Short id) {
		bootuserservice.deleteByPrimaryKey(id);
		return "redirect:list";	
	}
	
	@RequestMapping("/add")
    public String add() {   
        return "add";
    }
	
	@RequestMapping("/insert")
	public String insert(Bootuser record) {
		bootuserservice.insert(record);
		return "redirect:list";		
	}
	
	@RequestMapping("/list")
	public String selectByExample(HttpServletRequest request,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
		    String bootname=request.getParameter("search");
		    if (bootname == null)
	        {
		    	bootname="";
	        }
	        PageHelper.startPage(pageNum,5);
	        List<Bootuser> list = bootuserservice.selectByExample(bootname);
	        PageInfo<Bootuser> pageInfo = new PageInfo<Bootuser>(list);
	        request.setAttribute("pageInfo",pageInfo);
	        return "list";
	    }
	
	@RequestMapping("/edit")
    public ModelAndView edit(Short id) {
        ModelAndView mav = new ModelAndView("edit");
        Bootuser boot = bootuserservice.selectByPrimaryKey(id);
        mav.addObject("boot", boot);
        return mav;
    }
	
	@RequestMapping("/update")
	public String updateByPrimaryKeySelective(Bootuser record) {
		bootuserservice.updateByPrimaryKeySelective(record);
		return "redirect:list";
	}


}
