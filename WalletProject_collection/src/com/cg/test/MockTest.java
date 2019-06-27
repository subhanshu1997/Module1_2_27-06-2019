package com.cg.test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.dao.AccountDAOImpl;
import com.cg.service.AccountService;

class MockTest {
	private AccountService service;
	private AccountDAOImpl mockDao;

	@Before
	public void setup() {
		service = new AccountService();
		mockDao = EasyMock.createMock(AccountDAOImpl.class);
		service.setDao(mockDao);
	}
	@Test
	void test() {
			Account user = new Account();
			long mob=9818547631L;
			/* expect tells your mock object to expect the method */
			EasyMock.expect
			(mockDao.findAccount(9818547631L))
			.andReturn(user);
			EasyMock.replay(mockDao);
			assertEquals(user,service.findAccount(mob));
			EasyMock.verify(mockDao);

}
}
