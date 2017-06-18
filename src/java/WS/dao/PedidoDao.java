package WS.dao;

import WS.entity.Pedido;
import WS.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PedidoDao {private Session sessao;
    private Transaction trans;
    
    public void addPedido(Pedido pe){
        try {
            Pedido pedido = new Pedido();
           pedido.setId(pe.getId());
           pedido.setCliente(pe.getCliente());
           pedido.setItens(pe.getItens());
                    
            
        Session se = HibernateUtil.getSession().openSession();
        //Transaction trans = se.beginTransaction();
        se.save(pedido);
        trans.commit();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    
    
    public void removePedido(Pedido c){
         try {
            
       
            sessao = HibernateUtil.getSession().getCurrentSession();
            trans = sessao.beginTransaction();
           
        sessao.delete(c);
       trans.commit();
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
           sessao.close();
        }
    }
    
    
     public List<Pedido> getList() {
       Session sessao  = HibernateUtil.getSession().openSession();
        Transaction trans = sessao .beginTransaction();
        
        Criteria cri = sessao .createCriteria(Pedido.class);
        //this.list = cri.list();
        return cri.list();
    }
    
    
    
    public void salvar(Pedido pedido){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

