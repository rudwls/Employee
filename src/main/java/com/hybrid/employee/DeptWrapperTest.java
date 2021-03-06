package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;

public class DeptWrapperTest {
	static Log log = LogFactory.getLog(DeptWrapperTest.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");

		DeptMapper deptMapper = ctx.getBean(DeptMapper.class);
		List<Dept> list = deptMapper.selectAll();

		list.forEach(new Consumer<Dept>() {

			public void accept(Dept t) {
				String msg = "deptno = " + t.getDeptno() + "dname = " + t.getDname() + "loc = " + t.getLoc();
				log.info(msg);
			}
		});

		ctx.close();
	}

}
