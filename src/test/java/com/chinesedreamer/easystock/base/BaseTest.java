package com.chinesedreamer.easystock.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-config.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests{

}
