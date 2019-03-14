package com.fleet.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.fleet.daos.orm.TestEntity;

@Repository
public class HibernateTestDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<TestEntity> findStaticData() {
		List<TestEntity> result = new ArrayList<TestEntity>();
		result.add(new TestEntity(1, "Ahmed static"));
		result.add(new TestEntity(2, "Mohamed static"));
		return result;
	}

	public List<TestEntity> findDataFromDB() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<TestEntity> cq = cb.createQuery(TestEntity.class);
		Root<TestEntity> root = cq.from(TestEntity.class);

		cq.select(root);
		TypedQuery<TestEntity> q = entityManager.createQuery(cq);
		return q.getResultList();
	}
}