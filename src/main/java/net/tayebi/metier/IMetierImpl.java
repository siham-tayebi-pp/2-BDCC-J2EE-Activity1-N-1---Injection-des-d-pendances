package net.tayebi.metier;

import net.tayebi.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class IMetierImpl implements IMetier {
//    @Autowired
    private IDao dao; //couplage faible
    @Override
    public double calcul() {
        double t=dao.getData();
        double res = t * 12 * Math.PI/2 * Math.cos(t);
        return res;
    }
    //    pour injecter dans l'attribut dao un objet de type idao
//     cad un obj dune interface qui implemente lobj dao
//    au moment de linstanciation dobj
    public IMetierImpl(@Qualifier("d") IDao dao) {
        this.dao = dao;
    }
    public IMetierImpl() {
    }

    //    pour injecter dans l'attribut dao un objet de type idao
//     cad un obj dune interface qui implemente lobj dao
//    apres de linstanciation dobj

    public void setDao(IDao dao) {
   this.dao = dao;
    }
}
