package com.toracoya.example

import com.toracoya.example.adapters.controllers.user.UserController
import com.toracoya.example.adapters.presenters.user.UserPresenter
import com.toracoya.example.gateways.repositories.MemoryUserRepository
import com.toracoya.example.usecases.user.UserUseCase

import scala.io.StdIn

object Main extends App {

  val repository = new MemoryUserRepository
  val useCase = new UserUseCase(repository)
  val presenter = new UserPresenter
  val controller = new UserController(useCase, presenter)

  println("Input user: ")
  val name = StdIn.readLine()
  println("Input password: ")
  val password = StdIn.readLine()

  controller.create(name, password)
}
