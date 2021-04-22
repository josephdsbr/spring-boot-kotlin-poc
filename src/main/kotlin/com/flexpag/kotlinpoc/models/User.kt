package com.flexpag.kotlinpoc.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "users")
class User(@Id @GeneratedValue val id: Long = 0L, val name: String = "", val password: String = "")