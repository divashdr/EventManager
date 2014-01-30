package org.jboss.tools.example.springmvc.mvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.jboss.tools.example.springmvc.domain.User;
import org.jboss.tools.example.springmvc.domain.UserGroup;
import org.jboss.tools.example.springmvc.domain.Community;
import org.jboss.tools.example.springmvc.domain.EventGroup;
import org.jboss.tools.example.springmvc.domain.EventGroupDetail;

import org.jboss.tools.example.springmvc.repo.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/groupdetail")
public class UserGroupController {
	@Autowired
	private MemberDao memberDao;


	@RequestMapping( method = RequestMethod.GET)
	public String displaySortedGroupsDetails(Model model) {
		model.addAttribute("userGroup", new UserGroup());
		model.addAttribute("members", memberDao.findAllOrderedByName());

		List<EventGroup> eventGroupList = memberDao.findAllGroups();
		List<Community> com = new ArrayList<Community>();
		for (EventGroup evtgrp : eventGroupList) {
			Community c = new Community(String.valueOf(evtgrp.getId()),
					evtgrp.getName());

			if (c != null)
				com.add(c);

		}
		model.addAttribute("groupList", com);

		return "groupdetail";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerUserGroup(
			@Valid @ModelAttribute("userGroup") UserGroup ug,
			BindingResult result, Model model) {
		System.out.println("Inside");

		String uid = ug.getUid();
		System.out.println(uid);
		User user = memberDao.findUserById(Long.valueOf(uid));
		System.out.println(user);

		if (ug.getUidClicked().equalsIgnoreCase("1")) {

			List<EventGroupDetail> egds = memberDao.findAllGroupsByUserId(user
					.getId());

			List<EventGroup> alleg = memberDao.findAllGroups();
			List<Community> com = new ArrayList<Community>();
			for (EventGroup evtgrp : alleg) {
				Community c = new Community(String.valueOf(evtgrp.getId()),
						evtgrp.getName());

				for (EventGroupDetail egd : egds) {
					if (egd.getGROUP_ID() == evtgrp.getId()) {
						c.setChecked("checked");
					}
				}

				if (c != null)
					com.add(c);

			}
			model.addAttribute("groupList", com);

			List<User> allUser = memberDao.findAllOrderedByName();
			for (User u : allUser) {
				if (user.getId() == u.getId()) {
					u.setChecked("Checked");
				} else {
					u.setChecked("");
				}

			}
			model.addAttribute("members", allUser);

			System.out.println("Here");
			return "groupdetail";

		}

		Set<EventGroup> groups = new HashSet<EventGroup>();

		String[] gids = ug.getGid().split(",");
		for (String gid : gids) {
			System.out.println(gid);
			EventGroup group = memberDao.findGroupById(Long.valueOf(gid));
			System.out.println(group);
			groups.add(group);
			memberDao.deleteUserGroup(user);
			System.out.println("Group Done");
		}

		memberDao.registerUserGroup(user, groups);
		System.out.println("User Done");

		model.addAttribute("userGroup", new UserGroup());
		model.addAttribute("members", memberDao.findAllOrderedByName());

		List<EventGroup> eventGroupList = memberDao.findAllGroups();
		List<Community> com = new ArrayList<Community>();
		for (EventGroup evtgrp : eventGroupList) {
			Community c = new Community(String.valueOf(evtgrp.getId()),
					evtgrp.getName());

			if (c != null)
				com.add(c);

		}
		model.addAttribute("groupList", com);

		return "groupdetail";

	}

}
