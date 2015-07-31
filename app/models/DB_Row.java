package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DB_Row")
public class DB_Row extends Model {
    @Id
    @GeneratedValue
    @Column(name = "DB_ROW_ID")
    public Long id;

    @Constraints.Required(message = "Enter label name")
    public String label;

    public String typesEnum;

    public Boolean required;

    public Boolean isActive;

    //@Constraints.MaxLength(1000)
    public String properties;

    public static Finder<Long, DB_Row> finder = new Finder<Long, DB_Row>(Long.class, DB_Row.class);

    public static List<DB_Row> db_rows = new ArrayList<DB_Row>();

    public DB_Row(Long id, String label, String typesEnum, Boolean required, Boolean isActive, String properties) {
        this.id = id;
        this.label = label;
        this.typesEnum = typesEnum;
        this.required = required;
        this.isActive = isActive;
        this.properties = properties;
    }

    public DB_Row(DB_Row oldRow) {
        this.id = oldRow.id;
        this.label = oldRow.label;
        this.typesEnum = oldRow.typesEnum;
        this.required = oldRow.required;
        this.isActive = oldRow.isActive;
        this.properties = oldRow.properties;
    }

    public DB_Row(){

    }

    public void setDb_rows(DB_Row oldRow) {
        this.label = oldRow.label;
        this.typesEnum = oldRow.typesEnum;
        this.required = oldRow.required;
        this.isActive = oldRow.isActive;
        this.properties = oldRow.properties;
    }
}
