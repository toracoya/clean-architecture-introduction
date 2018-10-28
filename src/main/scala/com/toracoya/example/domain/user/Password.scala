package com.toracoya.example.domain.user

case class Password(value: String) extends AnyVal {

  def hash: HashedPassword = HashedPassword(value.reverse)
}
