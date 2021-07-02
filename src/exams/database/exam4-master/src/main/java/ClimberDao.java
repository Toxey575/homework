import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClimberDao implements Dao<Climber> {
    private EntityManager manager;

    public ClimberDao(EntityManager manager) {
    this.manager= manager;
    }

    @Override
    public void add(Climber climber) {
        manager.persist(climber);

    }

    @Override
    public List<Climber> getAll() {
        TypedQuery<Climber> query = manager.createNamedQuery("climber.get_all", Climber.class);
        List<Climber> climbers = query.getResultList();
        return climbers;
    }

    @Override
    public void  update(Climber climber) {
        manager.merge(climber);

    }

    //запрос на получение альпиниста по имени и email
    //"SELECT g FROM Climber g WHERE g.fullName >?AND g.email>?"
    public List<Climber> byFullNameAndEmail(String fullName, String email) {
        TypedQuery<Climber> typedQuery = manager.createNamedQuery("Climber.get_fullNameAndEmail",Climber.class);
        typedQuery.setParameter("g.fullName",fullName);
        typedQuery.setParameter("g.email",email);
        List<Climber> climber = typedQuery.getResultList();
        return climber;
    }
}

