import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tb.mountains")
@NamedQueries({
        @NamedQuery(name = "Mountain.get_all",query = "SELECT g FROM Mountain g"),
        @NamedQuery(name = "Mountain.get_by_name",query = "SELECT g FROM Mountain g WHERE g.name = :mountain_name"),
        @NamedQuery(name = "Mountain.get_by_height",query = "SELECT g FROM Mountain g WHERE g.height = :mountain_height")})
public class Mountain extends Id{
    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
    @Getter
    @Setter
    @Column(nullable = false)
    private int height;
    @Getter
    @Setter
    private LocalDateTime startMountain;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "MountainList")
    private List<ClimbingGroup> climbingGroupsMountain= new ArrayList<>();

    public Mountain() {
        this("Гора по умолчанию", 300);
    }

    //конструктор
    public Mountain(String name, int height) {
        setName(name);
        setHeight(height);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            throw new IllegalArgumentException("name <2");
        }
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 100) {
            throw new IllegalArgumentException("height<100");
        }
        this.height = height;
    }

    public static boolean upMountain(LocalDateTime startMountain){
        if(startMountain.isAfter(LocalDateTime.now()));
        return true;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mountain)) return false;
        Mountain mountain = (Mountain) o;
        return height == mountain.height && Objects.equals(name, mountain.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
    }

    @Override
    public Mountain clone() {
        try {
            return (Mountain) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
