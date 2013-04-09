package testProject.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.beans.util.BeanMap;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.DateType;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.IntegerType;

import testProject.entity.Dept;
import testProject.entity.Emp;

public class EmpAction {

    public JdbcManager jdbcManager;

    /** 検索条件: 従業員名の前方一致 */
    public String condition_name_STARTS;

    /** 検索条件：入社日の範囲検索（開始） */
    @DateType
    public String condition_hireDate_GE;

    /** 検索条件：入社日の範囲検索（終了） */
    @DateType
    public String condition_hireDate_LE;

    /** 識別子(従業員)です。 */
    @IntegerType
    public String id;

    /** 名前(従業員)です。 */
    public String name;

    /** 入社日(従業員)です。 */
    @DateType
    public String hireDate;

    /** 部署の識別子です。 */
    @IntegerType
    public String deptId;

    /** バージョン(従業員)です。 */
    @IntegerType
    public String versionNo;

    /** 部署名です。 */
    public String deptName;

    /** 従業員のリストです。 */
    public List<Emp> empItems;

    /** 部署のリストです。 */
    public List<Dept> deptItems;

    @Execute(validator = false)
    public String search() {
    	System.out.println("");
    	System.out.println("EmpAction.search()");
        return "/search.jsp";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{
    	System.out.println("debug!!ポスト" + request);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{
    	System.out.println("debug!!ポスト" + request);
    }
    @Execute(validator = false)
    public String list() {
        empItems = jdbcManager.from(Emp.class)
            .leftOuterJoin("dept")
            .where(Beans.createAndCopy(BeanMap.class, this)
                .prefix("condition_")
                .excludesWhitespace()
                .timeConverter("yyyy/MM/dd hh:mm", "condition_hireDate_GE")
                .timeConverter("yyyy/MM/dd hh:mm", "condition_hireDate_LE")
                .execute())
            .orderBy("hireDate")
            .getResultList();
        System.out.println("debug!!" + this);

        return "/list.jsp";
    }

    @Execute(validator = false, urlPattern = "update/{id}")
    public String update() {
        deptItems = jdbcManager.from(Dept.class).orderBy("id").getResultList();

        Emp emp = jdbcManager.from(Emp.class).id(id).getSingleResult();
        Beans.copy(emp, this).dateConverter("yyyy/MM/dd", "hireDate").execute();

        return "/updateInput.jsp";
    }

    @Execute(validator = false)
    public String showConfirm() {
        if ("".equals(deptId)) {
            deptName = "";
        } else {
            Dept dept = jdbcManager.from(Dept.class).id(deptId).getSingleResult();
            deptName = dept.name;
        }

        return "/updateConfirm.jsp";
    }

    @Execute(validator = false)
    public String executeUpdate() {
        Emp emp = Beans.createAndCopy(Emp.class, this).execute();
        jdbcManager.update(emp).execute();

        return "/updateComplete.jsp";
    }
}