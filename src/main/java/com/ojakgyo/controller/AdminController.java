package com.ojakgyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ojakgyo.domain.GroupVO;
import com.ojakgyo.service.GroupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	GroupService group_serivce;
	
	@GetMapping("/group")
	public void group(Model model) {
		log.info("AdminController => 그룹관리 페이지로 이동");
		
//		List<GroupVO> groups_success = group_serivce.listStatus(1);
//		List<GroupVO> groups_pending = group_serivce.listStatus(2);
//		List<GroupVO> groups_failed = group_serivce.listStatus(3);
//		
//		model.addAttribute("groups_success", groups_success);
//		model.addAttribute("groups_pending", groups_pending);
//		model.addAttribute("groups_failed", groups_failed);
		
	}
	

}