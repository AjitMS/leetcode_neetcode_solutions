package com.ajitmohs.rnd.ammall.controller

import scala.jdk.CollectionConverters._
import akka.actor.{Actor, ActorSystem, Props}

case class Person(name: String, age: Int)

object Test {

  def main(args: Array[String]): Unit = {
    val scalaList: List[String] = List("1", "2")
    val javaList: java.util.ArrayList[String] = new java.util.ArrayList(scalaList.asJava)

    println(javaList)

    val p = Person("aa", 11)
    val p1 = Person("ab", 12)

//    val system = ActorSystem("HelloSystem")
//    val helloActor = system.actorOf(Props[HelloActor](), name = "HelloActor")
//    helloActor ! "bye"

    println(s"sum \n is \n ${sum(1, 8)}")
  }

  val add: (Int, Int)=> Int = (a: Int, b: Int) => a + b

  def calculate(fn: (Int, Int) => Int, a: Int, b: Int): Int = fn(fn(a,b), a)

  def sum (tuple:(Int, Int)): Int = {
    val (x, y) = tuple
    tuple._1 + tuple._2
  }

}

class HelloActor extends Actor {

  override def receive: Receive =
    case "hello" => println("Hey!")
    case "bye" => println("TC!")
    case _ => println("IDK?")
}