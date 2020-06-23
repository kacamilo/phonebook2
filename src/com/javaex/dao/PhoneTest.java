package com.javaex.dao;

import com.javaex.vo.PersonVo;

public class PhoneTest {

	public static void main(String[] args) {
		PhoneDao phoneDao = new PhoneDao();
		/*
		List <PersonVo>personList= phoneDao.getPersonList();
		System.out.println(personList.toString());
		*/
		/*
		PersonVo personVo = new PersonVo("강한솔", "010-5555-6666", "02-2222-2222");
		phoneDao.personInsert(personVo);
		*/
		
		PersonVo personvo = phoneDao.getPerson(1);
		System.out.println(personvo.toString());
		
		
	}

}
