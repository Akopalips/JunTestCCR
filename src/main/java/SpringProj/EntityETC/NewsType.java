package SpringProj.EntityETC;

import javax.persistence.*;

@Entity
@Table(name = "news_type")
public class NewsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String name = null;
    private String color = null;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }

    private NewsType(){}

    public void consume(NewsType newsType){
        if (name == null) name = newsType.getName();
        if (color == null) color = newsType.getColor();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":").append(id);
        builder.append(", \"name\":\"").append(name).append('\"');
        builder.append(", \"color\":\"").append(color).append('\"');
        builder.append('}');
        return builder.toString();
    }
}
