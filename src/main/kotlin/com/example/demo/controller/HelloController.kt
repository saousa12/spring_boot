package com.example.demo.controller

import com.example.demo.model.Department
import com.example.demo.model.Employee

import com.example.demo.service.HelloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.Date

@RestController
class HelloController {

    @Autowired
    lateinit var helloService: HelloService

//    @GetMapping("hello/{code}")
//    fun hello(@PathVariable("code") code :String,
//        @RequestParam("name") name:String, @RequestParam("lastName") lastName:String) :String{
//        return helloService.hello(name,lastName,code)
//        // http://localhost:8080/hello/pppp?name=ousa&lastName=j
//    }
@GetMapping("grade")
fun gradeCalcOutput(@RequestParam("score") score: String) :String{
    return helloService.gradeCalc(score)
}

    @PostMapping("cal")
    fun cal(
        @RequestBody num: Map<String,String>
    ):String{
        return helloService.calNumber(num)
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("dept")
    fun getAllDepartment(): List<Department> {
        return helloService.getAllDepartment()
    }
    @CrossOrigin("http://localhost:3000")
    @GetMapping("emp")
    fun getAllEmployees(): List<Employee> {
        return helloService.getAllEmployees()
    }

    //selecte empno
    @GetMapping("empno/{empNO}")
    fun getEmployeeByEmpNo(@PathVariable("empNO") empNo: String): List<Employee> {
        return helloService.getEmployeeByEmpNo(empNo)
    }

    //selecte ename
    @GetMapping("ename/{ename}")
    fun getEmployeeByEname(@PathVariable("ename") ename: String): List<Employee> {
        return helloService.getEmployeeByEname(ename)
    }

    //selecte job
    @GetMapping("job/{job}")
    fun getEmployeeByJob(@PathVariable("job") job: String): List<Employee> {
        return helloService.getEmployeeByJob(job)
    }

    //selecte mgr
    @GetMapping("mgr/{mgr}")
    fun getEmployeeByMgr(@PathVariable("mgr") mgr: String): List<Employee> {
        return helloService.getEmployeeByMgr(mgr)
    }

    //selecte hiredate
    @GetMapping("hiredate/{hiredate}")
    fun getEmployeeByHiredate(@PathVariable("hiredate") hiredateString: String): List<Employee> {
        val hiredate: Date = SimpleDateFormat("yyyy-MM-dd").parse(hiredateString)
        val employees: List<Employee> = helloService.getEmployeeByHiredate(hiredate)

        return employees
    }

    //selecte sal
    @GetMapping("sal/{sal}")
    fun getEmployeeBySal(@PathVariable("sal") sal: Double): List<Employee> {
        return helloService.getEmployeeBySal(sal)
    }

    //selecte comm
    @GetMapping("commission/{comm}")
    fun getEmployeeByComm(@PathVariable("comm") comm: Double): List<Employee> {
        return helloService.getEmployeeByComm(comm)
    }

    //selecte deptno
    @GetMapping("deptno/{deptno}")
    fun getEmployeeByDeptno(@PathVariable("deptno") deptno: Int): List<Employee> {
        return helloService.getEmployeeByDeptno(deptno)
    }

    //insert
    @PostMapping("emp/insert")
    fun insertEmployee(@RequestBody emp: Employee): Employee{
        var insertEmployee = helloService.saveEmployee(emp)
        return helloService.saveEmployee(emp)
    }

    //update
    @PutMapping("emp/update/{empNo}")
    fun updateEmployee(@PathVariable("empNo") empNo: String, @RequestBody emp: Employee): Employee {
        emp.empNo = empNo
        return helloService.saveEmployee(emp)
    }
    //delete
    @DeleteMapping("emp/delete/{empNo}")
    fun deleteEmployee(@PathVariable("empNo") empNo: String): List<Employee> {
        val deletedEmployee = helloService.getEmployeeByEmpNo(empNo)
        helloService.deleteEmployeeByEmpNo(empNo)
        return deletedEmployee
    }

    //mgr count
    @GetMapping("mgr/count/{mgr}")
    fun getEmployeeByMgrCount(@PathVariable("mgr") mgr: String): Map<String, Any> {
        val (numEmp, totalSalary) = helloService.getEmployeeByMgrCount(mgr)
        val result = HashMap<String, Any>()
        result["numEmployee"] = numEmp
        result["totalSalary"] = totalSalary
        return result
    }

}