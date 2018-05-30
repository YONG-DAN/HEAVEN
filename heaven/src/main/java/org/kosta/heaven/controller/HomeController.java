package org.kosta.heaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home.do")
	public String home() {
		return "home.tiles";
	}
	
	/**
	 * 
	 * tiles가 적용된 view
	 * 
	 * @author 조민경
	 * 
	 */
	@RequestMapping("{dirName}/{viewName}.do")
	public String showTiles(@PathVariable String dirName, @PathVariable String viewName) {
		return dirName+"/"+viewName+".tiles";
	}
}
