package com.flexpag.kotlinpoc.controller

import com.flexpag.kotlinpoc.models.User
import com.flexpag.kotlinpoc.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController {
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping
    fun findAll(): List<User> {
        return userRepository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody user: User): User {
        return userRepository.save(user)
    }
}