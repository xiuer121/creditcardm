package carss.dao;




import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import carss.vo.View;







@SuppressWarnings("unchecked")
abstract public class BaseDao<T> extends HibernateDaoSupport{
	
	private Class<T> entityClass;
	
	public BaseDao() {
		entityClass =(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 *@����  ���һ�����������
	 */
	public void clear(){
		this.getHibernateTemplate().clear();
	}

	/**
	 *@����  ɾ��ʵ��
	 */
	public void delete(Serializable id){
		T one=(T)this.getHibernateTemplate().get(entityClass, id);
		this.delete(one);
	}
	
	/**
	 *@����  ɾ��ʵ��
	 */
	public void delete(T one) {
		if(one!=null){
			this.getHibernateTemplate().delete(one);
		}
	}
	
	/**
	 *@����  ��ȡʵ��
	 */
	public T get(Serializable id){
		return (T)this.getHibernateTemplate().get(entityClass, id);
	}

	/**
	 *@����  ����ʵ��
	 */
	public void save(T one) {
		this.getHibernateTemplate().save(one);
	}
	
	/**
	 *@����  ����ʵ��
	 */
	public void update(T one) {
		this.getHibernateTemplate().update(one);
	}
	
	/**
	 *@���� ��������
	 */
	public void executeUpdate(final String hql) {
		this.executeUpdate(hql, null);
	}
	
	/**
	 *@���� ��������(����ѯ����)
	 */ 
	public void executeUpdate(final String hql,final Object[] queryParams) {
		this.getHibernateTemplate().execute(
				new HibernateCallback() { 
					public Object doInHibernate(Session session) throws HibernateException, SQLException { 
						Query query=session.createQuery(hql);
						setQueryParams(query, queryParams);
						return query.executeUpdate();
					} 
				}
		);
	}
	
	/**
	 * @���� �ۺϲ�ѯ
	 */
	public Object juhe(String hql) {
		return getHibernateTemplate().find(hql).get(0);
	}
	
	/**
	 * @���� �ۺϲ�ѯ������ԃ��
	 */
	public Object juhe(String hql,Object[] queryParams) {
		return getHibernateTemplate().find(hql,queryParams).get(0);
	}
	
	/**
	 * @���� ��ȡ��¼����
	 */
	public Long getCount() {
		String hql="select count(o) from "+this.getEntityName()+" o ";
		return (Long)getHibernateTemplate().find(hql).get(0);
	}

	/**
	 * @���� ��ȡ��¼����������ԃ��
	 */
	public Long getCount(String where,Object[] queryParams){
		
		String hql="select count(o) from "+this.getEntityName()+" o "+where;
		return (Long)getHibernateTemplate().find(hql,queryParams).get(0);
		
	}

	/**
	 * @���� ������ж���
	 */
	public List<T> getList(){
		String hql="from "+this.getEntityName()+" o order by o.id desc";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * @���� ������ж���(����ѯ)
	 */
	public List<T> getList(String where,Object[] queryParams){	
		String hql="from "+this.getEntityName()+" o "+where;
		return this.getHibernateTemplate().find(hql,queryParams);
	}
	
	/**
	 * @���� ���ָ����������
	 */
	public List<T> getListByNum(final Integer num){	
		
		final String hql="from "+this.getEntityName()+" o order by o.id desc";
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() { 
					public Object doInHibernate(Session session) throws HibernateException, SQLException { 
						Query query=session.createQuery(hql);

						return query.setMaxResults(num).list(); 
					} 
				}
			);  
			return list;
	}
	
	/**
	 * @���� ���ָ������ ����(����ѯ)
	 */
	public List<T> getListByNum(final String where,final Object[] queryParams,final Integer num){	
		
		final String hql="from "+this.getEntityName()+" o "+where;
		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() { 
					public Object doInHibernate(Session session) throws HibernateException, SQLException { 
						Query query=session.createQuery(hql);
						setQueryParams(query, queryParams);
						return query.setMaxResults(num).list(); 
					} 
				}
			);  
			return list;
	}
	
	/**
	 * @���� ��÷�ҳ�����
	 */
	public List<T> getListByPage(final View<T> view){
		
		final String hql="from "+this.getEntityName()+" o order by o.id desc";

		List<T> list = getHibernateTemplate().executeFind(
			new HibernateCallback() { 
				public Object doInHibernate(Session session) throws HibernateException, SQLException { 
					return session.createQuery(hql)
						   		  .setFirstResult(view.getFirstResult())
						          .setMaxResults(view.getRecorderPage())
						          .list(); 
				} 
			}
		);  
		return list;
	}
	
	/**
	 * @���� ��÷�ҳ�����������ѯ��
	 */
	public List<T> getListByPage(final View<T> view,final String where,final Object[] queryParams){
		
		final String hql="from "+this.getEntityName()+" o "+where;

		List<T> list = getHibernateTemplate().executeFind(
				new HibernateCallback() { 
					public Object doInHibernate(Session session) throws HibernateException, SQLException { 
						
						Query query=session.createQuery(hql);
						setQueryParams(query, queryParams);

						return query.setFirstResult(view.getFirstResult())
				          			.setMaxResults(view.getRecorderPage())
				          			.list(); 
					} 
				}
			);  
			return list;
	}

	
	
	
	

    @Resource(name="sessionFactory")    
     public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
    
	/**
	 *@����  ���ʵ������
	 */
	private String getEntityName(){
		return entityClass.getSimpleName();
	}
	
	/**
	 *@����  ƴװ��ѯ����
	 */
	private void setQueryParams(Query query, Object[] queryParams){
		if(queryParams!=null && queryParams.length>0){
			for(int i=0; i<queryParams.length; i++){
				query.setParameter(i, queryParams[i]);
			}
		}
	}
	
	


	
}
