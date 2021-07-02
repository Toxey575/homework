import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tb.climbers")
@NamedQueries(
        @NamedQuery(name = "Climber.get_fullNameAndEmail",query = "SELECT g FROM Climber g WHERE g.fullName >?AND g.email>?"))
public class Climber extends Id {
    @Getter
    @Setter
    @Column(nullable = false,length = 30)
    private String fullName;
    @Getter
    @Setter
    @Column(nullable = false,length = 3)
    private int age;
    @Getter
    @Setter
    @Column(nullable = false,length = 100)
    private String email;
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "climbersList")
    private List<ClimbingGroup> climbingGroups= new ArrayList<>();

    public Climber(String fullName, int age, String email) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }
    public List<ClimbingGroup> getClimberGroups() {
        return climbingGroups;
    }

    void setFullName(String fullName){
        if (fullName == null || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Значение fullName < 3");
        }
        this.fullName = fullName;
    }

    void setAge (int age){
        if(age<18)
            throw new IllegalArgumentException("Значение age < 18");
        this.age=age;
    }

    public void setEmail(String email) {
        if(email == null || !email.trim().contains("@")){
            throw new IllegalArgumentException("Это не email");
        }
        this.email = email;
    }

    public String getFullName(){
        return fullName;
    }
    public int getAge(){
        return age;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Climber)) return false;
        Climber climber = (Climber) o;
        return age == climber.age && Objects.equals(fullName, climber.fullName) && Objects.equals(email, climber.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, email);
    }

    //Alt+insert
    @Override
    public String toString() {
        return "Climber{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}