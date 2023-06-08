package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name="dept")
data class Department (

    @Id
    @Column(name = "deptno", nullable = false)
    var deptNo : Int,

    @Column(name = "dname")
    var dname : String?,

    @Column(name = "loc")
    var loc : String?,

    )