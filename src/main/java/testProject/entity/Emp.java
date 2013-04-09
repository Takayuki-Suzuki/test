package testProject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 従業員です。
 *
 * @author dewa
 *
 */
@Entity
public class Emp {

    /** 識別子です。 */
    @Id
    @GeneratedValue
    public Integer id;

    /** 名前です。 */
    public String name;


    /** 入社日です。 */
    @Temporal(TemporalType.DATE)
    public Date hireDate;

    /** 部署の識別子です。 */
    public Integer deptId;

    /** 部署です。 */
    @ManyToOne
    public Dept dept;

    /** バージョンです。 */
    @Version
    public Integer versionNo;
}