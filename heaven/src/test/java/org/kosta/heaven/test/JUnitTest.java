package org.kosta.heaven.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.heaven.model.dao.UserDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class JUnitTest {
	@Resource
	UserDAO userDAO;
	@Test
	public void registerTest() {
		userDAO.checkId("admin");
	}
}
