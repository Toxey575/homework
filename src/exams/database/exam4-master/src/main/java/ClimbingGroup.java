import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb.climbing_group")
@NamedQueries({
        @NamedQuery(name = "ClimbingGroup.get_all",query = "SELECT g FROM ClimbingGroup g"),
        @NamedQuery(name = "ClimbingGroup.get_by_upClimbingGroupMountain",query = "SELECT g FROM ClimbingGroup g WHERE g.upClimbingGroupMountain = :upClimbingGroupMountain")})
public class ClimbingGroup extends Id {
    @Getter
    @Setter
    @Column(nullable = false,length = 50)
    private Mountain mountain;
    @Getter
    @Setter
    @Column(nullable = false,length = 100)
    private Climber[] climbers;
    @Getter
    @Setter
    private LocalDateTime start;
    @ManyToMany
    @JoinTable(name = "tb_climber_climberGroup",joinColumns = @JoinColumn(name = "ClimberGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "Climber_id"))
    private List<Climber> Climbers = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "tb_mountain_climberGroup",joinColumns = @JoinColumn(name = "ClimberGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "Mountain_id"))
    private List<Climber> Mountains = new ArrayList<>();

    public ClimbingGroup(Mountain mountain, Climber[] climbers, LocalDateTime start) {
        this.mountain = mountain;
        this.climbers = climbers;
        this.start = start;

    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public ClimbingGroup(Mountain mountain, int climberCount){
    this.mountain = Objects.requireNonNull(mountain,"mountain не может быть null");//если null-exceprtion,если нет,то вернет ссылку
    climbers = new Climber[climberCount];
    }
    public void  addClimber (Climber climber){
        Objects.requireNonNull(climber,"climber не может быть null");
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null){
                climbers[i] = climber;
                return;
            }
        }
        System.out.println("Мест нет");
    }
    public static boolean upDateTimeMountain(LocalDateTime start){
        LocalDate todayDateTime = LocalDate.now();
        if(start.isAfter(ChronoLocalDateTime.from(todayDateTime)))
            return true;
        else
        if(start.isBefore(ChronoLocalDateTime.from(todayDateTime)))
            return false;
        return true;
    }
    static boolean upClimbingGroupMountain(ClimbingGroup climbingGroup, Mountain mountain) {
        boolean isUp;
        if (isUp = ClimbingGroup.upDateTimeMountain(mountain.getStartMountain())){
            System.out.println("Группа не начала восхождение на гору");
        }
        return isUp;
    }
    public boolean isUp() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClimbingGroup)) return false;
        ClimbingGroup that = (ClimbingGroup) o;
        return Objects.equals(mountain, that.mountain) && Arrays.equals(climbers, that.climbers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mountain);
        result = 31 * result + Arrays.hashCode(climbers);
        return result;
    }

    @Override
    protected ClimbingGroup clone() {
        Mountain copyM = this.mountain.clone();
        ClimbingGroup copyGr= new ClimbingGroup(copyM, climbers.length);
        copyGr.climbers = climbers.clone();
        return copyGr;
    }

    @Override
    public String toString() {
        return "ClimbingGroup{" +
                "mountain=" + mountain +
                ", climbers=" + Arrays.toString(climbers) +
                '}';
    }
}
