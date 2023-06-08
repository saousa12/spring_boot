package com.example.demo.service


import com.example.demo.model.Department
import com.example.demo.model.Employee
import com.example.demo.repository.DepartmentRepository
import com.example.demo.repository.EmployeeRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.script.ScriptEngineManager


@Service
class HelloService {
//    fun hello(name: String, lastName: String, code: String): String {
//        return "$name $lastName ,code $code"
//    }

    @Autowired
    lateinit var employeeRepository: EmployeeRepository
    @Autowired
    lateinit var departmentRepository: DepartmentRepository

    fun gradeCalc(score: String): String {
        var score = score.toInt()

        return when {
            score >= 80 && score <= 100 -> "Grade A"
            score >70 && score <80 -> "Grade B"
            score >= 60 && score < 70 -> "Grade C"
            score >= 50 && score < 60 -> "Grade D"
            score >= 0 && score < 50 -> "Grade F"
            else -> "Try again!"
        }

    }

    //All Department
    fun getAllDepartment(): List<Department> {
        return departmentRepository.findAll()
    }


    //All employees
    fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    fun getEmployeeByEmpNo(empNo: String): List<Employee> {
        return employeeRepository.findByEmpNoEquals(empNo)
    }

    fun getEmployeeByEname(ename: String): List<Employee> {
        return employeeRepository.findByEnameEquals(ename)
    }

    fun getEmployeeByJob(job: String): List<Employee> {
        return employeeRepository.findByJobEquals(job)
    }

    fun getEmployeeByMgr(mgr: String): List<Employee> {
        return employeeRepository.findByMgrEquals(mgr)
    }

    fun getEmployeeByHiredate(hiredate: Date): List<Employee> {
        return employeeRepository.findByHiredateEquals(hiredate)
    }

    fun getEmployeeBySal(sal: Double): List<Employee> {
        return employeeRepository.findBySalEquals(sal)
    }

    fun getEmployeeByComm(comm: Double): List<Employee> {
        return employeeRepository.findByCommEquals(comm)
    }

    fun getEmployeeByDeptno(deptno: Int): List<Employee> {
        return employeeRepository.findByDeptnoEquals(deptno)
    }

    fun saveEmployee(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    fun deleteEmployeeByEmpNo(empNo: String) {
    employeeRepository.deleteById(empNo)
    }

    fun getEmployeeByMgrCount(mgr: String): Pair<Int, Double> {
        val employee: List<Employee> = employeeRepository.findByMgrEquals(mgr)
        val totalSalary: Double = employee.sumOf { it.sal ?: 0.0 }
        return Pair(employee.size, totalSalary)
    }

  fun calNumber(numInput: Map<String,String>): String {
        var numInput = (numInput["numInput"]?:"")
        numInput = numInput.replace("x", "*")
        numInput = numInput.replace(",", "")
        val manager = ScriptEngineManager()
        val engine = manager.getEngineByName("JavaScript")
        val result = engine.eval(numInput)
        return "$numInput = " + String.format("%.2f", result.run { toString().toDouble() })
    }


}

