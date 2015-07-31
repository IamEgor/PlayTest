package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "Response_Data_Model")
public class ResponseDataModel extends Model {
    @Id
    @GeneratedValue
    @Column(name = "RESPONSE_DATA_ID")
    public Long id;

    public String name;

    public String value;

    public static Finder<Long, ResponseDataModel> find = new Finder<Long, ResponseDataModel>(
            Long.class, ResponseDataModel.class);
}
