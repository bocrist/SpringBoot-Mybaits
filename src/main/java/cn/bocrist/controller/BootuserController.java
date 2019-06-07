package cn.bocrist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.bocrist.entity.Bootuser;
import cn.bocrist.service.BootuserService;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("")
public class BootuserController {
	@Autowired
	private BootuserService bootuserservice;
	
	@RequestMapping("/")
	public ModelAndView showIndex(){
		  ModelAndView mv = new ModelAndView("index"); 
	        return mv; 
	}
	
	@ApiOperation("删除")
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ModelAndView deleteByPrimaryKey(@RequestParam(value="id")  Short id) {
		bootuserservice.deleteByPrimaryKey(id);
		 ModelAndView mv = new ModelAndView("redirect:/list"); 
	        return mv; 
	}
	
	@RequestMapping("/add")
    public ModelAndView add() {   
		 ModelAndView mv = new ModelAndView("add"); 
	        return mv; 
    }
	
  
	@PostMapping("insert")
	public ModelAndView insert(Bootuser record) {
		bootuserservice.insert(record);
		 ModelAndView mv = new ModelAndView("redirect:/list"); 
	        return mv; 	
	}
	
	@RequestMapping(value = "list",method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView selectByExample(HttpServletRequest request,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
		    String bootname=request.getParameter("search");
		    if (bootname == null)
	        {
		    	bootname="";
	        }
	        PageHelper.startPage(pageNum,5);
	        List<Bootuser> list = bootuserservice.selectByExample(bootname);
	        PageInfo<Bootuser> pageInfo = new PageInfo<Bootuser>(list);
	     
	       request.setAttribute("pageInfo",pageInfo);
	        ModelAndView mv = new ModelAndView("list");
	 
			return mv;	
	  
	    }
	
	@RequestMapping("/edit")
    public ModelAndView edit(Short id) {
        ModelAndView mav = new ModelAndView("edit");
        Bootuser boot = bootuserservice.selectByPrimaryKey(id);
        mav.addObject("boot", boot);
        return mav;
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView  updateByPrimaryKeySelective(Bootuser record) {
		bootuserservice.updateByPrimaryKeySelective(record);
		 ModelAndView mv = new ModelAndView("redirect:/list"); 
	        return mv; 
	}


}
