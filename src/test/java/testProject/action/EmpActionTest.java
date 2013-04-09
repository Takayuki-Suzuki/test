package testProject.action;

import static org.seasar.framework.unit.S2Assert.*;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class EmpActionTest {
	EmpAction emp = new EmpAction();

	public void testSearch() {
//		fail("まだ実装されていません");
		assertEquals( emp.list(), "/list.jsp");
	}

	public void testList() {
		fail("まだ実装されていません");
	}

	public void testUpdate() {
		fail("まだ実装されていません");
	}

	public void testShowConfirm() {
		fail("まだ実装されていません");
	}

	public void testExecuteUpdate() {
		fail("まだ実装されていません");
	}

}
