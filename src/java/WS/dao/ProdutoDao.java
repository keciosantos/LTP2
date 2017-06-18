package WS.dao;

import WS.entity.Fornecedor;
import WS.entity.Produto;
import WS.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProdutoDao {
    private Session sessao;
    private Transaction trans;
    private List<Produto> list;

    public List<Produto> getList() {
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        
        Criteria cri = se.createCriteria(Produto.class);
        this.list = cri.list();
        return list;
    }
    
   
    
    
    public void addProduto(Produto p){
        try {
            Produto produto = new Produto();
            produto.setNome(p.getNome());
            produto.setDescricao(p.getDescricao());
            produto.setValor(p.getValor());
            produto.setQuantidade(p.getQuantidade());
            
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.save(produto);
        trans.commit();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    public void salvar(Produto produto){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
