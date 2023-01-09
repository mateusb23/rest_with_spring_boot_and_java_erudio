package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVO(Person person) {
		
		PersonVOV2 vo = new PersonVOV2();
		
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setBirthday(new Date());
		
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOV2 personVOV2) {
		
		Person entity = new Person();
		
		entity.setId(personVOV2.getId());
		entity.setAddress(personVOV2.getAddress());
		entity.setFirstName(personVOV2.getFirstName());
		entity.setLastName(personVOV2.getLastName());
		//vo.setBirthday(new Date());
		
		return entity;
	}
	
}
