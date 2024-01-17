package com.example.app_sqlite.dto

import com.example.app_sqlite.dao.UserDAO

class UserDTO(var dni : String, var name : String, var age : Int, var profession : String, var salary : Int)
{
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