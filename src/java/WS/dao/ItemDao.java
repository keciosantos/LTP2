package WS.dao;

import WS.entity.Item;
import WS.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemDao {
     private Session se;
    private Transaction trans;
    //private List<Cliente> list;

    public List<Item> getList() {
       Session sessao  = HibernateUtil.getSession().openSession();
        Transaction trans = sessao .beginTransaction();
        
        Criteria cri = sessao .createCriteria(Item.class);
        //this.list = cri.list();
        return cri.list();
    }
    
    
    
    public void addItem(Item i){
        try {
          //  sessao = HibernateUtil.getSession().getCurrentSession();
          //trans = sessao.beginTransaction();
        
        Item item = new Item();
        item.setId(i.getId());
        
        
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.save(item);
        trans.commit();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    public void removeItem(Item c){
         try {
            
       
           Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.delete(c);
       trans.commit();
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
           se.close();
        }
    }

    public void salvar(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Item> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
