package SpringProj.EntityETC;


import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String name = null;
    private Long typeId = null;

    private String aboutShort = null;
    private String aboutFull = null;

    private News() {}

    protected News(Long id, String name, Long typeId, String aboutShort, String aboutFull) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.aboutShort = aboutShort;
        this.aboutFull = aboutFull;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAboutShort(String aboutShort) {
        this.aboutShort = aboutShort;
    }
    public void setAboutFull(String aboutFull) {
        this.aboutFull = aboutFull;
    }
    public void setTypeId(Long typeId) {
        this.typeId = (typeId);
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Long getTypeId() {
        return typeId;
    }
    public String getAboutFull() {
        return aboutFull;
    }
    public String getAboutShort() {
        return aboutShort;
    }
    public String getName() {
        return name;
    }

    public void consume(News news) {
        if (name == null) name = news.getName();
        if (aboutShort == null) aboutShort = news.getAboutShort();
        if (aboutFull == null) aboutFull = news.getAboutFull();
        if (typeId == null) typeId = news.getTypeId();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(", \"name\":\"").append(name).append('\"');
        sb.append(", \"aboutShort\":\"").append(aboutShort).append('\"');
        sb.append(", \"aboutFull\":\"").append(aboutFull).append('\"');
        sb.append(", \"typeId\":").append(typeId);
        sb.append("}");
        return sb.toString();
    }
}