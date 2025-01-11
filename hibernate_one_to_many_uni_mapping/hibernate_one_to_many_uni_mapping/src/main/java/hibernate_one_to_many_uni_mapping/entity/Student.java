package hibernate_one_to_many_uni_mapping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "student-subject",
		joinColumns = @JoinColumn(name="student-id"),
		inverseJoinColumns = @JoinColumn(name="subject-id")
			)
	private List<Subject> subjects;

	public Student(String name, String email, List<Subject> subjects) {
		super();
		this.name = name;
		this.email = email;
		this.subjects = subjects;
	}
	
	
}
