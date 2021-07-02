import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.Month;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entityManager");
        EntityManager manager = factory.createEntityManager();

        ClimberDao climberDao = new ClimberDao(manager);
        MountainDao mountainDao = new MountainDao(manager);
        ClimbingGroupDao climbingGroupDao = new ClimbingGroupDao(manager);
        // Альпинисты
        Climber climber1 = new Climber("Олег", 29, "abv");
        Climber climber2 = new Climber("Рома", 24, "avc");
        Climber climber3 = new Climber("Ира", 30, "anb");
        Climber climber4 = new Climber("Дарья", 25, "abd");
        // Горы
        Mountain mountain1 = new Mountain("Швейцарские альпы", 2000);
        Mountain mountain2 = new Mountain("Логан", 5000);
        Mountain mountain3 = new Mountain("Фудзи", 3000);
        Mountain mountain4 = new Mountain("Йотунхеймен", 4000);
        //Группы альпинистов
        LocalDateTime startDate1 = LocalDateTime.of(2021, Month.JANUARY, 20, 16, 23);
        LocalDateTime startDate2 = LocalDateTime.of(2021, Month.APRIL, 13, 17, 55);
        LocalDateTime startDate3 = LocalDateTime.of(2022, Month.MARCH, 22, 14, 00);
        ClimbingGroup group1 = new ClimbingGroup(mountain1, 1);
        ClimbingGroup group2 = new ClimbingGroup(mountain2, 2);
        ClimbingGroup group3 = new ClimbingGroup(mountain3, 3);
        ClimbingGroup group4 = new ClimbingGroup(mountain4, 4);
        // Manager
        manager.getTransaction().begin();
        climberDao.add(climber1);
        climberDao.add(climber2);
        climberDao.add(climber3);
        climberDao.add(climber4);
        mountainDao.add(mountain1);
        mountainDao.add(mountain2);
        mountainDao.add(mountain3);
        manager.getTransaction().commit();

            System.out.println(climberDao.byFullNameAndEmail("Олег", "abv"));
            System.out.println(mountainDao.byName("Швейцарские альпы"));
            System.out.println(mountainDao.byHeight(2000));



    }
}

















































