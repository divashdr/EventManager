package org.jboss.tools.example.springmvc.repo;

import java.util.List;
import java.util.Set;

import org.jboss.tools.example.springmvc.domain.EventGroup;
import org.jboss.tools.example.springmvc.domain.EventGroupDetail;
import org.jboss.tools.example.springmvc.domain.User;

public interface MemberDao {
	public User findUserById(Long id);

	public User findByEmail(String email);

	public List<User> findAllOrderedByName();

	public void register(User user);

	public void registerGroup(EventGroup group);

	public List<EventGroup> findAllGroups();

	public EventGroup findGroupById(Long id);

	public void registerUserGroup(User user, Set<EventGroup> groups);

	public List<EventGroupDetail> findAllGroupsByUserId(Long id);

	public void deleteUserGroup(User user);

	public User findById(Long id);


}
