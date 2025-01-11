package hibernate_one_to_many_uni_mapping.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hibernate_one_to_many_uni_mapping.entity.Student;
import hibernate_one_to_many_uni_mapping.entity.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentSubjectDao {

	EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Student saveStudentSubjectDao(Student student,List<Subject> subjects) {
		
		try {
			et.begin();
			
//			for (Subject subject : subjects) {
//				em.persist(subject);
//			}
			
			em.persist(student);
			
			et.commit();
			
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
    public List<Subject> saveSubjectDao(List<Subject> subjects, int studentId) {
		
		try {
			et.begin();
			for (Subject subject : subjects) {
				em.persist(subject);
				Query query=em.createNativeQuery("insert into student_subject(Student_id,subjects_id) values(?,?)");
				query.setParameter(1, studentId);
				query.setParameter(2, subject.getId());
				query.executeUpdate();
			}
			et.commit();
			
			return subjects;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
    
    public boolean deleteSubjectBySubjectIdDao(List<Integer>  subjectId) {
    	
    	String deleteSubjectQuery = "DELETE FROM student_subject where subjects_id=?";
    	et.begin();
    	boolean b=false;
    	for (Integer integer : subjectId) {
			
    		
    		em.createNativeQuery(deleteSubjectQuery).setParameter(1, integer).executeUpdate();
    		
    		Subject subject=em.find(Subject.class, integer);
    		
    		if(subject!=null) {
    			em.remove(subject);
    			b=true;
    		}else {
    			b=false;
    		}
    		
    	}
    	et.commit();
    	return b;
    }
    
    public List<Student> getAllStudentDao(){
    	return em.createQuery("from Student").getResultList();
    }
    
    public List<Student> filterStudentBySubjectName(String subjectName){
    	
    	List<Student> students=getAllStudentDao();
    	
    	return students
    	.stream()
    	.filter(a->a.getSubjects().stream()
    			.anyMatch(a1->a1.getName()
    					.equalsIgnoreCase(subjectName))).collect(Collectors.toList());
    }
}
