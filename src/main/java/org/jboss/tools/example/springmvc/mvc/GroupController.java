package org.jboss.tools.example.springmvc.mvc;

import javax.validation.Valid;

import org.jboss.tools.example.springmvc.domain.EventGroup;
import org.jboss.tools.example.springmvc.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/group")
public class GroupController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedGroups(Model model) {
		model.addAttribute("newGroup", new EventGroup());
		model.addAttribute("groups", memberDao.findAllGroups());
		return "group";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewGroup(
			@Valid @ModelAttribute("newGroup") EventGroup newGroup,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			memberDao.registerGroup(newGroup);
			return "redirect:/group";
		} else {
			model.addAttribute("groups", memberDao.findAllGroups());
			return "group";
		}
	}

}
