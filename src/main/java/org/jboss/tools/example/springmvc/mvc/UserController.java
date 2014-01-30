package org.jboss.tools.example.springmvc.mvc;

import javax.validation.Valid;

import org.jboss.tools.example.springmvc.domain.User;
import org.jboss.tools.example.springmvc.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedMembers(Model model) {
		model.addAttribute("newMember", new User());
		model.addAttribute("members", memberDao.findAllOrderedByName());
		return "user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewMember(
			@Valid @ModelAttribute("newMember") User newMember,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			memberDao.register(newMember);
			return "redirect:/user";
		} else {
			model.addAttribute("members", memberDao.findAllOrderedByName());
			return "user";
		}
	}

}
