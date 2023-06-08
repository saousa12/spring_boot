package com.example.demo.repository

import com.example.demo.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Date
import java.util.Objects

@Repository
interface EmployeeRepository:JpaRepository<Employee, String> {
    fun save(employee: Employee): Employee
    //"SELECT * FROM EMP WHERE EMPNO = ''"
    @Query("SELECT e FROM Employee e WHERE e.empNo = :empNo")
    fun findByEmpNoEquals(@Param("empNo") empNo: String): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.ename = :ename")
    fun findByEnameEquals(@Param("ename") ename: String): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.job = :job")
    fun findByJobEquals(@Param("job") job: String): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.mgr = :mgr")
    fun findByMgrEquals(@Param("mgr") mgr: String): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.hiredate = :hiredate")
    fun findByHiredateEquals(@Param("hiredate") hiredate: Date): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.sal = :sal")
    fun findBySalEquals(@Param("sal") sal: Double): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.commission_pct = :comm")
    fun findByCommEquals(@Param("comm") comm: Double): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.deptno = :deptno")
    fun findByDeptnoEquals(@Param("deptno") deptno: Int): List<Employee>

    @Query("SELECT count(empNo),sum(sal) FROM Employee WHERE mgr = :mgr")
    fun findByMgr(@Param("mgr") mgr: String): Employee


}
