package com.udemy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository( "queryDSLExampleRepo" )
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course find( boolean exists ){
		
		JPAQuery<Course> query = new JPAQuery<Course>();
		
		//Course course1 = query.select( qCourse ).from( qCourse ).where( qCourse.id.eq(23) ).fetchOne();
		//List<Course> courses = query.select( qCourse ).from(qCourse).where( qCourse.hours.between(20, 50) ).fetch();
		
		BooleanBuilder predicateBuilder = new BooleanBuilder( qCourse.description.endsWith("OP") );
		
		if ( exists ){
			Predicate predicate1 = qCourse.id.eq(23);
			predicateBuilder.and(predicate1);
		}else{
			Predicate predicate2 = qCourse.name.endsWith("OP");
			predicateBuilder.or( predicate2 );
		}
		
		return query.select( qCourse ).from( qCourse ).where( predicateBuilder ).fetchOne();
		
	}
	
}
