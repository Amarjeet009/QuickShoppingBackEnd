package com.amarj.quickshopping.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amarj.quickshopping.dao.SupplierDAO;
import com.amarj.quickshopping.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
   
	@Autowired
	private SessionFactory sessionFactory;
		
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Supplier> list() {
		/*@SuppressWarnings({ "unchecked", "deprecation" })
		List<Supplier> list = (List<Supplier>) sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;*/
    	return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	@Transactional
	public Supplier get(String id) {
		/*String hql = "from Supplier where id=" + id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Supplier> list = (List<Supplier>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;*/
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class,id);
	}

	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Transactional
	public boolean delete(String id) {
		
		try {
			sessionFactory.getCurrentSession().delete(deleteSupplierById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	@Transactional
	public Supplier deleteSupplierById(String id) {
		return sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	public SupplierDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
		
	

	/*@Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);	
		
	}

    @Transactional
	public void delete(String id) {
		
		Supplier supplier = new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
		
	}*/
	

}
