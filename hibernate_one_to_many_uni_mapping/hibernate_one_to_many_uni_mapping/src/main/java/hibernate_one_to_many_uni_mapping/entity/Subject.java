package hibernate_one_to_many_uni_mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "programmer")
    @SequenceGenerator(name = "programmer", sequenceName = "programmer", initialValue = 1234, allocationSize = 1)
	private int id;
	private String name;
	private String authorName;
	
	public Subject(String name, String authorName) {
		super();
		this.name = name;
		this.authorName = authorName;
	}
	
	
}
