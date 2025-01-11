# Hibernate One-to-Many Unidirectional Mapping

This project demonstrates the implementation of a **Hibernate One-to-Many Unidirectional Mapping** using JPA annotations. The goal is to showcase how a single entity can have a one-to-many relationship with another entity in a unidirectional manner, meaning only one side (the `One` side) is aware of the relationship.

## Project Overview

### Technologies Used:
- **Java 17**
- **Hibernate Core 6.5.2.Final**
- **MySQL Connector 8.4.0**
- **Lombok 1.18.34**
- **JUnit 3.8.1** (for testing)
- **Maven** for dependency management

### Dependencies
The `pom.xml` includes the following dependencies:

1. **Hibernate Core**: For ORM and database interaction.
2. **Lombok**: To reduce boilerplate code by using annotations.
3. **MySQL Connector**: To connect the application to a MySQL database.
4. **JUnit**: For testing purposes.

Refer to the `pom.xml` for detailed version information and configurations.

## Database Configuration

The project uses MySQL as the database. Update the `hibernate.cfg.xml` or application properties with your MySQL database credentials.

```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
        <property name="hibernate.connection.username">your_username</property>
        <property name="hibernate.connection.password">your_password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
    </session-factory>
</hibernate-configuration>
```

## Project Structure

```plaintext
src/main/java/com/jsp/
├── entity/
│   ├── ParentEntity.java
│   └── ChildEntity.java
├── dao/
│   └── ParentEntityDAO.java
├── utils/
│   └── HibernateUtil.java
└── App.java
```

### Entity Classes

#### ParentEntity.java
- Represents the parent entity in the relationship.
- Annotated with `@Entity` and `@Table`.
- Has a `@OneToMany` annotation mapping to the `ChildEntity`.

#### ChildEntity.java
- Represents the child entity in the relationship.
- Annotated with `@Entity` and `@Table`.

### DAO Layer

The `ParentEntityDAO` provides CRUD operations for the parent entity and manages the relationship with child entities.

### Utility Class

`HibernateUtil` contains methods to initialize and manage Hibernate sessions.

## Running the Application

1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   ```
2. **Configure Database**:
   Update the database details in the configuration file.
3. **Build the Project**:
   ```bash
   mvn clean install
   ```
4. **Run the Application**:
   Execute the `App.java` file which contains the main method.

## Example Usage

### Adding a Parent with Multiple Children

```java
ParentEntity parent = new ParentEntity();
parent.setName("Parent Name");

ChildEntity child1 = new ChildEntity();
child1.setName("Child 1");

ChildEntity child2 = new ChildEntity();
child2.setName("Child 2");

parent.setChildren(Arrays.asList(child1, child2));

ParentEntityDAO.save(parent);
```

### Fetching Parent and Associated Children

```java
ParentEntity parent = ParentEntityDAO.findById(1);
System.out.println("Parent: " + parent.getName());
parent.getChildren().forEach(child -> System.out.println("Child: " + child.getName()));
```



