package com.javaex.dao;

import java.util.List;
import java.util.Map;

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
	
	//사람추가 map을 사용하는 상황
	/*
	 * public int personInsert2(Map<String, String> pMap) {
	 * System.out.println("PhoneDao>personInsert2()");
	 * 
	 * int count = sqlSession.insert("phonebook.personInsert2", pMap); return count;
	 * }
	 */
	

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
	
	public void getPerson2(int no) {
		System.out.println("PhoneDao>getPerson2");
		System.out.println(no);
		
		Map<String, Object> pMap = sqlSession.selectOne("phoneDao.getPerson2", no);
		
		System.out.println(pMap);
	}
	

	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneDao>personUpdate");
		int count = sqlSession.update("phonebook.personUpdate", personVo);
		
		return count;
	}
	

}