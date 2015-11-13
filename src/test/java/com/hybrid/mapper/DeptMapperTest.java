package com.hybrid.mapper;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.employee.DeptWrapperTest;
import com.hybrid.model.Dept;

public class DeptMapperTest {
	static Log log = LogFactory.getLog(DeptWrapperTest.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");

		DeptMapper deptMapper = ctx.getBean(DeptMapper.class);
		List<Dept> list = deptMapper.selectAll();

		list.forEach(new Consumer<Dept>() {

			public void accept(Dept t) {
				String msg = "\ndeptno = " + t.getDeptno() + "\ndname = " + t.getDname() + "\nloc = " + t.getLoc();
				log.info(msg);
			}
		});
		
		Dept dept = deptMapper.selectByDeptno(20);
		String msg = "\ndeptno = " + dept.getDeptno() + "\ndname = " + dept.getDname() + "\nloc = " + dept.getLoc();
		log.info(msg);

	}
}
