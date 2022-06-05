package com.egebilmuh.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.egebilmuh.ecommerce.entity.*;


/*
@Repository Annotation is a specialization of @Component annotation which is used to indicate that the
class provides the mechanism for storage, retrieval, update, delete and search operation on objects.*/

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>
{
    Department findByDepartmentId(Long departmentId);
}
