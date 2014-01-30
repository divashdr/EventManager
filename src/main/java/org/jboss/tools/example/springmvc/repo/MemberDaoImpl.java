package org.jboss.tools.example.springmvc.repo;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.tools.example.springmvc.domain.EventGroup;
import org.jboss.tools.example.springmvc.domain.EventGroupDetail;
import org.jboss.tools.example.springmvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private EntityManager em;

	public User findById(Long id) {
		return em.find(User.class, id);
	}

	public User findByEmail(String email) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> member = criteria.from(User.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(member)
				.where(builder.equal(member.get("email"), email));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<User> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> member = criteria.from(User.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(member).orderBy(cb.asc(member.get("name")));
		return em.createQuery(criteria).getResultList();
	}

	public void register(User member) {
		em.persist(member);
		return;
	}

	@Override
	public void registerGroup(EventGroup group) {
		em.persist(group);
		return;
	}

	@Override
	public List<EventGroup> findAllGroups() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EventGroup> criteria = cb.createQuery(EventGroup.class);
		Root<EventGroup> member = criteria.from(EventGroup.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(member).orderBy(cb.asc(member.get("name")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public EventGroup findGroupById(Long id) {
		return em.find(EventGroup.class, id);
	}
	@Override
	public User findUserById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public void registerUserGroup(User user, Set<EventGroup> groups) {
		EventGroupDetail gd = null;
		for (EventGroup group : groups) {
			gd = new EventGroupDetail(user.getId().intValue(), group.getId()
					.intValue());
			em.persist(gd);
		}

	}

	@Override
	public List<EventGroupDetail> findAllGroupsByUserId(Long uid) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<EventGroupDetail> criteria = builder
				.createQuery(EventGroupDetail.class);
		Root<EventGroupDetail> member = criteria.from(EventGroupDetail.class);

		criteria.select(member)
				.where(builder.equal(member.get("USER_ID"), uid));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void deleteUserGroup(User user) {

		List<EventGroupDetail> egds = findAllGroupsByUserId(user.getId());

		for (EventGroupDetail egd : egds) {
			em.remove(egd);
		}

	}

}
