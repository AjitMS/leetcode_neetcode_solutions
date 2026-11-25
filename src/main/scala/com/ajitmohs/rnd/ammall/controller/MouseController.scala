package com.ajitmohs.rnd.amm
package com.ajitmohs.rnd.ammall.controller

import java.awt.Robot
import java.util.Collections
import scala.util.control.Breaks.break

object MouseController {

  @volatile private var isUserActive: Boolean = false

  def main(args: Array[String]): Unit = {
    while (true) { // this while is for running the entire app



      if(!isUserActive) {
        moveMyCursor()
        break
      }
      // this while will be closed only when the user exits the exe app
    }
  }

  private def randomDelay = {
    scala.util.Random.nextInt(5000) + 5000
  }

  private def moveMyCursor(): Unit = {

    // first fetch the initial location of the mouse cursor
    val initialMousePosition = java.awt.MouseInfo.getPointerInfo.getLocation
    println(s"Initial Mouse Position: $initialMousePosition")

    val robot = new Robot()
    val (x, y) = randomCoordinates()
    robot.mouseMove(x, y)

    val expectedMousePosition = new java.awt.Point(initialMousePosition.x + x, initialMousePosition.y + y)
    val newMousePosition = java.awt.MouseInfo.getPointerInfo.getLocation

    if (newMousePosition.equals(expectedMousePosition)) {
      println(s"No User mouse movement is detected")
    } else {
      // which means user has moved the mouse
      println(s"User has moved the mouse")
      isUserActive = true
    }

    println(s"New Mouse Position: $newMousePosition")


  }

  // create random coordinates
  private def randomCoordinates(): (Int, Int) = {
    val x = scala.util.Random.nextInt(200)
    val y = scala.util.Random.nextInt(200)
    (x, y)
  }

  // create a method to detect if the user is idle for more than 1 minute
  private def isUserIdleForMoreThan5Min() = {
    // verify if the user has not moved the mouse or pressed any key for more than 1 minute
    isUserActive = true
  }

  // create an async method to monitor if the user has pressed a key or moved the mouse
  private def monitorUserActivity(): Unit = {

  }

}
