import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MountainDao implements Dao<Mountain> {
        private EntityManager manager;

    public MountainDao(EntityManager manager) {
        this.manager=manager;
    }


    @Override
    public void add(Mountain mountain) {
        manager.persist(mountain);
    }
    //запрос на получение всех гор
    //"SELECT g FROM Mountain g"
    @Override
        public List<Mountain> getAll() {
            TypedQuery<Mountain> query = manager.createNamedQuery("mountain.get_all", Mountain.class);
            List<Mountain> mountainList = query.getResultList();
            return mountainList;
        }

    @Override
    public void update(Mountain mountain) {
        manager.merge(mountain);
    }


        //гору по названию
        //"SELECT g FROM Mountain g WHERE g.name = :mountain_name"
        public List<Mountain> byName(String name) {
            TypedQuery<Mountain> typedQuery = manager.createNamedQuery("Mountain.get_by_name",Mountain.class);
            typedQuery.setParameter("g.name",name);
            List<Mountain> mountainList = typedQuery.getResultList();
            return mountainList;
        }
        //гор с высотой от min до max
        //"SELECT g FROM Mountain g WHERE g.height = :mountain_height"
    public List<Mountain> byHeight(int height){
        TypedQuery<Mountain> typedQuery = manager.createNamedQuery("Mountain.get_by_height",Mountain.class);
        typedQuery.setParameter("g.height",height);
        List<Mountain> mountainList = typedQuery.getResultList();
        return mountainList;
    }

    }

