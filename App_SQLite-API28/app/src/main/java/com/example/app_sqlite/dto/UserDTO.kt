package com.example.app_sqlite.dto

import com.example.app_sqlite.dao.UserDAO

class UserDTO(var dni : String, var name : String, var age : Int, var profession : String, var salary : Int)
{
    var UserDAO = UserDAO();

    fun remove()
    {

    }

    /* Setters */
    /*fun setDni(dni : String)
    {
        this.dni = dni;
    }

    fun setName(name: String)
    {
        this.name = name;
    }

    fun setAge(age: Int)
    {
        this.age = age;
    }

    fun setProfession(profession: String)
    {
        this.profession = profession;
    }

    fun setSalary(salary : Int)
    {
        this.salary = salary;
    }

    /* Getters */
    fun getDni() : String
    {
        return this.dni;
    }

    fun getName() : String
    {
        return this.name;
    }

    fun getAge() : Int
    {
        return this.age;
    }

    fun getProfession() : String
    {
        return this.profession;
    }

    fun getSalary() : Int
    {
        return this.salary;
    }*/

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserDTO

        if (dni != other.dni) return false
        if (name != other.name) return false
        if (age != other.age) return false
        if (profession != other.profession) return false
        if (salary != other.salary) return false

        return true
    }

    override fun hashCode(): Int {
        var result = dni.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + age.hashCode()
        result = 31 * result + profession.hashCode()
        result = 31 * result + salary.hashCode()
        return result
    }
}