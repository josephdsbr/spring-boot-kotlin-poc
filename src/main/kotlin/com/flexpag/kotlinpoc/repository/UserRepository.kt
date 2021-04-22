package com.flexpag.kotlinpoc.repository

import com.flexpag.kotlinpoc.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long>