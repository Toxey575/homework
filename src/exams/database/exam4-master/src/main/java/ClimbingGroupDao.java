import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class ClimbingGroupDao implements Dao<ClimbingGroup> {
    private EntityManager manager;

    public ClimbingGroupDao(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public void add(ClimbingGroup climbingGroup) {
        manager.persist(climbingGroup);

    }

    @Override
    public List<ClimbingGroup> getAll() {
        TypedQuery<ClimbingGroup> query = manager.createNamedQuery("ClimbingGroup.get_all", ClimbingGroup.class);
        List<ClimbingGroup> climbingGroup = query.getResultList();
        return climbingGroup;
    }

    @Override
    public void update(ClimbingGroup climbingGroup) {
        manager.persist(climbingGroup);
    }

        //групп, которые еще не начали восхождения но горы
        //SELECT g FROM ClimbingGroup g WHERE g.upClimbingGroupMountain = :upClimbingGroupMountain
        public List<ClimbingGroup> byUpClimbingGroupMountain(LocalDateTime start){
            TypedQuery query = manager.createQuery("SELECT g FROM GroupUp g WHERE g.isOpen = :isOpen", ClimbingGroup.class);
            query.setParameter("g.getClimbingGroupUpMountain",start );
            List<ClimbingGroup> climbingGroupList = (List<ClimbingGroup>) query.getResultList();
            return climbingGroupList;

        }
    }

