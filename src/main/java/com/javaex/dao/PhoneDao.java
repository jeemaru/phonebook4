package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	public List<PersonVo> getPersonList() {
		System.out.println("PhoneDao>getPersonList()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");

		return personList;
	}

	// 사람추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhoneDao>personInsert()");

		int count = sqlSession.insert("phonebook.personInsert", personVo);

		return count;
	}


	public int personDelete(int no) {
		System.out.println("PhoneDao>personDelete");
		
		int count = sqlSession.delete("phonebook.personDelete", no);
		
		return count;
	}
	
	
	public PersonVo getPerson(int no) {
		System.out.println("PhoneDao>getPerson");
		
		PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", no);
		System.out.println(personVo);
		
		return personVo;
		
	}
	

	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneDao>personUpdate");
		int count = sqlSession.update("phonebook.personUpdate", personVo);
		
		return count;
	}
	

}