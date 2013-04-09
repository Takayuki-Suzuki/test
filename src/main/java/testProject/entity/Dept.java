package testProject.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 * 部署です。
 *
 * @author dewa
 */
@Entity
public class Dept {

    /** 識別子です。 */
    @Id
    @GeneratedValue
    public Integer id;

    /** 名前です。 */
    public String name;

    /** バージョンです。 */
    @Version
    public Integer versionNo;
}