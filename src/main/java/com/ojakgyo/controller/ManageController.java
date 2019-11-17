package com.ojakgyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ojakgyo.domain.GroupMemberVO;
import com.ojakgyo.service.GroupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/manage")
public class ManageController {

	@Autowired
	GroupService service;
	
	@GetMapping("{groupCode}")
	public String list(@PathVariable("groupCode") String groupCode, Model model) {
		log.info("ManageController => "+groupCode+"관리");
		//List<GroupMemberVO> list = service.list(groupCode);
		//model.addAttribute("list", list);
		//model.addAttribute("code", groupCode);
		
		
		return "/manage/list";
	}
	
	@ResponseBody
	@DeleteMapping("/delete")
	public ResponseEntity<String> remove(@RequestBody GroupMemberVO gMember){
		
		return service.remove(gMember) 
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ResponseBody
	@DeleteMapping("/modify")
	public ResponseEntity<String> modfiy(@RequestBody GroupMemberVO gMember){
		
		return service.modify(gMember) 
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		
	}
}
