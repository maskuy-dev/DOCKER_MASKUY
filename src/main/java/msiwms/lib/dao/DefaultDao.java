/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msiwms.lib.dao;

import msiwms.lib.vo.voStandard;
import msiwms.lib.model.DefaultEntityImpl;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;


public interface DefaultDao<T, K extends Serializable> {

    public T load(K key);
    public T findOne(K key);

    public List<T> findAll();

    public boolean deleteById(K key);

    public boolean delete(DefaultEntityImpl deletedEntity);

    public boolean save(T newEntity);
    public boolean save(DefaultEntityImpl newEntity, String user);

    public boolean evict(Object entity);

    public boolean update(T newEntity);
    public boolean update(DefaultEntityImpl editedEntity, String user);

    public void flush();

    public void clear();
    
    public int count(voStandard param);
    public abstract Criteria getCriteria(voStandard param);
}
