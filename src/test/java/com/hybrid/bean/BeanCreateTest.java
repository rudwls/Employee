package com.hybrid.bean;

import java.io.IOException;
import java.sql.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class BeanCreateTest {

	static Log log = LogFactory.getLog(BeanCreateTest.class);
	static GenericXmlApplicationContext ctx;
	public static void main(String[] args) throws ParserConfigurationException, InterruptedException, SAXException, IOException {
		 ctx = new GenericXmlApplicationContext("com/hybrid/bean/beans.xml");
		 
		 Document document = ctx.getBean(Document.class);
		 
		 Element root = document.getDocumentElement();
		 log.info(root.getNodeName());
		
	
	
	}
		static void test2() throws ParserConfigurationException, SAXException, IOException{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("com/hybrid/bean/beans.xml");

		DocumentBuilderFactory f = ctx.getBean(DocumentBuilderFactory.class);
		DocumentBuilder builder = f.newDocumentBuilder();
		ClassPathResource resource = new ClassPathResource("com/hybrid/bean/dept.xml");
		
		Document document = builder.parse(resource.getInputStream());
		Element root = document.getDocumentElement();
		log.info(root.getNodeName());
		
		ctx.close();
		
		//test();
	}

	static void test() throws InterruptedException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("com/hybrid/bean/beans.xml");

		Date d = ctx.getBean(Date.class);
		log.info("date = " + d);

		Thread.sleep(2000);

		Date d2 = ctx.getBean(Date.class);
		log.info("date = " + d2);

		ctx.close();
	}
}
